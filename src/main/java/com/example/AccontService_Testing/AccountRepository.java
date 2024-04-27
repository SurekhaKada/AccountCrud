package com.example.AccontService_Testing;


import com.example.AccontService_Testing.Account;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AccountRepository extends JpaRepository<Account, Integer> {

}