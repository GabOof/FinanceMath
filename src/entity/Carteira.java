// Arthur Segheto, Gabrielle Fonseca, Maria Eduarda e Pedro Arthur
package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Carteira {

    private int id;
    private String nome;
    private String classificacao;
    private double valor;
    private String data;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate currentDate = LocalDate.now();
    String realDate = currentDate.format(formatter);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRealDate() {
        return realDate;
    }

    public void setRealDate(String realDate) {
        this.realDate = realDate;
    }

    @Override
    public String toString() {
        return "Carteira{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", classificacao='" + classificacao + '\''
                + ", valor=" + valor
                + ", data=" + data
                + ", realDate='" + realDate + '\''
                + '}';
    }
}

