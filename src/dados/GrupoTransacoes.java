package dados;

import java.util.ArrayList;

public class GrupoTransacoes {

    /*************************************************************/
    /************** CLASSE DE GRUPO DE TRANSACOES ****************/
    /*************************************************************/

    private String nome;
    private ArrayList<Transacao> transacoes;

    public GrupoTransacoes(String nome) {
        this.nome = nome;
        transacoes = new ArrayList<Transacao>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(ArrayList<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
