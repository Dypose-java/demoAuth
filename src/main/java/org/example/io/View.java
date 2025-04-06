package org.example.io;

import javax.swing.*;

public interface View {
    ClassLoader CLASS_LOADER=View.class.getClassLoader();
    String APP_NAME="QAP";
    Icon FIRST_ICON = new ImageIcon(CLASS_LOADER.getResource("Icon/1620171336_61-phonot.png"));

    Icon LAST_ICON = new ImageIcon(CLASS_LOADER.getResource("Icon/train.png"));
    Icon TEST = new ImageIcon(CLASS_LOADER.getResource("Icon/1620171336_61-phonot.png"));

    public static void main(String[] args) {
        System.out.println(TEST);
    }
}
