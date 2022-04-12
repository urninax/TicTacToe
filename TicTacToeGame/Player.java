package TicTacToeGame;

import java.util.LinkedList;
import java.util.List;

public class Player extends Field{ // game logic
    private final String value;
    private String[][] field;

    public Player(String value){
        this.value = value;
    }

    public String placeValue(int position){
        Field fieldObj = new Field();
        this.field = fieldObj.getField();
        if(position > 10 || position <0){
            System.out.println("Invalid field");
            return "false";
        }
        if(position<=3){
            this.field[0][position-1] = value;
        }else if(position>3 && position <= 6){
            this.field[1][position-4] = value;
        }else{
            this.field[2][position-7] = value;
        }

        fieldObj.setField(this.field);

        if(checkVoid().equals("novoid"))
            return "zeroVoid";
        String isEndResult = checkCombinations();
        if(isEndResult.equals("end")){
            return "end";
        }
        return "true";
    }

    public String checkCombinations(){ //checks if the line (horizontal/vertical/diagonal) was filled
        String[][] combinations = new String[][]{{"1","2","3"}, {"4","5","6"}, {"7","8","9"}, {"1","5","9"}, {"3","5","7"}, {"1","4","7"}, {"2","5","8"}, {"3","6","9"}};
        List<String> values = new LinkedList<>();
        int count = 1;

        for(String[] strings : this.field){
            for(String string : strings){
                if(string.equals(value)){
                    values.add(String.valueOf(count));
                }
                count++;
            }
        }

        boolean firstValue = false;
        boolean secondValue = false;
        boolean thirdValue = false;

        for(String[] combination : combinations){
            if(values.contains(combination[0])){
                firstValue = true;
            }
            if(values.contains(combination[1])){
                secondValue = true;
            }
            if(values.contains(combination[2])){
                thirdValue = true;
            }
            if(firstValue && secondValue && thirdValue){
                return "end";
            }else{
                firstValue = false;
                secondValue = false;
                thirdValue = false;
            }
        }

        return "true";
    }

    public String checkVoid(){
        for(String[] strings : field){
            for(String string : strings){
                if(string.equals(" ")){
                    return "true";
                }
            }
        }
        return "novoid";
    }

    @Override
    public void setField(String[][] field){
        this.field = field;
    }

    @Override
    public String[][] getField(){
        return field;
    }
}
