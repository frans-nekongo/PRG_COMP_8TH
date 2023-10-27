package com.example.aims;

import java.util.HashMap;
import java.util.Map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class E_Voting {
    private Connection connection;

    public E_Voting() {
        // Initialize the database connection here (you'll need to set up your database connection details)
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Allow an alumni to cast their vote for a candidate
    public void vote(String voterName, String candidateName) {
        if (isValidCandidate(candidateName)) {
            try {
                // Update the vote count in the database
                String sql = "UPDATE candidates SET votes = votes + 1 WHERE name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, candidateName);
                preparedStatement.executeUpdate();
                System.out.println(voterName + " voted for " + candidateName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid candidate name.");
        }
    }

    // Check if the candidate exists in the database
    private boolean isValidCandidate(String candidateName) {
        try {
            String sql = "SELECT * FROM candidates WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, candidateName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Display the election results
    public void displayResults() {
        try {
            String sql = "SELECT name, position, votes FROM candidates";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Election Results:");
            while (resultSet.next()) {
                String candidateName = resultSet.getString("name");
                String position = resultSet.getString("position");
                int numVotes = resultSet.getInt("votes");
                System.out.println(candidateName + " (" + position + "): " + numVotes + " votes");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        E_Voting votingSystem = new E_Voting();

        // Simulate voting
        votingSystem.vote("Alumni 1", "Candidate A");
        votingSystem.vote("Alumni 2", "Candidate A");
        votingSystem.vote("Alumni 3", "Candidate B");
        votingSystem.vote("Alumni 4", "Invalid Candidate"); // Invalid vote

        // Display results
        votingSystem.displayResults();
    }
}


