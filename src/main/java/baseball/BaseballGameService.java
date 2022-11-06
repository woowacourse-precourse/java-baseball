package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameService {

    public static Player getPlayer() {
        int number = StringToIntConvertor.convert(Console.readLine());
        return Player.from(number);
    }

    public static ContinueOrBreak getContinueOrBreak() {
        int code = StringToIntConvertor.convert(Console.readLine());
        return ContinueOrBreak.from(code);
    }
}
