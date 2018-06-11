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
public class Disciplina implements Cloneable {

    private Professor professor;
    private String nome;
    private Integer qtdAulas;
    private boolean isVaga;
    private int id;

    private boolean mesmoDia;
    private boolean vagaAB;
    private boolean vagaErrada;
    private boolean profChoque;
    private boolean profPrefer;

    public Disciplina(String nome, Integer aulas, Professor professor) {
        this.professor = professor;
        this.nome = nome;
        this.qtdAulas = aulas;
    }

    public Disciplina() {
        this.mesmoDia = false;
        this.vagaAB = false;
    }

    public Disciplina(boolean vaga) {
        this.isVaga = vaga;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQtdAulas() {
        return qtdAulas;
    }

    public void setQtdAulas(Integer qtdAulas) {
        this.qtdAulas = qtdAulas;
    }

    public boolean isVaga() {
        return isVaga;
    }

    public void setIsVaga(boolean isVaga) {
        this.isVaga = isVaga;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Disciplina copia = new Disciplina();
        copia.setNome(getNome());
        copia.setQtdAulas(getQtdAulas());
        if (!isVaga()) {
            copia.setProfessor((Professor) getProfessor().clone());
            copia.setIsVaga(false);
        } else {
            copia.setIsVaga(true);
            copia.setNome("Vaga");
        }

        return copia;
    }

    void imprimir() {
        System.out.println(getNome() + " " + toString() + "  ");
        if (isVaga) {
            System.out.println("nao tem professor");
        } else {
            getProfessor().imprimir();
        }
    }

    public void setVagaAB(boolean vaga) {
        this.vagaAB = vaga;
    }

  
    public void setDiscErrada(boolean vaga) {
        this.vagaErrada = vaga;
    }

    public void setMesmoDia(boolean vaga) {
        this.mesmoDia = vaga;
    }

    void imprimirFormatado(int i) {
        if (i == 0) {
            System.out.print(NovoTCC.GREEN + NovoTCC.branco + " AB " + NovoTCC.RESET);
        } else if (i == 5){
            System.out.print(NovoTCC.GREEN + NovoTCC.branco + " CD " + NovoTCC.RESET);
        }
        if (isVaga) {
            if (vagaAB || vagaErrada) {
                System.out.print(NovoTCC.roxo + "" + getNome() + " - ");
            }else{
                System.out.print(NovoTCC.branco + "" + getNome() + " - ");
            }
        } else if (mesmoDia) {
            System.out.print(NovoTCC.amarelo + "" + getNome() + " -- ");
        } else if (professor.getUmHorario(i) > 1) {
            System.out.print(NovoTCC.vermelho + "" + getNome() + " -- ");
        } else if (professor.getUmaPrefe(i) == 0) {
            System.out.print(NovoTCC.ciano + "" + getNome() + " -- ");
        } else {
            System.out.print(NovoTCC.verde + "" + getNome() + " -- ");
        }

    }

}
