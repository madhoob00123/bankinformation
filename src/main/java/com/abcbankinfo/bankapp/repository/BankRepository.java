package com.abcbankinfo.bankapp.repository;


import com.abcbankinfo.bankapp.model.BankInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankInfo,Long> {

}
