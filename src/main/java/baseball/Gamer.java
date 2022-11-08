package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.*;
import static baseball.Util.*;

import java.util.ArrayList;
import java.util.List;

public class Gamer {
    public List<Integer> gamerNumber = new ArrayList<>();

    public void checkException(String input_Number){
        isWeirdSize(input_Number);
        isNumber(input_Number);
        isSameEachNumber(input_Number);
    }
    public void putInGamerNumber(int guess_number){
        gamerNumber.clear();
        gamerNumber.add(guess_number / 100);
        gamerNumber.add((guess_number % 100)/10);
        gamerNumber.add(guess_number % 10);
    }
    public void inputNumber(){
        System.out.print(INPUT_NUMBER);
        String input_number = Console.readLine();
        checkException(input_number);
        int guess_number = Integer.parseInt(input_number);
        putInGamerNumber(guess_number);
    }
    public boolean inputRestartNumber(){
        String restart_number = Console.readLine();
        if(restart_number.equals(RESTART_BUTTON)){
            return false;
        }else if(restart_number.equals(FINISH_BUTTON)){
            return true;
        }else{
            throw new IllegalArgumentException();
        }
    }
}
