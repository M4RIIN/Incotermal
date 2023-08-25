package org.lagrange.entity;

public class Exw {

    private double quantite;
    private double coutAchatMatierePremiere;
    private double mainOeuvre;
    private double autreChargeVariables;
    private double chargesFixes;
    private double conditionnement;
    private double margeCommercialeDepartUsine;


    private double prixVenteUnitaire;


    private double masseBruteProduitEtEmballage;
    private double masseBruteEmballage;
    private double prixProduitUnitaire;
    private double prixEmballageUnitaire;

    public Exw(double quantite, double coutAchatMatierePremiere, double mainOeuvre, double autreChargeVariables, double chargesFixes, double conditionnement, double margeCommerciale){

        this.quantite = quantite;
        this.coutAchatMatierePremiere = coutAchatMatierePremiere;
        this.mainOeuvre = mainOeuvre;
        this.autreChargeVariables = autreChargeVariables;
        this.chargesFixes = chargesFixes;
        this.conditionnement = conditionnement;
        this.margeCommercialeDepartUsine = margeCommerciale;
    }

    public Exw(double prixVenteUnitaire, double quantite) {
        this.prixVenteUnitaire = prixVenteUnitaire;
        this.quantite = quantite;
    }

    public Exw(double masseBruteProduit, double masseBruteEmballage, double prixProduitUnitaire, double prixEmballageUnitaire) {
        this.masseBruteProduitEtEmballage = masseBruteProduit;
        this.masseBruteEmballage = masseBruteEmballage;
        this.prixProduitUnitaire = prixProduitUnitaire;
        this.prixEmballageUnitaire = prixEmballageUnitaire;
    }

    public double byCoutDeRevientEtMargeCommerciale(){
        double coutDeRevient = (coutAchatMatierePremiere +
                mainOeuvre  +
                conditionnement +
                autreChargeVariables) * quantite +
                chargesFixes;
        double marge = 1 - margeCommercialeDepartUsine;
        return  coutDeRevient/marge;
    }

    public double byPrixVenteUnitaireEtQuantite(){
        return quantite * prixVenteUnitaire;
    }

    public double byPrixVenteProduitEtEmballage(){
        double masseNette = masseBruteProduitEtEmballage - masseBruteEmballage;
        double masseNetteTotale = quantite * masseNette;
        return masseNetteTotale * prixProduitUnitaire + quantite * prixEmballageUnitaire;

    }

}
