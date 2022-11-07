package baseball;

import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    private List<Integer> computerNumbersList;
    private List<Integer> playerNumbersList;
    private boolean again = true;


    public void playBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(again) {
            computerNumbersList = makesComputerNumbers();
            String result = "";
            while (!result.equals("3스트라이크")) {
                playerNumbersList = inputPlayerNumbers();
                result = judgeScore();
                System.out.println(result);
            }
            again = playAgain();
        }
    }

    private boolean playAgain() throws UnvailedNumberException {
        System.out.println("3개의 숫자를 모두 맞치셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer yesOrNo = Integer.parseInt(readLine());
        if (yesOrNo < 1 || 2 < yesOrNo) {
            throw new UnvailedNumberException();
        }
        if (yesOrNo == 1) {
            return true;
        }
        return false;
    }

    private List<Integer> inputPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        List<String> playerNumbersList = StringToList(readLine());
        List<Integer> playerNumbersIntegerList = playerNumbersList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return playerNumbersIntegerList;
    }

    private List<String> StringToList(String playerNumbers) throws UnvailedNumberException {
        List<String> playerNumbersList = new ArrayList<>(Arrays.asList(playerNumbers.split("")));
        if (checkScopeOfNumbers(playerNumbers) || checkSameNumbers(playerNumbersList)) {
            throw new UnvailedNumberException();
        }
        return playerNumbersList;
    }

    private boolean checkScopeOfNumbers(String playerNumbers) {
        Integer number = Integer.parseInt(playerNumbers);
        if (number < 123 || 987 < number) {
            return true;
        }
        return false;
    }

    private boolean checkSameNumbers(List<String> playerNumbersList) {
        Set<String> playerNumbersSet = new HashSet<>(playerNumbersList);
        if (playerNumbersSet.size() != 3) {
            return true;
        }
        return false;
    }

    private List<Integer> makesComputerNumbers() {
        List<Integer> computerNumbersList = new ArrayList<>();
        while (computerNumbersList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbersList.contains(randomNumber)) {
                computerNumbersList.add(randomNumber);
            }
        }
        return computerNumbersList;
    }

    private Integer CompareNumbers(List<Integer> computerNumbersList, List<Integer> playerNumbersList) {
        int result = 0;
        for (int i = 0; i < playerNumbersList.size(); i++) {
            if (computerNumbersList.contains(playerNumbersList.get(i))) {
                result++;
            }
        }
        return result;
    }

    private Integer countStrike(List<Integer> computerNumbersList, List<Integer> playerNumbersList) {
        int countStrike = 0;
        for (int i = 0; i < playerNumbersList.size(); i++) {
            if (computerNumbersList.get(i) == playerNumbersList.get(i)) {
                countStrike++;
            }
        }
        return countStrike;
    }

    private String judgeScore() {
        Integer totalScore = CompareNumbers(computerNumbersList, playerNumbersList);
        Integer strikeScore = countStrike(computerNumbersList, playerNumbersList);
        Integer ballScore = totalScore - strikeScore;
        return printScore(strikeScore, ballScore);
    }

    private String printScore(Integer strikeScore, Integer ballScore) {
        if (strikeScore == 0 && ballScore == 0) {
            return "낫싱";
        } else if (strikeScore == 0) {
            return ballScore + "볼";
        } else if (ballScore == 0) {
            return strikeScore + "스트라이크";
        }
        return ballScore + "볼 " + strikeScore + "스트라이크";
    }
}

