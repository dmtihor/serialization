import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Adm on 12/13/2015.
 */
public class Car implements Serializable {
    int speed;
    String color;
    transient Engine e;

    public Car(int speed, String color) {
        this.speed = speed;
        this.color = color;
    }

    public Car(int speed, Engine e, String color) {
        this.speed = speed;
        this.e = e;
        this.color = color;
    }

    public Car(int speed) {
        this.speed = speed;
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        os.writeInt(e.power);
        os.writeObject(e.producer);
    }
    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();
        e = new Engine(is.readInt(),(String)is.readObject());
    }

}

