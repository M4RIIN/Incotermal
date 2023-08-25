package com.lagrange.controller.rest;

public class PrixVenteProduitEtEmballageRest {
    private double quantite;
    private double masseBruteProduitEtEmballage;
    private double masseBruteEmballage;
    private double prixProduitUnitaire;
    private double prixEmballageUnitaire;

    public PrixVenteProduitEtEmballageRest() {
    }

    public PrixVenteProduitEtEmballageRest(double quantite, double masseBruteProduitEtEmballage, double masseBruteEmballage, double prixProduitUnitaire, double prixEmballageUnitaire) {
        this.quantite = quantite;
        this.masseBruteProduitEtEmballage = masseBruteProduitEtEmballage;
        this.masseBruteEmballage = masseBruteEmballage;
        this.prixProduitUnitaire = prixProduitUnitaire;
        this.prixEmballageUnitaire = prixEmballageUnitaire;
    }

    public double getQuantite() {
        return quantite;
    }

    public double getMasseBruteProduitEtEmballage() {
        return masseBruteProduitEtEmballage;
    }

    public double getMasseBruteEmballage() {
        return masseBruteEmballage;
    }

    public double getPrixProduitUnitaire() {
        return prixProduitUnitaire;
    }

    public double getPrixEmballageUnitaire() {
        return prixEmballageUnitaire;
    }
}
