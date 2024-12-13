package com.anurag.SpringMVCConnection.controller;

import com.anurag.SpringMVCConnection.model.Connection;
import com.anurag.SpringMVCConnection.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    // Display the form to apply for a new connection
    @GetMapping("/apply")
    public String showForm(Model model) {
        model.addAttribute("connection", new Connection());
        return "apply"; // Name of the HTML file (apply.html)
    }

    // Handle the POST request to submit a new connection application
    @PostMapping("/submit")
    public String submitConnection(@ModelAttribute("connection") Connection connection, Model model) {
        // Manual validation (for example, if connectionId is empty)
        boolean hasErrors = false;

        // Validate connectionId
        if (connection.getConnectionId() == null || connection.getConnectionId().trim().isEmpty()) {
            model.addAttribute("connectionIdError", "Customer ID is required.");
            hasErrors = true;
        }

        // Validate connectionType
        if (connection.getConnectionType() == null || connection.getConnectionType().trim().isEmpty()) {
            model.addAttribute("connectionTypeError", "Connection Type is required.");
            hasErrors = true;
        }

        // Validate networkType
        if (connection.getNetworkType() == null || connection.getNetworkType().trim().isEmpty()) {
            model.addAttribute("networkTypeError", "Network Type is required.");
            hasErrors = true;
        }

        // Validate activationDate
        if (connection.getActivationDate() == null) {
            model.addAttribute("activationDateError", "Activation Date is required.");
            hasErrors = true;
        }

        // If there are errors, redisplay the form with the current data
        if (hasErrors) {
            model.addAttribute("connection", connection);
            return "apply"; // Returning the apply form with error messages
        }

        // If validation passes, save the connection
        connectionService.saveConnection(connection);

        // Redirect to a success page or another page
        return "redirect:/apply"; // Replace with your desired success page
    }
}
