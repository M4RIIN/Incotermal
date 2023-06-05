package com.lagrange.controller;

import com.lagrange.controller.rest.CoutRevientMargeCommercialeRest;
import org.lagrange.entity.exw.ExwCalculParameters;
import org.lagrange.usecase.ExwUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EXWController {

    private final ExwUseCase exwUseCase;

    public EXWController(ExwUseCase exwUseCase) {
        this.exwUseCase = exwUseCase;
    }

    @PostMapping("/api/cout-revient-marge-com")
    public Double getCoutRevient(@RequestBody CoutRevientMargeCommercialeRest rest){
        ExwCalculParameters exwCalculParameters = new ExwCalculParameters.Builder()
                .setParametersForCalculCoutRevient(
                        rest.getQuantite(),rest.getCoutAchatMatierePremiere(),
                        rest.getMainOeuvre(),rest.getAutreChargeVariables(),
                        rest.getChargesFixes(),rest.getConditionnement(),
                        rest.getMargeCommercialeDepartUsine()
                ).build();
        return exwUseCase.getCoutDeRevient(exwCalculParameters);
    }

    @PostMapping("/api/vente-unitaire")
    public Double getVenteUnitaire(@RequestBody CoutRevientMargeCommercialeRest rest){
        ExwCalculParameters exwCalculParameters = new ExwCalculParameters.Builder()
                .setParametersForCalculCoutRevient(
                        rest.getQuantite(),rest.getCoutAchatMatierePremiere(),
                        rest.getMainOeuvre(),rest.getAutreChargeVariables(),
                        rest.getChargesFixes(),rest.getConditionnement(),
                        rest.getMargeCommercialeDepartUsine()
                ).build();
        return exwUseCase.getCoutVenteUnitaire(exwCalculParameters);
    }

    @PostMapping("/api/vente-produit")
    public Double getVenteProduit(@RequestBody CoutRevientMargeCommercialeRest rest){
        ExwCalculParameters exwCalculParameters = new ExwCalculParameters.Builder()
                .setParametersForCalculCoutRevient(
                        rest.getQuantite(),rest.getCoutAchatMatierePremiere(),
                        rest.getMainOeuvre(),rest.getAutreChargeVariables(),
                        rest.getChargesFixes(),rest.getConditionnement(),
                        rest.getMargeCommercialeDepartUsine()
                ).build();
        return exwUseCase.getCoutVenteProduit(exwCalculParameters);
    }
}
