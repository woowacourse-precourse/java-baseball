package baseball.Service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    public void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameInProgress() {
        List<Integer> computer = pickThreeNumbers();

        List<Integer> user = guessThreeNumbers();
    }

    public List<Integer> pickThreeNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public List<Integer> guessThreeNumbers() {
        List<Integer> user = new ArrayList<>();

        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (validateInput(input)) {
            throw new IllegalArgumentException();
        }

        char[] inputs = input.toCharArray();

        for (char inputChar : inputs) {
            user.add(inputChar - '0');
        }

        return user;
    }
    
}
