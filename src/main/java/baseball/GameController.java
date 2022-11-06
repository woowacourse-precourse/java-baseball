package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GameController {

    public List<Integer> RandomGenerator() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public boolean checkInput(String input) {
        Pattern pattern = Pattern.compile("[1-9]{3}");
        if (input == null){
            return false;
        }
        return pattern.matcher(input).matches();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame(RandomGenerator());
    }

    public void playGame(List<Integer> answer) {
        boolean isAnswer = false;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            isAnswer = true;
        } while (!isAnswer);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void endGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(br.readLine());
    }

}
