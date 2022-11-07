package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static List<Integer> pickComputerNumber () {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void isInputFormat() {
        String pattern = "^[1-9]{3}$";
        try {
            String guessNumber = Console.readLine();
            if (!guessNumber.matches(pattern)) {
                throw new IllegalArgumentException();
            } else if (!compareNumber(guessNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    public static boolean compareNumber(String number) {
        String[] splitArray = number.split("");
        Set<String> numberSet = new HashSet<>(List.of(splitArray));
        return splitArray.length == numberSet.size();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumber = pickComputerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        isInputFormat();

    }
}
