package org.lagrange.domain.entity;

import java.util.List;
import java.util.stream.Collectors;

public class SupplyChain {

    List<Etape> etapes;
    Incoterm incoterm;

    SuiviCouts suiviCouts;

    public SupplyChain(List<Etape> etapes, Incoterm incoterm) {
        this.etapes = etapes;
        this.incoterm = incoterm;
        suiviCouts = new SuiviCouts();
    }

    public void start(){
        etapes.forEach(etape -> {
            suiviCouts.processEtape(etape,incoterm.getPaiementStrategie());
        });
    }

    public SuiviCouts getSuiviCouts(){
        return this.suiviCouts;
    }

    public double getCoutsPourPartiePrenante(PartiePrenante partiePrenante){
        return this.suiviCouts.getCoutForPartiePrenante(partiePrenante).stream()
                .map(CoutAssocie::getEtape)
                .map(Etape::getCoutEtape)
                .flatMap(List::stream)
                .map(CoutEtape::getCout)
                .reduce(0.0, Double::sum);
    }

    public List<CoutEtape> getCoutEtapePourPartiePrenante(PartiePrenante partiePrenante){
        return this.suiviCouts.getCoutForPartiePrenante(partiePrenante).stream()
                .map(CoutAssocie::getEtape)
                .map(Etape::getCoutEtape)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public Incoterm getIncoterm() {
        return incoterm;
    }

    public void setIncoterm(Incoterm incoterm) {
        this.incoterm = incoterm;
    }

    public void resetSuivi(){
        this.suiviCouts = new SuiviCouts();
    }
}
