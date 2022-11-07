package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;


public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        getUserAnswer(getInputString());


    }

    private static String getInputString() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    protected static List<Integer> getUserAnswer(String userAnswer) throws IllegalArgumentException {
        if (userAnswer.length() != 3) {
            throw new IllegalArgumentException("숫자 3개를 입력해야 함");
        }

        if (userAnswer.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자여야 함");
        }

        return userAnswer.chars()
                .map(c -> {
                    if (c < '0' || c > '9') {
                        throw new IllegalArgumentException("숫자가 아닌 문자");
                    }
                    return c-'0';
                })
                .boxed()
                .collect(Collectors.toList());
    }
}
