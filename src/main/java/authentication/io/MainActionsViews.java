package authentication.io;

import authentication.service.object.Helper;
import authentication.service.object.ObjectInputStreams;
import authentication.service.object.ObjectOutputStreams;
import org.example.exception.AunteficationException;

import javax.swing.*;

import java.util.List;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class MainActionsViews implements ActionsViews {
    @Override
    public void showError(Throwable throwable) {
        JOptionPane.showMessageDialog(null,
                throwable.getMessage(),
                NAME_APP,ERROR_MESSAGE,
                LAST_ICON);
    }

    @Override
    public void showAttempts() {
        int num = (int) new ObjectInputStreams().readFile(Helper.FILE).stream().findFirst().get();
        StringBuilder stringBuilder = new StringBuilder();
        num--;
        if (num>0){
            new ObjectOutputStreams().objectOutputStream(Helper.FILE, List.of(num));
            stringBuilder.append("У вас осталось ").append(String.valueOf(num)).append(" попыток");
            JOptionPane.showMessageDialog(null,stringBuilder.toString(),NAME_APP,ERROR_MESSAGE,LAST_ICON);
            }
        else
            JOptionPane.showMessageDialog(null,new AunteficationException("Попыток не осталось"),NAME_APP,ERROR_MESSAGE,LAST_ICON);


    }




    }


