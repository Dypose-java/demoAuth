package authentication.service.object;

import java.io.File;

public interface Helper {
     File FILE = new File("src/main/resources/serializable/counter.dat");

     public static void main(String[] args) {
          System.out.println(FILE);
     }
}
