package org.lagrange.entity.incoterm;

import org.lagrange.entity.supplychain.CoutAssocie;
import org.lagrange.entity.supplychain.Etape;

public interface PaiementStrategy {

    CoutAssocie getCouts(Etape etape);
}
