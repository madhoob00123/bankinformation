package com.abcbankinfo.bankapp.controller;


import com.abcbankinfo.bankapp.services.BankService;
import com.abcbankinfo.bankapp.model.BankInfo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.Assert.*;


public class BankControllerTest {

    private BankController bankController;
    private BankService   mockBankservice;
    private  BankInfo bankInfo;


    @Before
    public void setup()
    {
        mockBankservice= Mockito.mock(BankService.class);
        bankController=new BankController(mockBankservice);
        bankInfo=new BankInfo();
        bankInfo.setId(123L);
        bankInfo.setBalance(1000.30);


    }
    @Test
    public void getBalanceReturnsBalanceOfAccount() {
        Mockito.when(mockBankservice.getBalance(123L)).thenReturn(Optional.ofNullable(bankInfo));

        ResponseEntity<BankInfo> newbalance=bankController.checkBalance(123L);

        assertEquals(1000.30,newbalance.getBody().getBalance(),0.00);
        assertEquals(HttpStatus.OK,newbalance.getStatusCode());

    }



    @Test
    public void withdrawlReturnsRemainingBalanceOfAccount() {
        Mockito.when(mockBankservice.getBalance(bankInfo.getId())).thenReturn(Optional.ofNullable(bankInfo));
        Mockito.when(mockBankservice.createIntialBankInfo(bankInfo)).thenReturn(bankInfo);
        ResponseEntity<BankInfo> newbalance=bankController.withdraw(123L, 200.00);
        assertEquals(800.30, newbalance.getBody().getBalance(), 0.00);
        assertEquals(HttpStatus.OK,newbalance.getStatusCode());

    }

    @Test
    public void depositReturnsRemainingBalanceOfAccount() {
        Mockito.when(mockBankservice.getBalance(bankInfo.getId())).thenReturn(Optional.ofNullable(bankInfo));
        Mockito.when(mockBankservice.createIntialBankInfo(bankInfo)).thenReturn(bankInfo);
        ResponseEntity<BankInfo> newbalance=bankController.deposit(123L, 300.00);
        assertEquals(1300.30, newbalance.getBody().getBalance(), 0.00);
        assertEquals(HttpStatus.OK,newbalance.getStatusCode());
    }
}
