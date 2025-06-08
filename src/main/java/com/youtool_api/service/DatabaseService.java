package com.youtool_api.service;

import com.youtool_api.model.ChannelData;
import com.youtool_api.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    private VideoRepository repository;

    public ChannelData salvar(ChannelData dados) {
        return repository.save(dados);
    }
}
