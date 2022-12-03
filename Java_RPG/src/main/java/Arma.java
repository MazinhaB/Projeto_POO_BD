import java.util.Objects;

public class Arma extends Item{
    private static int cont = 0;
    public int idArma;
    private String dadoDano;
    private int qtdDados;
    private int bonusDano;
    private int municao;
    Personagem personagem;
    Mundo mundo;

    public Arma(){
        cont++;
        this.idArma = cont;
    }

    public int calcDanoTotal(){
        int dano = 0;
        int max;
        if(Objects.equals(this.dadoDano, "d4"))
            max = 4;
        else if(Objects.equals(this.dadoDano, "d6"))
            max = 6;
        else if(Objects.equals(this.dadoDano, "d8"))
            max = 8;
        else if(Objects.equals(this.dadoDano, "d10"))
            max = 10;
        else
            max = 12;
        for(int i = 0; i < this.qtdDados; i++)
            dano += (int)(Math.random() * max + 1);

        dano += bonusDano;

        return dano;
    }

    public String getDadoDano() {
        return dadoDano;
    }

    public void setDadoDano(String dadoDano) {
        this.dadoDano = dadoDano;
    }

    public int getBonusDano() {
        return bonusDano;
    }

    public void setBonusDano(int bonusDano) {
        this.bonusDano = bonusDano;
    }

    public void setQtdDados(int qtdDados) {
        this.qtdDados = qtdDados;
    }

    public int getMunicao() {
        return municao;
    }

    public void setMunicao(int municao) {
        this.municao = municao;
    }

}
