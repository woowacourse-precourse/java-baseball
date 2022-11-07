package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean playing = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (playing) {
            computer = application.createRandomNumbersInList();
            do {
                System.out.print("숫자를 입력해주세요 : ");
                player = application.getPlayerNumberInList();
                result = application.computeResult(computer, player);
                application.printResult(result);
            } while (result.get(1) < 3);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            playing = application.actWhenGameFinish(Console.readLine());
        }
    }

    public List<Integer> createRandomNumbersInList() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public List<Integer> getPlayerNumberInList() {
        String playerNumber = Console.readLine();
        List<Integer> playerNumberList =
                Arrays.stream(playerNumber.split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        validatePlayerNumber(playerNumberList);
        return playerNumberList;
    }

    public void validatePlayerNumber(List<Integer> playerNumberList) {
        if (playerNumberList.size() != 3) {
            throw new IllegalArgumentException("the number should be a 3 digit number");
        }
        for (int i = 0; i < 3; i++) {
            if (playerNumberList.get(i) < 1 | playerNumberList.get(i) > 9) {
                throw new IllegalArgumentException("each digit cannot be out of range 1 to 9");
            }
        }
        if (playerNumberList.size() != playerNumberList.stream().distinct().count()) {
            throw new IllegalArgumentException("each digit should be different");
        }
    }

    public List<Integer> computeResult(
            List<Integer> computerNumberList,
            List<Integer> playerNumberList) {
        List<Integer> resultList = new ArrayList<>(Arrays.asList(0, 0));
        for (int i = 0; i < computerNumberList.size(); i++) {
            int index = playerNumberList.indexOf(computerNumberList.get(i));
            if (index < 0) {
                continue;
            } else if (index != i) {
                resultList.set(0, resultList.get(0) + 1);
            } else {
                resultList.set(1, resultList.get(1) + 1);
            }
        }
        return resultList;
    }

    public void printResult(List<Integer> resultList) {
        String gameResult = "";
        if (resultList.get(0) > 0) {
            gameResult = gameResult + resultList.get(0).toString() + "볼 ";
        }
        if (resultList.get(1) > 0) {
            gameResult = gameResult + resultList.get(1).toString() + "스트라이크";
        }
        if (resultList.get(0) == 0 & resultList.get(1) == 0) {
            gameResult = gameResult + "낫싱";
        }
        System.out.println(gameResult);
    }

    public boolean actWhenGameFinish(String code) {
        if (code.equals("1")) {
            System.out.println("게임을 새로 시작합니다.");
            return true;
        } else if (code.equals("2")) {
            System.out.println("게임을 완전히 종료합니다.");
            return false;
        } else {
            throw new IllegalArgumentException("the code should be 1 or 2");
        }
    }
}
