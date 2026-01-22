/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.NivoStudija;
import domen.Student;
import forme.KreirajStudentForma;
import java.util.List;
import komunikacija.Komunikacija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author DELL
 */
public class KreirajStudentKontroler {
    private final KreirajStudentForma ksf;
    
    public KreirajStudentKontroler(KreirajStudentForma ksf) {
        this.ksf = ksf;
        addActionListener();
    }
    public void otvoriFormu() {
        pripremiFormu();
        ksf.setVisible(true);
        
    }
    private void addActionListener() {
        ksf.addBtnKreirajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dodavanje studenta dugme
                kreirajStudent(e);
            }

            private void kreirajStudent(ActionEvent e) {
                String ime=ksf.getjTextField1ime().getText().trim();
                String prezime=ksf.getjTextField2prezime().getText().trim();
                String email=ksf.getjTextField2email().getText().trim();
                NivoStudija ns=(NivoStudija) ksf.getjComboBox1nivost().getSelectedItem();
                //id treba da bude vec generisani
                Student noviStudent=new Student(-1,ime,prezime,email,ns);
                
                //dodavanje novog studenta u bazu, update
            }
        });
    }

    private void pripremiFormu() {
        List<NivoStudija> nivoStudija = Komunikacija.getInstance().ucitajNivoStudija();
        ksf.getjComboBox1nivost().removeAllItems();
        for (NivoStudija n : nivoStudija) {
            ksf.getjComboBox1nivost().addItem(n);
        }
    }
    
    
}
