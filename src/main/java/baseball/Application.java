package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        System.out.println(GAME_START);
        Game answer = new Game();
        Game.init(answer);
    }
}

/**
 * 정답값과 입력값 문자열 비교
 * 1. 포함여부
 * 2. 순서 확인
 */
class Array {
    static boolean isArrayContains(final int[] ar, final int num) {
        for (int value : ar) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    static int inputIndexValue(final int[] ar, final int value) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

class Game {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    int[] number = new int[3];

    Game() {
        int randomNum;
        int numberIndex = 0;

        while (numberIndex < 3) {
            randomNum = RandomNumber();

            if (!Array.isArrayContains(number, randomNum)) {
                number[numberIndex++] = randomNum;
            }
        }
    }

    private int RandomNumber() {
        return pickNumberInRange(1, 9);
    }

    Game(String str) {
        for (int i = 0; i < 3; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    public static void init(Game gameAnswer) {
        Game answer = Game.userAnswer();

        Hint hint = new Hint();
        int[] count = hint.hintResult(answer, gameAnswer);
        hint.hintMessage(count);

        if (hint.strike != 3) {
            Game.init(gameAnswer);
            return;
        }

        int newGameAnswer = Game.newGameStart();
        if (newGameAnswer == 1) {
            gameAnswer = new Game();
            Game.init(gameAnswer);
        }
    }

    static int newGameStart() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(NEW_GAME_CHECK_MESSAGE);

        String newGameAnswer = readLine();
        return Game.getNewGameAnswer(newGameAnswer);
    }

    static int getNewGameAnswer(String str) {
        int value;
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (value != 1 && value != 2) {
            throw new IllegalArgumentException();
        }

        return value;
    }

    static Game userAnswer() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String userInput = readLine();
        Game.checkInputValue(userInput);

        return new Game(userInput);
    }

    static void checkInputValue(final String str) {
        isEqualNumber(str);
        isInputNumber(str);
        isLengthThree(str);
    }

    static boolean isLengthThree(final String str) {
        if(str.length() != 3) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static boolean isInputNumber(String str) {
        for(int i=0;i<str.length();i++){
            isCharNumber(str, i);
        }
        return true;
    }

    static boolean isCharNumber(String str, int index) {
        if(!Character.isDigit(str.charAt(index))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static boolean isEqualNumber(String str) {
        char[] check = new char[str.length()];
        for(int i=0;i<str.length();i++) {
            check[i] = str.charAt(i);
        }
        isCharEqualNumber(check);
        return true;
    }

    static boolean isCharEqualNumber(char[] check) throws IllegalArgumentException {
        for(int i=0;i<check.length-1;i++){
            if(check[i] == check[i+1]){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}

class Hint {
    int ball;
    int strike;

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

        private void addBall() {
        this.ball++;
    }

    private void addStrike() {
        this.strike++;
    }

    int[] hintResult(Game answer, Game rightAnswer) {
        int nowNumber;

        for (int i = 0; i < 3; i++) {
            nowNumber = answer.number[i];

            if (!Array.isArrayContains(rightAnswer.number, nowNumber)) {
                continue;
            }
            if (i == Array.inputIndexValue(rightAnswer.number, nowNumber)) {
                addStrike();
                continue;
            }
            addBall();
        }
        return new int[]{ball, strike};
    }

    void hintMessage(int[] hint) {
        if(hint[0] != 0){
            System.out.print(hint[0] + BALL + " ");
        }
        if(hint[1] != 0){
            System.out.print(hint[1] + STRIKE + " ");
        }
        if(hint[0] == 0 && hint[1] == 0) {
            System.out.println(NOTHING);
        }
        System.out.println();
    }
}