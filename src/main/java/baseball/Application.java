package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static final int RANDOM_NUMBER_LENGTH = 3;
    static final int RANDOM_NUMBER_FIRST_RANGE = 1;
    static final int RANDOM_NUMBER_LAST_RANGE = 9;

    static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    static public void startGame() {
        String randomNumber = makeRandomNumber();
    }

    static public String makeRandomNumber() {
        String randomNumber = "";

        while (randomNumber.length() < RANDOM_NUMBER_LENGTH) {
            int randomDigit = Randoms.pickNumberInRange(RANDOM_NUMBER_FIRST_RANGE, RANDOM_NUMBER_LAST_RANGE);
            String randomWord = String.valueOf(randomDigit);
            if (!randomNumber.contains(randomWord)) {
                randomNumber += randomWord;
            }
        }

        return randomNumber;
    }

    static public String getUserGuessNumber() {
        System.out.print(REQUEST_INPUT_MESSAGE);
        String userGuessNumber = Console.readLine();
        return userGuessNumber;
    }

    public static void main(String[] args) {
        System.out.println(GAME_START_MESSAGE);
        startGame();
    }
}