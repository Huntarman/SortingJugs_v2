package Main;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static Utility.Readers.*;
import Utility.Renderers.*;
public class GUI extends JFrame {
    private JTextField textFieldPreferences;
    private JTextField textFieldRandClientAmount;
    private JTextField textFieldJugAmount;
    private JTextField textFieldFlavour;
    private JTextField textFieldVolume;
    private JTextField textFieldMaxFlavourJug;
    private JTextField textFieldMaxFlavourClient;
    JLabel lblTotalSat = new JLabel("Total satisfaction: ");
    JLabel lblTotalDisSat = new JLabel("Total dissatisfaction: ");
    private JPanel panelClient = new JPanel();
    private JPanel panelJugs = new JPanel();
    private JPanel panelSorted = new JPanel();
    private ArrayList<Jug> jugList = new ArrayList<>();
    private ArrayList<Client> clientList = new ArrayList<>();
    private int MAX_FLAVOUR;
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 471);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1186, 434);
        getContentPane().add(panel);
        panel.setLayout(null);

        panelClient.setBackground(new Color(255, 255, 255));
        panelClient.setBounds(10, 80, 280, 320);
        panel.add(panelClient);

        panelJugs.setBackground(new Color(255, 255, 255));
        panelJugs.setBounds(325, 80, 280, 320);
        panel.add(panelJugs);

        panelSorted.setBackground(new Color(255, 255, 255));
        panelSorted.setBounds(640, 80, 536, 310);
        panel.add(panelSorted);

        JLabel lblClientList = new JLabel("Client list:");
        lblClientList.setBounds(10, 67, 119, 13);
        panel.add(lblClientList);

        JLabel lblJugList = new JLabel("Jug list:");
        lblJugList.setBounds(325, 67, 119, 13);
        panel.add(lblJugList);

        JLabel lblSortedList = new JLabel("List after assingement");
        lblSortedList.setBounds(639, 67, 251, 13);
        panel.add(lblSortedList);

        JLabel lblPreferences = new JLabel("Preferences:");
        lblPreferences.setBounds(105, 0, 155, 13);
        panel.add(lblPreferences);

        textFieldPreferences = new JTextField();
        textFieldPreferences.setBounds(105, 11, 155, 19);
        panel.add(textFieldPreferences);
        textFieldPreferences.setColumns(10);

        textFieldRandClientAmount = new JTextField();
        textFieldRandClientAmount.setBounds(139, 42, 45, 19);
        panel.add(textFieldRandClientAmount);
        textFieldRandClientAmount.setColumns(10);

        JLabel lblAmountClients = new JLabel("Amount:");
        lblAmountClients.setBounds(139, 30, 52, 13);
        panel.add(lblAmountClients);

        textFieldJugAmount = new JTextField();
        textFieldJugAmount.setBounds(454, 42, 65, 19);
        panel.add(textFieldJugAmount);
        textFieldJugAmount.setColumns(10);

        textFieldFlavour = new JTextField();
        textFieldFlavour.setColumns(10);
        textFieldFlavour.setBounds(419, 11, 45, 19);
        panel.add(textFieldFlavour);

        textFieldVolume = new JTextField();
        textFieldVolume.setColumns(10);
        textFieldVolume.setBounds(474, 11, 45, 19);
        panel.add(textFieldVolume);

        textFieldMaxFlavourJug = new JTextField();
        textFieldMaxFlavourJug.setColumns(10);
        textFieldMaxFlavourJug.setBounds(529, 42, 45, 19);
        panel.add(textFieldMaxFlavourJug);

        textFieldMaxFlavourClient = new JTextField();
        textFieldMaxFlavourClient.setColumns(10);
        textFieldMaxFlavourClient.setBounds(194, 42, 45, 19);
        panel.add(textFieldMaxFlavourClient);

        JLabel lblmaxFlavourClient = new JLabel("Max flavour num:");
        lblmaxFlavourClient.setBounds(194, 30, 110, 13);
        panel.add(lblmaxFlavourClient);

        JLabel lblmaxFlavourJug = new JLabel("Max flavour num:");
        lblmaxFlavourJug.setBounds(529, 30, 110, 13);
        panel.add(lblmaxFlavourJug);

        JLabel lblAmountJug = new JLabel("Amount");
        lblAmountJug.setBounds(454, 30, 45, 13);
        panel.add(lblAmountJug);

        JLabel lblFlavour = new JLabel("Flavour");
        lblFlavour.setBounds(420, 0, 45, 13);
        panel.add(lblFlavour);

        JLabel lblVolume = new JLabel("Volume");
        lblVolume.setBounds(474, 0, 45, 13);
        panel.add(lblVolume);

        lblTotalSat.setBounds(640, 398, 250, 13);
        panel.add(lblTotalSat);

        lblTotalDisSat.setBounds(640, 421, 250, 13);
        panel.add(lblTotalDisSat);

        JButton readJugsFromFilebtn = new JButton("Read Jugs from file");
        readJugsFromFilebtn.setBounds(325, 413, 181, 21);
        readJugsFromFilebtn.addActionListener(e -> readJugsAction());
        panel.add(readJugsFromFilebtn);

        JButton readClientsFromFilebtn = new JButton("Read Clients from file");
        readClientsFromFilebtn.setBounds(10, 413, 181, 21);
        readClientsFromFilebtn.addActionListener(e -> readClientsAction());
        panel.add(readClientsFromFilebtn);

        JButton addJugBtn = new JButton("Add jug");
        addJugBtn.addActionListener(e -> addJugAction());
        addJugBtn.setBounds(325, 10, 85, 21);
        panel.add(addJugBtn);

        JButton addRandomJugBtn = new JButton("Add random jugs");
        addRandomJugBtn.setBounds(325, 41, 119, 21);
        addRandomJugBtn.addActionListener(e -> addRandomJugsAction());
        panel.add(addRandomJugBtn);

        JButton addClientBtn = new JButton("Add client");
        addClientBtn.addActionListener(e -> addClientAction());
        addClientBtn.setBounds(10, 10, 85, 21);
        panel.add(addClientBtn);

        JButton randomClientBtn = new JButton("Add random num");
        randomClientBtn.addActionListener(e -> addRandomClientsAction());
        randomClientBtn.setBounds(10, 41, 119, 21);
        panel.add(randomClientBtn);

        JButton clearClientBtn = new JButton("Clear");
        clearClientBtn.setBounds(202, 413, 85, 21);
        clearClientBtn.addActionListener(e -> clearClientAction());
        panel.add(clearClientBtn);

        JButton clearJarBtn = new JButton("Clear");
        clearJarBtn.setBounds(517, 413, 85, 21);
        clearJarBtn.addActionListener(e -> clearJugsAction());
        panel.add(clearJarBtn);

        JButton sortBtnspecial = new JButton("Sort( Special method )");
        sortBtnspecial.setBounds(640, 10, 250, 21);
        sortBtnspecial.addActionListener(e -> sortSpecialAction());
        panel.add(sortBtnspecial);

        JButton sortBtnGreedy = new JButton("Sort( Greedy algorithm)");
        sortBtnGreedy.setBounds(640, 41, 250, 21);
        sortBtnGreedy.addActionListener(e -> sortGreedyAction());
        panel.add(sortBtnGreedy);
    }
    public void sortSpecialAction(){
        ArrayList<Jug> jugListSorted = new ArrayList<>(jugList);
        jugListSorted.sort(Comparator.comparing(Jug::getVolume));
        Collections.reverse(jugListSorted);
        setMAX_FLAVOUR();
        ArrayList<Client> clientListSorted = new ArrayList<>(clientList);
        ArrayList<Client> clientCopy = new ArrayList<>(clientList);
        ArrayList<Jug> jugCopy = new ArrayList<>(jugList);
        int[] jugsPerFlavour = new int[MAX_FLAVOUR];
        for(Jug jug : jugList){
            jugsPerFlavour[jug.getFlavour()-1]++;
        }
        for (Client client : clientListSorted){
            client.createDrankFlavour(MAX_FLAVOUR);
        }
        for (Jug jug : jugListSorted){
            int importantClients=0;
            for (Client client: clientListSorted){
                client.setImportance(jug.getFlavour(),MAX_FLAVOUR);
                if (client.getImportance()>0){
                    importantClients++;
                }
            }

            clientListSorted.sort(Comparator.comparing(Client::getImportance));
            Collections.reverse(clientListSorted);
            int m = importantClients/jugsPerFlavour[jug.getFlavour()-1];

            int i=0;
            while (m!=0 && jug.getVolume()!=0){
                int portion = Math.round(jug.getVolume()/m);
                clientList.get(clientListSorted.get(i).getId()-1)
                        .givePortion(jug.getId(), jug.getFlavour(), portion);
                jug.reduceVolume(portion);
                m--;i++;
            }
            jugsPerFlavour[jug.getFlavour()-1]--;
        }
        int totSat = 0, totDisSat=0;
        for (Client client: clientListSorted){
            totSat += client.getSatisfaction();
            totDisSat += client.getDissatisfaction();
        }
        lblTotalSat.setText("Total satisfaction: " + totSat);
        lblTotalDisSat.setText("Total dissatisfaction: " + totDisSat);
        fillSortedJList();
        clientList = clientCopy;
        jugList = jugCopy;
    }
    private void sortGreedyAction() throws NumberFormatException{
        HashMap<Integer,ArrayList<Client>> set = new HashMap<>();
        ArrayList<Integer> keys = new ArrayList<>();
        setMAX_FLAVOUR();
        ArrayList<Client>  setValuelist;
        ArrayList<Client> clientCopy = new ArrayList<>(clientList);
        ArrayList<Jug> jugCopy;
        for (int i = 0; i<1000 ; i++){
            setValuelist = new ArrayList<>(clientList);
            jugCopy = new ArrayList<>(jugList);
            for (Client client: setValuelist){
                client.createDrankFlavour(MAX_FLAVOUR);
            }
            for (Jug jug: jugCopy) {
                for (Client client: setValuelist){
                    client.setImportance(jug.getFlavour(),MAX_FLAVOUR);
                }
                setValuelist.sort(Comparator.comparing(Client::getImportance));
                Collections.reverse(setValuelist);
                int j=0;
                while (jug.getVolume() != 0){
                    if (setValuelist.get(j).getImportance()>0){
                        Random rand = new Random();
                        int portion = rand.nextInt(jug.getVolume())+1;
                        setValuelist.get(j).givePortion(jug.getId(), jug.getFlavour(), portion);
                        jug.reduceVolume(portion);
                    }
                    j++;
                    if (j==clientList.size()){
                        setValuelist.get(0).givePortion(jug.getId(), jug.getFlavour(), jug.getVolume());
                        jug.reduceVolume(jug.getVolume());
                    }
                }
            }
            int totSat = 0;
            for (Client client: setValuelist) {
                totSat += client.getSatisfaction();
            }
            keys.add(totSat);
            set.put(totSat,setValuelist);
        }
        Collections.sort(keys);Collections.reverse(keys);
        clientList = set.get(keys.get(0));
        clientList.sort(Comparator.comparing(Client::getId));
        int totDisSat = 0;
        for (Client client: clientList) totDisSat += client.getDissatisfaction();
        lblTotalSat.setText("Total satisfaction: " + keys.get(0));
        lblTotalDisSat.setText("Total dissatisfaction: " + totDisSat);
        fillSortedJList();
        clientList = clientCopy;
    }
    private void addClientAction(){
        ArrayList<Integer> preferences = new ArrayList<>();
        String[] strarr = textFieldPreferences.getText().split(",");
        try{
            for (String str: strarr){
                preferences.add(Integer.parseInt(str));
            }
            clientList.add(new Client(clientList.size()+1,preferences));
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Values must be in different format - example: 1,2,3,4", "", JOptionPane.INFORMATION_MESSAGE);
        }
        textFieldPreferences.setText("");
        fillClientJList();
    }
    private void addJugAction(){
        int flavor=0,volume=0;
        try{
            flavor = Integer.parseInt(textFieldFlavour.getText());
            volume = Integer.parseInt(textFieldVolume.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Value must be an integer", "", JOptionPane.INFORMATION_MESSAGE);
        }
        jugList.add(new Jug(jugList.size()+1, flavor, volume));
        textFieldFlavour.setText("");textFieldVolume.setText("");
        fillJugJList();
    }
    private void readJugsAction(){
        jugList = readJugs("Jugs.txt");
        fillJugJList();
    }
    private void readClientsAction(){
        clientList = readClients("Clients.txt");
        fillClientJList();
    }
    private void addRandomJugsAction(){
        int n = 0,m = 0;
        try{
            n = Integer.parseInt(textFieldJugAmount.getText());
            m = Integer.parseInt(textFieldMaxFlavourJug.getText());
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Value must be an integer", "", JOptionPane.INFORMATION_MESSAGE);
        }
        for (int i = 0; i<n; i++){
            jugList.add(new Jug(jugList.size()+1,m));
        }
        textFieldJugAmount.setText("");textFieldMaxFlavourJug.setText("");
        fillJugJList();
    }
    private void addRandomClientsAction(){
        int n = 0,m = 0;
        try{
            n = Integer.parseInt(textFieldRandClientAmount.getText());
            m = Integer.parseInt(textFieldMaxFlavourClient.getText());
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Value must be an integer", "", JOptionPane.INFORMATION_MESSAGE);
        }
        for (int i = 0; i < n; i++){
            clientList.add(new Client(clientList.size()+1,m));
        }
        textFieldRandClientAmount.setText("");textFieldMaxFlavourClient.setText("");
        fillClientJList();
    }
    private void clearClientAction(){
        clientList.clear();
        fillClientJList();
    }
    private void clearJugsAction(){
        jugList.clear();
        fillJugJList();
    }
    private void fillJugJList(){
        panelJugs.removeAll();
        JList<Jug> jugJList = new JList<>();
        try{
            jugJList = new JList<>(jugList.toArray(new Jug[0]));
            jugJList.setSelectionMode(JList.HORIZONTAL_WRAP);
            jugJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            jugJList.setVisibleRowCount(-1);
            jugJList.setLayoutOrientation(JList.VERTICAL);
            jugJList.setCellRenderer(new renderJugs());
        }catch (Exception e){
            e.printStackTrace();
        }
        panelJugs.add(jugJList);
        panelJugs.repaint();
        panelJugs.revalidate();
    }
    private void fillClientJList(){
        panelClient.removeAll();
        JList<Client> clientJList = new JList<>();
        try{
            clientJList = new JList<>(clientList.toArray(new Client[0]));
            clientJList.setSelectionMode(JList.HORIZONTAL_WRAP);
            clientJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            clientJList.setVisibleRowCount(-1);
            clientJList.setLayoutOrientation(JList.VERTICAL);
            clientJList.setCellRenderer(new renderClient());
        }catch (Exception e){
            e.printStackTrace();
        }
        panelClient.add(clientJList);
        panelClient.repaint();
        panelClient.revalidate();
    }
    private void fillSortedJList(){
        panelSorted.removeAll();
        JList<Client> sortedJList = new JList<>();
        try{
            sortedJList = new JList<>(clientList.toArray(new Client[0]));
            sortedJList.setSelectionMode(JList.HORIZONTAL_WRAP);
            sortedJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            sortedJList.setVisibleRowCount(-1);
            sortedJList.setLayoutOrientation(JList.VERTICAL);
            sortedJList.setCellRenderer(new renderSorted());
        }catch (Exception e){
            e.printStackTrace();
        }
        panelSorted.add(sortedJList);
        panelSorted.repaint();
        panelSorted.revalidate();
    }
    private void setMAX_FLAVOUR(){
        for (Jug jug: jugList) MAX_FLAVOUR = Integer.max(MAX_FLAVOUR, jug.getFlavour());
        for (Client client: clientList) MAX_FLAVOUR = Integer.max(MAX_FLAVOUR, client.maxPreferedFlavour());
    }
}
