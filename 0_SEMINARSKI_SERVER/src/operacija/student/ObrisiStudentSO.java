/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.student;

import domen.Student;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author DELL
 */
public class ObrisiStudentSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object obj) throws Exception {
        if(obj==null || !(obj instanceof Student)){
            throw new Exception("Систем не може да обрише студента");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String kljuc) throws Exception {
        broker.delete((Student)obj);
    }
    
}
