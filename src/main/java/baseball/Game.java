package baseball;

import baseball.user.Input;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 게임의 전반적인 기능을 하는 클래스
 */
public class Game {

    Input input = new Input();
    private final int GAME_CONTINUE_NUMBER = 1;

    public Game() {}

    public void gamePlay() {
        while (true) {
            playGameRound();
            
            // 여기 계속할지 처리하는 메소드
            if(!isContinue()){
                break;
            }
        }
    }

    /**
     * 사용자의 입력을 받아 List로 변환해 넘겨주는 메소드
     *
     * @return 숫자를 차례로 넣은 List
     */
    public List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();

        if (!input.checkValidateInput(userInput)) {
            throw new IllegalArgumentException();
        }

        return input.changeInputStringToList(userInput);
    }

    /**
     * 게임의 한 라운드를 수행하는 메소드
     */
    public void playGameRound() {
        Computer computer = new Computer();
        List<Integer> computerRandomDigit = computer.completedDigits;
        List<Integer> userInputDigit;

        while (true) {
            // 잘못된 입력을 받았을 때 프로그램을 종료하지 않고 다시 입력을 받으려면
            // 아래 주석처리 된 코드를 사용한다.
//            try {
//                userInputDigit = getUserInput();
//            } catch (IllegalArgumentException e) {
//                continue;
//            }

            // 잘못된 입력을 받았을 때 Exception을 던지며 프로그램을 종료한다.
            userInputDigit = getUserInput();

            // 여기 입력받은 값과 컴퓨터의 값을 비교해서 결과 출력하는 메소드
            String checkDigitsResult = computer.checkDigits(userInputDigit, computerRandomDigit);
            System.out.println(checkDigitsResult);
            if (isGameWin(checkDigitsResult)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    /**
     * 게임을 이겼는지(종료할 수 있는지) 확인하는 메소드
     * 3스트라이크가 되면 종료할 수 있다.
     */
    public boolean isGameWin(String checkDigitResult) {
        return checkDigitResult.equals("3스트라이크");
    }

    /**
     * 게임을 새로 시작할지(1), 종료할 지(2) 선택하는 메소드
     * 적절한 입력인지 확인하고 예외처리하는 기능
     */
    public int getMenuNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String inputMenu = Console.readLine();
        if (!input.isAllDigits(inputMenu)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(inputMenu);
    }

    public boolean isContinue(){

        while (true) {
            int menuInput;

            try {
                menuInput = getMenuNumber();
            } catch (IllegalArgumentException e){
                continue;
            }

            if(menuInput == GAME_CONTINUE_NUMBER){
                return true;
            } else {
                return false;
            }
        }

    }
}
