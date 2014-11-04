package dados;

import java.util.ArrayList;

public class Conta {

    /*************************************************************/
    /********************** CLASSE DE CONTAS *********************/
    /*************************************************************/

    private String nome;
    private String senha;
    private Double quantiaInicial = 0.0;
    private Double saldo = 0.0;
    private ArrayList<Transacao> transacoes;
    private ArrayList<GrupoTransacoes> grupoTransacoes;

    public Conta(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        grupoTransacoes = new ArrayList<GrupoTransacoes>();
        transacoes = new ArrayList<Transacao>();
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQuantiaInicial() {
        return quantiaInicial;
    }

    public void setQuantiaInicial(Double quantiaInicial) {
        this.quantiaInicial = quantiaInicial;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(ArrayList<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public ArrayList<GrupoTransacoes> getGrupoTransacoes() {
        return grupoTransacoes;
    }

    public void setGrupoTransacoes(ArrayList<GrupoTransacoes> grupoTransacoes) {
        this.grupoTransacoes = grupoTransacoes;
    }
}
