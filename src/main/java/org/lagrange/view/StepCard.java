package org.lagrange.view;

import org.lagrange.domain.entity.Etape;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StepCard extends JPanel {
    public StepCard(Etape etape) {
        Border loweredetched = BorderFactory.createCompoundBorder(new EmptyBorder(5,5,5,5),BorderFactory.createLoweredBevelBorder());
        setBorder(loweredetched);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel topContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextArea title = new JTextArea(etape.getType().toString());
        title.setMargin(new Insets(0,5,0,5));
        title.setBorder(BorderFactory.createLoweredBevelBorder());
        //title.setPreferredSize(new Dimension(topContainer.getWidth(),100));
        Color color = new JLabel().getBackground();
        title.setBackground(color);
        title.setEditable(false);

       // topContainer.setBackground(Color.RED);

        topContainer.add(title);
        add(topContainer);
        etape.getCoutEtape().forEach(coutEtape -> {
            JPanel stepCout = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JTextArea textArea = new JTextArea(coutEtape.getDescription());
            textArea.setMargin(new Insets(0,5,0,5));
            textArea.setEditable(false);
            textArea.setBackground(color);
            stepCout.add(textArea);
            JTextField costField = new JTextField(Double.toString(coutEtape.getCout()));
            costField.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {


                }

                @Override
                public void keyReleased(KeyEvent e) {
                    coutEtape.setCout(Double.parseDouble(costField.getText()));

                }
            });
            costField.setPreferredSize(new Dimension(100,20));
            stepCout.add(costField);
            add(stepCout);
        });
    }
}
