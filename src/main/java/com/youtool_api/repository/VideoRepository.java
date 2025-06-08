package com.youtool_api.repository;

import com.youtool_api.model.ChannelData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<ChannelData, String> {

}
