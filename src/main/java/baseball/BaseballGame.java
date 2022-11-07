package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    List<Integer> computerNumbersList = makesComputerNumbers();
    List<Integer> playerNumbersList =

    public void playBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String playerNumbers = readLine();  // 어레이리스트로 변환하기

        }
    }

    private List<Integer> inputPlayerNumbers() {
        String playerNumbers = readLine();
        List<Integer> playerNumbersList = new ArrayList<>();
        try {
            StringToList(readLine());
        } catch (UnvailedNumberException e) {
        }

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
}

