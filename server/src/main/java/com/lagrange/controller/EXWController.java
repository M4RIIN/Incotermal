package com.lagrange.controller;

import com.lagrange.controller.rest.CoutRevientMargeCommercialeRest;
import org.lagrange.entity.Exw;
import org.lagrange.entity.supplychain.SupplyChain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EXWController {

    @PostMapping("/api/cout-revient-marge-com")
    public Double getInitialSupplyChain(@RequestBody CoutRevientMargeCommercialeRest rest){
        return new Exw(
                rest.getQuantite(),
                rest.getCoutAchatMatierePremiere(),
                rest.getMainOeuvre(),
                rest.getAutreChargeVariables(),
                rest.getChargesFixes(),
                rest.getConditionnement(),
                rest.getMargeCommercialeDepartUsine()
        ).byCoutDeRevientEtMargeCommerciale();
    }
}
