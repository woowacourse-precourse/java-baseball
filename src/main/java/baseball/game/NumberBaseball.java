package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import static baseball.constant.Rule.PICK;
import static baseball.constant.Want.FINISH;
import static baseball.constant.Want.MORE;

public class NumberBaseball {
    private final Staff staff = new Staff();

    private final Referee referee = new Referee();

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true){
            List<Integer> targetNumbers = staff.getTargetNumbers();
            game(targetNumbers);
            System.out.println("게임을 새로 시작하려면 " + MORE + ", 종료하려면 " + FINISH + "를 입력하세요.");
            String input = Console.readLine();

            if (staff.isUserWantFinish(input)) {
                break;
            }
        }

        System.out.println("게임이 정상적으로 종료되었습니다.");
    }

    private void game(List<Integer> targetNumbers) {

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> userNumbers = staff.getUserNumbers(input);

            if (referee.isPerfectAnswer(targetNumbers, userNumbers)) {
                break;
            }
        }

        System.out.println(PICK + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
