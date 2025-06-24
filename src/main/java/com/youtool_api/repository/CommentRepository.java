package com.youtool_api.repository;

import com.youtool_api.model.VideoComments;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<VideoComments, String> {

}
