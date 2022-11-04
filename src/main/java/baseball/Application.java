package baseball;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BaseballGame baseballGame = new BaseballGame();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = baseballGame.getRandomNumberList();

            baseballGame.start(computer, sc);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String string = sc.nextLine();

            if (!baseballGame.isReStart(string)) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}
