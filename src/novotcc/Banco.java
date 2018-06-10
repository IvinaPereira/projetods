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
public class Banco {

    private ArrayList<Curso> cursos = new ArrayList<>();
    public ArrayList<Professor> professores = new ArrayList<>();

    public Banco(int op) {

        switch (op) {
            case 0: {
                gerarProfessores();
                gerarCursos();
            }
            break;
            case 1: {
                gerarProfsCaso1();
                gerarCaso1();
            }
            break;
            case 2: {
                gerarProfsCaso2();
                gerarCaso2();
            }
            break;
            case 3: {
                gerarProfsCaso3();
                gerarCaso2();
            }
            break;

        }
//        imprimirCursos();
//        cursoSistemas.imprimirCurso();
    }

    public ArrayList<Curso> getCursos() {
        return this.cursos;
    }

    public ArrayList<Professor> getProf() {
        return this.professores;
    }

    private void gerarCursos() {

        cursos.add(gerarSistemas());
        cursos.add(gerarArquitetura());
//        cursos.add(gerarADM());
//        gerarADS();
//        gerarEngCivil();
//        gerarEngProd();
//        gerarPsicologia();
//        gerarDireito();
//        gerarMarketing();
    }

    private Curso gerarSistemas() {
        Curso curso = new Curso("Sistemas de Informação");
        ArrayList<Semestre> sems = new ArrayList<>();
        //criando o primeiro semestre de sistemas
        ArrayList<Disciplina> disc = new ArrayList<>();
        Semestre semestre = new Semestre("Primeiro", 10);
        Disciplina d = new Disciplina("Programação", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("Filosofia", 1, professores.get(1));
        disc.add(d);
        d = new Disciplina("Discreta", 2, professores.get(3));
        disc.add(d);
        d = new Disciplina("Fundamentos", 2, professores.get(0));
        disc.add(d);
        d = new Disciplina("Calculo", 2, professores.get(6));
        disc.add(d);
        d = new Disciplina("Inglês", 1, professores.get(13));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

//        criando segundo semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Segundo", 10);
        d = new Disciplina("FCC", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("Logica", 2, professores.get(3));
        disc.add(d);
        d = new Disciplina("ADM", 1, professores.get(7));
        disc.add(d);
        d = new Disciplina("ProgII", 2, professores.get(9));
        disc.add(d);
        d = new Disciplina("AEDI", 2, professores.get(5));
        disc.add(d);
        d = new Disciplina("Português", 1, professores.get(0));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);
        //criando terceiro semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Terceiro", 10);
        d = new Disciplina("TGS", 1, professores.get(7));
        disc.add(d);
        d = new Disciplina("AEDII", 2, professores.get(5));
        disc.add(d);
        d = new Disciplina("SistemasO", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("Metodologia", 1, professores.get(0));
        disc.add(d);
        d = new Disciplina("Banco I", 2, professores.get(10));
        disc.add(d);
        d = new Disciplina("POO I", 2, professores.get(12));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

//        //criando quarto semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Quarto", 10);
        d = new Disciplina("APISI", 2, professores.get(4));
        disc.add(d);
        d = new Disciplina("Arquitetura", 2, professores.get(9));
        disc.add(d);
        d = new Disciplina("EngenhariaI", 1, professores.get(4));
        disc.add(d);
        d = new Disciplina("RedesI", 2, professores.get(8));
        disc.add(d);
        d = new Disciplina("POOII", 2, professores.get(12));
        disc.add(d);
        d = new Disciplina("Linguagens", 1, professores.get(11));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);
//
//        //criando quinto semestre de sistemas
//        disc = new ArrayList<>();
//        semestre = new Semestre(0, "Quinto", 5);
//        d = new Disciplina("Multimidia", 1, professores.get(9));
//        disc.add(d);
//        d = new Disciplina("POD", 1, professores.get(5));
//        disc.add(d);
//        d = new Disciplina("ProjetoBD", 2, professores.get(10));
//        disc.add(d);
//        d = new Disciplina("RedesII", 2, professores.get(8));
//        disc.add(d);
//        d = new Disciplina("EngenhariaII", 2, professores.get(4));
//        disc.add(d);
//        d = new Disciplina("Estatistica", 2, professores.get(3));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando sexto semestre de sistemas
//        disc = new ArrayList<>();
//        semestre = new Semestre(0, "Sexto", 6);
//        d = new Disciplina("Cooperativos", 2, professores.get(13));
//        disc.add(d);
//        d = new Disciplina("BDOO", 2, professores.get(10));
//        disc.add(d);
//        d = new Disciplina("APISII", 2, professores.get(8));
//        disc.add(d);
//        d = new Disciplina("Segurança", 1, professores.get(6));
//        disc.add(d);
//        d = new Disciplina("Interface", 1, professores.get(9));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando sétimo semestre de sistemas
//        disc = new ArrayList<>();
//        semestre = new Semestre(0, "Sétimo", 7);
//        d = new Disciplina("Economia", 1, professores.get(7));
//        disc.add(d);
//        d = new Disciplina("ComputacaoG", 2, professores.get(13));
//        disc.add(d);
//        d = new Disciplina("InteligenciaA", 2, professores.get(2));
//        disc.add(d);
//        d = new Disciplina("GestãoE", 1, professores.get(7));
//        disc.add(d);
//        d = new Disciplina("Gerenciamento", 1, professores.get(9));
//        disc.add(d);
//        d = new Disciplina("Legislacao", 1, professores.get(1));
//        disc.add(d);
//        d = new Disciplina("TCCI", 1, professores.get(0));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando oitavo semestre de sistemas
//        disc = new ArrayList<>();
//        semestre = new Semestre(0, "Oitavo", 8);
//        d = new Disciplina("Gestão", 2, professores.get(6));
//        disc.add(d);
//        d = new Disciplina("Tópicos", 2, professores.get(2));
//        disc.add(d);
//        d = new Disciplina("Contabilidade", 1, professores.get(6));
//        disc.add(d);
//        d = new Disciplina("Sociologia", 1, professores.get(1));
//        disc.add(d);
//        d = new Disciplina("TCCII", 1, professores.get(0));
//        disc.add(d);
//        d = new Disciplina("Comércio", 1, professores.get(7));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
        curso.setSemestres(sems);
        return curso;
    }

    private Curso gerarArquitetura() {
        Curso curso = new Curso("Arquitetura");

        ArrayList<Semestre> sems = new ArrayList<>();

        //criando o primeiro semestre de arquitetura
        ArrayList<Disciplina> disc = new ArrayList<>();
        Semestre semestre = new Semestre("Primeiro", 9);
        Disciplina d = new Disciplina("Desenho de Observação", 1, professores.get(14));
        disc.add(d);
        d = new Disciplina("Geometria", 2, professores.get(1));
        disc.add(d);
        d = new Disciplina("PlásticaI", 2, professores.get(3));
        disc.add(d);
        d = new Disciplina("História da Arte", 1, professores.get(0));
        disc.add(d);
        d = new Disciplina("Introdução a Arq", 1, professores.get(11));
        disc.add(d);
        d = new Disciplina("Sistemas EstruturaisI", 1, professores.get(1));
        disc.add(d);
        d = new Disciplina("Representação Gráfica", 1, professores.get(1));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

//        //criando segundo semestre de arquitetura
//        disc = new ArrayList<>();
//        semestre = new Semestre(1, "Segundo", 2);
//        d = new Disciplina("HistóriaI", 2, professores.get(14));
//        disc.add(d);
//        d = new Disciplina("ConfortoI", 1, professores.get(3));
//        disc.add(d);
//        d = new Disciplina("Resistência", 1, professores.get(15));
//        disc.add(d);
//        d = new Disciplina("Ergonomia", 1, professores.get(9));
//        disc.add(d);
//        d = new Disciplina("PlásticaII", 1, professores.get(5));
//        disc.add(d);
//        d = new Disciplina("DArquitetonicoI", 2, professores.get(0));
//        disc.add(d);
//        d = new Disciplina("Legislação", 1, professores.get(16));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando terceiro semestre de arquitetura
//        disc = new ArrayList<>();
//        semestre = new Semestre(1, "Terceiro", 3);
//        d = new Disciplina("ProjetoI", 2, professores.get(15));
//        disc.add(d);
//        d = new Disciplina("Materiais", 1, professores.get(5));
//        disc.add(d);
//        d = new Disciplina("HistóriaII", 2, professores.get(14));
//        disc.add(d);
//        d = new Disciplina("DArquitetonicoII", 2, professores.get(16));
//        disc.add(d);
//        d = new Disciplina("Sistemas EstruturaisII", 1, professores.get(10));
//        disc.add(d);
//        d = new Disciplina("ConfortoII", 2, professores.get(16));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando quarto semestre de arquitetura
//        disc = new ArrayList<>();
//        semestre = new Semestre(1, "Quarto", 4);
//        d = new Disciplina("ProjetoII", 2, professores.get(4));
//        disc.add(d);
//        d = new Disciplina("MateriaisII", 2, professores.get(16));
//        disc.add(d);
//        d = new Disciplina("DesenhoUI", 2, professores.get(4));
//        disc.add(d);
//        d = new Disciplina("Metodologia", 1, professores.get(8));
//        disc.add(d);
//        d = new Disciplina("PlanejamentoUI", 1, professores.get(10));
//        disc.add(d);
//        d = new Disciplina("ConfortoIII", 1, professores.get(10));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando quinto semestre de arquitetura
//        disc = new ArrayList<>();
//        semestre = new Semestre(1, "Quinto", 5);
//        d = new Disciplina("ProjetoIII", 2, professores.get(9));
//        disc.add(d);
//        d = new Disciplina("DesenhoUII", 2, professores.get(13));
//        disc.add(d);
//        d = new Disciplina("Eficiência", 1, professores.get(10));
//        disc.add(d);
//        d = new Disciplina("PlanejamentoUII", 2, professores.get(12));
//        disc.add(d);
//        d = new Disciplina("Elétrica", 1, professores.get(4));
//        disc.add(d);
//        d = new Disciplina("Concreto", 1, professores.get(3));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando sexto semestre de arquitetura
//        disc = new ArrayList<>();
//        semestre = new Semestre(1, "Sexto", 6);
//        d = new Disciplina("ProjetoIV", 2, professores.get(5));
//        disc.add(d);
//        d = new Disciplina("HistoriaBrasilI", 1, professores.get(13));
//        disc.add(d);
//        d = new Disciplina("DesenhoUIII", 2, professores.get(8));
//        disc.add(d);
//        d = new Disciplina("PPaisagísticoI", 2, professores.get(11));
//        disc.add(d);
//        d = new Disciplina("Hidráulica", 1, professores.get(16));
//        disc.add(d);
//        d = new Disciplina("Aço Madeira", 1, professores.get(16));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando sétimo semestre de arquitetura
//        disc = new ArrayList<>();
//        semestre = new Semestre(1, "Sétimo", 7);
//        d = new Disciplina("ProjetoV", 2, professores.get(15));
//        disc.add(d);
//        d = new Disciplina("HistoriaBrasilII", 2, professores.get(13));
//        disc.add(d);
//        d = new Disciplina("DesenhoUIV", 2, professores.get(14));
//        disc.add(d);
//        d = new Disciplina("Interiores", 2, professores.get(15));
//        disc.add(d);
//        d = new Disciplina("Ética", 1, professores.get(9));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando oitavo semestre de arquitetura
//        disc = new ArrayList<>();
//        semestre = new Semestre(1, "Oitavo", 8);
//        d = new Disciplina("Socioantropológico", 1, professores.get(11));
//        disc.add(d);
//        d = new Disciplina("Teorias e Técnicas", 2, professores.get(14));
//        disc.add(d);
//        d = new Disciplina("PPaisagísticoII", 2, professores.get(11));
//        disc.add(d);
//        d = new Disciplina("InterioresII", 2, professores.get(1));
//        disc.add(d);
//        d = new Disciplina("Topografia", 1, professores.get(16));
//        disc.add(d);
//        d = new Disciplina("Deontologia", 1, professores.get(15));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando nono semestre de arquitetura
//        disc = new ArrayList<>();
//        semestre = new Semestre(1, "Nono", 9);
//        d = new Disciplina("Conservação", 2, professores.get(11));
//        disc.add(d);
//        d = new Disciplina("TCCI", 2, professores.get(15));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
//        //criando décimo semestre de arquitetura
//        disc = new ArrayList<>();
//        semestre = new Semestre(1, "Décimo", 10);
//        d = new Disciplina("TCCII", 2, professores.get(6));
//        disc.add(d);
//        semestre.setDisciplinas(disc);
//        sems.add(semestre);
//
        curso.setSemestres(sems);
        return curso;
    }

    private void gerarProfessores() {
        ArrayList<Professor> profs = new ArrayList<>();
        //disponibilidade dos professores, 1 - Sim // 0 - Não
        //6
        int[] disponibilidade = {1, 0, 1, 1, 0, 1, 1, 0, 0, 1};
        Professor prof = new Professor("César", disponibilidade, 0);
        profs.add(prof);

        //4
        disponibilidade = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        prof = new Professor("Régio", disponibilidade, 1);
        profs.add(prof);

        //10
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Michelan", disponibilidade, 2);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 0, 0, 1, 0, 1};
        prof = new Professor("Eduardo", disponibilidade, 3);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Paula", disponibilidade, 4);
        profs.add(prof);

        //9
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Édimo", disponibilidade, 5);
        profs.add(prof);

        //6
        disponibilidade = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 0, 1};
        prof = new Professor("Raniere", disponibilidade, 6);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 1, 1, 1, 1, 0, 1, 1, 0, 0};
        prof = new Professor("Piedley", disponibilidade, 7);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 0, 1, 1, 1, 1};
        prof = new Professor("Rafael", disponibilidade, 8);
        profs.add(prof);

        //9
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Fabricio", disponibilidade, 9);
        profs.add(prof);

        //9
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Tadeu", disponibilidade, 10);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1};
        prof = new Professor("Maria", disponibilidade, 11);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        prof = new Professor("Augusto", disponibilidade, 12);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        prof = new Professor("Igor", disponibilidade, 13);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 0, 1, 1, 1};
        prof = new Professor("Sandra", disponibilidade, 14);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        prof = new Professor("Renata", disponibilidade, 15);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 0, 1, 1, 1};
        prof = new Professor("Paulo", disponibilidade, 16);
        profs.add(prof);

        this.professores = profs;
    }

//    public void imprimirCursos() {
//        cursos.forEach((curso) -> {
//            curso.imprimirCurso();
//        });
//    }
    public void imprimirProfessores() {
        System.out.println("Professores do banco");
        for (Professor professor : professores) {
            professor.imprimir();
        }
        System.out.println("\n");
    }

    private void gerarCaso1() {
        Curso curso = new Curso("Curso 1");
        ArrayList<Semestre> sems = new ArrayList<>();
        //criando o primeiro semestre de sistemas
        ArrayList<Disciplina> disc = new ArrayList<>();
        Semestre semestre = new Semestre("Primeiro", 10);
        Disciplina d = new Disciplina("D01", 1, professores.get(0));
        disc.add(d);
        d = new Disciplina("D02", 1, professores.get(1));
        disc.add(d);
        d = new Disciplina("D03", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("D04", 2, professores.get(6));
        disc.add(d);
        d = new Disciplina("D05", 2, professores.get(7));
        disc.add(d);
        d = new Disciplina("D06", 2, professores.get(4));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

//        criando segundo semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Segundo", 10);
        d = new Disciplina("D07", 1, professores.get(4));
        disc.add(d);
        d = new Disciplina("D08", 1, professores.get(1));
        disc.add(d);
        d = new Disciplina("D09", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("D10", 2, professores.get(3));
        disc.add(d);
        d = new Disciplina("D11", 2, professores.get(5));
        disc.add(d);
        d = new Disciplina("D12", 2, professores.get(6));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);
        //criando terceiro semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Terceiro", 10);
        d = new Disciplina("D13", 1, professores.get(6));
        disc.add(d);
        d = new Disciplina("D14", 1, professores.get(3));
        disc.add(d);
        d = new Disciplina("D15", 2, professores.get(0));
        disc.add(d);
        d = new Disciplina("D16", 2, professores.get(1));
        disc.add(d);
        d = new Disciplina("D17", 2, professores.get(7));
        disc.add(d);
        d = new Disciplina("D18", 2, professores.get(4));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

//        //criando quarto semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Quarto", 10);
        d = new Disciplina("D19", 1, professores.get(2));
        disc.add(d);
        d = new Disciplina("D20", 1, professores.get(3));
        disc.add(d);
        d = new Disciplina("D21", 2, professores.get(0));
        disc.add(d);
        d = new Disciplina("D22", 2, professores.get(1));
        disc.add(d);
        d = new Disciplina("D23", 2, professores.get(5));
        disc.add(d);
        d = new Disciplina("D24", 2, professores.get(6));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

        //criando quinto semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Quinto", 10);
        d = new Disciplina("D25", 1, professores.get(4));
        disc.add(d);
        d = new Disciplina("D26", 1, professores.get(5));
        disc.add(d);
        d = new Disciplina("D27", 2, professores.get(0));
        disc.add(d);
        d = new Disciplina("D28", 2, professores.get(7));
        disc.add(d);
        d = new Disciplina("D29", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("D30", 2, professores.get(3));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

        //criando sexto semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Sexto", 10);
        d = new Disciplina("D31", 1, professores.get(0));
        disc.add(d);
        d = new Disciplina("D32", 1, professores.get(7));
        disc.add(d);
        d = new Disciplina("D33", 2, professores.get(1));
        disc.add(d);
        d = new Disciplina("D34", 2, professores.get(6));
        disc.add(d);
        d = new Disciplina("D35", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("D36", 2, professores.get(5));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

        //criando sétimo semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Sétimo", 10);
        d = new Disciplina("D37", 1, professores.get(6));
        disc.add(d);
        d = new Disciplina("D38", 1, professores.get(5));
        disc.add(d);
        d = new Disciplina("D39", 2, professores.get(3));
        disc.add(d);
        d = new Disciplina("D40", 2, professores.get(1));
        disc.add(d);
        d = new Disciplina("D41", 2, professores.get(4));
        disc.add(d);
        d = new Disciplina("D42", 2, professores.get(7));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

        //criando oitavo semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Oitavo", 10);
        d = new Disciplina("D43", 1, professores.get(2));
        disc.add(d);
        d = new Disciplina("D44", 1, professores.get(7));
        disc.add(d);
        d = new Disciplina("D45", 2, professores.get(0));
        disc.add(d);
        d = new Disciplina("D46", 2, professores.get(3));
        disc.add(d);
        d = new Disciplina("D47", 2, professores.get(4));
        disc.add(d);
        d = new Disciplina("D48", 2, professores.get(5));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);
        curso.setSemestres(sems);
        
        this.cursos.add(curso);
    }

    private void gerarProfsCaso1() {
        ArrayList<Professor> profs = new ArrayList<>();
        //disponibilidade dos professores, 1 - Sim // 0 - Não
        //6
        int[] disponibilidade = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Professor prof = new Professor("Professor 0", disponibilidade, 0);
        profs.add(prof);

        //4
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 1", disponibilidade, 1);
        profs.add(prof);

        //10
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 2", disponibilidade, 2);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 3", disponibilidade, 3);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 4", disponibilidade, 4);
        profs.add(prof);

        //9
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 5", disponibilidade, 5);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 6", disponibilidade, 6);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 7", disponibilidade, 7);
        profs.add(prof);

        this.professores = profs;
    }
    
    private void gerarCaso2() {
        Curso curso = new Curso("Curso 1");
        ArrayList<Semestre> sems = new ArrayList<>();
        //criando o primeiro semestre de sistemas
        ArrayList<Disciplina> disc = new ArrayList<>();
        Semestre semestre = new Semestre("Primeiro", 10);
        Disciplina d = new Disciplina("D01", 1, professores.get(10));
        disc.add(d);
        d = new Disciplina("D02", 1, professores.get(8));
        disc.add(d);
        d = new Disciplina("D03", 2, professores.get(9));
        disc.add(d);
        d = new Disciplina("D04", 2, professores.get(6));
        disc.add(d);
        d = new Disciplina("D05", 2, professores.get(7));
        disc.add(d);
        d = new Disciplina("D06", 2, professores.get(4));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

//        criando segundo semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Segundo", 10);
        d = new Disciplina("D07", 1, professores.get(4));
        disc.add(d);
        d = new Disciplina("D08", 1, professores.get(1));
        disc.add(d);
        d = new Disciplina("D09", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("D10", 2, professores.get(9));
        disc.add(d);
        d = new Disciplina("D11", 2, professores.get(5));
        disc.add(d);
        d = new Disciplina("D12", 2, professores.get(10));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);
        //criando terceiro semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Terceiro", 10);
        d = new Disciplina("D13", 1, professores.get(6));
        disc.add(d);
        d = new Disciplina("D14", 1, professores.get(9));
        disc.add(d);
        d = new Disciplina("D15", 2, professores.get(8));
        disc.add(d);
        d = new Disciplina("D16", 2, professores.get(1));
        disc.add(d);
        d = new Disciplina("D17", 2, professores.get(7));
        disc.add(d);
        d = new Disciplina("D18", 2, professores.get(4));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

//        //criando quarto semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Quarto", 10);
        d = new Disciplina("D19", 1, professores.get(2));
        disc.add(d);
        d = new Disciplina("D20", 1, professores.get(3));
        disc.add(d);
        d = new Disciplina("D21", 2, professores.get(0));
        disc.add(d);
        d = new Disciplina("D22", 2, professores.get(1));
        disc.add(d);
        d = new Disciplina("D23", 2, professores.get(9));
        disc.add(d);
        d = new Disciplina("D24", 2, professores.get(6));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

        //criando quinto semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Quinto", 10);
        d = new Disciplina("D25", 1, professores.get(8));
        disc.add(d);
        d = new Disciplina("D26", 1, professores.get(5));
        disc.add(d);
        d = new Disciplina("D27", 2, professores.get(0));
        disc.add(d);
        d = new Disciplina("D28", 2, professores.get(7));
        disc.add(d);
        d = new Disciplina("D29", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("D30", 2, professores.get(3));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

        //criando sexto semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Sexto", 10);
        d = new Disciplina("D31", 1, professores.get(0));
        disc.add(d);
        d = new Disciplina("D32", 1, professores.get(8));
        disc.add(d);
        d = new Disciplina("D33", 2, professores.get(1));
        disc.add(d);
        d = new Disciplina("D34", 2, professores.get(6));
        disc.add(d);
        d = new Disciplina("D35", 2, professores.get(2));
        disc.add(d);
        d = new Disciplina("D36", 2, professores.get(5));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

        //criando sétimo semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Sétimo", 10);
        d = new Disciplina("D37", 1, professores.get(6));
        disc.add(d);
        d = new Disciplina("D38", 1, professores.get(5));
        disc.add(d);
        d = new Disciplina("D39", 2, professores.get(3));
        disc.add(d);
        d = new Disciplina("D40", 2, professores.get(1));
        disc.add(d);
        d = new Disciplina("D41", 2, professores.get(4));
        disc.add(d);
        d = new Disciplina("D42", 2, professores.get(7));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);

        //criando oitavo semestre de sistemas
        disc = new ArrayList<>();
        semestre = new Semestre("Oitavo", 10);
        d = new Disciplina("D43", 1, professores.get(2));
        disc.add(d);
        d = new Disciplina("D44", 1, professores.get(7));
        disc.add(d);
        d = new Disciplina("D45", 2, professores.get(0));
        disc.add(d);
        d = new Disciplina("D46", 2, professores.get(3));
        disc.add(d);
        d = new Disciplina("D47", 2, professores.get(4));
        disc.add(d);
        d = new Disciplina("D48", 2, professores.get(5));
        disc.add(d);
        semestre.setDisciplinas(disc);
        sems.add(semestre);
        curso.setSemestres(sems);
        
        this.cursos.add(curso);
    }

    private void gerarProfsCaso2() {
        ArrayList<Professor> profs = new ArrayList<>();
        //disponibilidade dos professores, 1 - Sim // 0 - Não
        //6
        int[] disponibilidade = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Professor prof = new Professor("Professor 0", disponibilidade, 0);
        profs.add(prof);

        //4
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 1", disponibilidade, 1);
        profs.add(prof);

        //10
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 2", disponibilidade, 2);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 3", disponibilidade, 3);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 4", disponibilidade, 4);
        profs.add(prof);

        //9
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 5", disponibilidade, 5);
        profs.add(prof);

        //6
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 6", disponibilidade, 6);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 7", disponibilidade, 7);
        profs.add(prof);

        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 8", disponibilidade, 8);
        profs.add(prof);

        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 9", disponibilidade, 9);
        profs.add(prof);

        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 10", disponibilidade, 10);
        profs.add(prof);

        this.professores = profs;        
    }
    
        private void gerarProfsCaso3() {
        ArrayList<Professor> profs = new ArrayList<>();
        //disponibilidade dos professores, 1 - Sim // 0 - Não
        //6
        int[] disponibilidade = {1, 0, 1, 0, 1, 1, 0, 1, 1, 1};
        Professor prof = new Professor("Professor 0", disponibilidade, 0);
        profs.add(prof);

        //4
        disponibilidade = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 1};
        prof = new Professor("Professor 1", disponibilidade, 1);
        profs.add(prof);

        //10
        disponibilidade = new int[]{1, 1, 1, 0, 1, 1, 1, 1, 1, 0};
        prof = new Professor("Professor 2", disponibilidade, 2);
        profs.add(prof);

        //6
        disponibilidade = new int[]{0, 1, 1, 0, 1, 1, 1, 1, 1, 0};
        prof = new Professor("Professor 3", disponibilidade, 3);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 1, 1, 0, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 4", disponibilidade, 4);
        profs.add(prof);

        //9
        disponibilidade = new int[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        prof = new Professor("Professor 5", disponibilidade, 5);
        profs.add(prof);

        //6
        disponibilidade = new int[]{0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 6", disponibilidade, 6);
        profs.add(prof);

        //5
        disponibilidade = new int[]{1, 1, 1, 0, 1, 1, 1, 1, 1, 1};
        prof = new Professor("Professor 7", disponibilidade, 7);
        profs.add(prof);

        disponibilidade = new int[]{1, 0, 1, 1, 0, 0, 1, 1, 0, 0};
        prof = new Professor("Professor 8", disponibilidade, 8);
        profs.add(prof);

        disponibilidade = new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        prof = new Professor("Professor 9", disponibilidade, 9);
        profs.add(prof);

        disponibilidade = new int[]{1, 0, 0, 0, 1, 0, 0, 1, 1, 1};
        prof = new Professor("Professor 10", disponibilidade, 10);
        profs.add(prof);

        this.professores = profs;
    }
}
