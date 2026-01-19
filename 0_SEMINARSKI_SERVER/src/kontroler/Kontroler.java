/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Bibliotekar;
import domen.NivoStudija;
import domen.Student;
import java.util.ArrayList;
import java.util.List;
import operacija.bibliotekar.PrijaviBibliotekarSO;
import operacija.nivostudija.UcitajNivoStudijaSO;
import operacija.student.ObrisiStudentSO;
import operacija.student.PretraziStudentSO;

/**
 *
 * @author DELL
 */
public class Kontroler {
    
    private static Kontroler instance;
    private List<Bibliotekar> prijavljeniBibl=new ArrayList<>();
           
    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if(instance==null)
            instance=new Kontroler();
        return instance;
    }

    public List<Bibliotekar> getPrijavljeniBibl() {
        return prijavljeniBibl;
    }

    public void setPrijavljeniBibl(List<Bibliotekar> prijavljeniBibl) {
        this.prijavljeniBibl = prijavljeniBibl;
    }
    
    public Bibliotekar prijaviBibliotekar(Bibliotekar b) throws Exception {
        //umesto Bibliotekar b -> korIme,sifra ??
        PrijaviBibliotekarSO operacija=new PrijaviBibliotekarSO();
        operacija.izvrsi(b, null);
        System.out.println("klasa kontroler, prijavljivanje:"+operacija.getBibliotekar());
        return operacija.getBibliotekar();
    }

    public List<Student> ucitajStudente() throws Exception {
        PretraziStudentSO operacija=new PretraziStudentSO();
        operacija.izvrsi(null, null);
        System.out.println("klasa kontroler:"+operacija.getListaStudenata());
        return operacija.getListaStudenata();
    }

    public void obrisiStudent(Student s) throws Exception {
        ObrisiStudentSO operacija=new ObrisiStudentSO();
        operacija.izvrsi(s, null);
        //napraviti exception za studente koji se ne mogu obrisati
        //ako ima FK ka iznajmljivanju, ne moze se obrisati
        
    }

    public List<NivoStudija> ucitajNivoStudija() throws Exception {
        UcitajNivoStudijaSO operacija = new UcitajNivoStudijaSO();
        operacija.izvrsi(null, null);
        
        return operacija.getLista();
    }
    
    
}
