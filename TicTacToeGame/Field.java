package TicTacToeGame;

import java.util.Arrays;

public class Field{
    private static String[][] field = new String[3][3];
    private static final String[][] demonstrativeField = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    public void setField(String[][] field){
        Field.field = field;
    }

    public void fillField(){
        for(String[] strings : field){
            Arrays.fill(strings, " ");
        }
    }

    public void printField(){
        for(int i = 0; i < field.length; i++){
            System.out.println(field[i][0]+" | "+field[i][1]+" | "+field[i][2]);
            if(i != 2)
                System.out.println("---------");
        }
    }

    public void printDemonstrativeField(){
        for(int i = 0; i < demonstrativeField.length; i++){
            System.out.println(demonstrativeField[i][0]+" | "+demonstrativeField[i][1]+" | "+demonstrativeField[i][2]);
            if(i != 2)
                System.out.println("---------");
        }
    }

    public String[][] getField(){
        return field;
    }
}
