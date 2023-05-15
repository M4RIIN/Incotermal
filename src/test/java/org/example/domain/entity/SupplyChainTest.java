package org.example.domain.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SupplyChainTest {

    @Test
    void shouldAttributeCorrectlyEtapeForFOB(){
        List<Etape> etapes = new ArrayList<>();
        CoutEtape coutEtapCollecte1 = new CoutEtape("Coût d'emballage des marchandises");
        CoutEtape coutEtapCollecte2 = new CoutEtape("Coût de manutention des marchandises");
        CoutEtape coutEtapCollecte3 = new CoutEtape("Coût d'entreposage temporaire si nécessaire");
        CoutEtape coutEtapCollecte4 = new CoutEtape("Coût de l'assurance des marchandises jusqu'au port d'embarquement");

        CoutEtape coutEtapEmballage = new CoutEtape("Coût des matériaux d'emballage (caisses, palettes, etc.)");
        CoutEtape coutEtapEmballage2 = new CoutEtape("Coût de la main-d'œuvre pour l'emballage des marchandises");

        CoutEtape coutEtapTransportInterieur1 = new CoutEtape("Coût de transport des marchandises jusqu'au port d'embarquement (camion, train, etc.)");
        CoutEtape coutEtapTransportInterieur2 = new CoutEtape("Coût de manutention des marchandises lors du chargement sur le véhicule de transport");

        CoutEtape coutEtapDouaneExport1 = new CoutEtape("Coût des formalités douanières (déclaration en douane, autorisations, etc.)");
        CoutEtape coutEtapDouaneExport2 = new CoutEtape("Coût des taxes à l'exportation (le cas échéant)");
        CoutEtape coutEtapDouaneExport3 = new CoutEtape("Coût de l'inspection ou de la certification des marchandises (le cas échéant)");

        CoutEtape coutEtapChargement1 = new CoutEtape("Coût de manutention des marchandises pour les charger sur le navire");
        CoutEtape coutEtapChargement2 = new CoutEtape("Coût de location du conteneur si nécessaire");
        CoutEtape coutEtapChargement3 = new CoutEtape("Coût de l'arrimage et de la sécurisation des marchandises dans le conteneur");

        CoutEtape coutEtapTransportInternational1 = new CoutEtape("Coût du fret maritime (calculé en fonction du volume, du poids et de la distance)");
        CoutEtape coutEtapTransportInternational2 = new CoutEtape("Coût de l'assurance des marchandises pendant le transport maritime");

        CoutEtape coutEtapDouaneImport1 = new CoutEtape("Coût des formalités douanières (déclaration en douane, autorisations, etc.)");
        CoutEtape coutEtapDouaneImport2 = new CoutEtape("Coût des taxes à l'importation (le cas échéant)");
        CoutEtape coutEtapDouaneImport3 = new CoutEtape("Coût de l'inspection ou de la certification des marchandises (le cas échéant)");

        CoutEtape coutEtapDechargement1 = new CoutEtape("Coût de manutention des marchandises pour les décharger du navire");
        CoutEtape coutEtapDechargement2 = new CoutEtape("Coût de location du conteneur si nécessaire");

        CoutEtape coutEtapStockage1 = new CoutEtape("Coût de l'entreposage des marchandises dans le port d'arrivée");
        CoutEtape coutEtapStockage2 = new CoutEtape("Coût de l'assurance des marchandises pendant l'entreposage");

        CoutEtape coutEtapLivraison1 = new CoutEtape("Coût de transport des marchandises de l'entrepôt du port d'arrivée à la destination finale");
        CoutEtape coutEtapLivraison2 = new CoutEtape("Coût de manutention des marchandises lors de la livraison");

        etapes.add(new EtapeCollecte(EtapeType.COLLECTE, Arrays.asList(coutEtapCollecte1,coutEtapCollecte2,coutEtapCollecte3,coutEtapCollecte4)));
        etapes.add(new EtapeCollecte(EtapeType.EMBALLAGE, Arrays.asList(coutEtapEmballage,coutEtapEmballage2)));
        etapes.add(new EtapeCollecte(EtapeType.TRANSPORT_INTERIEUR, Arrays.asList(coutEtapTransportInterieur1,coutEtapTransportInterieur2)));
        etapes.add(new EtapeCollecte(EtapeType.DOUANE_EXPORT, Arrays.asList(coutEtapDouaneExport1,coutEtapDouaneExport2,coutEtapDouaneExport3)));
        etapes.add(new EtapeCollecte(EtapeType.CHARGEMENT, Arrays.asList(coutEtapChargement1,coutEtapChargement2,coutEtapChargement3)));
        etapes.add(new EtapeCollecte(EtapeType.TRANSPORT_INTERNATIONAL, Arrays.asList(coutEtapTransportInternational1,coutEtapTransportInternational2)));
        etapes.add(new EtapeCollecte(EtapeType.DOUANE_IMPORT, Arrays.asList(coutEtapDouaneImport1,coutEtapDouaneImport2,coutEtapDouaneImport3)));
        etapes.add(new EtapeCollecte(EtapeType.DECHARGEMENT, Arrays.asList(coutEtapDechargement1,coutEtapDechargement2)));
        etapes.add(new EtapeCollecte(EtapeType.STOCKAGE, Arrays.asList(coutEtapStockage1,coutEtapStockage2)));
        etapes.add(new EtapeCollecte(EtapeType.LIVRAISON, Arrays.asList(coutEtapLivraison1,coutEtapLivraison2)));
        Incoterm incoterm = new Incoterm(IncotermType.FOB,new FobStrategy());
        SupplyChain supplyChain = new SupplyChain(etapes,incoterm);

        supplyChain.start();

        assertTrue(supplyChain.getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.ACHETEUR).size() == 5);
        assertTrue(supplyChain.getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.FOURNISSEUR).size() == 5);

        assertEquals(4300,supplyChain.getCoutsPourPartiePrenante(PartiePrenante.ACHETEUR));
        assertEquals(2861,supplyChain.getCoutsPourPartiePrenante(PartiePrenante.FOURNISSEUR));
    }

}