package org.example.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("SCI Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new CreateSupplyChainView());
        setVisible(true);
        //pack();
    }
}
