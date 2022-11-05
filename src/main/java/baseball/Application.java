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

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = application.createRandomNumbersInList();
        System.out.print("숫자를 입력해주세요 : ");
        player = application.getPlayerNumberInList();

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
        return playerNumberList;
    }
}
