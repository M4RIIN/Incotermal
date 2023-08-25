package org.lagrange.entity.exw;

public class CalculCoutDeRevient implements ExwCalcul {

    @Override
    public Double process(ExwCalculParameters parameters) {
        double coutDeRevient = (parameters.getCoutAchatMatierePremiere() +
                parameters.getMainOeuvre() +
                parameters.getConditionnement() +
                parameters.getAutreChargeVariables()) * parameters.getQuantite() +
                parameters.getChargesFixes();
        double marge = 1 - parameters.getMargeCommercialeDepartUsine();
        return coutDeRevient / marge;
    }
}