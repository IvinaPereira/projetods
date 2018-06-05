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
public class Anticorpo implements Cloneable{
    
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Professor> profAnticorpo = new ArrayList<>();
    private String nome;
    private int nivelAptidao;

    public Anticorpo() throws CloneNotSupportedException {
        adicionarProfessores();
        gerar();
    }
    
    public Anticorpo(boolean f){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Professor> getProfAnticorpo() {
        return profAnticorpo;
    }

    public void setProfAnticorpo(ArrayList<Professor> profAnticorpo) {
        this.profAnticorpo = profAnticorpo;
    }

    public int getNivelAptidao() {
        return nivelAptidao;
    }

//    public void setNivelAptidao(int nivelAptidao) {
//        this.nivelAptidao = nivelAptidao;
//    }
    
    public void gerarNivelAptidao() {
        int n = 0;
        for (Curso curso : cursos) {
            n += curso.getNivelAptidao();
        }
        this.nivelAptidao = n;
    }  
    
    public void gerar() throws CloneNotSupportedException{
        Banco banco = new Banco();
        
        ArrayList<Curso> curss = banco.getCursos();
        for (Curso curso : curss) {
            Curso cur = new Curso(curso.getNome());
            cur.gerar(curso,profAnticorpo);
            this.cursos.add(cur);            
        }
        gerarNivelAptidao();
    }
    
    public void adicionarProfessores() throws CloneNotSupportedException{
        Banco banco = new Banco();
        ArrayList<Professor> professores = banco.getProf();
        
        for (Professor professor : professores) {
            Professor prof = (Professor) professor.clone();
            this.profAnticorpo.add(prof);
        }        
    }
    
    public void mutar(){
        Random rand = new Random();
        
        int i = rand.nextInt(this.cursos.size());
        
        System.out.println("Mutando o curso"+this.cursos.get(i).getNome());
        this.cursos.get(i).mutar();
        gerarNivelAptidao();
    }
    
    public void imprimir(){
        System.out.println("\n\n"+getNome()+ " APTIDAO-"+ this.nivelAptidao);
        for (Curso curso : cursos) {
            curso.imprimir();
        }
    }
    
    public void imprimirProfessores(){
        System.out.println("Professores do "+getNome());
        for (Professor professor : profAnticorpo) {
            professor.imprimir();
        }
        System.out.println("\n");
    }
    
    public void imprimirHorariosProfessores(){
        System.out.println("Professores do "+getNome());
        for (Professor professor : profAnticorpo) {
            professor.imprimirHorario();
        }
        System.out.println("\n");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Anticorpo copia = new Anticorpo(false);
        copia.adicionarProfessores();
        copia.setCursos(clonarCursos(copia.getProfAnticorpo()));
        copia.gerarNivelAptidao();
        return copia;
    }
    
    public ArrayList<Curso> clonarCursos(ArrayList<Professor> profs) throws CloneNotSupportedException{
        ArrayList<Curso> clonados = new ArrayList<>();
        for (Curso curso : cursos) {
            Curso copia = (Curso) curso.clone(profs);
            clonados.add(copia);
        }
        
        return clonados;
    }
    
}
