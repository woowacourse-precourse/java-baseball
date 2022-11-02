package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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
        computer.putAnswer(List.of(1, 2, 3));
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("2")) {
            return;
        }
        if (input.equals("1")) {
            start();
        }
        throw new IllegalArgumentException("잘못된 입력입니다");
        // 컴퓨터가 랜덤숫자를 만든다
        // 세자리 숫자 입력받는다
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
