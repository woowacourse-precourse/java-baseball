package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    public Input() {

    }

    public List<String> getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<String> input = Arrays.asList(Console.readLine().split(""));
        if(input.size()!=3 || input.size() != input.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public Boolean continuePlay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(input.equals("1")) {
            return true;
        } else if(input.equals("2")) {
            return false;
        }

        System.out.println("1과 2중에서만 입력하세요.");
        throw new IllegalArgumentException();
    }
}
