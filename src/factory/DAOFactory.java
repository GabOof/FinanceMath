// Arthur Segheto
package factory;

// Esta interface define o método factory que todas as fábricas concretas devem implementar.
public interface DAOFactory {

    // Método factory para criar um objeto DAO. O tipo exato do objeto DAO é determinado pela fábrica concreta que
    // implementa esta interface.
    Object createDAO();
}
