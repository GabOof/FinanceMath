// Arthur Segheto, Gabrielle Fonseca, Maria Eduarda e Pedro Arthur
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Faz a conexao com o BD usando o padrão Singleton, garantindo que haja apenas uma instância da conexão
public class Conexao {

    // URL de conexão com o banco de dados
    private static final String url = "jdbc:mysql://127.0.0.1:3306/BDProg";

    // Credenciais para acesso ao banco de dados
    private static final String user = "root"; // Seu usuário do BD
    private static final String password = "123456"; //Sua senha do BD

    // A instância única da conexão
    private static Connection conn;

    // Construtor privado para evitar instâncias externas
    public Conexao() {
        // Construtor vazio, para que outras classes não instanciem essa classe diretamente.
    }

    //Obtém a instância única da conexão com o banco de dados, retornando a instância única da conexão.
    public static Connection getInstance() {
        try {
            // Verifica se a instância não existe ou está fechada
            if (conn == null || conn.isClosed()) {
                // Cria uma nova conexão se não existir ou estiver fechada
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida!");
            }
            // Retorna a instância única da conexão
            return conn;
        } catch (SQLException e) {
            // Tratamento de exceção em caso de erro na conexão
            System.out.println("Erro ao conectar " + e.getMessage());
            return null;
        }
    }
}
