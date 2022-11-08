package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballInput {

    public static BaseballNumber getUserNumber() {
        BaseballOutput.printInputNumberMessage();
        BaseballNumber baseballNumber = new BaseballNumber(Console.readLine());
        return baseballNumber;
    }

    public static Integer getPlayCode() throws IllegalArgumentException {
        BaseballOutput.printInputPlayCodeMessage();
        Integer playCode = null;
        try {
            while (playCode == null
                    || !(playCode == Application.PLAY_AGAIN_CODE
                    || playCode == Application.EXIT_CODE)) {
                playCode = Integer.parseInt(Console.readLine());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return playCode;
    }


}
