package com.anurag.SpringMVCConnection.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "conndetails")
public class Connection {

    @Id
    @Column(name = "connection_id", unique = true, nullable = false)
    private String connectionId;

    @Column(name = "connection_type", nullable = false)
    private String connectionType;

    @Column(name = "network_type", nullable = false)
    private String networkType;

    @Column(name = "activation_date", nullable = false)
    private LocalDate activationDate;

    // Default constructor
    public Connection() {}

    // Parameterized constructor
    public Connection(String connectionId, String connectionType, String networkType, LocalDate activationDate) {
        this.connectionId = connectionId;
        this.connectionType = connectionType;
        this.networkType = networkType;
        this.activationDate = activationDate;
    }

    // Getters and setters
    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(LocalDate activationDate) {
        this.activationDate = activationDate;
    }
}
