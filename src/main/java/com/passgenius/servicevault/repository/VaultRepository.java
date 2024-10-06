package com.passgenius.servicevault.repository;

import com.passgenius.servicevault.models.Vault;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VaultRepository extends MongoRepository<Vault, String> {
    List<Vault> findByUserId(String userId);
    void deleteByUserId(String userId);
}
