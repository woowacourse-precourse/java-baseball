package baseball;

import baseball.utils.validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class numberScan {

    public List<Integer> playerGames(){
        List<Integer> insertNum = new ArrayList<>();
        String input = Console.readLine();
        if(!validation.userInputValidation(input)){
            throw new IllegalArgumentException();
        }
        insertNum = stringToListNumber(input);
        return insertNum;
    }
    public List<Integer> stringToListNumber(String input) {
        List<Integer> Game = new ArrayList<>();
        for(int i=0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            Game.add(digit);
        }
        return Game;
    }

    public boolean decideContinue(){
        System.out.println("다시 하시겠습니까? 재시작 : 1 , 종료 :2");
        String input = Console.readLine();
        validation.startOrEndValidation(input);
        char inputChar = input.charAt(0);
        if(inputChar == '1'){
            return true;
        }
        else{
            return false;
        }
    }
}
