package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        //create the matrix with empty grid and print on the  screen
        char[][] matrix = new char[3][3];
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                char emptyField = ' ';
                matrix[i][j] = emptyField;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        //enter the coordinates
        int x = 0;
        int y = 0;
        boolean xCoordinatesFilled = false;
        boolean yCoordinatesFilled = false;
        boolean xTurn = true;
        boolean gameEnd = false;
        System.out.println("Enter the coordinates:");
        String dataRow = scanner.next().replaceAll(">", "");
        String dataColl = scanner.next().replaceAll(">", "");
        while (!xCoordinatesFilled || !yCoordinatesFilled) {


            //check if input are numbers out of the grid
            if (dataRow.matches("\\d") && dataColl.matches("\\d")) {
                int row = Integer.parseInt(dataRow);
                int coll = Integer.parseInt(dataColl);
                if ((row > 0 && row < 4) && (coll > 0 && coll < 4)) {
                    x = row - 1;
                    y = coll - 1;
                    xCoordinatesFilled = true;
                    yCoordinatesFilled = true;
                    int xS = 0;
                    int oS = 0;
                    for (char[] chars : matrix) {
                        for (int j = 0; j < matrix.length; j++) {
                            if (chars[j] != ' ') {
                                if (chars[j] == 'X') {
                                    xS++;
                                } else {
                                    oS++;
                                }
                            }
                        }
                    }
                    if (xS == oS) {
                        xTurn = true;
                    } else {
                        xTurn = false;
                    }

                    //if the chosen cell is empty
                    if(matrix[x][y] == ' ') {
                        if (xTurn) {
                            matrix[x][y] = 'X';
                            xTurn = false;
                            printMatrix(matrix);
                            //'O'
                        } else {
                            matrix[x][y] = 'O';
                            xTurn = true;
                            printMatrix(matrix);
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        xCoordinatesFilled = false;
                        yCoordinatesFilled = false;
                    }
                    int winnerCount = 0;
                    int cellsCount = 0;

                    boolean xWins = false;
                    boolean oWins = false;
                    //horizontals
                    for (char[] chars : matrix) {
                        for (int j = 0; j < matrix.length; j++) {
                            if (chars[j] != ' ') {
                                winnerCount += chars[j];
                                cellsCount++;
                            }
                        }
                        if (winnerCount == 264) {
                            xWins = true;
                        } else if (winnerCount == 237) {
                            oWins = true;
                        }
                        winnerCount = 0;

                    }
                    //verticals
                    for (int i = 0; i < matrix.length; i++) {
                        for (char[] chars : matrix) {
                            if (chars[i] != '_') {
                                winnerCount += chars[i];
                            }
                        }
                        if (winnerCount == 264) {
                            xWins = true;
                        } else if (winnerCount == 237) {
                            oWins = true;
                        }
                        winnerCount = 0;
                    }
                    //diagonals
                    for (int i = 0; i < 3; i++) {
                        if (matrix[i][i] != '_') {
                            winnerCount += matrix[i][i];
                        }
                    }
                    if (winnerCount == 264) {
                        xWins = true;
                    } else if (winnerCount == 237) {
                        oWins = true;
                    }
                    winnerCount = 0;

                    for (int i = 0; i < 3; i++) {
                        int j = 2 - i;
                        if (matrix[i][j] != '_') {
                            winnerCount += matrix[i][j];
                        }
                    }
                    if (winnerCount == 264) {
                        xWins = true;
                    } else if (winnerCount == 237) {
                        oWins = true;
                    }

                    int diff = xS - oS;
                    if ((xWins && oWins) || Math.abs(diff) > 1) {
                        System.out.println("Impossible");
                    } else if (!xWins && !oWins) {
                        if (cellsCount == 9) {
                            System.out.println("Draw");
                            gameEnd = true;
                        }
                    } else {
                        if (xWins) {
                            System.out.println("X wins");

                        } else {
                            System.out.println("O wins");
                        }
                        gameEnd = true;
                    }

                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
                //if input contains NotNumbers
            } else {
                System.out.println("You should enter numbers!");
            }

            if (!gameEnd) {
                System.out.println("Enter the coordinates:");
                dataRow = scanner.next().replaceAll(">", "");
                dataColl = scanner.next().replaceAll(">", "");
                xCoordinatesFilled = false;
                yCoordinatesFilled = false;
            } else {
                break;
            }
        }
    }
    private static void printMatrix(char matrix[][]) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
