package com.anurag.SpringMVCConnection.service;

import com.anurag.SpringMVCConnection.model.Connection;
import com.anurag.SpringMVCConnection.repo.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService {

    @Autowired
    private ConnectionRepository connectionRepository;

    // Save connection
    public Connection saveConnection(Connection connection) {
        // Save the connection to the database and return the saved entity
        return connectionRepository.save(connection);
    }
}
