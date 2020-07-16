package com.example.interviews.repo;

import com.example.interviews.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value = "SELECT MAX(ID) FROM company", nativeQuery = true)
    int greatestId();
}
