package dados;

import java.util.Date;
import java.util.GregorianCalendar;

public class Transacao {

    /*************************************************************/
    /******************** CLASSE DE TRANSACOES *******************/
    /*************************************************************/

    private String descricao;
    private String categoria;
    private String data;
    private Double valor;
    private char status;
    private char tipo;

    public Transacao(String descricao, String categoria, String data, Double valor, char status, char tipo) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.status = status;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}
