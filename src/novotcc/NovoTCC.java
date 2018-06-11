/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package novotcc;

import java.util.ArrayList;

/**
 *
 * @author ivina
 */
public class NovoTCC {

    /**
     * @param args the command line arguments
     * @throws java.lang.CloneNotSupportedException
     */
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String preto = "\u001B[40m";
    public static final String vermelho = "\u001B[41m";
    public static final String verde = "\u001B[42m";
    public static final String amarelo = "\u001B[43m";
    public static final String azul = "\u001B[44m";
    public static final String roxo = "\u001B[45m";
    public static final String ciano = "\u001B[46m";
    public static final String branco = "\u001B[47m";

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Integer> media = new ArrayList<>();
        ArrayList<Integer> anticorposBons = new ArrayList<>();
        ArrayList<Anticorpo> melhores = new ArrayList<>();

        Banco banco = new Banco(4);
        Populacao pop = new Populacao(banco);
        int cont = 0;
        int g = 1;
        int ultimaGeracao = 0;
        int melhor = pop.getMelhor().getNivelAptidao();
        melhores.add(pop.getMelhor());
        anticorposBons.add(melhor);
        do {
            media.add(pop.getMedia());
            pop.todosIguais();
            pop.atribuirPais();
            pop.gerarCopias();
            pop.mutar();
//            if (cont % 1000 == 0 && g >= 0) {
//                pop.aumentaTaxaMutacao();
//                g--;
//            }
            if (cont % 50 == 0) {
                System.out.println("\n"+azul + "Iteração " + cont);
                pop.aumentaTaxaMutacao();
                pop.getMelhor().imprimir();
                pop.getMelhor().imprimirHorariosProfessores();
            } 
            pop.retiraRuins();
            cont++;
            melhor = pop.getMelhor().getNivelAptidao();
            melhores.add(pop.getMelhor());

            if (melhor > anticorposBons.get(anticorposBons.size() - 1)) {
                anticorposBons.add(melhor);
                ultimaGeracao = cont;
            }

//        } while (cont < 1000 );
//        } while (cont < 50000 && melhor < 800);
        } while (melhor < 1200);

        System.out.println("\n\n");
        System.out.println(ciano + "Medias das iteracoes");
        for (int i = 0; i < media.size(); i++) {
            System.out.println(media.get(i));
        }

        System.out.println("\n");
        System.out.println("Melhores individuos");
        for (int i = 0; i < melhores.size(); i++) {
            System.out.println(melhores.get(i).getNivelAptidao());
        }

        System.out.println("anticorpos bons individuos");
        for (int i = 0; i < anticorposBons.size(); i++) {
            System.out.println(anticorposBons.get(i));
        }

//        pop.imprimirSimples();
        System.out.println("\n\n");
        pop.getMelhor().imprimir();
        pop.getMelhor().imprimirHorariosProfessores();
        System.out.println("Melhor" + pop.getMelhor().getNivelAptidao());
        System.out.println("Ultima geração" + ultimaGeracao);
        System.out.println("Quantidade de Iteracoes:" + cont);
    }

}
