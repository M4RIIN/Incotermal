package org.lagrange.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuiviCouts {

    private final List<CoutAssocie> coutAssocies;

    public SuiviCouts() {
        coutAssocies = new ArrayList<>();
    }

    public void processEtape(Etape etape, PaiementStrategy paiementStrategie) {
        coutAssocies.add(paiementStrategie.getCouts(etape));
    }

    public List<CoutAssocie> getCoutForPartiePrenante(PartiePrenante partiePrenante){
        return coutAssocies.stream()
                .filter(coutAssocie -> coutAssocie.getPartiePrenante().equals(partiePrenante))
                .collect(Collectors.toList());
    }
}
