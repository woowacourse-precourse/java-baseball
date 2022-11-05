package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            String stringQuizNumber = getStringQuizNumber();
            while(true) {
                String getUserInput = getUserInput();
                System.out.println(getUserInput);
            }
        }
    }

    private static String getUserInput() {
        String userInput = readLine();
        if (validateUserInput(userInput)){
            return userInput;
        }else{
            throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 숫자 3자리만 입력해주세요");
        }
    }

    private static boolean validateUserInput(String userInput) {
        if (userInput.length() != 3){
            return false;
        }

        List<Integer> numberList = new ArrayList<>();

        for (int idx = 0; idx < userInput.length(); idx++) {
            int eachNum = userInput.charAt(idx) - '0';

            if (eachNum < 1 || eachNum > 9) {
                return false;
            }

            if(!numberList.contains(eachNum)){
                numberList.add(eachNum);
            }else{
                return false;
            }
        }

        return true;
    }

    public static String getStringQuizNumber() {
        List<Integer> quizEachNumList = new ArrayList<>();

        while (quizEachNumList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!quizEachNumList.contains(randomNumber)) {
                quizEachNumList.add(randomNumber);
            }
        }

        StringBuilder returnString = new StringBuilder();
        for (Integer integer : quizEachNumList) {
            returnString.append(integer);
        }

        return returnString.toString();
    }
}
