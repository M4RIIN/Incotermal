package org.lagrange.entity.exw;

public class ExwCalculParameters {

    private final double quantite;
    private final double coutAchatMatierePremiere;
    private final double mainOeuvre;
    private final double autreChargeVariables;
    private final double chargesFixes;
    private final double conditionnement;
    private final double margeCommercialeDepartUsine;
    private final double prixVenteUnitaire;
    private final double masseBruteProduitEtEmballage;
    private final double masseBruteEmballage;
    private final double prixProduitUnitaire;
    private final double prixEmballageUnitaire;


    public ExwCalculParameters(double quantite, double coutAchatMatierePremiere, double mainOeuvre, double autreChargeVariables, double chargesFixes, double conditionnement, double margeCommercialeDepartUsine, double prixVenteUnitaire, double masseBruteProduitEtEmballage, double masseBruteEmballage, double prixProduitUnitaire, double prixEmballageUnitaire) {
        this.quantite = quantite;
        this.coutAchatMatierePremiere = coutAchatMatierePremiere;
        this.mainOeuvre = mainOeuvre;
        this.autreChargeVariables = autreChargeVariables;
        this.chargesFixes = chargesFixes;
        this.conditionnement = conditionnement;
        this.margeCommercialeDepartUsine = margeCommercialeDepartUsine;
        this.prixVenteUnitaire = prixVenteUnitaire;
        this.masseBruteProduitEtEmballage = masseBruteProduitEtEmballage;
        this.masseBruteEmballage = masseBruteEmballage;
        this.prixProduitUnitaire = prixProduitUnitaire;
        this.prixEmballageUnitaire = prixEmballageUnitaire;
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

    public double getPrixVenteUnitaire() {
        return prixVenteUnitaire;
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

   public static class Builder{

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

        public Builder setParametersForCalculCoutRevient(double quantite, double coutAchatMatierePremiere, double mainOeuvre, double autreChargeVariables, double chargesFixes, double conditionnement, double margeCommercialeDepartUsine) {
            this.quantite = quantite;
            this.coutAchatMatierePremiere = coutAchatMatierePremiere;
            this.mainOeuvre = mainOeuvre;
            this.autreChargeVariables = autreChargeVariables;
            this.chargesFixes = chargesFixes;
            this.conditionnement = conditionnement;
            this.margeCommercialeDepartUsine = margeCommercialeDepartUsine;
            return this;
        }


        public Builder setQuantite(double quantite) {
            this.quantite = quantite;
            return this;
        }

        public Builder setCoutAchatMatierePremiere(double coutAchatMatierePremiere) {
            this.coutAchatMatierePremiere = coutAchatMatierePremiere;
            return this;
        }

        public Builder setMainOeuvre(double mainOeuvre) {
            this.mainOeuvre = mainOeuvre;
            return this;
        }

        public Builder setAutreChargeVariables(double autreChargeVariables) {
            this.autreChargeVariables = autreChargeVariables;
            return this;
        }

        public Builder setChargesFixes(double chargesFixes) {
            this.chargesFixes = chargesFixes;
            return this;
        }

        public Builder setConditionnement(double conditionnement) {
            this.conditionnement = conditionnement;
            return this;
        }

        public Builder setMargeCommercialeDepartUsine(double margeCommercialeDepartUsine) {
            this.margeCommercialeDepartUsine = margeCommercialeDepartUsine;
            return this;
        }

        public Builder setPrixVenteUnitaire(double prixVenteUnitaire) {
            this.prixVenteUnitaire = prixVenteUnitaire;
            return this;
        }

        public Builder setMasseBruteProduitEtEmballage(double masseBruteProduitEtEmballage) {
            this.masseBruteProduitEtEmballage = masseBruteProduitEtEmballage;
            return this;
        }

        public Builder setMasseBruteEmballage(double masseBruteEmballage) {
            this.masseBruteEmballage = masseBruteEmballage;
            return this;
        }

        public Builder setPrixProduitUnitaire(double prixProduitUnitaire) {
            this.prixProduitUnitaire = prixProduitUnitaire;
            return this;
        }

        public Builder setPrixEmballageUnitaire(double prixEmballageUnitaire) {
            this.prixEmballageUnitaire = prixEmballageUnitaire;
            return this;
        }


        public ExwCalculParameters build(){
            return new ExwCalculParameters(quantite,coutAchatMatierePremiere,mainOeuvre,autreChargeVariables,chargesFixes,
                    conditionnement,margeCommercialeDepartUsine,prixVenteUnitaire,masseBruteProduitEtEmballage,masseBruteEmballage,
                    prixProduitUnitaire,prixEmballageUnitaire);
        }
    }
}