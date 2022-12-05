import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        database.connect();

        Scanner in = new Scanner(System.in);
        String nomeAux;
        String classe;
        String raca;
        int nivel;
        int aux;
        int op;
        int op2;
        boolean rep = false;

        System.out.println("1 - Cadastrar informacoes\n2 - Pesquisar informacoes\n3 - Atualizar nome do Personagem\n4 - Deletar informacoes\n5 - Sair");
        op2 = in.nextInt();
        while(op2 != 5) {
            switch (op2) {
                case 1 -> {
                    in.nextLine();
                    System.out.println("Entre com as informacoes do mundo");
                    Mundo m1 = new Mundo();
                    System.out.print("Nome do mundo: ");
                    nomeAux = in.nextLine();
                    m1.setNomeMundo(nomeAux);
                    System.out.print("Tipo do mundo: ");
                    nomeAux = in.nextLine();
                    m1.setTipoMundo(nomeAux);
                    System.out.print("Nome do mestre: ");
                    nomeAux = in.nextLine();
                    m1.setNomeMestre(nomeAux);
                    database.insertMundo(m1);
                    System.out.println("------------------------------------------");
                    System.out.println("Entre com as informacoes do personagem: ");
                    System.out.print("Nome: ");
                    nomeAux = in.nextLine();
                    System.out.print("Classe: ");
                    classe = in.nextLine();
                    System.out.print("Raca: ");
                    raca = in.nextLine();
                    System.out.print("Nivel: ");
                    nivel = in.nextInt();
                    Personagem p1 = new Personagem(nomeAux, classe, raca, nivel);
                    System.out.print("Nome do jogador: ");
                    in.nextLine();
                    nomeAux = in.nextLine();
                    p1.setNomeJogador(nomeAux);
                    System.out.println("Deseja gerar os atributos aleatoriamente? (1 - sim / 2 - nao)");
                    aux = in.nextInt();
                    if(aux == 1)
                        p1.gerarAtributos();
                    else {
                        System.out.print("Valor de destreza: ");
                        aux = in.nextInt();
                        p1.setDestreza(aux);
                        System.out.print("Valor de constituicao: ");
                        aux = in.nextInt();
                        p1.setConstituicao(aux);
                        System.out.print("Valor de forca: ");
                        aux = in.nextInt();
                        p1.setForca(aux);
                        System.out.print("Valor de inteligencia: ");
                        aux = in.nextInt();
                        p1.setInteligencia(aux);
                        System.out.print("Valor de sabedoria: ");
                        aux = in.nextInt();
                        p1.setSabedoria(aux);
                        System.out.print("Valor de carisma: ");
                        aux = in.nextInt();
                        p1.setCarisma(aux);
                    }
                    p1.calcModificadores();
                    System.out.println("Qual a vida maxima do " + p1.getNome());
                    aux = in.nextInt();
                    p1.setPvMax(aux);
                    System.out.println("Qual a vida atual do " + p1.getNome());
                    aux = in.nextInt();
                    p1.setPvAtual(aux);
                    p1.defineMundo(m1);

                    Arma arma1 = new Arma();
                    System.out.println("Entre com o nome da arma: ");
                    in.nextLine();
                    nomeAux = in.nextLine();
                    arma1.setNome(nomeAux);
                    System.out.println("Entre com o tipo da arma: ");
                    nomeAux = in.nextLine();
                    arma1.setTipo(nomeAux);
                    System.out.println("Qual o dado de dano da arma?");
                    nomeAux = in.nextLine();
                    arma1.setDadoDano(nomeAux);
                    System.out.println("Quantos dados de dano?");
                    aux = in.nextInt();
                    arma1.setQtdDados(aux);
                    System.out.println("Quanto de municao a arma tem?");
                    aux = in.nextInt();
                    arma1.setMunicao(aux);
                    System.out.println("Qual o bonus total de dano?");
                    aux = in.nextInt();
                    arma1.setBonusDano(aux);
                    arma1.personagem = p1;
                    arma1.mundo = m1;
                    System.out.println("Entre com a descricao da arma: ");
                    in.nextLine();
                    nomeAux = in.nextLine();
                    arma1.setDescricao(nomeAux);
                    p1.cadastraArmas(arma1);
                    p1.defineArmaAtual(arma1);

                    Armadura armadura1 = new Armadura();
                    System.out.println("Entre com o nome da armadura: ");
                    nomeAux = in.nextLine();
                    armadura1.setNome(nomeAux);
                    System.out.println("Entre com o tipo da armadura: ");
                    nomeAux = in.nextLine();
                    armadura1.setTipo(nomeAux);
                    System.out.println("Entre com a descricao da armadura:");
                    nomeAux = in.nextLine();
                    armadura1.setDescricao(nomeAux);
                    System.out.println("Qual a CA da armadura?");
                    aux = in.nextInt();
                    armadura1.setCa(aux);
                    armadura1.personagem = p1;
                    armadura1.mundo = m1;
                    p1.armadura = armadura1;

                    // Inserção
                    database.insertPersonagem(p1);
                    database.insertItem(arma1);
                    database.insertArma(arma1);
                    database.insertItem(armadura1);
                    database.insertArmadura(armadura1);

                    if (rep) {
                        System.out.println("Digite 1 para cadastrar um novo mundo e 0 caso deseje manter o mesmo");
                        op = in.nextInt();
                        if (op == 1) {
                            Mundo m2 = new Mundo();
                            System.out.println("Entre com as informacoes do mundo");
                            System.out.print("Nome do mundo: ");
                            in.nextLine();
                            nomeAux = in.nextLine();
                            m2.setNomeMundo(nomeAux);
                            System.out.print("Tipo do mundo: ");
                            nomeAux = in.nextLine();
                            m2.setTipoMundo(nomeAux);
                            System.out.print("Nome do mestre: ");
                            nomeAux = in.nextLine();
                            m2.setNomeMestre(nomeAux);
                            database.insertMundo(m2);
                            m1 = m2;
                        }
                    }
                    rep = true;
                }

                case 2 -> {
                    System.out.println("1 - Lista de Personagens\n2 - Lista de Armas\n3 - Lista de Armaduras\n4 - Lista de Itens\n5 - Lista de Mundos");
                    aux = in.nextInt();
                    switch (aux) {
                        case 1 -> {
                            database.researchPersonagem();
                        }
                        case 2 -> {
                            database.researchArma();
                        }
                        case 3 -> {
                            database.researchArmadura();
                        }
                        case 4 -> {
                            database.researchItem();
                        }
                        case 5 -> {
                            database.researchMundo();
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Entre com o id e o novo nome do personagem");
                    aux = in.nextInt();
                    in.nextLine();
                    nomeAux = in.nextLine();
                    database.updatePersonagem(aux, nomeAux);
                }
                case 4 -> {
                    System.out.println("1 - Deletar personagem\n2 - Deletar arma\n3 - Deletar armadura\n4 - Deletar item\n5 - Deletar mundo");
                    aux = in.nextInt();
                    switch (aux) {
                        case 1 -> {
                            System.out.println("Entre com o nome do personagem que deseja deletar");
                            in.nextLine();
                            nomeAux = in.nextLine();
                            database.deletePersonagem(nomeAux);
                        }
                        case 2 -> {
                            System.out.println("Entre com o id da arma que deseja deletar");
                            aux = in.nextInt();
                            database.deleteArma(aux);
                        }
                        case 3 -> {
                            System.out.println("Entre com o id da armadura que deseja deletar");
                            aux = in.nextInt();
                            database.deleteArmadura(aux);
                        }
                        case 4 -> {
                            System.out.println("Entre com o nome do item que deseja deletar");
                            in.nextLine();
                            nomeAux = in.nextLine();
                            database.deleteItem(nomeAux);
                        }
                        case 5 -> {
                            System.out.println("Entre com o nome do mundo que deseja deletar");
                            in.nextLine();
                            nomeAux = in.nextLine();
                            database.deleteMundo(nomeAux);
                        }
                    }
                }
            }
            System.out.println("1 - Cadastrar informacoes\n2 - Pesquisar informacoes\n3 - Atualizar nome do Personagem\n4 - Deletar informacoes\n5 - Sair");
            op2 = in.nextInt();
        }
    }
}
