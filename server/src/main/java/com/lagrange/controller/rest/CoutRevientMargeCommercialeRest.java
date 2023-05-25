package com.lagrange.controller.rest;

public class CoutRevientMargeCommercialeRest {
    private double quantite;
    private double coutAchatMatierePremiere;
    private double mainOeuvre;
    private double autreChargeVariables;
    private double chargesFixes;
    private double conditionnement;
    private double margeCommercialeDepartUsine;

    public CoutRevientMargeCommercialeRest() {
    }

    public CoutRevientMargeCommercialeRest(double quantite, double coutAchatMatierePremiere, double mainOeuvre, double autreChargeVariables, double chargesFixes, double conditionnement, double margeCommercialeDepartUsine) {
        this.quantite = quantite;
        this.coutAchatMatierePremiere = coutAchatMatierePremiere;
        this.mainOeuvre = mainOeuvre;
        this.autreChargeVariables = autreChargeVariables;
        this.chargesFixes = chargesFixes;
        this.conditionnement = conditionnement;
        this.margeCommercialeDepartUsine = margeCommercialeDepartUsine;
    }

    public double getQuantite() {
        return quantite;
    }

    public double getCoutAchatMatierePremiere() {
        return coutAchatMatierePremiere;
    }

    public double getMainOeuvre() {
        return mainOeuvre;
    }

    public double getAutreChargeVariables() {
        return autreChargeVariables;
    }

    public double getChargesFixes() {
        return chargesFixes;
    }

    public double getConditionnement() {
        return conditionnement;
    }

    public double getMargeCommercialeDepartUsine() {
        return margeCommercialeDepartUsine;
    }
}
