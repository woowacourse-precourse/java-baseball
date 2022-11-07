package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void game() {
        List<Integer> randomNum= random();

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> inputNum=input();
            boolean returnValue=checkNum(randomNum,inputNum);
            if(returnValue)
                break;
            else
                continue;
        }
    }

    public static void startGame() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {

            game();
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String userInput=Console.readLine();

            if(userInput.equals("1")) {
                continue;
            }
            else if(userInput.equals("2")) {
                break;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
    }
}
