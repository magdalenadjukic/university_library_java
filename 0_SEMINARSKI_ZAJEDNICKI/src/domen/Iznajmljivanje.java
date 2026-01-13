/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Iznajmljivanje implements ApstraktniDomenskiObjekat{
    //.Iznajmljivanje (idIznajmljivanje, datumIznajmljivanja, datumVracanja, idBibliotekar,idStudent) 
    private int idIznajmljivanje;
    private Date datumIznajmljivanja;
    private Date datumVracanja;
    private Bibliotekar bibliotekar;
    private Student student;
    private List<StavkaIznajmljivanja> listaStavki;
    
    public Iznajmljivanje() {
    }

    public Iznajmljivanje(int idIznajmljivanje, Date datumIznajmljivanja, Date datumVracanja, Bibliotekar bibliotekar, Student student,List<StavkaIznajmljivanja> listaStavki) {
        this.idIznajmljivanje = idIznajmljivanje;
        this.datumIznajmljivanja = datumIznajmljivanja;
        this.datumVracanja = datumVracanja;
        this.bibliotekar = bibliotekar;
        this.student = student;
        this.listaStavki=listaStavki;
    }

    public List<StavkaIznajmljivanja> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaIznajmljivanja> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public int getIdIznajmljivanje() {
        return idIznajmljivanje;
    }

    public void setIdIznajmljivanje(int idIznajmljivanje) {
        this.idIznajmljivanje = idIznajmljivanje;
    }

    public Date getDatumIznajmljivanja() {
        return datumIznajmljivanja;
    }

    public void setDatumIznajmljivanja(Date datumIznajmljivanja) {
        this.datumIznajmljivanja = datumIznajmljivanja;
    }

    public Date getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(Date datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    public Bibliotekar getBibliotekar() {
        return bibliotekar;
    }

    public void setBibliotekar(Bibliotekar bibliotekar) {
        this.bibliotekar = bibliotekar;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Iznajmljivanje other = (Iznajmljivanje) obj;
        return this.idIznajmljivanje == other.idIznajmljivanje;
    }

    @Override
    public String toString() {
        return "listaStavki=" + listaStavki;
    }

    @Override
    public String vratiNazivTabele() {
        return "iznajmljivanje";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumIznajmljivanja,datumVracanja,idBibliotekar,idStudent";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+datumIznajmljivanja+"','"+datumVracanja+"',"+bibliotekar.getIdBibliotekar()+","+student.getIdStudent();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "iznajmljivanje.idIznajmljivanje="+idIznajmljivanje;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        //idIznajmljivanje, datumIznajmljivanja, datumVracanja, idBibliotekar,idStudent
        return "idIznajmljivanje="+idIznajmljivanje+",datumIznajmljivanja='"+datumIznajmljivanja+"',datumVracanja='"+datumVracanja+"',idBibliotekar="+bibliotekar.getIdBibliotekar()+",idStudent="+student.getIdStudent();
    }

    
    
}
