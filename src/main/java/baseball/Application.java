package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(Comment.STARTGAME);
        ComputerList.initialize();

        while (true) {
            // 입력하기
            System.out.print(Comment.INPUTNUMBER);
            String inputStr = Console.readLine();
            validateInput(inputStr);

            ArrayList<Integer> inputList = stringToList(inputStr);
        }
    }

    private static ArrayList<Integer> stringToList(String inputStr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            int number = Integer.parseInt(inputStr.charAt(i) + "");
            list.add(number);
        }
        return list;
    }

    private static void validateInput(String input) {
        String tmpInput = input.trim();

        if (tmpInput.length() != 3) {
            throw new IllegalArgumentException("3자리 수 를 입력해주세요.");
        }

        String numberOnlyRegex = "^[0-9]+$";
        boolean matches = tmpInput.matches(numberOnlyRegex);
        if (!matches) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}

class ComputerList {
    private static List<Integer> list;

    private ComputerList() {
    }

    public static void initialize() {
        list = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public static List<Hint> compareTo(List<Integer> input) {
        List<Hint> hintArr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Hint hint = checkInputValue(i, input.get(i));
            hintArr.add(hint);
        }
        return hintArr;
    }

    private static Hint checkInputValue(Integer index, Integer value) {
        if (list.contains(value) && (list.indexOf(value) == index)) {
            return Hint.STRIKE;
        } else if (list.contains(value)) {
            return Hint.BALL;
        }
        return Hint.MISS;
    }
}

class Comment {
    final static String STARTGAME = "숫자 야구 게임을 시작합니다.";
    final static String ENDGAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final static String REGAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final static String INPUTNUMBER = "숫자를 입력해주세요 : ";
}

enum Hint {
    BALL,
    STRIKE,
    MISS
}
