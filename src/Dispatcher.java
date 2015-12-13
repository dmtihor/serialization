import java.io.*;
import java.util.ArrayList;

/**
 * Created by Adm on 12/13/2015.
 */
public class Dispatcher {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Car c1 = new Car(200, new MyEngine(250), "white");
        Car c2 = new Car(180, new MyEngine(210), "black");
        Car c3 = new Car(130, new MyEngine(220), "yellow");
       // ArrayList<Car> al = new ArrayList();
       // al.add(c1);
      //  al.add(c2);
      //  al.add(c3);

        File f1 = new File("D:/Java/workspace/serialization/f1");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f1));
        //oos.writeObject(al);
        oos.writeObject(c1);
        oos.writeObject(c2);
         oos.writeObject(c3);
        oos.flush();
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));
        Car c1_New = (Car) ois.readObject();
        Car c2_New = (Car) ois.readObject();
        Car c3_New = (Car) ois.readObject();
        ois.close();
        System.out.println(c1_New.speed + c1_New.color);
        System.out.println(c2_New.speed);
        System.out.println(c3_New.speed+ " "+ c3_New.e.power);
    }
}
