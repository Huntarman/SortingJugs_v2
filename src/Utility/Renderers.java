package Utility;

import Main.Client;
import Main.Jug;

import javax.swing.*;
import java.awt.*;

public class Renderers {
    public static class renderJugs extends JLabel implements ListCellRenderer<Jug> {

        public renderJugs(){setOpaque(true);}
        @Override
        public Component getListCellRendererComponent(JList<? extends Jug> list, Jug value, int index, boolean isSelected, boolean cellHasFocus) {
            setText("ID: " + value.getId() + " | Flavour: " + value.getFlavour() + " | Volume: " + value.getVolume());
            return this;
        }
    }

    public static class renderClient extends JLabel implements ListCellRenderer<Client> {

        public renderClient(){setOpaque(true);}
        @Override
        public Component getListCellRendererComponent(JList<? extends Client> list, Client value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.clientToString());
            return this;
        }
    }
}
