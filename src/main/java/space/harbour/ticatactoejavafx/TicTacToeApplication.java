package space.harbour.ticatactoejavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApplication.class.getResource("tic-tac-toe.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("tic-tac-toe");
        Image logo = new Image("file:src\\main\\resources\\space\\harbour\\ticatactoejavafx\\XO_logo.png");
        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}