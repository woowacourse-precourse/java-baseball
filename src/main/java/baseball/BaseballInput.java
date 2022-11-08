package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BaseballInput {
    private BaseballInput() {

    }

    public static BaseballNumber getUserNumber() {
        BaseballOutput.printInputNumberMessage();
        BaseballNumber baseballNumber = new BaseballNumber(Console.readLine());
        return baseballNumber;
    }

    public static Integer getPlayCode() {
        BaseballOutput.printInputPlayCodeMessage();
        Integer playCode = null;
        try {
            playCode = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (!Arrays
                .stream(PlayCode.values())
                .map(PlayCode::getCode)
                .collect(Collectors.toSet())
                .contains(playCode)) {
            throw new IllegalArgumentException();
        }
        return playCode;
    }


}
