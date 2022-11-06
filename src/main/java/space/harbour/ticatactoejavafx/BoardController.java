package space.harbour.ticatactoejavafx;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static space.harbour.ticatactoejavafx.utils.GameBoardUtils.*;


public class BoardController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView view11;
    @FXML
    private ImageView view12;
    @FXML
    private ImageView view13;
    @FXML
    private ImageView view21;
    @FXML
    private ImageView view22;
    @FXML
    private ImageView view23;
    @FXML
    private ImageView view31;
    @FXML
    private ImageView view32;
    @FXML
    private ImageView view33;
    private static final Image imageX = new Image("file:src/main/resources/space/harbour/ticatactoejavafx/X.png");

    private static final Image imageO = new Image("file:src/main/resources/space/harbour/ticatactoejavafx/O.png");

    private static int[][] gameTable = {{0,0,0}, {0,0,0}, {0,0,0}};

    private int moves = 0;
    private int playerMoveValue = 1;
    private int cpuMoveValue = 2;

    private boolean playerMoveDone;

    private Scene scene;
    @FXML
    private void makeMove(MouseEvent mouseEvent) throws InterruptedException {
        playerMoveDone = false;
        ImageView imageView = ((ImageView) mouseEvent.getSource());
        scene = imageView.getScene();
        String elementId = imageView.getId();
        int row = Character.getNumericValue(elementId.charAt(elementId.length()-2));
        int column = Character.getNumericValue(elementId.charAt(elementId.length()-1));
        if(isMoveAllowed(gameTable, row, column)) {
            imageView.setImage(imageX);
            writeMove(gameTable, row, column, playerMoveValue);
//            if (moves % 2 == 0){                                          //to do develop option play as second player
//                writeMove(gameTable, row, column, playerMoveValue);
//            } else {
//                writeMove(gameTable, row, column, cpuMoveCValue);
//            }
            moves++;
            playerMoveDone = true;
            if(isPlayerWin(gameTable, playerMoveValue)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Win!");
                alert.setHeaderText("Congratulations, You won!");
                alert.setContentText("Press button to exit game");
                if (alert.showAndWait().get() == ButtonType.OK){
                    Stage stage = (Stage) scene.getWindow();
                    stage.close();
                    return;
                }
            }
            if (moves == 9) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Draw!");
                alert.setHeaderText("DRAW");
                alert.setContentText("Press button to exit game");
                if (alert.showAndWait().get() == ButtonType.OK){
                    Stage stage = (Stage) scene.getWindow();
                    stage.close();
                    return;
                }
            }

        }
        if (playerMoveDone) {
            Thread.sleep(200);
            int indexView = getCpuMove(gameTable, cpuMoveValue, moves);

            ImageView imageViewCpu = ((ImageView) anchorPane.getChildren().get(indexView + 4-1));
            imageViewCpu .setImage(imageO);
            String elementCpuId = imageViewCpu.getId();
            row = Character.getNumericValue(elementCpuId.charAt(elementCpuId.length()-2));
            column = Character.getNumericValue(elementCpuId.charAt(elementCpuId.length()-1));
            writeMove(gameTable, row, column, cpuMoveValue);
            moves++;
        }
        if(isPlayerWin(gameTable, cpuMoveValue)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Win!");
            alert.setHeaderText("CPU  won this game");
            alert.setContentText("Press button to exit game");
            if (alert.showAndWait().get() == ButtonType.OK){
                Stage stage = (Stage) scene.getWindow();
                stage.close();
                return;
            }
        }

    }
}