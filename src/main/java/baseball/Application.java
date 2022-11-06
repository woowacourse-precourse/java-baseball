package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // 상대방(컴퓨터)의 입력 숫자
        String computer = "";
        while(computer.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            char randomNumberToChar = (char)(randomNumber + '0');
            if(computer.contains(Character.toString(randomNumberToChar)))
                computer += randomNumberToChar;
        }

        // 유저의 입력들
        for (String userInput : args) {

        }
    }
}
