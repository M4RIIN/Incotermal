export class SupplyChain{
  etapes: Etape[];
  incoterm: Incoterm;
  suiviCouts: SuiviCouts;

  constructor(){
    this.etapes = [];
    this.incoterm = {type : "FOB"},
    this.suiviCouts = {coutAssocies : []}
  }
}

export class Etape{
  type: string;
  coutEtape: CoutEtape[];

  constructor(){
    this.type = "";
    this.coutEtape = []
  }
}

export class CoutEtape{
  description: string;
  cout: number;

  constructor(){
    this.description = "";
    this.cout = 0;
  }
}

export class Incoterm{
  type: string;

  constructor(){
    this.type = "";
  }
}
export class SuiviCouts{
  coutAssocies: CoutAssocie[];

  constructor(){
    this.coutAssocies = [];
  }
}
export class CoutAssocie{
  etape: Etape;
  partiePrenante: string;

  constructor(){
    this.etape = new Etape();
    this.partiePrenante = "";
  }

}

export class SuiviCoupListResponse{
  suivisCouts: SuiviCouts[] = [];
}

export class CoutRevientMargeCommercialeRest{
  quantite :number = 0;
  coutAchatMatierePremiere :number = 0;
  mainOeuvre :number = 0;
  autreChargeVariables :number = 0;
  chargesFixes :number = 0;
  conditionnement :number = 0;
  margeCommercialeDepartUsine :number = 0;

}

export class PrixVenteUnitaireRest {
quantite :number = 0;
prixVenteUnitaire : number = 0;
}

export class PrixVenteProduitEtEmballageRest {
  quantite = 0;
  masseBruteProduitEtEmballage = 0;
  masseBruteEmballage = 0;
  prixProduitUnitaire = 0;
  prixEmballageUnitaire = 0;
}
