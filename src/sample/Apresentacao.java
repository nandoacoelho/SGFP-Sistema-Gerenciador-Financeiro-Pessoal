package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import regradenegocios.Gerenciador;

import java.sql.SQLException;


public class Apresentacao extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("apresentacao1.fxml"));
        primaryStage.setTitle("Sistema Gerenciador Financeiro Pessoal");
        primaryStage.setScene(new Scene(root, 850.0, 642.0));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
