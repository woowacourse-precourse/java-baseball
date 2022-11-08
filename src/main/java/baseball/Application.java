package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            computer.setRandomNumbers();

            do {
                System.out.print("숫자를 입력해주세요 : ");
                user.setUserNumbers(readLine());

            } while (!computer.checkThreeStrike(user.numbers));

            if (!computer.restart(readLine())) {
                return;
            }
        }
    }
}
