package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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

    int[] hintResult(Game answer, Game rightAnswer) {
        int nowNumber;


        for (int i = 0; i < 3; i++) {
            nowNumber = answer.number[i];

            if (!Array.isArrayContains(rightAnswer.number, nowNumber)) {
                continue;
            }
            if (i == Array.inputIndexValue(rightAnswer.number, nowNumber)) {
                this.strike++;
                continue;
            }
            this.ball++;
        }
        return new int[]{ball, strike};
    }
}