package com.example.LibrarySystemApplication.repository;

import com.example.LibrarySystemApplication.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower,Long> {
}
