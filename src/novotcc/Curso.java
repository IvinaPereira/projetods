/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package novotcc;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ivina
 */
public class Curso implements Cloneable{
    
    private ArrayList<Semestre> semestres = new ArrayList<>();
    private String nome;
    private int nivelAptidao;
    
    public Curso() {
    
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  
    
    public ArrayList<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(ArrayList<Semestre> semestres) {
        this.semestres = semestres;
    }

    public int getNivelAptidao() {
        return nivelAptidao;
    }

//    public void setNivelAptidao(int nivelAptidao) {
//        this.nivelAptidao = nivelAptidao;
//    }
    
    public void gerarNivelAptidao() {
        int n = 0;
        for(Semestre sem : semestres){
            n += sem.getNivelAptidao();
        }
        this.nivelAptidao = n;
    }
        
      
    public void gerar(Curso banco, ArrayList<Professor> profs) throws CloneNotSupportedException{
        ArrayList<Semestre> semes = banco.getSemestres();
        for (Semestre semestre : semes) {
            Semestre sem = new Semestre(semestre.getNome(),semestre.getQtdAulas());
            sem.gerar(semestre,profs);
            this.semestres.add(sem);            
        }
        gerarNivelAptidao();
    }
    
    public void mutar(){
        Random rand = new Random();
        
        int i = rand.nextInt(semestres.size());

        System.out.println("Mutando o semestre "+this.semestres.get(i).getNome());
        this.semestres.get(i).mutar();
        gerarNivelAptidao();
    }
    
    public void imprimir(){
        System.out.println("\n"+getNome() +" "+ this+ " APT-"+nivelAptidao);
        for (Semestre semestre : this.semestres) {
            semestre.imprimirDisciplinas();
            
        }
    }

    protected Object clone(ArrayList<Professor> profs) throws CloneNotSupportedException {
        Curso copia = new Curso();
        copia.setNome(getNome());
        copia.setSemestres(clonarSemestres(profs));
        copia.gerarNivelAptidao();
        return copia;
    }    
    
    private ArrayList<Semestre> clonarSemestres(ArrayList<Professor> profs) throws CloneNotSupportedException{
        ArrayList<Semestre> clonados = new ArrayList<>();
        for (Semestre semestre : semestres) {
            Semestre copia = (Semestre) semestre.clone(profs);
            clonados.add(copia);
        }
        return clonados;
    }
    
}
