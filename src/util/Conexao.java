package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.glass.ui.Robot;
import dados.*;

import javax.swing.JOptionPane;

public class Conexao {

    private Connection connection;
    private String url;
    private Statement stmt;

    public Conexao() {
        url = "jdbc:mysql://127.0.0.1:3306/SGFP";
        connection = null;
        stmt = null;

    }

    private void Conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, "root", "WaGuC8ki");
    }

    private void Desconectar() throws SQLException{
        connection.close();
    }

    private void Statement() throws SQLException{
        stmt = connection.createStatement();
    }

    public ResultSet Consultar(String sql) {
        ResultSet retorno = null;
        try {
            Conectar();
            Statement();
            retorno = stmt.executeQuery(sql);
            Desconectar();
        }catch (ClassNotFoundException enx) {
            JOptionPane.showMessageDialog(null, "Driver MySQL não encontrado!\n" + enx.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados!\n" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }

    public boolean Manipula(String sql){
        boolean retorno = false;
        try {
            Conectar();
            Statement();
            stmt.executeUpdate(sql);
            retorno = true;
            Desconectar();
        }catch (ClassNotFoundException enx) {
            JOptionPane.showMessageDialog(null, "Driver MySQL não encontrado!\n" + enx.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados!\n" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }

    /** METODO DE INCLUSAO EM BD DE CONTAS, TRANSACOES E GRUPO DE TRANSACOES **/

    public boolean Inclui(Conta conta, Transacao transacao, GrupoTransacoes grupoTransacoes) throws SQLException{
        boolean retorno = false;
        /** se o objeto passado pela assinatura for CONTA **/
        if ( (conta!=null) && (transacao == null) && (grupoTransacoes == null)) {
            try {
                Conectar();
                if (!connection.isClosed()) {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("Insert into conta (idConta, nomeConta, senhaConta, quantiaInicialConta, saldoConta) VALUES (null \',\'"+ conta.getNome() + "\',\'" + conta.getSenha() + "," + conta.getQuantiaInicial() + ", " + conta.getSaldo());
                    statement.close();
                    retorno = true;
                }
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Inserção no banco", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Inserção no banco", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        /** se o objeto passado pela assinatura for TRANSACAO **/
        }else if ( (conta==null) && (transacao != null) && (grupoTransacoes == null)) {
            try {
                Conectar();
                if (!connection.isClosed()) {
                    Statement statement = connection.createStatement();
                    //statement.executeUpdate("Insert into conta (nomeConta, senhaConta, quantiaInicialConta) VALUES (" + conta.getNome() + "\',\'" + conta.getSenha() + "\',\' " + conta.getQuantiaInicial());
                    statement.close();
                    retorno = true;
                }
            } catch (ClassNotFoundException | SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Inserção no banco", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        /** se o objeto passado pela assinatura for GRUPO DE TRANSACOES **/
        }else if ( (conta==null) && (transacao == null) && (grupoTransacoes != null) ) {
            try {
                Conectar();
                if (!connection.isClosed()) {
                    Statement statement = connection.createStatement();
                    //statement.executeUpdate("Insert into conta (nomeConta, senhaConta, quantiaInicialConta) VALUES (" + conta.getNome() + "\',\'" + conta.getSenha(senha) + "\',\' " + conta.getQuantiaInicial());
                    statement.close();
                    retorno = true;
                }
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Inserção no banco", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Inserção no banco", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        }
        return retorno;
    }
}