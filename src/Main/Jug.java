package Main;
import java.util.Random;

public class Jug {
    private int id;
    private int flavour;
    private int volume;

    //for reading jug from file, or adding jug mannualy in GUI
    public Jug(int ID, int FLAVOUR, int VOLUME){
        this.id = ID;
        this.flavour = FLAVOUR;
        this.volume = VOLUME;
    }

    //for randomly creating a jug
    public Jug(int ID, int FLAVOUR_NUM_MAX){
        Random r = new Random();
        this.id = ID;
        this.flavour = r.nextInt(FLAVOUR_NUM_MAX) + 1;
        this.volume = r.nextInt(3000) + 1;
    }

    public int getId(){
        return this.id;
    }

    public int getFlavour() {
        return this.flavour;
    }

    public int getVolume() {
        return this.volume;
    }
}
