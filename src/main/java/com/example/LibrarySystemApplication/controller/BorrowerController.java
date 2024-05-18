package com.example.LibrarySystemApplication.controller;

import com.example.LibrarySystemApplication.entity.Borrower;
import com.example.LibrarySystemApplication.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @PostMapping
    public ResponseEntity<Borrower> registerBorrower(@RequestBody Borrower borrower)
    {
        Borrower newBorrower = borrowerService.registerBorrower(borrower);
        return ResponseEntity.ok(newBorrower);
    }

    public ResponseEntity<List<Borrower>> getAllBorrowers(){
        List<Borrower>  borrowers = borrowerService.getAllBorrowers();
        return  ResponseEntity.ok(borrowers);
    }

}
