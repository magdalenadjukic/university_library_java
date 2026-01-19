/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.bibliotekar;

import domen.Bibliotekar;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author DELL
 */
public class PrijaviBibliotekarSO extends ApstraktnaGenerickaOperacija {
    private Bibliotekar bibliotekar;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
        if(obj==null || !(obj instanceof Bibliotekar)){
            throw new Exception("Корисничко име и шифра нису исправни.");
            //ispisati poruku kao jop.showmessagedialog?
        }
        Bibliotekar bibliotekar=(Bibliotekar) obj; 
        
        if(bibliotekar.getKorisnickoIme()==null || bibliotekar.getKorisnickoIme().isEmpty() || bibliotekar.getLozinka()==null || bibliotekar.getLozinka().isEmpty()){
            throw new Exception("Корисничко име и шифра нису исправни.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        List<Bibliotekar> listaBibliotekara=broker.getAll((Bibliotekar) obj, null);
        System.out.println("PrijaviBibliotekarSO: "+listaBibliotekara);
        for (Bibliotekar b : listaBibliotekara) {
            if(b.equals((Bibliotekar)obj)){
                bibliotekar=b;
                return;
            }
        }
        bibliotekar=null;
    }

    public Bibliotekar getBibliotekar() {
        return bibliotekar;
    }

    
}
