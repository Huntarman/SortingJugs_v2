package Utility;

import Main.Client;
import Main.Jug;

import java.io.*;
import java.util.ArrayList;

public class Readers {
    public static ArrayList<Jug> readJugs(String filename){
        ArrayList<Jug> jugs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while (line!=null) {
                String[] strarr = line.split("; ");
                int[] casttoint = new int[3];
                int i = 0;
                for (String str : strarr) {
                    casttoint[i] = Integer.parseInt(str);
                    i++;
                }
                jugs.add(new Jug(casttoint[0], casttoint[1], casttoint[2]));
                line = reader.readLine();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jugs;
    }

    public static ArrayList<Client> readClients(String filename){
        ArrayList<Client> clients = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] strarr = line.split(";");
                int Id = Integer.parseInt(strarr[0]);
                String[] strarr2 = strarr[1].split(",");
                ArrayList<Integer> prefferedflavour = new ArrayList<Integer>();
                int i = 0;
                for (String str : strarr2) {
                    prefferedflavour.add(Integer.parseInt(strarr2[i]));
                    i++;
                }
                clients.add(new Client(Id, prefferedflavour));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
