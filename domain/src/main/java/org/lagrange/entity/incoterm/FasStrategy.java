package org.lagrange.entity.incoterm;

import org.lagrange.entity.supplychain.CoutAssocie;
import org.lagrange.entity.supplychain.Etape;
import org.lagrange.entity.supplychain.EtapeType;
import org.lagrange.entity.supplychain.PartiePrenante;

import java.util.Arrays;

public class FasStrategy implements PaiementStrategy {

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
            EtapeType.CHARGEMENT
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
