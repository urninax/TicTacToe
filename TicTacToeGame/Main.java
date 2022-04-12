package TicTacToeGame;

import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Field field = new Field();
        field.fillField();
        field.printDemonstrativeField();
        Random random = new Random();
        int i = random.nextInt(2-1)+1;

        Player player1 = new Player("X");
        Player player2 = new Player("O");

        String result = "true";
        Scanner scanner = new Scanner(System.in);

        //players turns
        while(true){
            if(i == 1){
                while(result.equals("false")){
                    System.out.println("Player 1 turn. He plays by a cross.");
                    int pos = scanner.nextInt();
                    result = player1.placeValue(pos);
                    i=2;
                    field.printField();
                    switch(result){
                        case "end":
                            System.out.println("Game over. Player 1 won!");
                            return;
                        case "zeroVoid":
                            System.out.println("Game over. Draw");
                            return;
                    }
                }
            }else{
                while(result.equals("false")){
                    System.out.println("Player 2 turn. He plays by a zero.");
                    int pos = scanner.nextInt();
                    result = player2.placeValue(pos);
                    i=1;
                    field.printField();
                    switch(result){
                        case "end":
                            System.out.println("Game over. Player 2 won!");
                            return;
                        case "zeroVoid":
                            System.out.println("Game over. Nobody won");
                            return;
                    }
                }
            }
            result = "false";
        }
    }
}

