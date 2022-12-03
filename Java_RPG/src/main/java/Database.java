import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection connection; // objeto para conexão com o servidor do MySQL
    Statement statement; // objeto para preparar consultas (SELECT)
    ResultSet result; // objeto para executar consultas (SELECT)
    PreparedStatement pst; // objetos para querys de manipulação dinâmica (INSERT, UPDATE, DELETE)

    static final String user = "root";
    static final String password = "coladmin!";
    static final String database = "cadastroRPG";
    //static final String url = "jdbc:mysql://localhost:3306/" + database+ "?allowPublicKeyRetrieval=true&useSSL=false";
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false?allowPublicKeyRetrieval=true&useSSL=false";
    private boolean check = false;

    // ---- Método de conexão ----
    public void connect(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao feita com sucesso "+connection);
        }catch(SQLException e){
            System.out.println("Erro de conexao: "+e.getMessage());
        }
    }

    // ---- Métodos de inserção ----
    public boolean insertPersonagem(Personagem personagem){
        connect();
        String sql = "INSERT INTO Personagem(idPersonagem, nomeJogador, nome, classe, raca, nivel, destreza, forca, constituicao, sabedoria, " +
                "inteligencia, carisma, modDestreza, modForca, modConstituicao, modSabedoria, modInteligencia, modCarisma," +
                "pvAtual, pvMax, mundo_idMundo) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, personagem.idPersonagem);
            pst.setString(2, personagem.getNomeJogador());
            pst.setString(3, personagem.getNome());
            pst.setString(4, personagem.getClasse());
            pst.setString(5, personagem.getRaca());
            pst.setInt(6, personagem.getNivel());
            pst.setInt(7, personagem.getDestreza());
            pst.setInt(8, personagem.getForca());
            pst.setInt(9, personagem.getConstituicao());
            pst.setInt(10, personagem.getSabedoria());
            pst.setInt(11, personagem.getInteligencia());
            pst.setInt(12, personagem.getCarisma());
            pst.setInt(13, personagem.getModDestreza());
            pst.setInt(14, personagem.getModForca());
            pst.setInt(15, personagem.getModConstituicao());
            pst.setInt(16, personagem.getModSabedoria());
            pst.setInt(17, personagem.getModInteligencia());
            pst.setInt(18, personagem.getModCarisma());
            pst.setInt(19, personagem.getPvAtual());
            pst.setInt(20, personagem.getPvMax());
            pst.setInt(21, personagem.mundo.idMundo);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao "+e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e) {
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
    public boolean insertArmadura (Armadura armadura){
        connect();
        String sql = "INSERT INTO Armadura (idArmadura, ca, Item_idItem, personagem_idPersonagem, personagem_mundo_idMundo) VALUES (?, ?, ?, ?, ?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, armadura.idArmadura);
            pst.setInt(2, armadura.getCa());
            pst.setInt(3, armadura.idItem);
            pst.setInt(4, armadura.personagem.idPersonagem);
            pst.setInt(5, armadura.mundo.idMundo);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao "+e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e) {
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
    public boolean insertArma(Arma arma){
        connect();
        String sql = "INSERT INTO Arma (idArma, dadoDano, municao, bonusDano, Item_idItem, Personagem_idPersonagem) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, arma.idArma);
            pst.setString(2, arma.getDadoDano());
            pst.setInt(3, arma.getMunicao());
            pst.setInt(4, arma.getBonusDano());
            pst.setInt(5, arma.idItem);
            pst.setInt(6, arma.personagem.idPersonagem);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao "+e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e) {
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
    public boolean insertItem(Item item){
        connect();
        String sql = "INSERT INTO Item (idItem, nome, tipo, descricao) VALUES (?, ?, ?, ?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, item.idItem);
            pst.setString(2, item.getNome());
            pst.setString(3, item.getTipo());
            pst.setString(4, item.getDescricao());
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao "+e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e) {
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
    public boolean insertMundo(Mundo mundo){
        connect();
        String sql = "INSERT INTO Mundo (idMundo, nomeMundo, tipoMundo, nomeMestre) VALUES (?, ?, ?, ?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, mundo.idMundo);
            pst.setString(2, mundo.getNomeMundo());
            pst.setString(3, mundo.getTipoMundo());
            pst.setString(4, mundo.getNomeMestre());
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao "+e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e) {
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }

    // ---- Métodos de busca ----
    public ArrayList<Personagem> researchPersonagem(){
        connect();
        ArrayList<Personagem> personagens = new ArrayList<>();
        String sql = "SELECT * FROM Personagem";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Personagem persTemp = new Personagem(result.getString("nome"), result.getString("classe"),
                        result.getString("raca"), result.getInt("nivel"));
                persTemp.idPersonagem = result.getInt("idPersonagem");
                System.out.println("ID: "+persTemp.idPersonagem);
                System.out.println("Nome: "+persTemp.getNome());
                System.out.println("Classe: "+persTemp.getClasse());
                System.out.println("Raca: "+persTemp.getRaca());
                System.out.println("Nivel: "+persTemp.getNivel());
                System.out.println("-----------------------------------");
                personagens.add(persTemp);
            }
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
        }finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }

        return personagens;
    }
    public ArrayList<Armadura> researchArmadura(){
        connect();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        String sql = "SELECT * FROM Armadura";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Armadura armadura = new Armadura();
                armadura.idArmadura = result.getInt("idArmadura");
                System.out.println("ID: "+armadura.idArmadura);
                armadura.setCa(result.getInt("ca"));
                System.out.println("CA: "+armadura.getCa());
                System.out.println("-----------------------------------");
                armaduras.add(armadura);
            }
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
        }finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }

        return armaduras;
    }
    public ArrayList<Arma> researchArma(){
        connect();
        ArrayList<Arma> armas = new ArrayList<>();
        String sql = "SELECT * FROM Arma";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Arma arma = new Arma();
                arma.idArma = result.getInt("idArma");
                arma.setMunicao(result.getInt("municao"));
                arma.setDadoDano(result.getString("dadoDano"));
                arma.setBonusDano(result.getInt("bonusDano"));
                System.out.println("ID: "+arma.idArma);
                System.out.println("Dado de dano: "+arma.getDadoDano());
                System.out.println("Municao: "+arma.getMunicao());
                System.out.println("Bonus de dano: "+arma.getBonusDano());
                System.out.println("-----------------------------------");
                armas.add(arma);
            }
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
        }finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }

        return armas;
    }
    public ArrayList<Item> researchItem(){
        connect();
        ArrayList<Item> itens = new ArrayList<>();
        String sql = "SELECT * FROM Item";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Item item  = new Item();
                item.idItem = result.getInt("idItem");
                item.setNome(result.getString("nome"));
                item.setTipo(result.getString("tipo"));
                item.setDescricao(result.getString("descricao"));
                System.out.println("ID: "+item.idItem);
                System.out.println("Nome: "+item.getNome());
                System.out.println("Tipo: "+item.getTipo());
                System.out.println("Descricao: "+item.getDescricao());
                System.out.println("-----------------------------------");
                itens.add(item);
            }
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
        }finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }

        return itens;
    }
    public ArrayList<Mundo> researchMundo(){
        connect();
        ArrayList<Mundo> mundos = new ArrayList<>();
        String sql = "SELECT * FROM Mundo";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Mundo mundo = new Mundo();
                mundo.idMundo = result.getInt("idMundo");
                mundo.setNomeMundo(result.getString("nomeMundo"));
                mundo.setTipoMundo(result.getString("tipoMundo"));
                mundo.setNomeMestre(result.getString("nomeMestre"));
                System.out.println("ID: "+mundo.idMundo);
                System.out.println("Nome: "+mundo.getNomeMundo());
                System.out.println("Tipo: "+mundo.getTipoMundo());
                System.out.println("Mestre: "+mundo.getNomeMestre());
                System.out.println("-----------------------------------");
                mundos.add(mundo);
            }
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
        }finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }

        return mundos;
    }

    // ---- Método de atualização ----
    public boolean updatePersonagem(int id, String nome){
        connect();
        String sql = "UPDATE Personagem SET nome=? WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }

    // ---- Método de exclusão ----
    public boolean deletePersonagem(String nome){
        connect();
        String sql = "DELETE FROM Personagem WHERE nome=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
    public boolean deleteMundo(String nome){
        connect();
        String sql = "DELETE FROM Mundo WHERE nomeMundo=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
    public boolean deleteItem(String nome){
        connect();
        String sql = "DELETE FROM Item WHERE nome=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
    public boolean deleteArma(int id){
        connect();
        String sql = "DELETE FROM Arma WHERE idArma=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
    public boolean deleteArmadura(int id){
        connect();
        String sql = "DELETE FROM Armadura WHERE idArmadura=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        }catch(SQLException e){
            System.out.println("Erro de operacao: "+e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexao: "+e.getMessage());
            }
        }
        return check;
    }
}
