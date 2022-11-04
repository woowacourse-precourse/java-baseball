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
        Computer.gameInitialize();

        while (true) {
            System.out.print(Comment.INPUTNUMBER);

            String inputStr = Console.readLine();
            validateInput(inputStr);

            ArrayList<Integer> inputList = stringToList(inputStr);
            Computer.compare(inputList);
            Computer.printHint();
            Computer.checkResult();

            if (Computer.getGameResult()) {
                restartQeustion();
                Computer.gameInitialize();
            }
        }
    }

    private static void restartQeustion() {
        System.out.println(Comment.REGAME);
        String restartInput = Console.readLine();
        validateInput(restartInput);

        if (restartInput.equals("1")) {
            Computer.setRestartFlag(true);
        }

        if (restartInput.equals("2")) {
            Computer.setRestartFlag(false);
        }

        throw new IllegalArgumentException("1 과 2 중 선택해야합니다.");
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

        String numberOnlyRegex = "^[0-9]+$";
        boolean matches = tmpInput.matches(numberOnlyRegex);
        if (!matches) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}

class Computer {
    private static List<Integer> answerList;
    private static Map<Hint, Integer> hintCountMap;
    private static Boolean gameResult;
    private static Boolean restartFlag;
    private Computer() {
    }

    public static void gameInitialize() {
        answerInitialize();
        hintCountInitialize();
        gameResult = false;
        restartFlag = false;
    }

    public static void compare(ArrayList<Integer> inputList) {
        validateList(inputList);
        for (int index = 0; index < inputList.size(); index++) {
            eachValueMatching(index, answerList.get(index));
        }
    }

    private static void answerInitialize() {
        answerList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    private static Map<Hint, Integer> hintCountInitialize() {
        Map<Hint, Integer> hintCountMap = new HashMap<>();
        hintCountMap.put(Hint.STRIKE, 0);
        hintCountMap.put(Hint.BALL, 0);
        hintCountMap.put(Hint.MISS, 0);
        return hintCountMap;
    }

    private static void eachValueMatching(int index, Integer value) {
        if (answerList.contains(value) && answerList.get(index).equals(value)) {
            Integer before = hintCountMap.get(Hint.STRIKE);
            hintCountMap.put(Hint.STRIKE, before + 1);
        } else if (answerList.contains(value)) {
            Integer before = hintCountMap.get(Hint.BALL);
            hintCountMap.put(Hint.BALL, before + 1);
        } else {
            Integer before = hintCountMap.get(Hint.MISS);
            hintCountMap.put(Hint.MISS, before + 1);
        }
    }

    private static void validateList(ArrayList<Integer> inputList) {
        if (answerList.size() != 3) {
            throw new IllegalArgumentException("3자리 수 를 입력해주세요.");
        }

        if (answerList == null || inputList == null) {
            throw new IllegalArgumentException("리스트 값이 유효하지 않습니다.");
        }
    }

    public static Map<Hint, Integer> getHintCountMap() {
        return hintCountMap;
    }

    public static void printHint() {
        Integer ballCount = hintCountMap.get(Hint.BALL);
        Integer strikeCount = hintCountMap.get(Hint.STRIKE);
        String hintStr = null;

        if (ballCount == 0 && strikeCount == 0) {
            hintStr = "낫싱";
        } else if (ballCount != 0 && strikeCount == 0) {
            hintStr = String.format("%d볼", ballCount);
        } else if (ballCount == 0 && strikeCount != 0) {
            hintStr = String.format("%d스트라이트", strikeCount);
        } else if (ballCount != 0 && strikeCount != 0) {
            hintStr = String.format("%d볼 %d스트라이크",ballCount,strikeCount)
        }

        System.out.println(hintStr);
    }

    public static void checkResult() {
        if (hintCountMap.get(Hint.STRIKE).equals(3)) {
            gameResult = true;
            System.out.println(Comment.ENDGAME);
        }
        hintCountInitialize();
    }

    public static Boolean getGameResult() {
        return gameResult;
    }

    public static Boolean getRestartFlag() {
        return restartFlag;
    }

    public static void setRestartFlag(Boolean restartFlag) {
        Computer.restartFlag = restartFlag;
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