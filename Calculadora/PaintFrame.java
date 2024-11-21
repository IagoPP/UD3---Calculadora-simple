package Calculadora;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PaintFrame extends JFrame {
    private ActionController eventClicks;

    private void execActions() {
        eventClicks = new ActionController(this);

        eventClicks.eventListener();
    }

    private void centerFrame(Dimension size){ //Este es un método que hice para centrar la ventana justo en el medio de la pantalla, util cuando el JFrame no tiene unas dimensiones predefinidas por ti
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

        int ancho = pantalla.width/2 - (int)size.getWidth()/2;
        int alto = pantalla.height/2 - (int)size.getHeight()/2;

        this.setLocation(ancho, alto);
    }

    JPanel panel = new JPanel();
    JPanel bottomPanel = new JPanel();

    JTextField operationDisplay = new JTextField(9);

    String
    JButton[][] buttons;


    JLabel passError = new JLabel("La contraseña debe de tener al menos 8 caracteres");

    public PaintFrame() {
        //this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelConfig();
        this.getContentPane().add(panel);
        this.pack();
        centerFrame(this.getSize());
    }

    public void panelConfig() {
        
    }
}
