package org.lagrange.domain.entity;

import org.junit.jupiter.api.Test;
import org.lagrange.domain.utils.SupplyChainUtils;
import org.lagrange.entity.incoterm.*;
import org.lagrange.entity.supplychain.PartiePrenante;
import org.lagrange.entity.supplychain.SupplyChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SupplyChainTest {

    @Test
    void shouldAttributeCorrectlyEtapeForFOB(){
        Incoterm incoterm = new Incoterm(IncotermType.FOB,new FobStrategy());

        SupplyChain supplyChain = SupplyChainUtils.createSupplyChain(incoterm);

        supplyChain.start();

        assertEquals(5, supplyChain.getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.ACHETEUR).size());
        assertEquals(5, supplyChain.getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.FOURNISSEUR).size());

        assertEquals(1100,supplyChain.getCoutsPourPartiePrenante(PartiePrenante.ACHETEUR));
        assertEquals(1400,supplyChain.getCoutsPourPartiePrenante(PartiePrenante.FOURNISSEUR));
    }

    @Test
    void shouldAttributeCorrectlyEtapeForCIF(){
        Incoterm incoterm = new Incoterm(IncotermType.CIF,new CifStrategy());

        SupplyChain supplyChain = SupplyChainUtils.createSupplyChain(incoterm);

        supplyChain.start();

        assertEquals(4, supplyChain.getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.ACHETEUR).size());
        assertEquals(6, supplyChain.getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.FOURNISSEUR).size());

        assertEquals(900,supplyChain.getCoutsPourPartiePrenante(PartiePrenante.ACHETEUR));
        assertEquals(1600,supplyChain.getCoutsPourPartiePrenante(PartiePrenante.FOURNISSEUR));
    }

    @Test
    void shouldAttributeCorrectlyEtapeForFAS(){
        Incoterm incoterm = new Incoterm(IncotermType.FAS,new FasStrategy());

        SupplyChain supplyChain = SupplyChainUtils.createSupplyChain(incoterm);

        supplyChain.start();

        assertEquals(4,supplyChain.getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.ACHETEUR).size());
        assertEquals(5,supplyChain.getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.FOURNISSEUR).size());
        assertEquals(1,supplyChain.getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.UNDEFINED).size());

        assertEquals(900,supplyChain.getCoutsPourPartiePrenante(PartiePrenante.ACHETEUR));
        assertEquals(1400,supplyChain.getCoutsPourPartiePrenante(PartiePrenante.FOURNISSEUR));
        assertEquals(200,supplyChain.getCoutsPourPartiePrenante(PartiePrenante.UNDEFINED));
    }

}