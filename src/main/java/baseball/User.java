package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User implements Number {
    List<Integer> number;

    @Override
    public void create() {
        Game.printInputMessage();
        number = convertInputAsNumber(Console.readLine());
    }

    @Override
    public List<Integer> get() {
        return number;
    }

    public void createRepeatInput() {
        Game.printRepeatMessage();
        String flag = Console.readLine();
        if (isInValidFlag(flag)) {
            Information.throwError(Information.Error.FLAG);
        }
        Game.checkRestart(flag);
    }

    public static List<Integer> convertInputAsNumber(String inputNumber) {
        validateNumber(inputNumber);
        return Stream.of(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void validateNumber (String number) {
        if (!isNumberValidMaxSize(number)) {
            Information.throwError(Information.Error.SIZE);
        }

        if (!isNumberValidUnique(number)) {
            Information.throwError(Information.Error.UNIQUE);
        }

        if (!isNumberValidRange(number)) {
            Information.throwError(Information.Error.RANGE);
        }
    }

    public static boolean isInValidFlag(String flag) {
        return !List.of(Game.RESTART_GAME_FLAG, Game.END_GAME_FLAG)
                .contains(flag);
    }

    public static boolean isNumberValidMaxSize(String inputNumber) {
        return inputNumber.length() == MAX_SIZE;
    }

    public static boolean isNumberValidUnique(String inputNumber) {
        long distinctSize = Arrays.stream(inputNumber.split(""))
                .distinct()
                .count();
        return inputNumber.length() == distinctSize;
    }

    public static boolean isNumberValidRange(String inputNumber) {
        try {
            return Stream.of(inputNumber.split(""))
                    .map(Integer::parseInt)
                    .allMatch(number -> number >= START_NUMBER && number <= END_NUMBER);
        } catch (NumberFormatException error) {
            return false;
        }
    }
}
