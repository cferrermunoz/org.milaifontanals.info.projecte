/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import P1_T5_CapaOracle_FerrerMuñozCarles.ConnexioGeneral;
import P1_T5_InterficiePersistencia_FerrerMuñozCarles.IGestorBDWikiloc;
import P1_T5_InterficiePersistencia_FerrerMuñozCarles.IGestorBDWikilocException;
import java.awt.TextArea;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author isard
 */
public class Vista extends JFrame{
    private ConnexioGeneral gBD = null;
    private static String nomClassePersistencia = null;
    
    public static void main(String[] args) {
        if (args.length == 0){
            System.exit(0);
        }
        nomClassePersistencia = args[0];
//        System.out.println(nomClassePersistencia);
        Vista vista = new Vista();
        vista.go();
    }

    private void go() {
        try {
            gBD = (ConnexioGeneral) Class.forName(nomClassePersistencia).newInstance();
            JFrame frame = new Login(gBD);
            frame.setVisible(true);
            
        } catch (IGestorBDWikilocException ex){
            JOptionPane.showMessageDialog(this, "Error en connectar-se a la base de dades (IGestorBDWikilocException)", "Error", 1);
            System.exit(WIDTH);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, "Error en connectar-se a la base de dades", "Error", 1);
            System.exit(WIDTH);
        } 
    }
    
    private String infoError(Throwable ex) {
        String aux;
        String info = ex.getMessage();
        if (info != null) {
            info += "\n";
        }
        while (ex.getCause() != null) {
            aux = ex.getCause().getMessage();
            if (aux != null) {
                aux += "\n";
            }
            info = info + aux;
            ex = ex.getCause();
        }
        return info;
    }
       
}
