package authentication.io;

import javax.swing.*;

public interface Views {
    ClassLoader CLASS_LOADER= Views.class.getClassLoader();
    String NAME_APP="Залупа";
    Integer COUNTER =3;
    Icon FIRST_ICON = new ImageIcon(CLASS_LOADER.getResource("Icon/first_icon.png"));

    Icon LAST_ICON = new ImageIcon(CLASS_LOADER.getResource("Icon/sad_icon.png"));
    public static void main(String[] args) {

    }

}

