package org.lagrange.domain.entity;

import java.util.Arrays;

public class CifStrategy implements PaiementStrategy {

    private final EtapeType[] etapesPrisEnChargeAcheteur = {
            EtapeType.DOUANE_IMPORT,
            EtapeType.DECHARGEMENT,
            EtapeType.STOCKAGE,
            EtapeType.LIVRAISON
    };
    private final EtapeType[] etapesPrisEnChargeFournisseur = {
            EtapeType.COLLECTE,
            EtapeType.EMBALLAGE,
            EtapeType.TRANSPORT_INTERIEUR,
            EtapeType.DOUANE_EXPORT,
            EtapeType.CHARGEMENT,
            EtapeType.TRANSPORT_INTERNATIONAL,

    };
    @Override
    public CoutAssocie getCouts(Etape etape) {
        if(Arrays.asList(etapesPrisEnChargeAcheteur).contains(etape.getType())){
            return new CoutAssocie(etape, PartiePrenante.ACHETEUR);
        } else if(Arrays.asList(etapesPrisEnChargeFournisseur).contains(etape.getType())){
            return new CoutAssocie(etape, PartiePrenante.FOURNISSEUR);
        } else return new CoutAssocie(etape, PartiePrenante.UNDEFINED);
    }
}
