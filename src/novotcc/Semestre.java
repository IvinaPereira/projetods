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

    private int pesoFuncao1 = 14;
    private int pesoFuncao2AB = 3;
    private int pesoFuncao2Disc = 6;
    private int pesoFuncao2Vaga = 6;

    private int diaBloqueado;
    private boolean bloquear;

    public Semestre() {
        adicionarDiscVagas();
    }

    public Semestre(String nome, int aulas) {
        this.nome = nome;
        this.qtdAulas = aulas;
        this.bloquear = false;
        adicionarDiscVagas();
    }

    public Semestre(String nome, int aulas, boolean bloqueado, int dia) {
        this.nome = nome;
        this.qtdAulas = aulas;
        this.bloquear = bloqueado;
        this.diaBloqueado = dia;
        adicionarDiscVagas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDiaBloqueado() {
        return diaBloqueado;
    }

    public void setDiaBloqueado(int dia) {
        this.diaBloqueado = dia;
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

    public boolean isBloquear() {
        return bloquear;
    }

    public void setBloquear(boolean b) {
        this.bloquear = b;
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
                disciplinas.get(i + 5).setMesmoDia(true);
                nivel++;
            }
        }
        nivel = nivel * pesoFuncao1;
        return nivel;
    }

//    public int funcao23() {
//        int nivel = 0;
//        if (this.qtdAulas >= 5) {
//            //for apenas nas aulas do horário AB
//            for (int i = 0; i < 5; i++) {
////          se a disciplina for vaga
//                if (disciplinas.get(i).isVaga()) {
//                    disciplinas.get(i).setVagaAB(true);
//                    nivel++;
//                }
//            }
//        }
//        nivel = nivel * pesoFuncao2AB;
//        return nivel;
//    }
    public int funcao2() {
        int nivel = 0;
        int nivel2 = 0;
        int nivel3 = 0;
        int diasDisponiveis = 5;

        if (qtdAulas <= 10) {

            if (bloquear) {
                diasDisponiveis = 4;
            }

            int permitidoVaga;
            int permitidoDisc;
            int vagaCompleta = 0;

            if (diasDisponiveis >= qtdAulas) {
                permitidoVaga = diasDisponiveis - qtdAulas;
                permitidoDisc = 0;
            } else {
                permitidoDisc = qtdAulas - diasDisponiveis;
                permitidoVaga = 0;
            }

            if (bloquear) {
                for (int j = 0; j < 10; j++) {
                    if (disciplinas.get(j).isVaga()) {
                        if (j == diaBloqueado || j == diaBloqueado + 5) {
                            vagaCompleta++;
//                    if (vagaCompleta < 2) {
//                        }

                        } else {
                            nivel2++;
                            if (j < 5) {
                                if (permitidoVaga == 0) {
                                    disciplinas.get(j).setVagaAB(true);
                                    nivel++;
                                } else {
                                    permitidoVaga--;
                                }
                            }
                        }
                    } else {
                        if (j == diaBloqueado || j == diaBloqueado + 5) {
                            nivel3++;
                        } else {
                            if (j >= 5) {
                                if (permitidoDisc == 0) {
                                    disciplinas.get(j).setDiscErrada(true);
                                    nivel++;
                                } else {
                                    permitidoDisc--;
                                }
                            }
                        }
                    }
                }
                if (vagaCompleta == 2) {
                    nivel2 = 0;
                }
                nivel = nivel * pesoFuncao2Disc;
            } else {
                for (int j = 0; j < 10; j++) {
                    if (disciplinas.get(j).isVaga()) {
                        if (j < 5) {
                            if (permitidoVaga == 0) {
                                disciplinas.get(j).setVagaAB(true);
                                nivel++;
                            } else {
                                permitidoVaga--;
                            }
                        }
                    } else {
                        if (j >= 5) {
                            if (permitidoDisc == 0) {
                                disciplinas.get(j).setDiscErrada(true);
                                nivel++;
                            } else {
                                permitidoDisc--;
                            }
                        }
                    }
                }
            }
        }
        nivel = nivel * pesoFuncao2AB;
        nivel2 = nivel2 * pesoFuncao2Vaga;
        nivel3 = nivel3 * pesoFuncao2Disc;
        return nivel + nivel2 + nivel3;

    }

    public int funcao25() {
        int nivel = 0;
        int nivel2 = 0;
        int nivel3 = 0;
        int nivel4 = 0;

        int vagasNosBloqueados = 0;
        //for apenas nas aulas do horário AB
        if (bloquear) {
            for (int i = 0; i < 10; i++) {
                if (disciplinas.get(i).isVaga()) {

                    if (i != diaBloqueado && i != diaBloqueado + 5) {
//                        disciplinas.get(i).setVErrada(true);
                        nivel2++;
                        if (i < 5) {
                            if (this.qtdAulas >= 5) {
                                disciplinas.get(i).setVagaAB(true);
                                nivel4++;
                            } else {
                                disciplinas.get(i).setVagaAB(true);
                                nivel++;
                            }
                        }
                    } else {
                        vagasNosBloqueados++;
                    }
                } else {
                    if (i == diaBloqueado || i == diaBloqueado + 5) {
                        nivel3++;
                    }
                }
            }
        } else {
            // se nao tiver no dia de bloqueio
            for (int i = 0; i < 10; i++) {
//          se a disciplina for vaga
                if (disciplinas.get(i).isVaga()) {
                    if (i < 5) {
                        if (this.qtdAulas >= 5) {
                            disciplinas.get(i).setVagaAB(true);
                            nivel4++;
                        } else {
                            disciplinas.get(i).setVagaAB(true);
                            nivel++;
                        }

                    }
                }
            }
        }

        if (nivel > 0) {
            int numPermitido = 5 - this.qtdAulas;
            if (nivel > numPermitido) {
                nivel = nivel * pesoFuncao2AB;
            } else {
                nivel = 0;
            }
        }
        if (vagasNosBloqueados == 2) {
            nivel2 = 0;
        }

        nivel2 = nivel2 * pesoFuncao2Vaga;
        nivel3 = nivel3 * pesoFuncao2Disc;
        nivel4 = nivel4 * pesoFuncao2AB;
        return nivel + nivel2 + nivel3 + nivel4;
    }

//    public int funcao3() {
//        int nivel = 0;
//
//        if (bloquear) {
//            for (int i = 0; i < 10; i++) {
//                if (disciplinas.get(i).isVaga()) {
//                    if (i != diaBloqueado && i != (diaBloqueado + 5)) {
//                        nivel++;
//                    }
//                } else {
//                    if (i != diaBloqueado && i != (diaBloqueado + 5)) {
//                        nivel++;
//                    }
//                }
//
//            }
//
//        }
////        nivel = nivel * pesoFuncao3;
//        return nivel;
//    }
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
        System.out.println(this.nome + " Semestre -  APT-" + this.nivelAptidao);
        for (Disciplina disciplina : this.disciplinas) {
            disciplina.imprimir();
        }
        System.out.println("");
    }

    public void imprimirDisciplinas() {
        System.out.println("" + this.nome + " Semestre - APT-" + this.nivelAptidao);
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
        copia.setBloquear(isBloquear());
        if (copia.isBloquear()) {
            copia.setDiaBloqueado(getDiaBloqueado());
        }
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
        genee.get(aula1).setDiscErrada(false);
        genee.get(aula1).setMesmoDia(false);
        genee.get(aula2).setVagaAB(false);
        genee.get(aula2).setDiscErrada(false);
        genee.get(aula2).setMesmoDia(false);

        gerarNivelAptidao();
    }
}
