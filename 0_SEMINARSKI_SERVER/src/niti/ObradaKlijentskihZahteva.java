/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Bibliotekar;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author DELL
 */
public class ObradaKlijentskihZahteva extends Thread {
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;
    boolean kraj=false;
    
    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket=socket;
        posiljalac=new Posiljalac(socket);
        primalac=new Primalac(socket);
    }
    
    @Override
    public void run() {
        while(!kraj){
                Zahtev zahtev=(Zahtev) primalac.primi();
                Odgovor odgovor=new Odgovor();
                try{
                switch (zahtev.getOperacija()) {
                    case LOGIN:
                        Bibliotekar b=(Bibliotekar) zahtev.getParametar();
                        b=kontroler.Kontroler.getInstance().prijaviBibliotekar(b);
                        odgovor.setOdgovor(b);
                        break;
                        
                    default:
                        System.out.println("operacija ne postoji");
                }
                }catch(Exception ex){
                     ex.printStackTrace();
                     odgovor.setExc(ex);
                }
                
                posiljalac.posalji(odgovor);
            
        }
    }
    
    public void prekini(){
        kraj=true;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        interrupt();
    }
    
}
