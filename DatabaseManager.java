package com.univ.notes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_notes"; // Remplace localhost si nécessaire
    private static final String USER = "root";  // Remplace par ton utilisateur MySQL
    private static final String PASSWORD = ""; // Remplace par ton mot de passe MySQL

    // une Méthode pour établir la connexion
    public static Connection getConnection() throws SQLException {
        try {
            // Chargement du driver JDBC pour MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver JDBC non trouvé");
        }
    }
}

