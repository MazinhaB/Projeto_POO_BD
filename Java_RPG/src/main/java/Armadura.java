public class Armadura extends Item{
    private static int cont = 0;
    public int idArmadura;
    private int ca;
    Personagem personagem;
    Mundo mundo;

    public Armadura(){
        cont++;
        this.idArmadura = cont;
    }
    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }
}
