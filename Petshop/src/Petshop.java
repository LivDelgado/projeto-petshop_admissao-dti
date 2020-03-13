public class Petshop {
    private String nome;
    private double precoDiaUtilP;
    private double precoDiaUtilG;
    private double precoFimSemanaP;
    private double precoFimSemanaG;
    private double distancia;

    public Petshop(String nome, double precoDiaUtilP, double precoDiaUtilG, double precoFimSemanaP, double precoFimSemanaG, double distancia) {
        this.nome = nome;
        this.precoDiaUtilP = precoDiaUtilP;
        this.precoDiaUtilG = precoDiaUtilG;
        this.precoFimSemanaP = precoFimSemanaP;
        this.precoFimSemanaG = precoFimSemanaG;
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoDiaUtilP() {
        return precoDiaUtilP;
    }

    public void setPrecoDiaUtilP(double precoDiaUtilP) {
        this.precoDiaUtilP = precoDiaUtilP;
    }

    public double getPrecoDiaUtilG() {
        return precoDiaUtilG;
    }

    public void setPrecoDiaUtilG(double precoDiaUtilG) {
        this.precoDiaUtilG = precoDiaUtilG;
    }

    public double getPrecoFimSemanaP() {
        return precoFimSemanaP;
    }

    public void setPrecoFimSemanaP(double precoFimSemanaP) {
        this.precoFimSemanaP = precoFimSemanaP;
    }

    public double getPrecoFimSemanaG() {
        return precoFimSemanaG;
    }

    public void setPrecoFimSemanaG(double precoFimSemanaG) {
        this.precoFimSemanaG = precoFimSemanaG;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    
}
