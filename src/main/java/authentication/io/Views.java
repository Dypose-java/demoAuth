package authentication.io;

import javax.swing.*;

public interface Views {
    ClassLoader CLASS_LOADER= Views.class.getClassLoader();
    String NAME_APP="Залупа";
    Integer COUNTER =3;
    Icon FIRST_ICON = new ImageIcon(CLASS_LOADER.getResource("Icon/2.png"));

    Icon LAST_ICON = new ImageIcon(CLASS_LOADER.getResource("Icon/3.png"));
    public static void main(String[] args) {

    }


}

