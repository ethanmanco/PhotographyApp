/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package photographyapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Ethan
 */
public class PhotographyApp {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
               }
            }
        } catch (Exception ex) {
                   ex.printStackTrace();
        }
        
        // Create an instance of your JFrame class
        Login login = new Login();
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        login.setVisible(true);
    }
    
}
