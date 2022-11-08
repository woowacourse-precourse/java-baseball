package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private List<Character> computerNumber = new ArrayList<>();
    public static final int DIGIT = 3;

    public ComputerNumber(){
        generateComputerNumber();
    }
    public List<Character> getComputerNumber(){
        return computerNumber;
    }

    public void generateComputerNumber(){
        List<Character> numberList = new ArrayList<>();
        while(numberList.size() < DIGIT){
            addNumber(getRandomNumber(), numberList);
        }
        this.computerNumber = numberList;
    }

    public void addNumber(char number, List<Character> numberList){
        if(!numberList.contains(number)){
            numberList.add(number);
        }
    }

    public static Character getRandomNumber(){
        return (char)(Randoms.pickNumberInRange(1, 9)+'0');
    }
}
