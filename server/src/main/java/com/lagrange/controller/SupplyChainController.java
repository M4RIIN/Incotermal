package com.lagrange.controller;

import org.lagrange.entity.incoterm.*;
import org.lagrange.entity.supplychain.EtapeCollecte;
import org.lagrange.entity.supplychain.EtapeType;
import org.lagrange.entity.supplychain.SupplyChain;
import org.lagrange.entity.utils.SupplyChainUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SupplyChainController {


    @GetMapping("/api/supply-chain")
    public SupplyChainRest getInitialSupplyChain(@RequestParam(name = "incoterm") String incoterm){
        org.lagrange.entity.incoterm.Incoterm incoterme = getIncotermFromStringType(incoterm);
        return toRest(SupplyChainUtils.createSupplyChain(incoterme));
    }

    private org.lagrange.entity.incoterm.Incoterm getIncotermFromStringType(String incoterm) {
        org.lagrange.entity.incoterm.Incoterm incoterme = new org.lagrange.entity.incoterm.Incoterm(IncotermType.FOB,new FobStrategy());
        IncotermType incotermType = IncotermType.valueOf(incoterm);
        switch (incotermType){
            case CIF -> incoterme = new org.lagrange.entity.incoterm.Incoterm(IncotermType.CIF,new CifStrategy());
            case FAS -> incoterme = new org.lagrange.entity.incoterm.Incoterm(IncotermType.FAS,new FasStrategy());
            case FOB -> incoterme = new org.lagrange.entity.incoterm.Incoterm(IncotermType.FOB,new FobStrategy());
        }
        return incoterme;
    }

    @PostMapping("/api/supply-chain")
    public SuiviCouts getInitialSupplyChain(@RequestBody SupplyChainRest supplyChainRest){
        SupplyChain supplyChain = toDomain(supplyChainRest);
        supplyChain.start();
        return toRest(supplyChain.getSuiviCouts());
    }

    @PostMapping("/api/supply-chain/compare")
            public SuiviCoupListResponse getInitialSupplyChain(@RequestBody SupplyChainRest supplyChainRest, @RequestParam(name = "types") String types){
        String[] typesArray = types.split(",");
        List<SuiviCouts> res = new ArrayList<>();
        for(String incoterm : typesArray){
            Incoterm inco = new Incoterm();
            inco.setType(incoterm);
            supplyChainRest.setIncoterm(inco);
            SupplyChain supplyChain = toDomain(supplyChainRest);
            supplyChain.start();
            res.add(toRest(supplyChain.getSuiviCouts()));
        }
        SuiviCoupListResponse suiviCoupListResponse = new SuiviCoupListResponse();
        suiviCoupListResponse.setSuivisCouts(res);
        return suiviCoupListResponse;
    }

    private SuiviCouts toRest(org.lagrange.entity.supplychain.SuiviCouts suiviCouts) {
        SuiviCouts sc = new SuiviCouts();
        sc.setCoutAssocies(suiviCouts.getCoutAssocies().stream()
                .map(coutAssocie -> {
                    CoutAssocie ca = new CoutAssocie();
                    Etape etape = new Etape();
                    etape.setType(coutAssocie.getEtape().getType().name());
                    etape.setCoutEtape(coutAssocie.getEtape().getCoutEtape().stream()
                            .map(coutEtape -> {
                                CoutEtape ce = new CoutEtape();
                                ce.setCout(coutEtape.getCout());
                                ce.setDescription(coutEtape.getDescription());
                                return ce;
                            }).collect(Collectors.toList()));
                    ca.setEtape(etape);
                    ca.setPartiePrenante(coutAssocie.getPartiePrenante().name());
                    return ca;
                }).collect(Collectors.toList()));
        return sc;
    }

    private SupplyChainRest toRest(SupplyChain sp){
        SupplyChainRest supplyChainRest = new SupplyChainRest();
        Incoterm incoterm = new Incoterm();
        incoterm.setType(sp.getIncoterm().getType().name());
        supplyChainRest.setIncoterm(incoterm);
        supplyChainRest.setEtapes(
                sp.getEtapes().stream()
                        .map(etape -> {
                            Etape e = new Etape();
                            e.setType(etape.getType().name());
                            e.setCoutEtape(etape.getCoutEtape().stream()
                                    .map(coutEtape -> {
                                        CoutEtape ce = new CoutEtape();
                                        ce.setDescription(coutEtape.getDescription());
                                        ce.setCout(coutEtape.getCout());
                                        return ce;
                                    }).collect(Collectors.toList()));
                            return e;
                        }).collect(Collectors.toList())
        );
        supplyChainRest.setSuiviCouts(null);
        return supplyChainRest;
    }

    private SupplyChain toDomain(SupplyChainRest supplyChainRest){
        return new SupplyChain(
                supplyChainRest.getEtapes().stream()
                        .map(etapeRest ->{
                            return new EtapeCollecte(EtapeType.valueOf(etapeRest.getType()),
                                    etapeRest.getCoutEtape().stream()
                                            .map(coutEtapeRest -> {
                                                org.lagrange.entity.supplychain.CoutEtape ce = new org.lagrange.entity.supplychain.CoutEtape(coutEtapeRest.getDescription());
                                                ce.setCout(coutEtapeRest.getCout());
                                                return ce;
                                            }).collect(Collectors.toList())
                                    );
                }).collect(Collectors.toList()),
                getIncotermFromStringType(supplyChainRest.getIncoterm().getType())
        );
    }
}
