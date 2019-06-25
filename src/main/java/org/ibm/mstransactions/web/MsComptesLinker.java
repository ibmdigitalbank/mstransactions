package org.ibm.mstransactions.web;

import org.ibm.mstransactions.entities.Transaction;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
public class MsComptesLinker {
    private String mscomptesHost="http://mscomptes:8081";
    private RestTemplate restTemplate = new RestTemplate();
    public Object post(String url, Transaction t){
        //mscomptesHost ="http://localhost:8081";
        System.out.println("> POST REQUEST TO '"+mscomptesHost+url+"' with data : "+t.toString());
        HttpEntity<Object> request = new HttpEntity<>(t);
        return restTemplate.postForObject(mscomptesHost+ url, request,Object.class);
    }
    public Byte sendTransactionToMSComptes(Transaction t){
        return Byte.parseByte(post("/transaction",t).toString());
    }
}
