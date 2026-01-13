/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Knjiga implements ApstraktniDomenskiObjekat{
    private int idKnjiga;
    private String nazivKnjige;
    private String autor; //mozda kao posebnu klasu?
    private Zanr zanr; //izmeniti da bude enum u dokumentaciji

    public Knjiga() {
    }

    public Knjiga(int idKnjiga, String nazivKnjige, String autor, Zanr zanr) {
        this.idKnjiga = idKnjiga;
        this.nazivKnjige = nazivKnjige;
        this.autor = autor;
        this.zanr = zanr;
    }

    public int getIdKnjiga() {
        return idKnjiga;
    }

    public void setIdKnjiga(int idKnjiga) {
        this.idKnjiga = idKnjiga;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
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
        final Knjiga other = (Knjiga) obj;
        if (!Objects.equals(this.nazivKnjige, other.nazivKnjige)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }

    @Override
    public String toString() {
        return nazivKnjige;
    }

    @Override
    public String vratiNazivTabele() {
        return "knjiga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista=new ArrayList<>();
        
        while(rs.next()){
            int idKnjiga=rs.getInt("knjiga.idKnjiga");
            String nazivKnjige=rs.getString("knjiga.nazivKnjige");
            String autor=rs.getString("knjiga.autor");
            String z=rs.getString("knjiga.zanr");
            Zanr zanr=Zanr.valueOf(z);
            Knjiga k=new Knjiga(idKnjiga, nazivKnjige, autor, zanr);//proveriti za enum
            lista.add(k);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "nazivKnjige, autor, zanr";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+nazivKnjige+"','"+autor+"','"+zanr+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "knjiga.idKnjiga="+idKnjiga;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "idKnjiga="+idKnjiga+",nazivKnjige='"+nazivKnjige+"',autor='"+autor+"',zanr='"+zanr+"'";
    }
    
    
    
}
