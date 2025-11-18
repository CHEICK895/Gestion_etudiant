package com.univ.notes;

public class TestEtudiant {
    public static void main(String[] args) {
        EtudiantSQL etudiantSQL = new EtudiantSQL();

        // Création d'un étudiant
        Etudiant etudiant = new Etudiant(0, "Dupont", "Jean", "jean.dupont@example.com");

        // un ajout d'étudiant à la base de données
        etudiantSQL.addEtudiant(etudiant);
        System.out.println("Etudiant ajouté : " + etudiant.getNom());

        // Une Vérification que l'étudiant a bien été ajouté et a un ID valide
        if (etudiant.getId() == 0) {
            System.out.println("Erreur : l'ID de l'étudiant n'a pas été récupéré.");
            return;
        }

        // Creation d'une note pour cet étudiant avec l'ID récupéré
        NotationSQL notationSQL = new NotationSQL();
        Notation notation = new Notation(0, etudiant.getId(), 16.5);
        notationSQL.addNote(notation);
        System.out.println("Note ajoutée : " + notation.getNote());

        // Une Récupération et un affichage de la note
        double noteRecup = notationSQL.getNoteByEtudiantId(etudiant.getId());
        System.out.println("Note récupérée pour l'étudiant : " + noteRecup);
    }
}