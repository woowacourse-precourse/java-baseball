package baseball.util;

import baseball.common.GameMessage;
import baseball.exception.Exception;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Util {

    public int continueGame(Exception exception) {
        System.out.println(GameMessage.QUESTION_CONTINUE.getValue());

        int selectNext = Integer.parseInt(Console.readLine());

        exception.restartException(selectNext);
        // 새시작시 True, 종료 시  false
        return selectNext;
    }

    public String createAnswerString() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }

        StringBuilder sb = new StringBuilder();

        Iterator iter = set.iterator();

        while (iter.hasNext()) {
            sb.append(iter.next());
        }

        return sb.toString();
    }
}
