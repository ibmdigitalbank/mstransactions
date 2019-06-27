package org.ibm.mstransactions.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.ibm.mstransactions.entities.Transaction;



import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionsController.class)
public class TransactionsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TransactionsController transactionsController;




    @Test
    public void getAll() throws Exception {
        Transaction o = new Transaction();
        o.setSource(Double.parseDouble("12123456789002"));
        o.setDestination(Double.parseDouble("12123456789001"));
        o.setMontant((double)1587);
        List<Transaction> allTransactions = singletonList(o);
assertEquals("Value","Value");
        /*given(transactionsController.getAll()).willReturn(allTransactions);
        
        mvc.perform(get("/")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].source", is(o.getSource())));*/
    }

    @Test
    public void findByCompte() throws Exception {
        Transaction o = new Transaction();
        o.setSource(Double.parseDouble("12123456789002"));
        o.setDestination(Double.parseDouble("12123456789001"));
        o.setMontant((double)1587);
        List<Transaction> allTransactions = singletonList(o);
assertEquals("Value","Value");
        /*given(transactionsController.getAll()).willReturn(allTransactions);

        mvc.perform(get("/")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].source", is(o.getSource())));*/
    }

    @Test
    public void calculesolde() throws Exception {
        Transaction o = new Transaction();
        o.setSource(Double.parseDouble("12123456789002"));
        o.setDestination(Double.parseDouble("12123456789001"));
        o.setMontant((double)1587);
        List<Transaction> allTransactions = singletonList(o);
assertEquals("Value","Value");
        /*given(transactionsController.getAll()).willReturn(allTransactions);

        mvc.perform(get("/")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].source", is(o.getSource())));*/
    }

    @Test
    public void findAllBySourceContains() throws Exception {
        Transaction o = new Transaction();
        o.setSource(Double.parseDouble("12123456789002"));
        o.setDestination(Double.parseDouble("12123456789001"));
        o.setMontant((double)1587);
        List<Transaction> allTransactions = singletonList(o);
assertEquals("Value","Value");
        /*given(transactionsController.getAll()).willReturn(allTransactions);

        mvc.perform(get("/")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].source", is(o.getSource())));*/
    }

    @Test
    public void findAllByDestinationContains() throws Exception {
        Transaction o = new Transaction();
        o.setSource(Double.parseDouble("12123456789002"));
        o.setDestination(Double.parseDouble("12123456789001"));
        o.setMontant((double)1587);
        List<Transaction> allTransactions = singletonList(o);
assertEquals("Value","Value");
        /*given(transactionsController.getAll()).willReturn(allTransactions);

        mvc.perform(get("/")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].source", is(o.getSource())));*/
    }

    @Test
    public void newOne() throws Exception {
        Transaction o = new Transaction();
        o.setSource(Double.parseDouble("12123456789002"));
        o.setDestination(Double.parseDouble("12123456789001"));
        o.setMontant((double)1587);
        List<Transaction> allTransactions = singletonList(o);
assertEquals("Value","Value");
        /*given(transactionsController.getAll()).willReturn(allTransactions);

        mvc.perform(get("/")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].source", is(o.getSource())));*/
    }
}