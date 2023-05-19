package com.lagrange.controller;

import java.util.ArrayList;
import java.util.List;

public class SupplyChainRest {
    private List<Etape> etapes;
    private Incoterm incoterm;
    private SuiviCouts suiviCouts;

    public SupplyChainRest() {
        this.etapes = new ArrayList<>();
        this.incoterm = new Incoterm();
        this.incoterm.setType("FOB");
        this.suiviCouts = new SuiviCouts();
        this.suiviCouts.setCoutAssocies(new ArrayList<>());
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    public Incoterm getIncoterm() {
        return incoterm;
    }

    public void setIncoterm(Incoterm incoterm) {
        this.incoterm = incoterm;
    }

    public SuiviCouts getSuiviCouts() {
        return suiviCouts;
    }

    public void setSuiviCouts(SuiviCouts suiviCouts) {
        this.suiviCouts = suiviCouts;
    }
}

 class Etape {
    private String type;
    private List<CoutEtape> coutEtape;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CoutEtape> getCoutEtape() {
        return coutEtape;
    }

    public void setCoutEtape(List<CoutEtape> coutEtape) {
        this.coutEtape = coutEtape;
    }
}

 class CoutEtape {
    private String description;
    private double cout;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }
}

 class Incoterm {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

 class SuiviCouts {
    private List<CoutAssocie> coutAssocies;

    public List<CoutAssocie> getCoutAssocies() {
        return coutAssocies;
    }

    public void setCoutAssocies(List<CoutAssocie> coutAssocies) {
        this.coutAssocies = coutAssocies;
    }
}

 class CoutAssocie {
    private Etape etape;
    private String partiePrenante;

    public Etape getEtape() {
        return etape;
    }

    public void setEtape(Etape etape) {
        this.etape = etape;
    }

    public String getPartiePrenante() {
        return partiePrenante;
    }

    public void setPartiePrenante(String partiePrenante) {
        this.partiePrenante = partiePrenante;
    }
}


class SuiviCoupListResponse {
    private List<SuiviCouts> suivisCouts;

    public List<SuiviCouts> getSuivisCouts() {
        return suivisCouts;
    }

    public void setSuivisCouts(List<SuiviCouts> suivisCouts) {
        this.suivisCouts = suivisCouts;
    }
}
