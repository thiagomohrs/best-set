package com.api.bestset.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.bestset.models.HuntsModel;

import com.api.bestset.dtos.HuntsDTO;

import com.api.bestset.services.HuntsService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/hunts")
public class HuntsController extends ResponseEntityExceptionHandler{

    final HuntsService HuntsService;

    public HuntsController(HuntsService HuntsService) {
        this.HuntsService = HuntsService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveHunt(@RequestBody @Valid HuntsDTO HuntsDto){
        var HuntsModel = new HuntsModel();
        BeanUtils.copyProperties(HuntsDto, HuntsModel);
        var time = LocalDateTime.now(ZoneId.of("UTC"));
        HuntsModel.setCreatedDate(time);
        HuntsModel.setLastUpdatedDate(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(HuntsService.save(HuntsModel));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> updateHunt(@PathVariable UUID id, @RequestBody @Valid HuntsDTO HuntsDto) throws NotFoundException{
        var HuntsModel = HuntsService.findById(id).orElseThrow(NotFoundException::new);
        var time = LocalDateTime.now(ZoneId.of("UTC"));
        HuntsModel.setLastUpdatedDate(time);
        return ResponseEntity.status(HttpStatus.OK).body(HuntsService.save(HuntsModel));

    }

    @GetMapping
    public ResponseEntity<List<HuntsModel>> getAllHunts(){
        return ResponseEntity.status(HttpStatus.OK).body(HuntsService.findAll());
    }
}
