package com.passgenius.servicevault.service;


import com.passgenius.servicevault.models.Vault;
import com.passgenius.servicevault.repository.VaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class VaultService {

    @Autowired
    VaultRepository vaultRepository;


    public Vault saveVault(Vault vault) {
        if (vault.getId().isBlank()){
            vault.setId(UUID.randomUUID().toString());
        }
        vault.setCreatedAt(LocalDateTime.now().toString());
        return vaultRepository.save(vault);
    }
    public List<Vault> getVaultsForUser(String userId){
        return vaultRepository.findByUserId(userId);
    }

    public void deleteVault(String id) throws IOException {
       var isPresent = vaultRepository.existsById(id);
       if (!isPresent){
           throw new IOException("Vault doesn't exist");
       }
       vaultRepository.deleteById(id);
    }
    public void deleteVaultByUserId(String userId){
       vaultRepository.deleteByUserId(userId);
    }
}
