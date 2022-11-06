package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            ComputerNums computernums = new ComputerNums(3);
            gameStart(computernums);

            String userfinalinput = UserInput.endInput();
            confirmUserFinalInput(userfinalinput);
            if (userfinalinput.equals("2")) {
                break;
            }
        } while (true);

    }

    public static void gameStart(ComputerNums computernums) {
        while (true) {
            UserNums usernum = new UserNums(UserInput.startInput());
            BaseballCount baseballCount = new BaseballCount(computernums.getNumbers(),
                usernum.getNumbers());
            if (allStrike(baseballCount)) {
                SystemOutput.allStrikeMessage();
                break;
            }
            if (allNotSame(baseballCount)) {
                SystemOutput.allNotSameMessage();
                continue;
            }
            SystemOutput.baseballCountMessage(baseballCount);
        }
    }

    public static boolean allStrike(BaseballCount baseballCount) {
        return baseballCount.strikecount == 3;
    }

    public static boolean allNotSame(BaseballCount baseballCount) {
        return baseballCount.strikecount == 0 && baseballCount.ballcount == 0;
    }

    public static void confirmUserFinalInput(String userfinalinput) {
        if (!userfinalinput.equals("1") && !userfinalinput.equals("2")) {
            throw new IllegalArgumentException("1이나 2가 아닙니다.");
        }
    }


}
