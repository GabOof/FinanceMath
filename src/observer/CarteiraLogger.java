// Pedro Arthur e Gabrielle Fonseca
package observer;

import entity.Carteira;

public class CarteiraLogger implements CarteiraObserver {
    @Override
    public void update(Carteira carteira) {
        System.out.println("A carteira foi atualizada: " + carteira);
        // Adicione aqui a lógica desejada para lidar com a atualização da carteira
    }

    @Override
    public void updateGanhos(double ganhos) {
        System.out.println("Ganhos foram atualizados: " + ganhos);
        // Adicione aqui a lógica desejada para lidar com a atualização dos ganhos
    }

    @Override
    public void updateGastos(double gastos) {
        System.out.println("Gastos foram atualizados: " + gastos);
        // Adicione aqui a lógica desejada para lidar com a atualização dos gastos
    }
}

