/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cnpm;

import DAO.DAO;
import View.Login;
import javax.swing.JOptionPane;
/**
 *
 * @author jasper
 */
public class CNPM {
    
    public static void main(String[] args) {
//        String noti = JOptionPane.showInputDialog(null, "Enter your Client ID");
//        userID = Integer.parseInt(noti);
        
        DAO dao = new DAO();
        Login session = new Login();
        session.setVisible(true);
    }
    
}
