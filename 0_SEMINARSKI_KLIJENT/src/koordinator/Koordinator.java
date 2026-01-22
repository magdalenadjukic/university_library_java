/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koordinator;

import domen.Bibliotekar;
import forme.GlavnaForma;
import forme.KreirajStudentForma;
import forme.LoginForma;
import forme.PrikazStudenataForma;
import kontroleri.GlavnaFormaKontroler;
import kontroleri.KreirajStudentKontroler;
import kontroleri.LoginKontroler;
import kontroleri.PrikazStudenataKontroler;

/**
 *
 * @author DELL
 */
public class Koordinator {
    //sadrzi sve ostale kontrolere, kao glavni kontroler
    private static Koordinator instance;
    private LoginKontroler loginKontroler;
    private GlavnaFormaKontroler glavnaFormaKontroler;
    private Bibliotekar ulogovaniBibl;
    private PrikazStudenataKontroler psk;
    private KreirajStudentKontroler ksk;
    
    private Koordinator() {
    }

    public static Koordinator getInstance() {
        if(instance==null)
            instance=new Koordinator();
        return instance;
    }

    public Bibliotekar getUlogovaniBibl() {
        return ulogovaniBibl;
    }

    public void setUlogovaniBibl(Bibliotekar ulogovaniBibl) {
        this.ulogovaniBibl = ulogovaniBibl;
    }

    public void otvoriLoginFormu() {
        loginKontroler=new LoginKontroler(new LoginForma());
        loginKontroler.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaKontroler=new GlavnaFormaKontroler(new GlavnaForma());
        glavnaFormaKontroler.otvoriFormu();
    }

    public void otvoriPrikazStudenataFormu() {
        psk=new PrikazStudenataKontroler(new PrikazStudenataForma());
        psk.otvoriFormu();
    }
    public void otvoriKreirajStudentFormu(){
        ksk=new KreirajStudentKontroler(new KreirajStudentForma());
        ksk.otvoriFormu();
    }
}
