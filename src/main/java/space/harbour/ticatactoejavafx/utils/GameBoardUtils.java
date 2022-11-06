package space.harbour.ticatactoejavafx.utils;

import java.util.Random;

public class GameBoardUtils {

    public static void writeMove(int[][] gameTable, int row, int column, int value){
        gameTable[row-1][column-1] = value;
    }

    public static boolean isMoveAllowed (int[][] gameTable, int row, int column) {
        if (gameTable[row-1][column-1] == 0) {
            return true;
        }
        return false;
    }

    public static int getCpuMove(int[][] gameTable,int value, int moves) {
        Random randomValue = new Random();
        int index = 0;
        int randomMove = randomValue.nextInt(9 - moves) +1;
        for (int i = 0; i < gameTable[0].length; i++) {
            for (int j = 0; j < gameTable.length; j++) {
                index++;
                if (isMoveAllowed(gameTable, i + 1, j + 1)) {
                    randomMove--;
                }
                if (randomMove == 0) {
                    return index;
                }
            }
        }
        return index;
    }

    public static boolean isPlayerWin(int[][] gameTable, int playerMoveValue){
        if(playerMoveValue == gameTable[0][0] &&  playerMoveValue == gameTable[0][1]
                && playerMoveValue == gameTable[0][2] ){
            return  true;
        } else if(playerMoveValue == gameTable[1][0] &&  playerMoveValue == gameTable[1][1]
                && playerMoveValue == gameTable[1][2]) {
            return  true;
        } else if(playerMoveValue == gameTable[2][0] &&  playerMoveValue == gameTable[2][1]
                && playerMoveValue == gameTable[2][2] ) {
            return  true;
        } else if(playerMoveValue == gameTable[0][0]&&  playerMoveValue == gameTable[1][0]
                && playerMoveValue == gameTable[2][0]) {
            return  true;
        } else if(playerMoveValue == gameTable[0][1] &&  playerMoveValue == gameTable[1][1]
                && playerMoveValue == gameTable[2][1]) {
            return  true;
        } else if(playerMoveValue == gameTable[0][2] &&  playerMoveValue == gameTable[1][2]
                && playerMoveValue == gameTable[2][2] ) {
            return  true;
        } else if(playerMoveValue == gameTable[0][0]&&  playerMoveValue == gameTable[1][1]
                && playerMoveValue == gameTable[2][2] ) {
            return  true;
        } else if(playerMoveValue == gameTable[0][2] &&  playerMoveValue == gameTable[1][1]
                && playerMoveValue == gameTable[2][0]) {
            return  true;
        } else {
            return false;
        }
    }
}
