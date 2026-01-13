/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class TerminDezurstva implements ApstraktniDomenskiObjekat{
    private int idTerminDezurstva;
    private Date vremeOd;
    private Date vremeDo;

    public TerminDezurstva() {
    }

    public TerminDezurstva(int idTerminDezurstva, Date vremeOd, Date vremeDo) {
        this.idTerminDezurstva = idTerminDezurstva;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
    }

    public int getIdTerminDezurstva() {
        return idTerminDezurstva;
    }

    public void setIdTerminDezurstva(int idTerminDezurstva) {
        this.idTerminDezurstva = idTerminDezurstva;
    }

    public Date getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(Date vremeOd) {
        this.vremeOd = vremeOd;
    }

    public Date getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(Date vremeDo) {
        this.vremeDo = vremeDo;
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
        final TerminDezurstva other = (TerminDezurstva) obj;
        if (!Objects.equals(this.vremeOd, other.vremeOd)) {
            return false;
        }
        return Objects.equals(this.vremeDo, other.vremeDo);
    }

    @Override
    public String toString() {
        return vremeOd + " - " + vremeDo;
    }

    @Override
    public String vratiNazivTabele() {
        return "termindezurstva";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista=new ArrayList<>();
        
        while(rs.next()){
            int idTerminDezurstva=rs.getInt("termindezurstva.idTerminDezurstva");
            
            java.sql.Date vo=rs.getDate("termindezurstva.vremeOd"); //proveriti za datum
            java.util.Date vremeOd=new java.util.Date(vo.getTime());
            
            java.sql.Date vd=rs.getDate("termindezurstva.vremeDo");
            java.util.Date vremeDo=new java.util.Date(vd.getTime());
           
            TerminDezurstva td=new TerminDezurstva(idTerminDezurstva, vremeOd, vremeDo);
            lista.add(td);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "vremeOd,vremeDo";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+vremeOd+"','"+vremeDo+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "termindezurstva.idTerminDezurstva="+idTerminDezurstva;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "idTerminDezurstva="+idTerminDezurstva+",vremeOd='"+vremeOd+"',vremeDo='"+vremeDo+"'";
    }
    
    
}
