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
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Integer> media = new ArrayList<>();
        ArrayList<Anticorpo> melhores = new ArrayList<>();

        Populacao pop = new Populacao();
        int cont = 0;
        do {
            media.add(pop.getMedia());
            melhores.add(pop.getMelhor());
            pop.atribuirPais();
            pop.gerarCopias();
            pop.imprimirSimples();
            pop.mutar();
            pop.retiraRuins();
            pop.imprimirSimples();
            cont++;
        } while (cont < 200);

        System.out.println("\n\n");
        System.out.println("Medias das iteracoes");
        for (int i = 0; i < media.size(); i++) {
            System.out.print(media.get(i) + " - ");
        }

        System.out.println("\n");
        System.out.println("Melhores individuos");
        for (int i = 0; i < melhores.size(); i++) {
            System.out.print(melhores.get(i).getNivelAptidao() + " - ");
        }

        pop.imprimirSimples();
        System.out.println("\n\n");
        pop.getMelhor().imprimir();
        System.out.println("Quantidade de Iteracoes:" + cont);
    }

}
