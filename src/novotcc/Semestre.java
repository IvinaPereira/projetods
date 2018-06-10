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
public class Semestre implements Cloneable {

    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private int id;
    private int nivelAptidao;
    private int qtdAulas;
    private String nome;

    private int pesoFuncao1 = 8;
    private int pesoFuncao2 = 3;

    public Semestre() {
        adicionarDiscVagas();
    }

    public Semestre(String nome, int aulas) {
        this.nome = nome;
        this.qtdAulas = aulas;
        adicionarDiscVagas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public int getNivelAptidao() {
        return nivelAptidao;
    }

    public int getQtdAulas() {
        return qtdAulas;
    }

    public void setQtdAulas(int qtdAulas) {
        this.qtdAulas = qtdAulas;
    }
    
//    public void setNivelAptidao(int nivelAptidao) {
//        this.nivelAptidao = nivelAptidao;
//    }

    public void gerarNivelAptidao() {
        int nivel = 0;
        nivel += funcao1();
        nivel += funcao2();
        this.nivelAptidao = nivel;
    }

    //verifica  se a mesma disciplina esta no mesmo dia
    public int funcao1() {
        int nivel = 0;
        for (int i = 0; i < 5; i++) {
            if (disciplinas.get(i).equals(disciplinas.get(i + 5))) {
                disciplinas.get(i).setMesmoDia(true);
                disciplinas.get(i+5).setMesmoDia(true);
                nivel++;
            }
        }
        nivel = nivel * pesoFuncao1;
        return nivel;
    }

    public int funcao2() {
        int nivel = 0;
        if (this.qtdAulas >= 5) {
            //for apenas nas aulas do horário AB
            for (int i = 0; i < 5; i++) {
//          se a disciplina for vaga
                if (disciplinas.get(i).isVaga()) {
                    disciplinas.get(i).setVagaAB(true);
                    nivel++;
                }
            }
        }
        nivel = nivel * pesoFuncao2;
        return nivel;
    }

    public void gerar(Semestre banco, ArrayList<Professor> profs) throws CloneNotSupportedException {
        Random rand = new Random();
        ArrayList<Disciplina> disciBanco = banco.getDisciplinas();

        for (Disciplina disciplina : disciBanco) {
            int cont = 0;
            Disciplina copia = (Disciplina) disciplina.clone();
            copia.setProfessor(profs.get(disciplina.getProfessor().getId()));
            while (copia.getQtdAulas() > cont) {
                int num = rand.nextInt(10);
                if (this.disciplinas.get(num).isVaga()) {
                    this.disciplinas.remove(num);
                    copia.getProfessor().setUmHorario(num);
                    cont++;
                    this.disciplinas.add(num, copia);
                }
            }
        }
        gerarNivelAptidao();
    }

    public void imprimir() {
        System.out.println(this.nome + " Semestre -  APT-"+this.nivelAptidao);
        for (Disciplina disciplina : this.disciplinas) {
            disciplina.imprimir();
        }
        System.out.println("");
    }

    public void imprimirDisciplinas() {
        System.out.println(""+this.nome + " Semestre - APT-"+this.nivelAptidao);
        int i = 0;
        for (Disciplina disciplina : this.disciplinas) {
            disciplina.imprimirFormatado(i);
            if (i == 4) {
                System.out.println("");
            }
            i++;
        }
        System.out.println("");
    }

    private void adicionarDiscVagas() {
        for (int i = 0; i < 10; i++) {
            Disciplina disc = new Disciplina(true);
            this.disciplinas.add(disc);
        }
    }

    protected Object clone(ArrayList<Professor> profs) throws CloneNotSupportedException {
        Semestre copia = new Semestre();
        copia.setNome(getNome());
        copia.setDisciplinas(clonarDisciplinas(profs));
        copia.setQtdAulas(getQtdAulas());
        copia.gerarNivelAptidao();
        return copia;
    }

    public ArrayList<Disciplina> clonarDisciplinas(ArrayList<Professor> profs) throws CloneNotSupportedException {
        ArrayList<Disciplina> clonadas = new ArrayList<>();
        Disciplina copia = null;
        boolean aux = false;
        int i;
        for (Disciplina disciplina : disciplinas) {
            if (!disciplina.isVaga()) {
                i = 0;
                if (disciplina.getQtdAulas() == 2) {
                    while (i < clonadas.size() && aux == false) {
                        if (!clonadas.get(i).isVaga()) {
                            if (clonadas.get(i).getNome().equals(disciplina.getNome())) {
                                copia = clonadas.get(i);
                                aux = true;
                            }
                        }
                        i++;
                    }
                }
                if (!aux) {
                    copia = (Disciplina) disciplina.clone();
                }
                copia.setProfessor(profs.get(disciplina.getProfessor().getId()));
                copia.getProfessor().setUmHorario(clonadas.size());
                aux = false;

            } else {
                copia = (Disciplina) disciplina.clone();
            }
            clonadas.add(copia);
        }

        return clonadas;
    }

    public void mutar() {
        Random rand = new Random();
        ArrayList<Disciplina> genee = getDisciplinas();

        int aula1, aula2;
        aula1 = rand.nextInt(10);
        do {
            aula2 = rand.nextInt(10);
        } while (aula1 == aula2);

        Disciplina d1 = genee.get(aula1);
        Disciplina d2 = genee.get(aula2);
        genee.remove(aula1);
        genee.add(aula1, d2);
        genee.remove(aula2);
        if (aula2 == 9) {
            genee.add(d1);
        } else {
            genee.add(aula2, d1);
        }

        if (!genee.get(aula1).isVaga()) {
            genee.get(aula1).getProfessor().setUmHorario(aula1);
            genee.get(aula1).getProfessor().retiraUmHorario(aula2);
        }

        if (!genee.get(aula2).isVaga()) {
            genee.get(aula2).getProfessor().setUmHorario(aula2);
            genee.get(aula2).getProfessor().retiraUmHorario(aula1);
        }
        
        
        
        genee.get(aula1).setVagaAB(false);
        genee.get(aula1).setMesmoDia(false);
        genee.get(aula2).setVagaAB(false);
        genee.get(aula2).setMesmoDia(false);
        
        gerarNivelAptidao();
    }
}
