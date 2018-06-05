/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package novotcc;

/**
 *
 * @author ivina
 */
public class NovoTCC {

    /**
     * @param args the command line arguments
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
//        Banco banco = new Banco();

        Anticorpo novo = new Anticorpo();

        novo.setNome("Anticorpo001");

        
        Anticorpo dois = (Anticorpo) novo.clone();
        
        
        novo.mutar();
        novo.mutar();
        novo.mutar();
        novo.mutar();
        novo.mutar();
        
        novo.imprimir();
//        novo.imprimirHorariosProfessores();
        dois.imprimir();
//        dois.imprimirHorariosProfessores();
        
    }

}
