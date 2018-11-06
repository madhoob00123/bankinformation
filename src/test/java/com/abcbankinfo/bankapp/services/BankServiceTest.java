package com.abcbankinfo.bankapp.services;

import com.abcbankinfo.bankapp.repository.BankRepository;
import com.abcbankinfo.bankapp.model.BankInfo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class BankServiceTest {

private BankRepository bankRepo;
private BankService  bankService;

private BankInfo bankInfo;


    @Before
    public void setup()
    {
        bankRepo = Mockito.mock(BankRepository.class);
        bankService= new BankService(bankRepo);
        bankInfo=new BankInfo();
        bankInfo.setId(123L);
        bankInfo.setBalance(1000.30);


    }
    @Test
    public void getBalanceReturnsBalanceOfAccount() {
        Mockito.when(bankRepo.findById(123l)).thenReturn(Optional.ofNullable(bankInfo));

        assertEquals(bankInfo, bankService.getBalance(123L).get());

    }

}
