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

    public static void isInputFormat(String userInput) throws IllegalArgumentException {
        String pattern = "^[1-9]{3}$";
        String[] splitArray = userInput.split("");
        Set<String> numberSet = new HashSet<>(List.of(splitArray));
        if (splitArray.length != numberSet.size()) {
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력해주세요.");
        }
        if (!userInput.matches(pattern)) {
            throw new IllegalArgumentException("1-9사이의 3자리 숫자를 입력해주세요.");
        }
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
        boolean allStrike = false;
        strike = scoreMap.get("스트라이크");
        ball = scoreMap.get("볼");
        if ((strike > 0) && (ball > 0)) {
            System.out.printf("%d볼 %d스트라이크%n",ball,strike);
        } else if ((strike > 0) && (ball == 0)) {
            System.out.printf("%d스트라이크%n", strike);
            if (strike == 3) {
                allStrike = true;
            }
        } else if ((strike == 0) && (ball > 0)) {
            System.out.printf("%d볼%n", ball);
        } else {
            System.out.println("낫싱");
        }
        return allStrike;
    }

    public static boolean setGameSetting() throws IllegalArgumentException {
        boolean gameSetting;
        String gameChoice = Console.readLine();
        if (gameChoice.equals("1")) {
            gameSetting = true;
        } else if (gameChoice.equals("2")) {
            gameSetting = false;
        } else {
            throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
        }
        return gameSetting;
    }

    public static void startGame(List<Integer> computerNumber) throws IllegalArgumentException {
        String guessNumber;
        boolean stopPoint = true;
        boolean gamePoint;
        List<Integer> splitUserNumber;
        Map<String, Integer> scoreMap;
        System.out.println(computerNumber);
        while(stopPoint) {
            System.out.print("숫자를 입력해주세요 : ");
            guessNumber = Console.readLine();
            isInputFormat(guessNumber);
            splitUserNumber = covertStringIntoInteger(guessNumber);
            scoreMap = countScore(splitUserNumber, computerNumber);
            gamePoint = printScore(scoreMap); //false
            if (gamePoint) {
                computerNumber = stopOrRestart();
            }
            if (computerNumber.isEmpty()) {
                stopPoint = false;
            }
        }
    }

    public static List<Integer> stopOrRestart() throws IllegalArgumentException {
        List<Integer> computerNumberArray = new ArrayList<>();
        boolean setPoint;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        setPoint = setGameSetting();
        if (setPoint) {
            computerNumberArray = pickComputerNumber();
            System.out.println(computerNumberArray);
        }
        return computerNumberArray;
    }

    public static List<Integer> covertStringIntoInteger(String input) {
        List<Integer> splitNumberArray = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return splitNumberArray;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumber = pickComputerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame(computerNumber);

    }
}