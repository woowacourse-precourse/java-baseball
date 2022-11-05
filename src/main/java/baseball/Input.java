package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputNumber = Console.readLine();

        return userInputNumber;
    }

}
