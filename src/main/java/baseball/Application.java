package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static String userInput;
    private static int targetNumber;


    public static void main(String[] args) {

        startGamePrint();
        //while
        while (true) {
            //컴퓨터 수 생성
            targetNumber = makeTargetNumber();

            while (true) {
                //사용자 값 입력
                getNumberPrint();
                userInput = Console.readLine();
                validUserInput(Integer.parseInt(userInput));

                BallAndStrike ballAndStrike = compareNumbers(targetNumber, Integer.parseInt(userInput));
                if (ballAndStrike.getStrike() == 3) {
                    gameOverPrint();
                    break;
                }
                ballAndStrike.print();


            }

            //게임 진행 선택
            gameContinuePrint();
            userInput = Console.readLine();
            validGameContinueInput(Integer.parseInt(userInput));
            if (userInput.equals("2")) break;
        }
    }

    //TODO
    private static int makeTargetNumber() {

        return 0;
    }

    //TODO
    private static BallAndStrike compareNumbers(int targetNumber, int userInput) {
        BallAndStrike count = new BallAndStrike();


        return count;
    }


    private static void getNumberPrint() {
        System.out.print("숫자를 입력해주세요. : ");
    }

    private static void gameOverPrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    private static void gameContinuePrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void startGamePrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void validUserInput(int number) {
        //세자리 수가 아닐때
        //세자리 수 중 0이 있을 때
    }

    private static void validGameContinueInput(int number) {
        //1또는 2가 아닐때

    }

}
