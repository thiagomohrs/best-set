package com.api.bestset.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.bestset.models.SetsModel;
import com.api.bestset.repositories.SetsRepository;

@Service
public class SetsService {
    
    final SetsRepository SetsRepository;


    public SetsService(SetsRepository SetsRepository) {
        this.SetsRepository = SetsRepository;
    }

    @Transactional
    public SetsModel save(SetsModel SetsModel) {
        return SetsRepository.save(SetsModel);
    }

    public List<SetsModel> findAll() {
        return SetsRepository.findAll();
    }

    
    public Optional<SetsModel> findById(UUID id) {
        return SetsRepository.findById(id);
    }

    public List<SetsModel> findByHuntId(UUID huntId) {
        return SetsRepository.findByHuntId(huntId);
    }
}
