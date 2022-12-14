package com.api.bestset.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.bestset.models.HuntsModel;
import com.api.bestset.repositories.HuntsRepository;

@Service
public class HuntsService {
    
    final HuntsRepository HuntsRepository;

    public HuntsService(HuntsRepository HuntsRepository) {
        this.HuntsRepository = HuntsRepository;
    }

    @Transactional
    public HuntsModel save(HuntsModel HuntsModel) {
        return HuntsRepository.save(HuntsModel);
    }

    public List<HuntsModel> findAll() {
        return HuntsRepository.findAll();
    }

    public Optional<HuntsModel> findById(UUID id) {
        return HuntsRepository.findById(id);
    }
}
