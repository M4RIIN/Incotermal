package org.lagrange.entity.exw;

public class CalculVenteUnitaire implements ExwCalcul{

    public Double process(ExwCalculParameters parameters) {
        return parameters.getQuantite() * parameters.getPrixVenteUnitaire();
    }
}