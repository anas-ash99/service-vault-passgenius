package com.passgenius.servicevault.controller;

import com.passgenius.servicevault.models.Vault;
import com.passgenius.servicevault.service.VaultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class VaultController {
    Logger logger = LoggerFactory.getLogger(VaultController.class);
    @Autowired
    VaultService vaultService;

    @PostMapping("/")
    public ResponseEntity<?> createVault(@RequestBody Vault vault) {
        return ResponseEntity.status(201).body(vaultService.saveVault(vault));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getVaultsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(vaultService.getVaultsForUser(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        try {
            vaultService.deleteVault(id);
            return ResponseEntity.ok("Vault deleted successfully");
        }catch (IOException e){
            logger.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body("Error deleting Vault: " + e.getMessage());
        }

    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteByUserId(@PathVariable String userId) {
        vaultService.deleteVaultByUserId(userId);
        return ResponseEntity.ok("Vaults for user: " + userId + " deleted successfully");
    }

}
