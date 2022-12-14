package com.api.bestset.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.bestset.dtos.SetsDto;
import com.api.bestset.models.SetsModel;

import com.api.bestset.services.SetsService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sets")
public class SetsController {

    final SetsService SetsService;

    public SetsController(SetsService SetsService) {
        this.SetsService = SetsService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveSet(@RequestBody @Valid SetsDto SetsDTO){
        var SetsModel = new SetsModel();
        BeanUtils.copyProperties(SetsDTO, SetsModel);
        var time = LocalDateTime.now(ZoneId.of("UTC"));
        SetsModel.setCreatedDate(time);
        SetsModel.setLastUpdatedDate(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(SetsService.save(SetsModel));
    }

    @GetMapping
    public ResponseEntity<List<SetsModel>> getAllSets(){
        return ResponseEntity.status(HttpStatus.OK).body(SetsService.findAll());
    }

    @GetMapping("/hunt/{huntId}")
    public ResponseEntity<List<SetsModel>> getSetsByHuntId(@PathVariable UUID huntId){
        return ResponseEntity.status(HttpStatus.OK).body(SetsService.findByHuntId(huntId));
    }
}
