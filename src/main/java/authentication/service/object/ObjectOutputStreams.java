package authentication.service.object;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ObjectOutputStreams  implements Helper {
public <T> void objectOutputStream(File fileName, List<T> listOutputInFile){
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
    {
        oos.writeObject(listOutputInFile);
        System.out.println(fileName.getName()+" записан в файл");
    }
    catch(Exception ex){
        System.out.println(ex.getMessage());
    }
}

    public static void main(String[] args) {
        new ObjectOutputStreams().objectOutputStream(FILE,List.of(52));
        List<Integer> list = new ObjectInputStreams().readFile(FILE);
        int numList =list.stream().findFirst().get();
        while (numList>0){
            System.out.println("Осталось попыток :"+numList);
            numList--;
            }
        System.out.println(numList);

        }
//        while (list.stream().findFirst().get()>0)
    }






