// Arthur Segheto, Gabrielle Fonseca, Maria Eduarda e Pedro Arthur
package dao;

import observer.CarteiraObserver;
import conexao.Conexao;
import entity.Carteira;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//DAO para a manipulação de dados relacionados a entidade chamada "Carteira"
public class CarteiraDAO {

    private final Connection conn;
    private List<CarteiraObserver> observers;

    // Construtor da classe CarteiraDAO
    public CarteiraDAO() {
        // Obtém a instância única da conexão usando o padrão Singleton
        this.conn = Conexao.getInstance();
        this.observers = new ArrayList<>();
    }

    // Adicione um observador
    public void addObserver(CarteiraObserver observer) {
        observers.add(observer);
    }

    // Remova um observador
    public void removeObserver(CarteiraObserver observer) {
        observers.remove(observer);
    }

    // Notifique todos os observadores
    private void notifyObservers(Carteira carteira) {
        for (CarteiraObserver observer : observers) {
            observer.update(carteira);
        }
    }

    public void inserir(Carteira carteira) {
        String sql = "INSERT INTO carteira(nome, classificacao, valor, data) VALUES " + "(?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, carteira.getNome());
            stmt.setString(2, carteira.getClassificacao());
            stmt.setDouble(3, carteira.getValor());
            stmt.setString(4, carteira.getData());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Inserido");

            // Notifique os observadores após a inserção
            notifyObservers(carteira);
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir dados." + e.getMessage());
        }
    }

    public List<Carteira> listarCarteira() {
        try {
            List<Carteira> lista = new ArrayList<Carteira>();
            String sql = "SELECT * from carteira";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Carteira c = new Carteira();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setClassificacao(rs.getString("classificacao"));
                c.setValor(rs.getDouble("valor"));
                c.setData(rs.getString("data"));

                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isVazio() {
        try {
            String sql = "SELECT COUNT(*) AS count FROM carteira";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count == 0;
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double calcularTotalGanhos() {
        double totalGanhos = 0.0;

        try {
            String sql = "SELECT SUM(valor) AS total_ganhos FROM carteira WHERE valor > 0";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalGanhos = rs.getDouble("total_ganhos");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Math.abs(totalGanhos);
    }

    public double calcularTotalGastos() {
        double totalGastos = 0.0;

        try {
            String sql = "SELECT SUM(valor) AS total_gastos FROM carteira WHERE valor < 0";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalGastos = rs.getDouble("total_gastos");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Math.abs(totalGastos);
    }

    public void excluir(Carteira carteira) {
        try {
            String sql = "delete from carteira where id = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, carteira.getId());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
