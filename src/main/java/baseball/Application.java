package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<String> playerInput = checkAvailable(Input());
    }

    public static List<String> Input() {
        System.out.print("숫자를 입력해 주세요 : ");
        String numString = Console.readLine();
        List<String> numList = new ArrayList<>(Arrays.asList(numString.split("")));
        return numList;
    }

    public static List<String> checkAvailable(List<String> numList) {
        if (numList.size() != 3) {
            throw new IllegalArgumentException();
        }
        for (String num : numList) {
            if (num.charAt(0) < '1' || num.charAt(0) > '9') {
                throw new IllegalArgumentException();
            }
        }
        Set<String> numSet = new HashSet<>(numList);
        if (numSet.size() != 3) {
            throw new IllegalArgumentException();
        }

        return numList;
    }
}
