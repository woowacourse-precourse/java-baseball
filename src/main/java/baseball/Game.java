package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    static final int SIZE = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;

    public int getRandomNumber() {
        int number = 0;

        for (int i = 0; i < SIZE; i++){
            number *= 10;
            number += Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        }

        return number;
    }

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
    }
}
