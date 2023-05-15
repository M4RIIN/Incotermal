package org.lagrange;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import org.lagrange.view.MainFrame;

public class Main {
    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        new MainFrame();
    }


}