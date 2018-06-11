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
public class Anticorpo implements Cloneable, Comparable<Anticorpo> {

    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Professor> profAnticorpo = new ArrayList<>();
    private String nome;
    private boolean pai;
    private int nivelAptidao;
    private int qtdCopias;

    private int pesoFuncao3 = 10;
    private int pesoFuncao4 = 6;

    private int mutacaoAlta;

    private Banco banco;

    public Anticorpo(String nome, Banco banco) throws CloneNotSupportedException {
        this.nome = nome;
        this.banco = banco;
        adicionarProfessores(this.banco);
        gerar();
    }

    public Anticorpo(boolean f) {
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

    public boolean isPai() {
        return pai;
    }

    public int getQtdCopias() {
        return qtdCopias;
    }

    public int gerarqtdCopias(int melhorIndividuo) {
        int taxa = melhorIndividuo / 10;
        this.qtdCopias = this.nivelAptidao / taxa;
        return qtdCopias;
    }

    public void setPai(boolean pai) {
        this.pai = pai;
    }

    public int getNivelAptidao() {
        return nivelAptidao;
    }

    public void gerarNivelAptidao() {
        int n = 0;
        for (Curso curso : cursos) {
            n += curso.getNivelAptidao();
        }
        n += funcao3();
        n += funcao4();
        this.nivelAptidao = 1200 - n;
    }

    //retorna todos os choques de horarios de todos os professores
    public int funcao3() {
        int n = 0;
        for (Professor professor : profAnticorpo) {
            n += professor.getChoqueHorario();
        }
        return n * pesoFuncao3;
    }

    //retorna todas as ocorrencias de aulas que os professores estarão indisponíveis
    public int funcao4() {
        int n = 0;
        for (Professor professor : profAnticorpo) {
            n += professor.getPreferencias();
        }
        return n * pesoFuncao4;
    }

    public void gerar() throws CloneNotSupportedException {
        ArrayList<Curso> curss = banco.getCursos();
        for (Curso curso : curss) {
            Curso cur = new Curso(curso.getNome());
            cur.gerar(curso, profAnticorpo);
            this.cursos.add(cur);
        }
        gerarNivelAptidao();
    }

    public void adicionarProfessores(Banco banco) throws CloneNotSupportedException {
        ArrayList<Professor> professores = banco.getProf();

        for (Professor professor : professores) {
            Professor prof = (Professor) professor.clone();
            this.profAnticorpo.add(prof);
        }
    }

    public void mutar(int taxaPadrao) {
        Random rand = new Random();
        float valor1 = (float) (1.0 / (nivelAptidao));
        float novo = ((valor1) * 1600);
//        System.out.println(" nivelAptidao " + nivelAptidao);
//        System.out.println(" novo " + novo);
        int taxa = (int) novo;
//        taxa = taxa * taxa;
//        System.out.println("taxa que chegou= " + taxaPadrao);
//        System.out.println("taxa = " + taxa);
        for (int j = 0; j < taxa; j++) {
            int i = rand.nextInt(this.cursos.size());
            this.cursos.get(i).mutar();
//            System.out.println("chegou");
        }
        gerarNivelAptidao();
//        System.out.println("vai sair");
    }

    public void imprimir() {
        System.out.println("\n\n" + getNome() + " APTIDAO-" + this.nivelAptidao + " Pai:" + pai);
        for (Curso curso : cursos) {
            curso.imprimir();
        }
    }

    public void imprimirProfessores() {
        System.out.print("\n---- Professores ----\n");
        for (Professor professor : profAnticorpo) {
            professor.imprimir();
        }
        System.out.println("\n");
    }

    public void imprimirHorariosProfessores() {
        System.out.print("\n\n---- Professores ----");
        for (Professor professor : profAnticorpo) {
            professor.imprimirHorario();
        }
        System.out.println("\n");
    }

    protected Object clone(Banco banco) throws CloneNotSupportedException {
        Anticorpo copia = new Anticorpo(false);
        copia.adicionarProfessores(banco);
        copia.setCursos(clonarCursos(copia.getProfAnticorpo()));
        copia.gerarNivelAptidao();
        copia.setNome("Anticorpo");
        copia.setPai(false);
        return copia;
    }

    public ArrayList<Curso> clonarCursos(ArrayList<Professor> profs) throws CloneNotSupportedException {
        ArrayList<Curso> clonados = new ArrayList<>();
        for (Curso curso : cursos) {
            Curso copia = (Curso) curso.clone(profs);
            clonados.add(copia);
        }

        return clonados;
    }

    @Override
    public int compareTo(Anticorpo o) {
        if (this.nivelAptidao < o.getNivelAptidao()) {
            return 1;
        }
        if (this.nivelAptidao > o.getNivelAptidao()) {
            return -1;
        }
        return 0;
    }
}
