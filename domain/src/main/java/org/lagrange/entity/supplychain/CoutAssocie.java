package org.lagrange.entity;

public class CoutAssocie {
    Etape etape;
    private final PartiePrenante partiePrenante;

    public CoutAssocie(Etape etape, PartiePrenante partiePrenante) {
        this.etape = etape;
        this.partiePrenante = partiePrenante;
    }

    public PartiePrenante getPartiePrenante() {
        return partiePrenante;
    }

    public Etape getEtape() {
        return etape;
    }
}
