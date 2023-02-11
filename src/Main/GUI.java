package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JTextField textFieldPreferences;
    private JTextField textFieldRandClientAmount;
    private JTextField textFieldJugAmount;
    private JTextField textFieldFlavour;
    private JTextField textFieldVolume;
    private JTextField textFieldMaxFlavourJug;
    private JTextField textFieldMaxFlavourClient;

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 914, 481);
        getContentPane().setLayout(null);
        getContentPane().setLayout(null);
        getContentPane().setLayout(null);
        getContentPane().setLayout(null);
        getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 886, 434);
        getContentPane().add(panel);
        panel.setLayout(null);

        JList listClient = new JList();
        listClient.setBackground(new Color(255, 255, 255));
        listClient.setBounds(10, 80, 250, 320);
        panel.add(listClient);

        JList listJugs = new JList();
        listJugs.setBackground(new Color(255, 255, 255));
        listJugs.setBounds(325, 80, 250, 320);
        panel.add(listJugs);

        JList listSorted = new JList();
        listSorted.setBackground(new Color(255, 255, 255));
        listSorted.setBounds(640, 80, 250, 354);
        panel.add(listSorted);

        JButton sortBtnspecial = new JButton("Sort( Special method )");
        sortBtnspecial.setBounds(640, 10, 250, 21);
        panel.add(sortBtnspecial);

        JButton sortBtnGreedy = new JButton("Sort( Greedy algorithm)");
        sortBtnGreedy.setBounds(640, 41, 250, 21);
        panel.add(sortBtnGreedy);

        JLabel lblClientList = new JLabel("Client list:");
        lblClientList.setBounds(10, 67, 119, 13);
        panel.add(lblClientList);

        JLabel lblJugList = new JLabel("Jug list:");
        lblJugList.setBounds(325, 67, 119, 13);
        panel.add(lblJugList);

        JLabel lblSortedList = new JLabel("List after assingement");
        lblSortedList.setBounds(639, 67, 251, 13);
        panel.add(lblSortedList);

        JButton addClientBtn = new JButton("Add client");
        addClientBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        addClientBtn.setBounds(10, 10, 85, 21);
        panel.add(addClientBtn);

        JLabel lblPreferences = new JLabel("Preferences:");
        lblPreferences.setBounds(105, 0, 155, 13);
        panel.add(lblPreferences);

        textFieldPreferences = new JTextField();
        textFieldPreferences.setBounds(105, 11, 155, 19);
        panel.add(textFieldPreferences);
        textFieldPreferences.setColumns(10);

        JButton randomClientBtn = new JButton("Add random num");
        randomClientBtn.setBounds(10, 41, 119, 21);
        panel.add(randomClientBtn);

        textFieldRandClientAmount = new JTextField();
        textFieldRandClientAmount.setBounds(139, 42, 45, 19);
        panel.add(textFieldRandClientAmount);
        textFieldRandClientAmount.setColumns(10);

        JLabel lblAmountClients = new JLabel("Amount:");
        lblAmountClients.setBounds(139, 30, 52, 13);
        panel.add(lblAmountClients);

        JButton addJugBtn = new JButton("Add jug");
        addJugBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        addJugBtn.setBounds(325, 10, 85, 21);
        panel.add(addJugBtn);

        JButton addRandomJugBtn = new JButton("Add random jugs");
        addRandomJugBtn.setBounds(325, 41, 119, 21);
        panel.add(addRandomJugBtn);

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

        JScrollBar scrollClient = new JScrollBar();
        scrollClient.setBounds(270, 80, 17, 320);
        panel.add(scrollClient);

        JScrollBar scrollJug = new JScrollBar();
        scrollJug.setBounds(585, 80, 17, 320);
        panel.add(scrollJug);

        JScrollBar scrollSorted = new JScrollBar();
        scrollSorted.setBounds(612, 80, 17, 354);
        panel.add(scrollSorted);

        JButton readJugsFromFilebtn = new JButton("Read Jugs from file");
        readJugsFromFilebtn.setBounds(325, 413, 250, 21);
        panel.add(readJugsFromFilebtn);

        JButton readClientsFromFilebtn = new JButton("Read Clients from file");
        readClientsFromFilebtn.setBounds(10, 413, 250, 21);
        panel.add(readClientsFromFilebtn);
    }
}
