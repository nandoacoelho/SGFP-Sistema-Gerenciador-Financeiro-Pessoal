package regradenegocios;

import dados.Conta;
import dados.GrupoTransacoes;
import dados.Transacao;
import util.Conexao;

import java.sql.SQLException;
import java.util.ArrayList;

public class Gerenciador {

    /*****************************************************************/
    /********************* CLASSE DE GERENCIADOR *********************/
    /*****************************************************************/
    /** ADMINISTRA CLASSES: CONTA, EXTRATO TRANSACAO E G.TRANSACOES **/
    /********** IMPORTA A CLASSE CONEXAO PARA BANCO DE DADOS *********/
    /*****************************************************************/


    private ArrayList<Conta> conta;
    private Conexao conexao;


    public Gerenciador() {
        conta = new ArrayList<Conta>();
        conexao = new Conexao();

        String nome = "nandoacoelho";
        String senha = "123456";
        Conta conta1 = new Conta(nome, senha);
        conta.add(conta1);
    }

    public void setConta(ArrayList<Conta> conta) {
        this.conta = conta;
    }

    /*************************************************************/
    /********************* METODOS DE EXTRATO ********************/
    /*************************************************************/

    public ArrayList<Transacao> ConsultaExtrato(Conta conta){
        for (Conta aConta : this.conta) if (aConta.equals(conta)) conta = aConta;
        return conta.getTransacoes();
    }

    /*************************************************************/
    /********************** METODOS DE CONTAS ********************/
    /*************************************************************/

    public boolean ValidaLogin(String nome, String senha){
        boolean retorno = false;
        for (int i = 0; i < this.conta.size(); i++)
            if (this.conta.get(i).getNome().equals(nome)) {
                if (this.conta.get(i).getSenha().equals(senha))
                    i = this.conta.size();
                    retorno = true;
                }

        return retorno;
    }

    public boolean ConsultarConta(String nome){
        boolean retorno = false;
        for (int i = 0; i < this.conta.size(); i++) {
            if (this.conta.get(i).getNome().equals(nome)) {
                i = this.conta.size();
                retorno = true;
            }
        }
        return retorno;
    }

    public boolean CadastrarConta(String nome, String senha) throws SQLException {
        boolean retorno = false;
        if (!ConsultarConta(nome)){
            Conta conta = new Conta(nome, senha);
            this.conta.add(conta);
            conexao.Inclui(conta, null, null);
            retorno = true;
        }
        return retorno;
    }

    public boolean AlterarConta(Conta conta){
        boolean retorno = false;
        for (Conta conta1 : this.conta) {
            if (conta1.getNome().equals(conta.getNome())) {
                if (conta.getNome() != null) conta1.setNome(conta.getNome());
                if (conta.getSenha() != null) conta1.setSenha(conta.getSenha());
                retorno = true;
            }
        }
        return retorno;
    }

    public boolean ExcluirConta(Conta conta){
        boolean retorno = false;
        for (int i = 0; i < this.conta.size(); i++){
            if (this.conta.get(i).getNome().equals(conta.getNome())){
                this.conta.remove(this.conta.get(i));
                retorno = true;
            }
        }
        return retorno;
    }

    /*************************************************************/
    /******************** METODOS DE TRANSACOES ******************/
    /*************************************************************/

    public ArrayList<Transacao> ConsultarTransacao(Conta conta){
        for (Conta aConta : this.conta)
            if (aConta.getNome().equals(conta.getNome()))
                conta = aConta;
                this.conta.size();

        return conta.getTransacoes();
    }

    public boolean CadastrarTransacao(String nome, Transacao transacao) throws SQLException {
        boolean retorno = false;
        for (Conta aConta : this.conta) {
            if (aConta.getNome().equals(nome)) {
                aConta.getTransacoes().add(transacao);
                conexao.Inclui(null, transacao, null);
                retorno = true;
            }
        }
        return retorno;
    }

    public boolean AlterarTransacao(String nome, Transacao transacao){
        boolean retorno = false;
        for (Conta aConta : this.conta) {
            if (aConta.getNome().equals(nome)) {
                for (int j = 0; j < aConta.getTransacoes().size(); j++) {
                    if (aConta.getTransacoes().get(j).equals(transacao)) {
                        if (transacao.getCategoria() != null) aConta.getTransacoes().get(j).setCategoria(transacao.getCategoria());
                        if (transacao.getData() != null) aConta.getTransacoes().get(j).setData(transacao.getData());
                        if (transacao.getDescricao() != null) aConta.getTransacoes().get(j).setDescricao(transacao.getDescricao());
                        if (transacao.getStatus() != '\0') aConta.getTransacoes().get(j).setStatus(transacao.getStatus());
                        if (transacao.getTipo() != '\0') aConta.getTransacoes().get(j).setTipo(transacao.getTipo());
                        if (transacao.getValor() != 0) aConta.getTransacoes().get(j).setValor(transacao.getValor());
                        retorno = true;
                    }
                }
            }
        }
        return retorno;
    }

    public boolean ExcluirTransacao(Conta conta, Transacao transacao){
        boolean retorno = false;
        for (Conta aConta : this.conta) {
            if (aConta.getNome().equals(conta.getNome())) {
                for (int j = 0; j < aConta.getTransacoes().size(); j++) {
                    if (aConta.getTransacoes().get(j).equals(transacao)) {
                        aConta.getTransacoes().remove(j);
                        retorno = true;
                    }
                }
            }
        }
        return retorno;
    }

    /*************************************************************/
    /************* METODOS DE GRUPO DE TRANSACOES ****************/
    /*************************************************************/

    public ArrayList<GrupoTransacoes> ConsultarGrupoTransacoes(Conta conta){
        for (Conta aConta : this.conta)
            if (aConta.getNome().equals(conta.getNome())) conta = aConta;
        return conta.getGrupoTransacoes();
    }

    public boolean CadastrarGrupoTransacoes(Conta conta, GrupoTransacoes grupoTransacoes) throws SQLException {
        boolean retorno = false;
        for (Conta aConta : this.conta) {
            if (aConta.equals(conta)) {
                aConta.getGrupoTransacoes().add(grupoTransacoes);
                conexao.Inclui(null, null, grupoTransacoes);
                retorno = true;
            }
        }
        return retorno;
    }

    public boolean AlterarGrupoTransacoes(Conta conta, GrupoTransacoes grupoTransacoes){
        boolean retorno = false;
        for (Conta aConta : this.conta) {
            if (aConta.equals(conta)) {
                for (int j = 0; j < aConta.getGrupoTransacoes().size(); j++) {
                    if (grupoTransacoes.getNome() != null) aConta.getGrupoTransacoes().get(j).setNome(grupoTransacoes.getNome());
                    if (grupoTransacoes.getTransacoes() != null) aConta.getGrupoTransacoes().get(j).setTransacoes(grupoTransacoes.getTransacoes());
                    retorno = true;
                }
            }
        }
        return retorno;
    }

    public boolean ExcluirGrupoTransacoes(Conta conta, GrupoTransacoes grupoTransacoes){
        boolean retorno = false;
        for (Conta aConta : this.conta) {
            if (aConta.getNome().equals(conta.getNome())) {
                for (int j = 0; j < aConta.getGrupoTransacoes().size(); j++) {
                    if (aConta.getGrupoTransacoes().get(j).getNome().equals(grupoTransacoes.getNome())) {
                        aConta.getGrupoTransacoes().remove(j);
                        retorno = true;
                    }
                }
            }
        }
        return retorno;

    }


}
