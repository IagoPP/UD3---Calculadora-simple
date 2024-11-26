package Calculadora;

import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ActionController implements ActionListener {
    PaintFrame viewPaintFrame;
    String dialog = "";
    boolean erase = false;
    ArrayList<String> nums = new ArrayList<String>();
    ArrayList<Integer> operations = new ArrayList<Integer>();

    public ActionController(PaintFrame vPaint) {
        viewPaintFrame = vPaint;
    }

    public void eventListener() {
        for (int i = 0; i < viewPaintFrame.buttons.length; i++) {
            for (int j = 0; j < viewPaintFrame.buttons[0].length; j++) {
                viewPaintFrame.buttons[i][j].addActionListener(this);
            }
        } 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        

       for (int i = 0; i < viewPaintFrame.buttons.length; i++) {
            for (int j = 0; j < viewPaintFrame.buttons[0].length; j++) {
                if(ae.getSource().equals(viewPaintFrame.buttons[i][j])){
                    if (viewPaintFrame.buttons[i][j].getText().matches("\\d")) {  
                        if (erase==true) {
                            dialog="";
                            erase=false;
                        }
                        dialog = dialog + viewPaintFrame.buttons[i][j].getText();
                        viewPaintFrame.numField.setText(dialog);


                        System.out.println(viewPaintFrame.buttons[i][j].getText());
                    }
                    if (viewPaintFrame.buttons[i][j].getText().matches("[+–×/]")) {                        
                        if (viewPaintFrame.buttons[i][j].getText().equals("+")) {
                            nums.add(dialog);
                            operations.add(0);
                            erase = true;
                        }
                    } 
                    if (viewPaintFrame.buttons[i][j].getText().equals("=")) {
                        int result=Integer.parseInt(dialog);
                        for (int k = 0; k < nums.size(); k++) {
                            result += Integer.parseInt(nums.get(k));
                        }
                        dialog = String.valueOf(result);
                        viewPaintFrame.numField.setText(dialog);
                        erase = true;
                    }
                    
                    if (viewPaintFrame.buttons[i][j].getText().equals("AC")) {
                        dialog = String.valueOf("");
                        viewPaintFrame.numField.setText(dialog);
                    }       
                }               
            }
        }
    }
}
