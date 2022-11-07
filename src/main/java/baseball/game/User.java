package baseball.game;

import baseball.game.utils.StringConverter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    public List<Integer> presume() {
        String input = Console.readLine().strip();
        return StringConverter.toIntegerList(input);
    }
}
