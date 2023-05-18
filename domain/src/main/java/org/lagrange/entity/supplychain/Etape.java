package org.lagrange.entity.supplychain;

import java.util.List;

public interface Etape {
    EtapeType getType();

    List<CoutEtape> getCoutEtape();
}
