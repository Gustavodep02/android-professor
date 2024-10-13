package br.edu.fateczl.professor.model;
/*
 *@author:<Gustavo de Paula>
 */
public class ProfessorTitular extends Professor {

    private int anosInstituicao;
    private double salario;

    public ProfessorTitular() {
        super();
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcSalario() {
        double salario = getSalario();
        int anos = getAnosInstituicao();

        while(anos >=5 ){
            salario = salario +(salario *0.05);
            anos = anos - 5;
        }
        return salario;
    }
}
