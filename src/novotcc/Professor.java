package novotcc;

public class Professor implements Cloneable{
    
    private String nome;
    private int id;
    private int[] horario;
    private int[] disponibilidade;

    public Professor() {
        setHorario(addHorarioVazio());
    }
    
    public Professor(String Nome, int[] disponibilidade, int id) {
        this.nome = Nome;
        this.id = id;
        this.disponibilidade = disponibilidade;
        setHorario(addHorarioVazio());
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
    
    public int[] getHorario() {
        return horario;
    }

    public void setHorario(int[] horario) {
        this.horario = horario;
    }

    public void setUmHorario(int dia) {
        this.horario[dia] = this.horario[dia] + 1;
    }
    
    public void retiraUmHorario(int dia) {
        this.horario[dia] = this.horario[dia] - 1;
    }

    public int[] getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(int[] disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setUmaDisponibilidade(int dia) {
        this.disponibilidade[dia] += 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Professor copia = new Professor();
        copia.setNome(getNome());
        copia.setId(getId());
        copia.setDisponibilidade(clonarDisponibilidade());
        return copia;
    }
    
    private int[] clonarDisponibilidade(){
        int[] copia = new int[10];
        for (int i = 0; i < 10; i++) {
            int num = disponibilidade[i];
            copia[i] = num;
        }
        return copia;
    }
    
    private int[] addHorarioVazio(){
        int[] horario = new int[]{0,0,0,0,0,0,0,0,0,0};
        return horario; 
    }
            
    public void imprimir() {
        System.out.println(getNome() + " "+ toString());
    }
  
    public void imprimirHorario() {
        System.out.println("\n"+getNome() + " "+ toString());
        for (int i = 0; i < 10; i++) {
            System.out.print(this.horario[i] + " ");
            if(i == 4){
                System.out.println("");
            }
        }
    }
    
    
}