package org.example.io;

import javax.swing.*;

public interface View {
    ClassLoader CLASS_LOADER=View.class.getClassLoader();
    String APP_NAME="QAP";
    Icon FIRST_ICON = new ImageIcon(CLASS_LOADER.getResource("Icon/1.png"));

    Icon LAST_ICON = new ImageIcon(CLASS_LOADER.getResource("Icon/4.png"));
    Icon TEST = new ImageIcon(CLASS_LOADER.getResource("Icon/1.png"));

    public static void main(String[] args) {
        System.out.println(TEST);
    }
}

