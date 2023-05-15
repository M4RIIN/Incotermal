package org.example;

import org.example.domain.entity.CoutEtape;
import org.example.domain.entity.Etape;
import org.example.domain.entity.EtapeCollecte;
import org.example.domain.entity.EtapeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EtapeUtils {

    public static Etape createEtapeByEtapeType(EtapeType etapeType) {
        return new EtapeCollecte(etapeType,createCoutEtapeForEtape(etapeType));
    }

    public static List<CoutEtape> createCoutEtapeForEtape(EtapeType etapeType){
        switch (etapeType){
            case LIVRAISON -> {
                CoutEtape coutEtapLivraison1 = new CoutEtape("Coût de transport des marchandises de l'entrepôt du port d'arrivée à la destination finale");
                CoutEtape coutEtapLivraison2 = new CoutEtape("Coût de manutention des marchandises lors de la livraison");
                return Arrays.asList(coutEtapLivraison1,coutEtapLivraison2);
            }
            case STOCKAGE -> {
                CoutEtape coutEtapStockage1 = new CoutEtape("Coût de l'entreposage des marchandises dans le port d'arrivée");
                CoutEtape coutEtapStockage2 = new CoutEtape("Coût de l'assurance des marchandises pendant l'entreposage");
                return  Arrays.asList(coutEtapStockage1,coutEtapStockage2);
            }
            case DECHARGEMENT -> {
                CoutEtape coutEtapDechargement1 = new CoutEtape("Coût de manutention des marchandises pour les décharger du navire");
                CoutEtape coutEtapDechargement2 = new CoutEtape("Coût de location du conteneur si nécessaire");
                return Arrays.asList(coutEtapDechargement1,coutEtapDechargement2);
            }
            case DOUANE_IMPORT -> {
                CoutEtape coutEtapDouaneImport1 = new CoutEtape("Coût des formalités douanières (déclaration en douane, autorisations, etc.)");
                CoutEtape coutEtapDouaneImport2 = new CoutEtape("Coût des taxes à l'importation (le cas échéant)");
                CoutEtape coutEtapDouaneImport3 = new CoutEtape("Coût de l'inspection ou de la certification des marchandises (le cas échéant)");
                return Arrays.asList(coutEtapDouaneImport1,coutEtapDouaneImport2,coutEtapDouaneImport3);
            }
            case CHARGEMENT -> {
                CoutEtape coutEtapChargement1 = new CoutEtape("Coût de manutention des marchandises pour les charger sur le navire");
                CoutEtape coutEtapChargement2 = new CoutEtape("Coût de location du conteneur si nécessaire");
                CoutEtape coutEtapChargement3 = new CoutEtape("Coût de l'arrimage et de la sécurisation des marchandises dans le conteneur");
                return Arrays.asList(coutEtapChargement1,coutEtapChargement2,coutEtapChargement3);
            }
            case EMBALLAGE -> {
                CoutEtape coutEtapEmballage = new CoutEtape("Coût des matériaux d'emballage (caisses, palettes, etc.)");
                CoutEtape coutEtapEmballage2 = new CoutEtape("Coût de la main-d'œuvre pour l'emballage des marchandises");
                return Arrays.asList(coutEtapEmballage,coutEtapEmballage2);
            }
            case COLLECTE -> {
                CoutEtape coutEtapCollecte1 = new CoutEtape("Coût d'emballage des marchandises");
                CoutEtape coutEtapCollecte2 = new CoutEtape("Coût de manutention des marchandises");
                CoutEtape coutEtapCollecte3 = new CoutEtape("Coût d'entreposage temporaire si nécessaire");
                CoutEtape coutEtapCollecte4 = new CoutEtape("Coût de l'assurance des marchandises jusqu'au port d'embarquement");
                return Arrays.asList(coutEtapCollecte1,coutEtapCollecte2,coutEtapCollecte3,coutEtapCollecte4);
            }
            case TRANSPORT_INTERNATIONAL -> {
                CoutEtape coutEtapTransportInternational1 = new CoutEtape("Coût du fret maritime (calculé en fonction du volume, du poids et de la distance)");
                CoutEtape coutEtapTransportInternational2 = new CoutEtape("Coût de l'assurance des marchandises pendant le transport maritime");
                return Arrays.asList(coutEtapTransportInternational1,coutEtapTransportInternational2);
            }
            case DOUANE_EXPORT -> {
                CoutEtape coutEtapDouaneExport1 = new CoutEtape("Coût des formalités douanières (déclaration en douane, autorisations, etc.)");
                CoutEtape coutEtapDouaneExport2 = new CoutEtape("Coût des taxes à l'exportation (le cas échéant)");
                CoutEtape coutEtapDouaneExport3 = new CoutEtape("Coût de l'inspection ou de la certification des marchandises (le cas échéant)");
                return Arrays.asList(coutEtapDouaneExport1,coutEtapDouaneExport2,coutEtapDouaneExport3);
            }
            case TRANSPORT_INTERIEUR -> {
                CoutEtape coutEtapTransportInterieur1 = new CoutEtape("Coût de transport des marchandises jusqu'au port d'embarquement (camion, train, etc.)");
                CoutEtape coutEtapTransportInterieur2 = new CoutEtape("Coût de manutention des marchandises lors du chargement sur le véhicule de transport");
                return Arrays.asList(coutEtapTransportInterieur1,coutEtapTransportInterieur2);
            }
            default -> {
                return new ArrayList<>();
            }
        }
    }
}
