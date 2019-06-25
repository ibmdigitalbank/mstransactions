package org.ibm.mstransactions.dao;

import org.ibm.mstransactions.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query("SELECT t FROM Transaction t WHERE t.source=:rib OR t.destination=:rib")
    public List<Transaction> findByCompte( Double rib);
    public List<Transaction> findAllBySourceEquals( Double rib);
    public List<Transaction> findAllByDestinationEquals( Double rib);
}