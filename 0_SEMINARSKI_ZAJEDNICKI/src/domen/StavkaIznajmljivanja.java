/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StavkaIznajmljivanja implements ApstraktniDomenskiObjekat{
    //StavkaIznajmljivanja (idIznajmljivanje, rb, idKnjiga) 
    private int rb;
    private Iznajmljivanje iznajmljivanje; //primarni
    private Knjiga knjiga; //spoljni kljuc

    public StavkaIznajmljivanja() {
    }

    public StavkaIznajmljivanja(int rb, Iznajmljivanje iznajmljivanje, Knjiga knjiga) {
        this.rb = rb;
        this.iznajmljivanje = iznajmljivanje;
        this.knjiga = knjiga;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public Iznajmljivanje getIznajmljivanje() {
        return iznajmljivanje;
    }

    public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        this.iznajmljivanje = iznajmljivanje;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final StavkaIznajmljivanja other = (StavkaIznajmljivanja) obj;
        return this.rb == other.rb;
    }

    @Override
    public String toString() {
        return "Stavka iznajmljivanja: " + rb;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaiznajmljivanja";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "rb,idIznajmljivanje,idKnjiga";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return rb+","+iznajmljivanje.getIdIznajmljivanje()+","+knjiga.getIdKnjiga();
    }

    @Override
    public String vratiPrimarniKljuc() {//ne treba za stavku ovako
       // return "stavkaiznajmljivanja.rb="+rb+" AND stavkaiznajmljivanja.idIznajmljivanje="+iznajmljivanje.getIdIznajmljivanje();
       return "uradi drugacije";
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "rb="+rb+",idIznajmljivanje="+iznajmljivanje.getIdIznajmljivanje()+",idKnjiga="+knjiga.getIdKnjiga();
    }
    
    
}
