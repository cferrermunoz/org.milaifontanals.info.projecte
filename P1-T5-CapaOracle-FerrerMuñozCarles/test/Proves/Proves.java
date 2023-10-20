/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proves;

import P1_T5_CapaOracle_FerrerMuñozCarles.ConnexioGeneral;
import P1_T5_Model_FerrerMuñozCarles.Punt;
import P1_T5_Model_FerrerMuñozCarles.Ruta;
import P1_T5_Model_FerrerMuñozCarles.Tipus;
import P1_T5_Model_FerrerMuñozCarles.Usuari;
import P1_T5_Model_FerrerMuñozCarles.WikilocException;
import java.util.List;

/**
 *
 * @author isard
 */
public class Proves {
    private static ConnexioGeneral gBD;
    
    public static void main(String[] args) {
        try {
            System.out.println("Intent de creació de la capa");
            gBD = new ConnexioGeneral("WikilocJDBC.xml");
        } catch (WikilocException ex){
            ex.printStackTrace();
            System.out.println("Problema en crear capa de persistència:");
            System.out.println(ex.getMessage());
            System.out.println("Avortem programa");
            return;
        }
        List<Tipus> tipus = gBD.getListTipus();
        Usuari user = new Usuari("cferrer1","cferrer1","cferrer1");
        Ruta r1 = new Ruta(4,null,"Títol prova","Text prova", 10, 10,10,10,1,5,4,"Descripció");
        
        Punt p1 = new Punt(15,r1,"punt prova", "descripció prova", null, 45,45,45,tipus.get(0));
        //mostrarRutes(new Usuari("cferrer1","cferrer1","cferrer1"));
        mostrarTipus(tipus);
        System.out.println("");
        if (gBD.comprovarContrasenya("cferrer1", "cferrer1")){
            System.out.println("He entrat");
        } else {
            System.out.println("xd");
            
        }
        //Prova afegir ruta
        System.out.println("Prova afegir ruta");
        if (gBD.afegirRuta(r1, user)){
            System.out.println("Ruta afegida");
            System.out.println(r1);
        } else {
            System.out.println("Ruta no afegida");
        }
        gBD.validateChanges();
        //Prova afegir Punt
        if (gBD.afegirPunt(p1)){
            System.out.println("Punt afegit");
        } else {
            System.out.println("Punt no afegit");
        }
        gBD.validateChanges();
        //Prova Eliminar Punt
        if (gBD.eliminarPunt(p1)){
            System.out.println("Punt eliminat");
        } else {
            System.out.println("Punt no eliminat");
        }
        gBD.validateChanges();
        //Prova podem eliminar ruta, útil en el cas de que estiguem mirant si la ruta té comentaris
        System.out.println("Prova podemEliminarRuta");
        if (gBD.podemEliminarRuta(r1)){
            System.out.println("Ruta possible eliminar");
        } else {
            System.out.println("Ruta no possible eliminar");
        }
        gBD.validateChanges();
        //Prova eliminar Ruta
        if (gBD.eliminarRuta(r1)){
            System.out.println("Ruta eliminada");
        } else {
            System.out.println("Ruta no eliminada");
        }
        gBD.validateChanges();
    }

    private static void mostrarRutes(Usuari usuari) {
        try {
            System.out.println("Recuperació de Rutes");
            List<Ruta> rutes = gBD.obtenirLlistaRuta(usuari.getLogin(), null, null, "");
            if (rutes.isEmpty()){
                System.out.println("No hi ha rutes");
            } else {
                System.out.println("Liista de Rutes:");
                for (Ruta r : rutes){
                    System.out.println(r);
                }
            }
        } catch (WikilocException ex){
            System.out.println("\tError: "+ex.getMessage());
        }
    }

    private static void mostrarTipus(List<Tipus> tipus) {
        try {
            System.out.println("Recuperació de Rutes");
            if (tipus.isEmpty()){
                System.out.println("No hi ha tipus");
            } else {
                System.out.println("Llista de tipus:");
                for (Tipus t : tipus){
                    System.out.println(t);
                }
            }
        } catch (WikilocException ex){
            System.out.println("\tError: "+ex.getMessage());
        }
    }
}
