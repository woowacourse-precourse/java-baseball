package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {


    public String userInput() {
        String userInput = readLine();

        return inputValidtor(userInput);
    }

    public static String inputValidtor(String inputValue) {


        if (inputValue.length() != 3) {
            throw new IllegalArgumentException("3자리 양식에 맞게 입력하세요");
        }
        return inputValue;
    }

}


