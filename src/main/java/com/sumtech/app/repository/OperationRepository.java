package com.sumtech.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumtech.app.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{
      
}
