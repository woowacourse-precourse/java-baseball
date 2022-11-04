package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println(Comment.STARTGAME);
        ComputerList.initialize();

        while (true) {
            System.out.print(Comment.INPUTNUMBER);

            // 입력받기
            String inputStr = Console.readLine();
            validateInput(inputStr);
            ArrayList<Integer> inputList = stringToList(inputStr);

            // 로직
            Map<Hint, Integer> hintCountMap = ComputerList.compare(inputList);

            // 출력
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
    private static Map<Hint, Integer> hintCountMap;

    private ComputerList() {
    }

    public static void initialize() {
        list = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        generateHintMap();
    }

    public static Map<Hint, Integer> compare(ArrayList<Integer> inputList) {
        validateList(inputList);
        for (int index = 0; index < inputList.size(); index++) {
            eachValueMatching(index, list.get(index));
        }
        return hintCountMap;
    }

    private static void eachValueMatching(int index, Integer value) {
        if (list.contains(value) && list.get(index) == value) {
            Integer before = hintCountMap.get(Hint.STRIKE);
            hintCountMap.put(Hint.STRIKE, before + 1);
        } else if (list.contains(value)) {
            Integer before = hintCountMap.get(Hint.BALL);
            hintCountMap.put(Hint.BALL, before + 1);
        } else {
            Integer before = hintCountMap.get(Hint.MISS);
            hintCountMap.put(Hint.MISS, before + 1);
        }
    }


    private static Map<Hint, Integer> generateHintMap() {
        Map<Hint, Integer> hintCountMap = new HashMap<>();
        hintCountMap.put(Hint.STRIKE, 0);
        hintCountMap.put(Hint.BALL, 0);
        hintCountMap.put(Hint.MISS, 0);
        return hintCountMap;
    }

    private static void validateList(ArrayList<Integer> inputList) {
        if (list == null || inputList == null) {
            throw new IllegalArgumentException("리스트 값이 유효하지 않습니다.");
        }
    }
}

class Comment {
    final static String STARTGAME = "숫자 야구 게임을 시작합니다.";
    final static String ENDGAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final static String REGAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final static String INPUTNUMBER = "숫자를 입력해주세요 : ";
}

enum Hint {
    STRIKE, BALL, MISS
}