package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void checkInput(String input) {
        try {
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {
                    throw new IllegalAccessException();
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력을 받는 부분
        String input;
        Boolean replay = true;
        // 인풋 판별, 이것은 app 단에서 static 메소드로 구현
        // 그 이후에 정상이면 input을 게임 구현한 클래스에서 돌리자
        while (replay) {
            input = Console.readLine();
            checkInput(input);
            // 여기서 baseball 클래스에서 게임구현

        }

    }
}