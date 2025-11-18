package com.univ.notes;
import java.sql.*;

public class EtudiantSQL {

    // UN Ajout D'un étudiant dans la base de données
    public void addEtudiant(Etudiant etudiant) {
        String query = "INSERT INTO etudiants (nom, prenom, email) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, etudiant.getNom());
            stmt.setString(2, etudiant.getPrenom());
            stmt.setString(3, etudiant.getEmail());

            int affectedRows = stmt.executeUpdate();

            // Récupérer l'ID généré
            if (affectedRows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Récupérer l'ID de l'étudiant ajouté
                    etudiant.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // une Récupération d'un étudiant par son ID
    public Etudiant getEtudiantById(int id) {
        Etudiant etudiant = null;
        String query = "SELECT * FROM etudiants WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Paramétrage la requête avec l'ID de l'étudiant
            stmt.setInt(1, id);

            // une exécution de la requête et une recuperation des résultats
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Créer un objet Etudiant avec les données récupérées
                etudiant = new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiant;  // Retourner l'étudiant trouvé, ou null si non trouvé
    }

}
