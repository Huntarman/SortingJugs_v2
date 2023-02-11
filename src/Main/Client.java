package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Client {
    private int id;
    private ArrayList<Integer> preferences = new ArrayList<>();
    private int satisfaction;
    private int dissatisfaction;
    //for reading client from file, or adding jug mannualy in GUI
    public Client(int ID, ArrayList<Integer> PREFERENCES){
        this.id = ID;
        this.preferences = PREFERENCES;
        this.satisfaction = 0;
        this.dissatisfaction = 400;
    }
    //for randomly generating client
    public Client(int ID, int FLAVOUR_NUM_MAX){
        this.id = ID;

        Random r = new Random();
        int var = r.nextInt(FLAVOUR_NUM_MAX) + 1;
        ArrayList<Integer> flavours = new ArrayList<>();
        for (int i = 0; i < FLAVOUR_NUM_MAX; i++) flavours.add(i+1);
        Collections.shuffle(flavours);

        for (int i = 0; i < var; i++){
            this.preferences.add(flavours.get(i));
        }

        this.satisfaction = 0;
        this.dissatisfaction = 400;
    }
    public int getId() {
        return id;
    }

    public ArrayList<Integer> getPreferences() {
        return preferences;
    }

    public int getPreference(int num) {
        return this.preferences.get(num);
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public int getDissatisfaction() {
        return dissatisfaction;
    }

    public String clientToString (){
        String str = this.id + "||";
        for (int flavour : preferences){
            str = str + flavour + "||";
        }
        return str;
    }
}
