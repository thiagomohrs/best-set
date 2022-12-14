package com.api.bestset.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bestset.models.HuntsModel;

@Repository
public interface HuntsRepository extends JpaRepository<HuntsModel, UUID> {

}