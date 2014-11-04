package sample;

import dados.Conta;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import regradenegocios.Gerenciador;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 04/12/13
 * Time: 10:09
 * To change this template use File | Settings | File Templates.
 */
public class Login extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception{
        final Gerenciador gerenciador = new Gerenciador();
        primaryStage.setTitle("SGFP");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Olá, este é o SGFP.");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label loginLabel = new Label("Login:");
        grid.add(loginLabel, 0, 1);

        final TextField loginTextField = new TextField();
        grid.add(loginTextField, 1, 1);

        Label senhaLabel = new Label("Senha:");
        grid.add(senhaLabel, 0, 2);

        final PasswordField senhaBox = new PasswordField();
        grid.add(senhaBox, 1, 2);

        Button criarContaBotao = new Button("Criar Conta");
        Button entrarBotao = new Button("Entrar");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(criarContaBotao);
        hbBtn.getChildren().add(entrarBotao);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        // ACAO BOTAO DE ENTRAR
        entrarBotao.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                if (gerenciador.ValidaLogin(loginTextField.getText(), senhaBox.getText())) {
                    Apresentacao apresentacao = new Apresentacao();
                    try {
                        apresentacao.start(primaryStage);

                    } catch (Exception e1) {
                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Login ou Senha incorretos.");
                }
            }
        });

        // ACAO BOTAO DE CRIAR CONTA
        criarContaBotao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CriarConta  criarConta = new CriarConta();
                try {
                    criarConta.start(primaryStage);
                } catch (Exception e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
