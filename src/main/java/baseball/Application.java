package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Balls computer;
        String userKeyInput;
        do {
            computer = new Balls(Randoms.pickUniqueNumbersInRange(1, 9, 3));
            System.out.println("숫자 야구 게임을 시작합니다.");
            Result result = new Result();
            while (!result.isGameOver()) {
                System.out.print("숫자를 입력해주세요 : ");
                result = computer.play(ValidationUtil.mapStringToList(Console.readLine()));
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userKeyInput = Console.readLine();
        } while (userKeyInput.equals("1"));
    }
}
