package com.abcbankinfo.bankapp.services;


import com.abcbankinfo.bankapp.repository.BankRepository;
import com.abcbankinfo.bankapp.model.BankInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {


    private final BankRepository bankRepo;

    @Autowired
    public BankService(BankRepository bankRepo){
        this.bankRepo=bankRepo;
    }

    public Optional<BankInfo> getBalance(long bankId) {

        return bankRepo.findById(bankId);
    }

    public BankInfo createIntialBankInfo(BankInfo bankInfo) {

       return bankRepo.save(bankInfo);
    }
}
