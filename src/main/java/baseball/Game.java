package baseball;

import baseball.user.Input;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 게임의 전반적인 기능을 하는 클래스
 */
public class Game {

    Input input = new Input();

    public Game() {
    }

    /**
     * 사용자의 입력을 받아 List로 변환해 넘겨주는 메소드
     * @return 숫자를 차례로 넣은 List
     */
    public List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();

        if (!input.isAllDigits(userInput)
                || !input.isAllDifferentDigit(userInput)
                || !input.isDigitsInRange(userInput)
                || !input.isInputLengthEqualsGameLength(userInput)) {
            throw new IllegalArgumentException();
        }

        return input.inputDigit(userInput);
    }

    /**
     * 게임의 한 라운드를 수행하는 메소드
     */
    public void playGameRound(){
        Computer computer = new Computer();
        List<Integer> computerRandomDigit = computer.completedDigits;

        while (true){
            try {
                List<Integer> userInputDigit = getUserInput();
            } catch (IllegalArgumentException e){
                continue;
            }

            // 여기 입력받은 값과 컴퓨터의 값을 비교해서 결과 출력하는 메소드

        }
    }
}
