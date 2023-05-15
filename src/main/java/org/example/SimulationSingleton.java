package org.example;

import org.example.domain.entity.SupplyChain;

public class SimulationSingleton {

    private static SimulationSingleton INSTANCE = null;

    private SupplyChain supplyChain;

    private SimulationSingleton(){

    }

    public static SimulationSingleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SimulationSingleton();
        }
        return INSTANCE;
    }

    public void setSupplyChain(SupplyChain supplyChain){
        this.supplyChain = supplyChain;
    }

    public SupplyChain getSupplyChain() {
        return supplyChain;
    }
}
