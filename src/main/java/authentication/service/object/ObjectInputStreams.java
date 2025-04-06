package authentication.service.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInputStreams implements Helper {
   public  <T>List<T> readFile(File fileName){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
            return (List<T>) ois.readObject();

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return List.of();
    }


}
