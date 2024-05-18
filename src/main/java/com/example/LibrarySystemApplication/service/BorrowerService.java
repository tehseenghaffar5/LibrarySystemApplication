package com.example.LibrarySystemApplication.service;

import com.example.LibrarySystemApplication.entity.Borrower;
import com.example.LibrarySystemApplication.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    public Borrower registerBorrower(Borrower borrower)
    {
        return  borrowerRepository.save(borrower);
    }

    public List<Borrower> getAllBorrowers()
    {
        return borrowerRepository.findAll();
    }
}
