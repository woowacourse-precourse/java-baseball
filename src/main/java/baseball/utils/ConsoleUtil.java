package baseball.utils;

import baseball.domain.BaseballDto;
import baseball.status.Comments;
import baseball.status.Constants;

public class ConsoleUtil {

    public static void consoleOutput(String output) {
        System.out.print(output);
    }

    public static void consoleOutputLine(String output) {
        System.out.println(output);
    }

    public static String ballAndStrikeOutput(BaseballDto baseballDto) {
        StringBuilder output = new StringBuilder();

        if (baseballDto.isBallExist()) {
            output.append(baseballDto.getBall()).append(Comments.BALL.getComment());
        }
        if (baseballDto.isBallExist() && baseballDto.isStrikeExist()) {
            output.append(Comments.SPACE.getComment());
        }
        if (baseballDto.isStrikeExist()) {
            output.append(baseballDto.getStrike()).append(Comments.STRIKE.getComment());
        }

        if (checkIsNothing(baseballDto)) {
            output.append(Comments.NOTHING.getComment());
        }
        if (gameEnd(baseballDto)) {
            output.append(Comments.NEXT_LINE.getComment()).append(Comments.GAME_END.getComment());
        }

        return output.toString();
    }

    private static boolean gameEnd(BaseballDto baseballDto) {
        return baseballDto.getStrike() == Constants.NUMBER_OF_DIGITS.getNumber();
    }

    private static boolean checkIsNothing(BaseballDto baseballDto) {
        return baseballDto.getBall() == Constants.ZERO_COUNT.getNumber()
                && baseballDto.getStrike() == Constants.ZERO_COUNT.getNumber();
    }
}
