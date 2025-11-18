package com.univ.notes;
public class Notation {

    private int id;
    private int etudiantId;
    private double note;

    // Constructeur
    public Notation(int id, int etudiantId, double note) {
        this.id = id;
        this.etudiantId = etudiantId;
        this.note = note;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}


