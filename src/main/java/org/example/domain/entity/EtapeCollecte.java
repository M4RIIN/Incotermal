package org.example.domain.entity;

import java.util.List;

public class EtapeCollecte implements Etape {
    private final EtapeType type;
    private final List<CoutEtape> coutEtape;

    public EtapeCollecte(EtapeType type, List<CoutEtape> coutEtape) {
        this.type = type;
        this.coutEtape = coutEtape;
    }

    @Override
    public EtapeType getType() {
        return type;
    }

    @Override
    public List<CoutEtape> getCoutEtape() {
        return coutEtape;
    }
}
