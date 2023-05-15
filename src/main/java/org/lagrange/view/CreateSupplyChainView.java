package org.lagrange.view;

import org.lagrange.EtapeUtils;
import org.lagrange.SimulationSingleton;
import org.lagrange.domain.entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateSupplyChainView extends JPanel {

    private final JComboBox<String> comboBox ;

    public CreateSupplyChainView() {
        comboBox = new JComboBox<>(getAllIncotermName());
        List<Etape> etapes = getEtapes();
        SupplyChain supplyChain = new SupplyChain(etapes, new Incoterm(IncotermType.FOB,new FobStrategy()));
        SimulationSingleton.getInstance().setSupplyChain(supplyChain);
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        JPanel topContainer = new JPanel(new BorderLayout());
        JPanel inconternContainer = new JPanel(new FlowLayout());
        setListenerComboBox();
        inconternContainer.add(new JLabel("Incoterm"));
        inconternContainer.add(comboBox);
        topContainer.add(inconternContainer,BorderLayout.WEST);
        JButton runButton = new JButton("Lancer la simulation");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulationSingleton.getInstance().getSupplyChain().start();
                new ResultView();
            }
        });
        topContainer.add(runButton,BorderLayout.EAST);
       // topContainer.setBackground(Color.RED);
        topContainer.setPreferredSize(new Dimension(400,30));
       // topContainer.setBorder(new EmptyBorder(5,5,5,5));
        add(topContainer,BorderLayout.NORTH);
        JPanel centerContainer = new JPanel();
        List<Etape> etapeList = SimulationSingleton.getInstance().getSupplyChain().getEtapes();


        etapeList.forEach(etape -> {
            centerContainer.add(new StepCard(etape));
        });
        centerContainer.setLayout(new GridLayout(etapeList.size()/2,2));
        add(centerContainer,BorderLayout.CENTER);
    }

    private String[] getAllIncotermName() {
        return Arrays.stream(IncotermType.values()).map(Enum::toString).toList().toArray(String[]::new);
    }

    private void setListenerComboBox() {
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // si l'état du combobox est modifiée
                if (e.getSource() == comboBox) {

                    IncotermType incotermType = IncotermType.valueOf((String)comboBox.getSelectedItem());
                    PaiementStrategy paiementStrategy = new FobStrategy();
                    if(incotermType.equals(IncotermType.FOB)){
                        paiementStrategy = new FobStrategy();
                    }else if(incotermType.equals(IncotermType.CIF)){
                        paiementStrategy = new CifStrategy();
                    }
                    Incoterm incoterm = new Incoterm(incotermType,paiementStrategy);
                    SimulationSingleton.getInstance().getSupplyChain().setIncoterm(incoterm);

                }
            }
        });
    }

    private List<Etape> getEtapes() {
        List<Etape> res = new ArrayList<>();
        for(EtapeType type : EtapeType.values()){
            res.add(EtapeUtils.createEtapeByEtapeType(type));
        }
        return res;
    }


}
