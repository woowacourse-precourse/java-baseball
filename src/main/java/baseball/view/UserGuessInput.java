package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class UserGuessInput{

    public String processGuess(){
        System.out.println("숫자를 입력해주세요:");
        String inputString = Console.readLine();
        return inputString;
    }

}