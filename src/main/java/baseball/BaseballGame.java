package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.security.interfaces.RSAKey;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    public void playGame() {
        do {
            startGame();
        } while (reGame());
    }

    public void startGame() {
        Computer computer = new Computer();
        Result result;
        String randomBall = computer.makeRandomBall();

        do {
            result = Result.compareBall(getUserInputNumber(), randomBall);
            printResult(result);
        } while (!Result.isAllStriek);
    }

    private boolean reGame() {
        String doReGame = getUserInputRegame();

        return doReGame.equals("1");
    }
    public String getUserInput(){
        return readLine();
    }
    public String getUserInputNumber(){
        System.out.print("숫자를 입력해 주세요 : ");

        String s = validateUserInputNum(getUserInput());
        System.out.println(s);
        return s;
    }

    private String validateUserInputNum(String userInput) {
       if(userInput.length() != 3){
           throw new IllegalArgumentException("세자리 숫자를 입력하세요.");
       }

       if(!isDigits(userInput)){
           throw new IllegalArgumentException("숫자를 제외한 다른 문자는 입력이 불가능합니다.");
       }

       if(!checkDuplicate(userInput)){
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
       }

       return userInput;
    }

    public boolean isDigits(String userInput){
        for(char digit : userInput.toCharArray()){
            if(!Character.isDigit(digit)){
                return false;
            }
        }

        return true;
    }

    private boolean checkDuplicate(String userInput) {
        Set <String> checkDuplicateSet = new HashSet <>(List.of(userInput.split("")));

        return checkDuplicateSet.size() == 3;
    }

    public String getUserInputRegame() {
        System.out.println("재시작을 하려면 1을, 게임을 종료하려면 2를 눌러주세요. : ");

        return validateUserInputRegame(getUserInput());
    }

    private String validateUserInputRegame(String userInput) {
        if(!(userInput.equals("1") || !userInput.equals("2"))) {
            throw new IllegalArgumentException("1, 2만 입력 가능합니다. 다시 입력해 주세요.");
        }

        return userInput;
    }
}
