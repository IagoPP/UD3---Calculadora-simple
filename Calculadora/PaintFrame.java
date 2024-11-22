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

    String[][] buttonsData = {  {"AC", "ans", "+/–", "/"},
                                {"7",  "8",    "9",  "×"},
                                {"4",  "5",    "6",  "–"},
                                {"1",  "2",    "3",  "+"},
                                {"  0", "",    ",",  "="},
                            };

    JButton[][] buttons = new JButton[buttonsData.length][buttonsData[0].length];

    GridBagConstraints c = new GridBagConstraints();

    public PaintFrame() {
        try {
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch (UnsupportedLookAndFeelException e) {
        // handle exception
        }
        catch (ClassNotFoundException e) {
        // handle exception
        }
        catch (InstantiationException e) {
        // handle exception
        }
        catch (IllegalAccessException e) {
        // handle exception
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelConfig();
        this.getContentPane().add(panel);
        this.pack();
        centerFrame(this.getSize());
    }

    public void panelConfig() {
        panel.setLayout(new GridBagLayout());

        for (int i = 0; i < buttonsData.length; i++) {
            for (int j = 0; j < buttonsData[0].length; j++) {
                buttons[i][j] = new JButton(buttonsData[i][j]);
                buttons[i][j].setPreferredSize(new Dimension(50, 50));

                if(buttons[i][j].getText()==null){
                    continue;
                }

                c.fill = GridBagConstraints.BOTH;
                c.gridy = i;
                c.gridx = j;
                c.gridheight = 1;
                if (buttons[i][j].getText().equals("  0")) {
                    buttons[i][j].setHorizontalAlignment(SwingConstants.LEFT);
                    c.gridwidth = 2;
                }else{
                    c.gridwidth = 1;
                }
                c.ipadx = 0;
                c.ipady = 0;
                c.insets = new Insets(1, 1, 1, 1);
        
                panel.add(buttons[i][j], c);
            }
        }
    }
}
