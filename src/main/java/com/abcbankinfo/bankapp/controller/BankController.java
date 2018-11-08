package com.abcbankinfo.bankapp.controller;


import com.abcbankinfo.bankapp.services.BankService;
import com.abcbankinfo.bankapp.model.BankInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/bankInfo"))
public class BankController {


    private BankService bankService;

    @Autowired
    public BankController(BankService bankService){
        this.bankService=bankService;
    }

    @GetMapping("/demo")
    public String getMessage(){
        return "Hello world  !!!!!";
    }

    @GetMapping("/{id}")

    public ResponseEntity<BankInfo> checkBalance(@PathVariable long id){

//        return new ResponseEntity<BankInfo>(bankService.getBalance(bankId).get(), HttpStatus.OK);
        BankInfo bankInfo = (BankInfo)bankService.getBalance(id).get();


        if(bankInfo==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(bankInfo, HttpStatus.OK);

    }


    @PostMapping("/")

    public ResponseEntity<BankInfo> createBankInfo(@RequestBody BankInfo intialBankInfo){



        BankInfo bankInfo  = (BankInfo)bankService.createIntialBankInfo(intialBankInfo);

        if(bankInfo==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(bankInfo, HttpStatus.OK);

    }


    @PutMapping("/withdraw/{id}/{withdrawAmount}")
    public ResponseEntity<BankInfo>  withdraw(@PathVariable long id, @PathVariable double withdrawAmount) {
        BankInfo bankInfo = (BankInfo)bankService.getBalance(id).get();

        if(bankInfo==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bankInfo.setBalance(bankInfo.getBalance()-withdrawAmount);
        bankInfo.setId(id);
        bankInfo  = bankService.createIntialBankInfo(bankInfo);

        return new ResponseEntity<>(bankInfo, HttpStatus.OK);
    }

    @PutMapping("/deposit/{id}/{depositAmount}")
    public ResponseEntity<BankInfo>  deposit(@PathVariable long id, @PathVariable double depositAmount) {

        BankInfo bankInfo = (BankInfo)bankService.getBalance(id).get();

        if(bankInfo==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bankInfo.setBalance(bankInfo.getBalance()+depositAmount);
        bankInfo.setId(id);
        bankInfo  = bankService.createIntialBankInfo(bankInfo);


        return new ResponseEntity<>(bankInfo, HttpStatus.OK);
    }
}
