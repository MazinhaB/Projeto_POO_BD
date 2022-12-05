import java.util.ArrayList;

public class Personagem {

    private static int cont = 0;
    public int idPersonagem;
    private String nomeJogador;
    private String nome;
    private String classe;
    private String raca;
    private int nivel;
    private int destreza;
    private int forca;
    private int constituicao;
    private int sabedoria;
    private int inteligencia;
    private int carisma;
    private int modDestreza;
    private int modForca;
    private int modConstituicao;
    private int modSabedoria;
    private int modInteligencia;
    private int modCarisma;
    private int pvAtual;
    private int pvMax;

    ArrayList<Arma> armas = new ArrayList<>();
    Arma armaAtual;
    Armadura armadura;
    Mundo mundo;

    public Personagem(String nome, String classe, String raca, int nivel){
        cont++;
        this.idPersonagem = cont;
        this.nome = nome;
        this.classe = classe;
        this.raca = raca;
        this.nivel = nivel;
    }
    public void defineArmaAtual(Arma arma){
        this.armaAtual = arma;
    }
    public void defineMundo(Mundo m){
        this.mundo = m;
    }

    public void gerarAtributos(){
        this.destreza = (int)(Math.random() * 16) + 3;
        this.forca = (int)(Math.random() * 16) + 3;
        this.constituicao = (int)(Math.random() * 16) + 3;
        this.sabedoria = (int)(Math.random() * 16) + 3;
        this.inteligencia = (int)(Math.random() * 16) + 3;
        this.carisma = (int)(Math.random() * 16) + 3;
    }

    public void calcModificadores(){
        this.modDestreza = (this.destreza - 10) / 2;
        this.modForca = (this.forca - 10) / 2;
        this.modConstituicao = (this.constituicao - 10) / 2;
        this.modSabedoria = (this.sabedoria - 10) / 2;
        this.modInteligencia = (this.inteligencia - 10) / 2;
        this.modCarisma = (this.carisma - 10) / 2;
    }

    public void mostraInfo(){
        System.out.println("Nome: " + this.nome + "\tNivel: " + this.nivel);
        System.out.println("Classe:" + this.classe + "\tRaca:" + this.raca);
        System.out.println("Forca: " + this.forca + "\t\t" + this.modForca);
        System.out.println("Destreza: " + this.destreza + "\t\t" + this.modDestreza);
        System.out.println("Constituicao: " + this.constituicao + "\t\t" + this.modConstituicao);
        System.out.println("Sabedoria: " + this.sabedoria + "\t\t" + this.modSabedoria);
        System.out.println("Inteligencia: " + this.inteligencia + "\t\t" + this.modInteligencia);
        System.out.println("Carisma: " + this.carisma + "\t\t" + this.modCarisma);
        System.out.println("Arma: " + this.armaAtual.getNome() + "\t Armadura: " + this.armadura.getNome());
    }
    public void cadastraArmas(Arma arma){this.armas.add(arma);}

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public String getRaca() {
        return raca;
    }

    public int getNivel() {
        return nivel;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getModDestreza() {
        return modDestreza;
    }

    public int getModForca() {
        return modForca;
    }

    public int getModConstituicao() {
        return modConstituicao;
    }

    public int getModSabedoria() {
        return modSabedoria;
    }

    public int getModInteligencia() {
        return modInteligencia;
    }

    public int getModCarisma() {
        return modCarisma;
    }

    public int getPvAtual() {
        return pvAtual;
    }

    public void setPvAtual(int pvAtual) {
        this.pvAtual = pvAtual;
    }

    public int getPvMax() {
        return pvMax;
    }

    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
    }

}
