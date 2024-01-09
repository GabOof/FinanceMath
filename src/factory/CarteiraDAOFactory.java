// Arthur Segheto
package factory;

import dao.CarteiraDAO;

// Esta é uma fábrica concreta que implementa a interface DAOFactory para criar objetos CarteiraDAO.
public class CarteiraDAOFactory implements DAOFactory {

    // Método factory que cria e retorna uma nova instância de CarteiraDAO.
    @Override
    public CarteiraDAO createDAO() {
        return new CarteiraDAO();
    }
}
