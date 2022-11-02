package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballGame {
    private static Computer computer;

    private BaseballGame() {
    }

    public static BaseballGame init() {
        BaseballGame game = new BaseballGame();
        game.computer = new Computer();
        return game;
    }

    public void start() {
        Input.startGameMessage();
        // 랜덤값 세 개를 만든다
        List<Integer> answer = RandomGenerator.makeNotDuplicatedRandomNumbers(3,1,9);
        System.out.println("(임시) answer is "+ answer);
        computer.putAnswer(answer);
        while (true) {
            List<Integer> guessNumbers = inputNumbers();
            List<Integer> results = computer.returnResult(guessNumbers);
            Integer strikeCnt = results.get(0);
            Integer ballCnt = results.get(1);
            Output.showGuessResult(strikeCnt, ballCnt);
            if(strikeCnt == 3) {
                Output.showGameCompleteMessage();
                break;
            }
        }
        decideWhatToDoNext();
    }

    private void decideWhatToDoNext() {
        try {
            Integer code = Input.askWhatToDo();
            if (code == 1) {
                start();
            }
            if (code == 2) {
                return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            decideWhatToDoNext();
        }
    }

    private List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> guessNumbers = new ArrayList<>();
        String input = Console.readLine();
        for (int i = 0; i < input.length(); i++) {
            guessNumbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return guessNumbers;
    }
}
