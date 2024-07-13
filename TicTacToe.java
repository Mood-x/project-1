import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static int[][] board = new int[3][3]; 
    public static Scanner input = new Scanner(System.in); 
    public static char currentPlayer; 
    public static char computer = 'O';
    public static char player = 'X';

    public static void main(String[] args) {
        try {
            System.out.println("Choose an option:\n(1) - Play one round\n(2) - Play three rounds");
            int choice = input.nextInt();

            if (choice == 1) {
                playOneRound(); 
            } else if (choice == 2) {
                playThreeRounds(); 
            } else {
                System.out.println("Invalid Input");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a number.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }


// -------------------------------> METHODS <-------------------------------

    public static void playOneRound() {
        positionsBoard();
        currentPlayer = player;

        while (true) {
            printBoard();

            if (currentPlayer == player) {
                playerTurn();
            } else {
                computerTurn();
            }

            if (checkWin()) {
                printBoard();
                System.out.println("\t\t\t|-------------------------------|");
                System.out.println("\t\t\t|     Player " + "[ " + currentPlayer + " ]" + " ~~~ wins ~~~ |");
                System.out.println("\t\t\t|-------------------------------|");
                break; 
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("The game is a draw.");
                break; 
            }

            switchPlayer();
        }
    }

    public static void playThreeRounds() {
        int playerWins = 0; 
        int computerWins = 0;

        for (int round = 1; round <= 3; round++) {
            System.out.println("Round " + round);
            positionsBoard();
            currentPlayer = player; 

            while (true) {
                printBoard();

                if (currentPlayer == player) {
                    playerTurn();
                } else {
                    computerTurn();
                }

                if (checkWin()) {
                    printBoard();
                    if (currentPlayer == player) {
                        playerWins++; 
                        System.out.println("Player wins round " + round);
                    } else {
                        computerWins++; 
                        System.out.println("Computer wins round " + round);
                    }
                    break; 
                }

                if (isBoardFull()) {
                    printBoard();
                    System.out.println("Round " + round + " is a draw!");
                    break; 
                }

                switchPlayer();
            }
        }

        System.out.println("Player wins: " + playerWins + " rounds.");
        System.out.println("Computer wins: " + computerWins + " rounds.");
        
        if (playerWins > computerWins) {
            System.out.println("Player is the winner in " + playerWins + " rounds!");
        } else if (computerWins > playerWins) {
            System.out.println("Computer is the winner in " + computerWins + " rounds!");
        } else {
            System.out.println("The game is a draw!");
        }
    }

    public static void playerTurn() {
        int position;

        while (true) {
            System.out.print("Enter your position (1-9): ");

            try {
                position = input.nextInt(); 
                if (position >= 1 && position <= 9 && isValidPosition(position)) {
                    chosePosition(position, player); 
                    break;
                } else {
                    System.out.println("Invalid position");
                }
            } catch (InputMismatchException e) {
                input.next(); 
                System.out.println("Error: Please enter a number.");
            }
        }
    }

    public static void computerTurn() {
        Random rand = new Random(); 
        int position; 

        while (true) {
            position = rand.nextInt(9) + 1; 
            if (isValidPosition(position)) {
                chosePosition(position, computer); 
                System.out.println("Computer chose position " + "[ " + position + " ]");
                break; 
            }
        }
    }

    public static void positionsBoard() {
        int position = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = position++; 
            }
        }
    }

    public static void printBoard() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-----------------------| TIC TAC TOE GAME |------------------------");
        System.out.println("-------------------------------------------------------------------\n");
        for (int i = 0; i < 3; i++) {
            System.out.print("===========================| ");
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == player) {
                    System.out.print(" X ");
                } else if (board[i][j] == computer) {
                    System.out.print(" O ");
                } else {
                    System.out.print("[" + board[i][j] + "]");
                }
            }
            System.out.print(" |===========================\n");
            System.out.println();
        }
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != player && board[i][j] != computer) {
                    return false; 
                }
            }
        }
        return true; 
    }

    public static boolean isValidPosition(int position) {
        int row = (position - 1) / 3; 
        int col = (position - 1) % 3; 
        return board[row][col] != player && board[row][col] != computer; 
    }

    public static void chosePosition(int position, char player) {
        int row = (position - 1) / 3; 
        int col = (position - 1) % 3; 
        board[row][col] = player; 
    }

    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true; 
            }
        }

        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) || 
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true; 
        }

        return false;
    }

    public static void switchPlayer() { 
        currentPlayer = (currentPlayer == player) ? computer : player; 
    }
}
