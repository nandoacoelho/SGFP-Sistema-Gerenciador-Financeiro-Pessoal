package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception{

        Login login = new Login();
        login.start(primaryStage);
        java.awt.Toolkit.getDefaultToolkit();
    }
        public static void main(String[] args) {
        System.setProperty("javafx.macosx.embedded", "true");
        java.awt.Toolkit.getDefaultToolkit();
        launch(args);
    }
}
