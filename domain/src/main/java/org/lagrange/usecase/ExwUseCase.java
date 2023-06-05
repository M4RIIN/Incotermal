package org.lagrange.usecase;

import org.lagrange.entity.exw.*;

public class ExwUseCase {


    public double getCoutDeRevient(ExwCalculParameters exwCalculParameters){
        ExwCalcul calcul = new CalculCoutDeRevient();
        return calcul.process(exwCalculParameters);
    }

    public double getCoutVenteProduit(ExwCalculParameters exwCalculParameters){
        return new CalculVenteProduit().process(exwCalculParameters);
    }

    public double getCoutVenteUnitaire(ExwCalculParameters exwCalculParameters){
        return new CalculVenteUnitaire().process(exwCalculParameters);
    }
}
