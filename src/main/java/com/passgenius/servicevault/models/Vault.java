package com.passgenius.servicevault.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "vaults")
public class Vault implements Serializable {
    private String id;
    private String userId;
    private List<Field> fields;
    private String name;
    private String createdAt;

    public Vault() {
        this.id = ""; // Generate a unique ID
        this.userId = "";
        this.fields = new ArrayList<>(); // Default to an empty list
        this.name = "";
        this.createdAt = LocalDateTime.now().toString();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

