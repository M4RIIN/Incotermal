package org.lagrange.entity.incoterm;

public class Incoterm {

    private final IncotermType type;
    private final PaiementStrategy paiementStrategy;
    public Incoterm(IncotermType type, PaiementStrategy paiementStrategy) {
        this.type = type;
        this.paiementStrategy = paiementStrategy;
    }

    public IncotermType getType() {
        return this.type;
    }

    public PaiementStrategy getPaiementStrategie() {
        return paiementStrategy;
    }
}
