package com.anurag.SpringMVCConnection.repo;

import com.anurag.SpringMVCConnection.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, String> {
    // JpaRepository provides basic CRUD operations automatically
    // You can add custom queries here if needed
}
