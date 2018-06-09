/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package novotcc;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ivina
 */
public class Populacao {

    private ArrayList<Anticorpo> horarios = new ArrayList<>();
    private int tamanho = 100;
    private int media;
    private Banco banco;

    public Populacao(Banco banco) throws CloneNotSupportedException {
        this.banco = banco;
        gerar();
        gerarMedia();
    }

    public void gerar() throws CloneNotSupportedException {
        ArrayList<Anticorpo> individuos = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            Anticorpo ind = new Anticorpo("Anticorpo", banco);
            individuos.add(ind);
        }
        this.horarios.addAll(individuos);
        ordenar();
    }

    public void gerarMedia() {
        int valor = 0;
        for (int i = 0; i < this.horarios.size(); i++) {
            valor += this.horarios.get(i).getNivelAptidao();
        }
        this.media = valor / this.horarios.size();
    }

    public void gerarCopias() throws CloneNotSupportedException {
        int copias = 0;
        int melhor = getMelhor().getNivelAptidao();
        for (int i = 0; i < this.horarios.size(); i++) {
            if (this.horarios.get(i).isPai()) {
                copias = this.horarios.get(i).gerarqtdCopias(melhor);
                while (copias > 0) {
                    Anticorpo copy = new Anticorpo(false);
                    copy = (Anticorpo) horarios.get(i).clone(banco);
                    horarios.add(copy);
                    copias--;
                }
            }
        }
        ordenar();
    }

    public int getMedia() {
        return media;
    }

    public Anticorpo getMelhor() {
        ordenar();
        return horarios.get(0);
    }

    public void atribuirPais() {
//        int cont = 0;
        for (int i = 0; i < this.horarios.size(); i++) {
            if (this.horarios.get(i).getNivelAptidao() >= media) {
                this.horarios.get(i).setPai(true);
            } else {
                this.horarios.get(i).setPai(false);
            }
        }
    }

    public void mutar() throws CloneNotSupportedException {
//        int taxa = 3;
        for (Anticorpo horario : horarios) {
            if (!horario.isPai()) {
//                while (taxa > 0) {
                    horario.mutar();
//                    taxa--;
//                }
            }
        }
    }

    public void escolherHorario() {

    }

    public void ordenar() {
        Collections.sort(horarios);
    }

    public void retiraRuins() {
        ordenar();
        ArrayList<Anticorpo> popMelhor = new ArrayList<>();
        for (int i = 0; i < this.tamanho; i++) {
            popMelhor.add(this.horarios.get(i));
        }
        this.horarios = popMelhor;
        gerarMedia();
    }

    public void imprimir() {
        System.out.println("Imprimindo a População");
        for (Anticorpo horario : horarios) {
            horario.imprimir();
            horario.imprimirHorariosProfessores();
        }
    }

    public void imprimirSimples() {
        System.out.println("Imprimindo a População");
        int cont = 1;
        for (Anticorpo horario : horarios) {
            System.out.println("horario " + cont + " " + horario.getNome() + " " + horario.getNivelAptidao() + " " + horario.isPai());
            cont++;
        }
        System.out.println("");
    }

    public ArrayList<Anticorpo> getHorarios() {
        return horarios;
    }

    public void todosIguais() throws CloneNotSupportedException {
        ordenar();
        if (horarios.get(0).getNivelAptidao() == horarios.get(horarios.size() - 1).getNivelAptidao()) {
//        imprimirSimples();
            int porcentagem = 10;
            int tamInicial = tamanho * porcentagem / 100;
            ArrayList<Anticorpo> novos = new ArrayList<>();
//            System.out.println("\n\n\n\n\novos");
            for (int i = tamInicial; i < tamanho; i++) {
                Anticorpo ind = new Anticorpo("Anticorpo", banco);
                novos.add(ind);
//                System.out.println("ind aptd"+ ind.getNivelAptidao());
            }
            ArrayList<Anticorpo> antigos = new ArrayList<>();
//            System.out.println("\n\n\n\n antigos");
            for (int i = 0; i < tamInicial; i++) {
                antigos.add(horarios.get(i));
//                System.out.println("ind aptd"+ horarios.get(i).getNivelAptidao());
            }
            antigos.addAll(novos);
//            System.out.println("\n\n\n\n atualizados");
            this.horarios = antigos;
//            imprimirSimples();
        }
    }

}
