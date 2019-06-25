package org.ibm.mstransactions.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ibm.mstransactions.dao.TransactionRepository;
import org.ibm.mstransactions.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@CrossOrigin("*")
@RestController
@Api(value="Transactions Controller", description="operations to manage transactions")
public class TransactionsController {
    @Autowired
    private TransactionRepository transactionRepository;
    private MsComptesLinker msComptesLinker=new MsComptesLinker();
    @GetMapping("/")
    @ApiOperation(value = "list of all transactions")
    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }
    @GetMapping("/parcompte/{rib}")
    @ApiOperation(value = "list of all transactions by a account number")
    public List<Transaction> findByCompte(@PathVariable Double rib){
        return transactionRepository.findByCompte(rib);
    }
    @GetMapping("/solde/{rib}")
    @ApiOperation(value = "calculate the balance of an account.")
    public Double calculesolde(@PathVariable Double rib){
        double solde=(double)0;
        List<Transaction> transactions=transactionRepository.findByCompte(rib);
        for(Transaction t : transactions)
            solde+=t.getDestination().equals(rib)?t.getMontant():-t.getMontant();
        return solde;
    }
    @GetMapping("/parsource/{rib}")
    @ApiOperation(value = "all transactions that are made by an account")
    public List<Transaction> findAllBySourceContains(@PathVariable Double rib){
        return transactionRepository.findAllBySourceEquals(rib);
    }
    @ApiOperation(value = "all transactions that are received by an account")
    @GetMapping("/pardestination/{rib}")
    public List<Transaction> findAllByDestinationContains(@PathVariable Double rib){
        return transactionRepository.findAllByDestinationEquals(rib);
    }
    @PostMapping("/transaction")
    @ApiOperation(value = "create new transaction")
    @Transactional
    public Transaction newOne(@RequestBody Transaction t){
        t.setDate(new Date());
        byte mscomptesRep=msComptesLinker.sendTransactionToMSComptes(t);
        if(mscomptesRep>0){
            System.out.println("Accounts updated");
            return transactionRepository.save(t);
        }
        else{
            String msg;
            switch (mscomptesRep){
                case -1:    msg="Accounts not found";break;
                case -2:    msg="BALANCE NOT ENOUGH";break;
                case -3:    msg="One or both accounts are not active.";break;
                default:    msg="UNKNOWN";
            }
            System.out.println(msg);
            return null;
        }
    }
}
