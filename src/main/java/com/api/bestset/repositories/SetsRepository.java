package com.api.bestset.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.bestset.models.SetsModel;

@Repository
public interface SetsRepository extends JpaRepository<SetsModel, UUID> {

    @Query(
        value = "SELECT * FROM tb_sets WHERE tb_sets.hunt_id = 1", 
        nativeQuery = true)
        List<SetsModel> findByHuntId(UUID huntId);
}