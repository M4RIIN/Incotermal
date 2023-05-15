package org.example.domain.entity;

import java.util.List;

public interface Etape {
    EtapeType getType();

    List<CoutEtape> getCoutEtape();
}
