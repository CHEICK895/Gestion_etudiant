package com.univ.notes;
import java.sql.*;

public class NotationSQL {

    // UN  Ajout DE note pour un étudiant dans la base de données
    public void addNote(Notation notation) {
        String query = "INSERT INTO notations (etudiant_id, note) VALUES (?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Utiliser l'ID de l'étudiant récupéré précédemment
            stmt.setInt(1, notation.getEtudiantId());
            stmt.setDouble(2, notation.getNote());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // RécupérATION DE  toutes les notes d'un étudiant par son ID
    public double getNoteByEtudiantId(int etudiantId) {
        double note = -1;
        String query = "SELECT note FROM notations WHERE etudiant_id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Paramétrer la requête avec l'ID de l'étudiant
            stmt.setInt(1, etudiantId);

            // Exécuter la requête et récupérer la note
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                note = rs.getDouble("note");  // Retourner la première note trouvée
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return note;  // Retourner la note, ou -1 si aucune note n'est trouvée
    }

    // Ajouter d'autres méthodes si nécessaire pour la suppression ou la mise à jour des notes
}

