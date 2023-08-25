package org.lagrange.entity.exw;

public class CalculVenteProduit implements ExwCalcul{

    public Double process(ExwCalculParameters parameters) {
        double masseNette = parameters.getMasseBruteProduitEtEmballage() - parameters.getMasseBruteEmballage();
        double masseNetteTotale = parameters.getQuantite() * masseNette;
        return masseNetteTotale * parameters.getPrixProduitUnitaire() + parameters.getQuantite() * parameters.getPrixEmballageUnitaire();
    }
}