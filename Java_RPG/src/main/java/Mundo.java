public class Mundo {
    private static int cont = 0;
    public int idMundo;
    private String nomeMundo;
    private String tipoMundo;
    private String nomeMestre;

    public Mundo(){
        cont++;
        this.idMundo = cont;
    }
    public void inserirPersonagem(){

    }

    public String getNomeMundo() {
        return nomeMundo;
    }

    public void setNomeMundo(String nomeMundo) {
        this.nomeMundo = nomeMundo;
    }

    public String getTipoMundo() {
        return tipoMundo;
    }

    public void setTipoMundo(String tipoMundo) {
        this.tipoMundo = tipoMundo;
    }

    public String getNomeMestre() {
        return nomeMestre;
    }

    public void setNomeMestre(String nomeMestre) {
        this.nomeMestre = nomeMestre;
    }
}
