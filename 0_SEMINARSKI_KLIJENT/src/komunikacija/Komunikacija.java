/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Bibliotekar;
import domen.NivoStudija;
import domen.Student;
import forme.PrikazStudenataForma;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Komunikacija {
    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instance;

    //private PrikazStudenataForma psf;
    
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
        
        Zahtev zahtev=new Zahtev(Operacija.PRIJAVA, b);
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

    public List<Student> ucitajStudente() {
        List<Student> lista=new ArrayList<>();
        
        Zahtev zahtev=new Zahtev(Operacija.UCITAJ_STUDENTE, null);
        posiljalac.posalji(zahtev);
        
        Odgovor odg=(Odgovor) primalac.primi();
        lista=(List<Student>) odg.getOdgovor();
        
        return lista;
    }

    public void obrisiStudent(Student s) throws Exception {
        Zahtev zahtev=new Zahtev(Operacija.OBRISI_STUDENT, s);
        posiljalac.posalji(zahtev);
        
        Odgovor odg=(Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            //uspesno brisanje
            System.out.println("USPESNO BRISANJE");
        }
        else{
            //JOptionPane.showMessageDialog(psf, "“Систем не може да обрише студента");
            System.out.println("NEUSPESNO BRISANJE");
            ((Exception) odg.getOdgovor()).printStackTrace();
            throw new Exception("X");
        }
    }

    public List<NivoStudija> ucitajNivoStudija() {
        List<NivoStudija> lista=new ArrayList<>();
        
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_NIVOE, null);
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        lista = (List<NivoStudija>) odgovor.getOdgovor();
        
        return lista;        
    }
    
    
    
    
}
