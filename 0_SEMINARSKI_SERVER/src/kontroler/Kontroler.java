/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Bibliotekar;
import operacija.bibliotekar.PrijaviBibliotekarSO;

/**
 *
 * @author DELL
 */
public class Kontroler {
    
    private static Kontroler instance;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if(instance==null)
            instance=new Kontroler();
        return instance;
    }

    public Bibliotekar prijaviBibliotekar(Bibliotekar b) throws Exception {
        PrijaviBibliotekarSO operacija=new PrijaviBibliotekarSO();
        operacija.izvrsi(b, null);
        System.out.println("klasa kontroler:"+operacija.getBibliotekar());
        return operacija.getBibliotekar();
    }
    
    
}
