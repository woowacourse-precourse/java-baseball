package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public ArrayList<Integer> userNumbers;

    public void getUserNumbers() {
        String numbers = Console.readLine();
        this.userNumbers = parseStringToInt(numbers);
    }

    public ArrayList<Integer> parseStringToInt(String numbers){
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        for(int i=0;i<numbers.length();i++){
            inputNumbers.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
        }
        return inputNumbers;
    }

}
