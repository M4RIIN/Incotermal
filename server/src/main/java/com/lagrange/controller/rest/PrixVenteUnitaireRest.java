package com.lagrange.controller.rest;

public class PrixVenteUnitaireRest {
    private double quantite;
    private double prixVenteUnitaire;

    public PrixVenteUnitaireRest() {
    }

    public PrixVenteUnitaireRest(double quantite, double prixVenteUnitaire) {
        this.quantite = quantite;
        this.prixVenteUnitaire = prixVenteUnitaire;
    }

    public double getQuantite() {
        return quantite;
    }

    public double getPrixVenteUnitaire() {
        return prixVenteUnitaire;
    }
}
