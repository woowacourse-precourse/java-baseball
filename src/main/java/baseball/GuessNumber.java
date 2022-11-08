package baseball;

import java.util.ArrayList;
import java.util.List;

public class GuessNumber {
    private List<Character> guessNumber = new ArrayList<>();

    public List<Character> getGuessNumber(){
        return guessNumber;
    }

    public void setGuessNumber(ArrayList<Character> guessNumber){
        if(!(checkDigit(guessNumber) && checkDuplicate(guessNumber) && isNumber(guessNumber))){
            throw new IllegalArgumentException();
        }
        this.guessNumber = guessNumber;
    }

    public static ArrayList<Character> stringToList(String guessNumber){
        ArrayList<Character> guessNumList = new ArrayList<>();

        for(int i = 0; i < guessNumber.length(); i++){
            guessNumList.add(guessNumber.charAt(i));
        }
        return guessNumList;
    }

    public static boolean checkDigit(ArrayList<Character> guessNumber){
        return (guessNumber.size() == ComputerNumber.DIGIT);
    }

    public static boolean checkDuplicate(ArrayList<Character> guessNumber){
            return (guessNumber.size() == guessNumber.stream().distinct().count());
    }

    public static boolean isNumber(ArrayList<Character> guessNumber){

        for(int i = 0; i < guessNumber.size(); i++){
            if(!Character.isDigit(guessNumber.get(i))){
                return false;
            }
        }
        return true;
    }
}
