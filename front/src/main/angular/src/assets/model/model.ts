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
