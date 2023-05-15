package org.lagrange.view;

import org.lagrange.SimulationSingleton;
import org.lagrange.domain.entity.CoutAssocie;
import org.lagrange.domain.entity.CoutEtape;
import org.lagrange.domain.entity.PartiePrenante;
import org.lagrange.domain.entity.SupplyChain;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ResultView extends JFrame {
    public ResultView() throws HeadlessException {
        setTitle("Resultats");
        setSize(1300,500);
        setLocationRelativeTo(null);
        SupplyChain supplyChain = SimulationSingleton.getInstance().getSupplyChain();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        JLabel incortenrResult = new JLabel("Incoterm selectionné: " + supplyChain.getIncoterm().getType().toString());
        JPanel incortermContainer = new JPanel(new FlowLayout());
        incortermContainer.add(incortenrResult);
        jPanel.add(incortermContainer);
        JLabel fournisseurResult =new JLabel("Cout Fournisseur : " + supplyChain.getCoutsPourPartiePrenante(PartiePrenante.FOURNISSEUR));
        JLabel achteurResult = new JLabel("Cout Acheteur : " + supplyChain.getCoutsPourPartiePrenante(PartiePrenante.ACHETEUR));

        JPanel resultContainer = new JPanel(new FlowLayout());
        resultContainer.add(fournisseurResult);
        resultContainer.add(achteurResult);


        JTextArea detailFournisseurLabel = new JTextArea(getTextPartiePrenant(PartiePrenante.FOURNISSEUR));
        detailFournisseurLabel.setFont(detailFournisseurLabel.getFont().deriveFont(11f));
        detailFournisseurLabel.setEditable(false);
        detailFournisseurLabel.setBackground(fournisseurResult.getBackground());

        JTextArea detailAcheteurLabel = new JTextArea(getTextPartiePrenant(PartiePrenante.ACHETEUR));
        detailAcheteurLabel.setFont(detailFournisseurLabel.getFont().deriveFont(11f));
        detailAcheteurLabel.setEditable(false);
        detailAcheteurLabel.setBackground(fournisseurResult.getBackground());

        JPanel detailsGridContainer = new JPanel();
        detailsGridContainer.add(detailFournisseurLabel);
        detailsGridContainer.add(detailAcheteurLabel);

        if(SimulationSingleton.getInstance().getSupplyChain().getSuiviCouts().getCoutForPartiePrenante(PartiePrenante.UNDEFINED).size() > 0 ){
            JTextArea detailNonGereLabel = new JTextArea(getTextPartiePrenant(PartiePrenante.UNDEFINED));
            detailNonGereLabel.setFont(detailFournisseurLabel.getFont().deriveFont(11f));
            detailNonGereLabel.setEditable(false);
            detailNonGereLabel.setBackground(fournisseurResult.getBackground());
            detailsGridContainer.add(detailNonGereLabel);

            JLabel nonGereResult =new JLabel("Cout non géré par l'incoterm " + supplyChain.getIncoterm().getType().toString() + " : " + supplyChain.getCoutsPourPartiePrenante(PartiePrenante.UNDEFINED));
            resultContainer.add(nonGereResult);
        }

        jPanel.add(resultContainer);
        detailsGridContainer.setLayout(new GridLayout(1,3));
        jPanel.add(detailsGridContainer);



        add(jPanel);
        setVisible(true);
        setOnCloseAction(this);
    }

    private static String getTextPartiePrenant(PartiePrenante partiePrenante) {
        StringBuilder result = new StringBuilder("DETAILS FOURNISSEUR : \n");
        List<CoutAssocie> coupAssocies =  SimulationSingleton.getInstance().getSupplyChain().getSuiviCouts().getCoutForPartiePrenante(partiePrenante);
        for(CoutAssocie ca : coupAssocies){
                result.append(ca.getEtape().getType().toString()).append("\n");
                for(CoutEtape ce : ca.getEtape().getCoutEtape()){
                    result.append("\t-").append(ce.getDescription()).append(" (").append(ce.getCout()).append(")\n");
        }
    }
        return result.toString();
    }

    private void setOnCloseAction(JFrame parent){
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                SimulationSingleton.getInstance().getSupplyChain().resetSuivi();
            }
        });
    }
}
