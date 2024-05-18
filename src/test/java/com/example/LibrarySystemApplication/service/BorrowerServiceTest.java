package com.example.LibrarySystemApplication.service;

import com.example.LibrarySystemApplication.entity.Borrower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BorrowerServiceTest {

    @Autowired
    private BorrowerService borrowerService;

    @Test
    void testRegisterBorrower(){
        Borrower borrower = new Borrower();
        borrower.setName("Tehsin");
        borrower.setEmail("tehseen.ghaffar5@gmail.com");
        Borrower savedBorrower = borrowerService.registerBorrower(borrower);
    }
}
