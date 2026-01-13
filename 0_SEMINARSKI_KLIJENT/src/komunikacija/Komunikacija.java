/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Bibliotekar;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Komunikacija {
    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instance;

    private Komunikacija() {
    }

    public static Komunikacija getInstance() {
        if (instance==null)
            instance=new Komunikacija();
        return instance;
    }
    
    public void konekcija() {
        try {
            socket=new Socket("localhost", 9000);
            posiljalac=new Posiljalac(socket);
            primalac=new Primalac(socket);
        } catch (IOException ex) {
            System.out.println("server nije povezan");
        }
    }

    public Bibliotekar prijava(String korisnickoIme, String lozinka) throws Exception{
        Bibliotekar b=new Bibliotekar();
        b.setKorisnickoIme(korisnickoIme);
        b.setLozinka(lozinka);
        
        Zahtev zahtev=new Zahtev(Operacija.LOGIN, b);
        posiljalac.posalji(zahtev);
        
        Odgovor odg=(Odgovor) primalac.primi();
        
        b=(Bibliotekar) odg.getOdgovor();
        if(odg.getExc()==null){
           System.out.println("USPEH");
            return b;
        }
        else{
          System.out.println("GRESKA");
          throw odg.getExc();
        }
    }
    
    
    
    
}
