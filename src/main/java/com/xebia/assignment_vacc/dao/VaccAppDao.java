package com.xebia.assignment_vacc.dao;

import com.xebia.assignment_vacc.entities.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VaccAppDao extends CrudRepository<Model, Integer> {

    @Query(value = "SELECT * FROM VACC_APP WHERE branch_name = ?1 and availability=true", nativeQuery = true)
    Optional<Model> findByBranchAvailability(String branchName);

    @Query(value = "SELECT * FROM VACC_APP WHERE branch_name = ?1", nativeQuery = true)
    Optional<Model> findByBranchName(String branchName);


}
