public class Item {
    private static int cont = 0;
    public int idItem;
    private String nome;
    private String tipo;
    private String descricao;

    public Item(){
        cont++;
        this.idItem = cont;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
