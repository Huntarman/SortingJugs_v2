package Main;

import java.util.*;

public class Client {
    private int id;
    private ArrayList<Integer> preferences = new ArrayList<>();
    private int satisfaction;
    private int dissatisfaction;
    private int importance;
    private boolean[] drankFlavour;
    private HashMap<Integer,Integer> portions = new HashMap<>();
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

    public void setImportance(int flavour, int flavourMax) {
        if (prefersFlavour(flavour) && !drankFlavour[flavour - 1]){
            this.importance = preferences.size() - preferences.indexOf(flavour);
            if (preferences.indexOf(flavour) == 0){
                this.importance += flavourMax+1;
            }
        }else{
            this.importance = 0;
        }
    }
    public int getImportance() {
        return importance;
    }
    public String clientToString (){
        String str = "ID: " + this.id + "| Preferences: ";
        for (int a : preferences){
            str += a + ", ";
        }
        return str;
    }
    public String portionsToString(){
        String str = "ID: " + this.id + "| Portions: " + portions.toString();
        return str;
    }

    public boolean prefersFlavour(int flavour){
        return preferences.contains(flavour);
    }
    public int maxPreferedFlavour(){
        int max = 0;
        for (int flavour: preferences) {
            max = Integer.max(max,flavour);
        }
        return max;
    }
    public void createDrankFlavour(int MAX_FLAVOUR){
        this.drankFlavour = new boolean[MAX_FLAVOUR];
    }
    public void givePortion(int id, int flavour, int volume){
        this.portions.put(id,volume);
        if (prefersFlavour(flavour)) {
            this.satisfaction += volume * (preferences.size() - preferences.indexOf(flavour));
            if (preferences.indexOf(flavour) == 0) {
                this.dissatisfaction = Math.max(this.dissatisfaction - volume, 0);
            }
            this.drankFlavour[flavour - 1] = true;
        }
    }
    public void getdrankFlavour(){
        String str = "";
        for (boolean bool : drankFlavour){
            str += bool + "|";
        }
        System.out.println(str);
    }
}
