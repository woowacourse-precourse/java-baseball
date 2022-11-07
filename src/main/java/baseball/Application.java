package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

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

    public static boolean isInputFormat(String userInput) {
        String pattern = "^[1-9]{3}$";
        try {
            if (!userInput.matches(pattern)) {
                throw new IllegalArgumentException();
            } else if (!compareNumber(userInput)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return true;
    }

    public static boolean compareNumber(String number) {
        String[] splitArray = number.split("");
        Set<String> numberSet = new HashSet<>(List.of(splitArray));
        return splitArray.length == numberSet.size();
    }

    public static Map<String, Integer> countScore(List<Integer> userInput, List<Integer> computerInput) {
        int searchIndex, score;
        Map<String, Integer> scoreMap = new HashMap<>() {{
            put("스트라이크", 0);
            put("볼", 0);
        }};
        for (int index=0; index < computerInput.size(); index++) {
            searchIndex = userInput.indexOf(computerInput.get(index));
            if (searchIndex == index) {
                score = scoreMap.get("스트라이크");
                scoreMap.put("스트라이크", score+1);
            }
            if ((searchIndex != index) && (searchIndex != -1)) {
                score = scoreMap.get("볼");
                scoreMap.put("볼", score+1);
            }
        }
        return scoreMap;
    }

    public static boolean printScore(Map<String, Integer> scoreMap) {
        int strike, ball;
        boolean endPoint = false;
        strike = scoreMap.get("스트라이크");
        ball = scoreMap.get("볼");

        if ((strike > 0) && (ball > 0)) {
            System.out.printf("%d볼%d스트라이크%n",ball,strike);
        } else if ((strike > 0) && (ball == 0)) {
            System.out.printf("%d스트라이크%n", strike);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                endPoint = setGameSetting();
            }
        } else if ((strike == 0) && (ball > 0)) {
            System.out.printf("%d볼%n", ball);
        } else {
            System.out.println("낫싱");
        }
        return endPoint;
    }

    public static boolean setGameSetting() {
        boolean gameSetting;
        String gameChoice = Console.readLine();
        if (gameChoice.equals("1")) {
            gameSetting = true;
        } else if (gameChoice.equals("2")) {
            gameSetting = false;
        } else {
            throw new IllegalArgumentException();
        }
        return gameSetting;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String guessNumber;
        List<Integer> splitNumberArray = new ArrayList<>();
        List<Integer> computerNumber = pickComputerNumber();
        Map<String, Integer> scoreMap;

        System.out.println(computerNumber);

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        guessNumber = Console.readLine();
        if (isInputFormat(guessNumber)) {
            splitNumberArray = Arrays.stream(guessNumber.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        scoreMap = countScore(splitNumberArray, computerNumber);
        printScore(scoreMap);
    }
}
