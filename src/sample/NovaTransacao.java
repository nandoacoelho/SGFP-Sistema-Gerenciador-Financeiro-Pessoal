package sample;

import dados.NumberTextField;
import dados.Transacao;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import regradenegocios.Gerenciador;
import util.Conexao;

import javax.swing.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NovaTransacao extends Application{
    @Override
    public void start(final Stage primaryStage) throws Exception{
        final Gerenciador gerenciador = new Gerenciador();
        final Transacao[] transacao = {null};
        primaryStage.setTitle("Criar Conta");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));

        Text scenetitle = new Text("Nova Transacao");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label descricaoLabel = new Label("Descrição:");
        grid.add(descricaoLabel, 0, 1);

        final TextField descricaoTextField = new TextField();
        grid.add(descricaoTextField, 1, 1);

        Label categoriaLabel = new Label("Categoria:");
        grid.add(categoriaLabel, 0, 2);

        final TextField categoriaTextField = new TextField();
        grid.add(categoriaTextField, 1, 2);

        Label valorLabel = new Label("Valor:");
        grid.add(valorLabel, 0, 3);

        final TextField valorTextField = new TextField();
        grid.add(valorTextField, 1, 3);

        Label dataLabel = new Label("Data:");
        grid.add(dataLabel, 0, 4);

        final TextField dataTextField = new TextField();
        grid.add(dataTextField, 1, 4);

        Label statusLabel = new Label("Status:");
        grid.add(statusLabel, 0, 5);

        final RadioButton apagar = new RadioButton("A pagar");
        final RadioButton pago = new RadioButton("Pago");
        HBox radiosstatus = new HBox(10);
        radiosstatus.getChildren().add(apagar);
        radiosstatus.getChildren().add(pago);
        grid.add(radiosstatus, 1, 5);


        Label tipoLabel = new Label("Tipo:");
        grid.add(tipoLabel, 0, 6);

        final RadioButton despesa = new RadioButton("Despesa");
        final RadioButton receita = new RadioButton("Receita");
        HBox radiostipo = new HBox(10);
        radiostipo.getChildren().add(receita);
        radiostipo.getChildren().add(despesa);
        grid.add(radiostipo, 1, 6);

        Button voltarBotao = new Button("Voltar");
        Button salvarBotao = new Button("Cadastrar");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(voltarBotao);
        hbBtn.getChildren().add(salvarBotao);
        grid.add(hbBtn, 1, 7);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 8);
        salvarBotao.setOnAction(new EventHandler<ActionEvent>() {

            private ActionEvent e;

            @Override
            public void handle(ActionEvent e) {
                this.e = e;
                try {
                    char status = 0;
                    char tipo = 0;
                    if (apagar.isPressed()) status = 'A';
                    if (pago.isPressed()) status = 'P';
                    if (despesa.isPressed()) tipo = 'D';
                    if (receita.isPressed()) tipo = 'R';
                    final double valor = Double.parseDouble((String) valorTextField.getText());
                    transacao[0] = new Transacao(descricaoTextField.getText(),categoriaTextField.getText(), dataTextField.getText(),valor,status,tipo);

                    if (transacao[0]==null){
                        actiontarget.setText("Você não digitou algum dos campos.");
                    }
                    if (gerenciador.CadastrarTransacao("nandoacoelho", transacao[0])){
                        actiontarget.setFill(Color.FIREBRICK);
                        actiontarget.setText("Cadastrado com Sucesso");
                        Platform.exit();
                    } else {
                        actiontarget.setText("Houve um erro.");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    actiontarget.setText("Erro");
                }
            }
        });

        voltarBotao.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Platform.exit();
            }
        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
