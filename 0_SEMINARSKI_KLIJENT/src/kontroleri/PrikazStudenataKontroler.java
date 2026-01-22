/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.NivoStudija;
import domen.Student;
import forme.PrikazStudenataForma;
import forme.model.ModelTabeleStudenti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author DELL
 */
public class PrikazStudenataKontroler {
    private final PrikazStudenataForma psf;

    public PrikazStudenataKontroler(PrikazStudenataForma psf) {
        this.psf = psf;
        addActionListener();
    }
   

    public void otvoriFormu() {
        pripremiFormu();//ucitava studente, ne treba ovako automatski da ih ucitava, vec pretraga?? TODO
        psf.setVisible(true);
        
    }

    private void pripremiFormu() {
        List<Student> listaStudenata=komunikacija.Komunikacija.getInstance().ucitajStudente();
        ModelTabeleStudenti mts=new ModelTabeleStudenti(listaStudenata);
        psf.getjTable1studenti().setModel(mts);
        
        List<NivoStudija> nivoStudija = Komunikacija.getInstance().ucitajNivoStudija();
        psf.getjComboBox1NivoSt().removeAllItems();
        for (NivoStudija n : nivoStudija) {
            psf.getjComboBox1NivoSt().addItem(n);
        }
        
    }

    private void addActionListener() {
        psf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red=psf.getjTable1studenti().getSelectedRow();
                
                if(red==-1){
                    JOptionPane.showMessageDialog(psf, "Систем не може да обрише студента", "ГРЕШКА", JOptionPane.ERROR_MESSAGE);
                    
                }
                else{
                    ModelTabeleStudenti mts=(ModelTabeleStudenti) psf.getjTable1studenti().getModel();
                    Student s=mts.getLista().get(red);
                    try {
                        komunikacija.Komunikacija.getInstance().obrisiStudent(s);
                        JOptionPane.showMessageDialog(psf, "Систем је обрисао студента");
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(psf, "Систем не може да обрише студента");
                        
                    }
                    
                }
            }
        });
        psf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ime,prezime,nivo studija
                String ime=psf.getjTextField1imeStudenta().getText().trim();
                String prezime=psf.getjTextField1prezimeStudenta().getText().trim();
                NivoStudija nivoStudija=(NivoStudija) psf.getjComboBox1NivoSt().getSelectedItem();
                
                ModelTabeleStudenti mts=(ModelTabeleStudenti) psf.getjTable1studenti().getModel();
                mts.pretraziStudent(ime,prezime,nivoStudija);
                
                if(mts.getLista().isEmpty()){
                    JOptionPane.showMessageDialog(psf, "Систем не може да нађе студенте по задатим критеријумима", "X", JOptionPane.ERROR_MESSAGE);
                    
                }
                else
                    JOptionPane.showMessageDialog(psf, "Систем је нашао студенте по задатим критеријумима", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            }
        }); 
        psf.addBtnResetTableActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
            }
        });
        
    }
    
}
