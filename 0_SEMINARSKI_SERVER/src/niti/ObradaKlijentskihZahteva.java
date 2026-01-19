/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Bibliotekar;
import domen.NivoStudija;
import domen.Student;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;
import komunikacija.Operacija;
import kontroler.Kontroler;

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
                    case PRIJAVA:
                        Bibliotekar b=(Bibliotekar) zahtev.getParametar();
                       // String korisnickoIme=b.getKorisnickoIme();
                        //String sifra=b.getLozinka();
                        b=kontroler.Kontroler.getInstance().prijaviBibliotekar(b);
                        odgovor.setOdgovor(b);
                        break;
                    case UCITAJ_STUDENTE:
                        List<Student> studenti=kontroler.Kontroler.getInstance().ucitajStudente();
                        
                        odgovor.setOdgovor(studenti);
                        break;
                    case OBRISI_STUDENT:
                    try {
                        Student s=(Student) zahtev.getParametar();
                        kontroler.Kontroler.getInstance().obrisiStudent(s);
                        odgovor.setOdgovor(null);
                    } catch (Exception e) {
                        odgovor.setOdgovor(e);
                    }
                        break;
                    case UCITAJ_NIVOE:
                    List<NivoStudija> listaNivoa = Kontroler.getInstance().ucitajNivoStudija();
                    odgovor.setOdgovor(listaNivoa);
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
