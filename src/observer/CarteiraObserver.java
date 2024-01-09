// Pedro Arthur e Gabrielle Fonseca
package observer;

import entity.Carteira;

public interface CarteiraObserver {

    void update(Carteira carteira);
    void updateGanhos(double ganhos);
    void updateGastos(double gastos);
}
