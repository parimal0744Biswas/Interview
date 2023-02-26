package com.parimal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parimal.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>
{

}
