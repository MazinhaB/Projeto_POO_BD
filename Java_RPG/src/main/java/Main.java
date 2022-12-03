public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        database.connect();

        // Cria o mundo
        Mundo m1 = new Mundo();
        m1.setNomeMundo("O misterio do el dourado");
        m1.setTipoMundo("Ordem Paranormal");
        m1.setNomeMestre("Mazinha");

        // Cria o personagem
        Personagem p1 = new Personagem("Shump", "Barbaro", "Meio-Orc", 5);
        p1.setDestreza(12);
        p1.setCarisma(10);
        p1.setInteligencia(7);
        p1.setForca(20);
        p1.setConstituicao(18);
        p1.setSabedoria(13);
        p1.setPvAtual(57);
        p1.setPvMax(89);
        p1.calcModificadores();
        p1.setNomeJogador("Mazinha");
        p1.defineMundo(m1);

        // Cria a arma
        Arma arma1 = new Arma();
        arma1.setNome("Machado Grande");
        arma1.setTipo("Corte");
        arma1.setDadoDano("d12");
        arma1.setMunicao(0);
        arma1.setBonusDano(8);
        arma1.setQtdDados(1);
        arma1.personagem = p1;
        arma1.mundo = m1;
        arma1.setDescricao("Machadao de barbaro");
        p1.cadastraArmas(arma1);
        p1.defineArmaAtual(arma1);


        // Cria a armadura
        Armadura armadura1 = new Armadura();
        armadura1.setNome("Colete");
        armadura1.setTipo("Couro");
        armadura1.setDescricao("Armadura ruim");
        armadura1.setCa(12);
        armadura1.personagem = p1;
        armadura1.mundo = m1;
        p1.armadura = armadura1;

        // Inserção
        database.insertMundo(m1);
        database.insertPersonagem(p1);
        database.insertItem(arma1);
        database.insertArma(arma1);
        database.insertItem(armadura1);
        database.insertArmadura(armadura1);

        //Pesquisa
        database.researchPersonagem();
        database.researchArma();
        database.researchArmadura();
        database.researchItem();
        database.researchMundo();


        //Deletar
        //database.deletePersonagem("Shump");
        //database.deleteMundo("O Misterio do el dourado");
        //database.deleteItem("Escudo");
        //database.deleteArma(1);
        //database.deleteArmadura(1);

    }
}
