package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private String answer;

    List<Integer> generateNumberSet() {
        List<Integer> generatedSet = new ArrayList<>();
        while (generatedSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedSet.contains(randomNumber)) {
                generatedSet.add(randomNumber);
            }
        }
        return generatedSet;
    }
    String generateAnswer() {
        List<Integer> generatedSet = generateNumberSet();
        return Utils.listToString(generatedSet);
    }

    boolean answerCheck(String userInput) {
        return answer.equals(userInput);
    }
    void initGame() {
        answer = generateAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void playGame() {
        int gameFlag = 1;
        while (gameFlag == 1) {
            initGame();
            String userInput = "";

            while (!answerCheck(userInput)) {
                System.out.print("숫자를 입력해주세요 : ");
                userInput = Console.readLine();
                Player.checkUserInput(userInput);
                Scorer.generateHint(userInput, answer);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameFlag = Integer.parseInt(Console.readLine());
        }
    }
}
