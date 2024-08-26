package com.companyproject.journalApp.repository;


import com.companyproject.journalApp.entity.ConfigJournalAppEntity;
import com.companyproject.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {


}
