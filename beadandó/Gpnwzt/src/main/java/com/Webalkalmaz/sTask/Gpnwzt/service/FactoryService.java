package com.Webalkalmaz.sTask.Gpnwzt.service;

import java.util.List;

import com.Webalkalmaz.sTask.Gpnwzt.models.Factory;
import com.Webalkalmaz.sTask.Gpnwzt.repositories.FactoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryService {
    
    @Autowired
    private FactoryRepository factoryRepository;

    public List<Factory> findAll() {
        return (List<Factory>) factoryRepository.findAll();
    }

    public Factory findById(long id){
        
       return factoryRepository.findById(id).get();
    }

    public void save(Factory factory){
        factoryRepository.save(factory);
    }

    public void delete(Factory factory){
        factoryRepository.delete(factory);
    }
}
