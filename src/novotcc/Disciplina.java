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

    public Disciplina(String nome, Integer aulas, Professor professor) {
        this.professor = professor;
        this.nome = nome;
        this.qtdAulas = aulas;
    }

    public Disciplina() {

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
        }else{
            copia.setIsVaga(true);
        }
        return copia;
    }


    void imprimir() {
        System.out.println(getNome() + " " + toString() + "  ");
        if (!isVaga) {
            getProfessor().imprimir();
        } else {
            System.out.println("nao tem professor");
        }
    }
    
    void imprimirNome() {
        System.out.print(getNome() + " -- ");
    }


}
