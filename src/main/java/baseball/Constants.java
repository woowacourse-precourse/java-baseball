package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Constants {

    public static final int DEFAULT_NUMBER_COUNT = 3;
    public static final boolean PROCESS_CONTINUE = true;
    public static final boolean PROCESS_FINISH = false;

    public enum Result {
        STRIKE, BALL, OUT
    }

    public enum EndCommand {
        UNKNOWN("0"),
        RESTART("1"),
        FINISH("2");

        private final String endCommand;

        EndCommand(String endCommand) {
            this.endCommand = endCommand;
        }

        public String getEndCommand() {
            return this.endCommand;
        }

        private static final Map<String, EndCommand> endCommands =
                Arrays.stream(EndCommand.values())
                        .collect(Collectors.toMap(EndCommand::getEndCommand, Function.identity()));

        public static EndCommand find(String command) {
            return endCommands.getOrDefault(command, UNKNOWN);
        }
    }

    public enum Messages{

        ASK("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
        INIT("숫자 야구 게임을 시작합니다."),
        INPUT("숫자를 입력해주세요 : ", System.out::print);

        private final String message;
        private final Consumer<String> printer;

        Messages(String message) {
            this.message = message;
            this.printer = System.out::println;
        }
        Messages(String message, Consumer<String> printer) {
            this.message = message;
            this.printer = printer;
        }

        public void printMessage() {
            this.printer.accept(this.message);
        }

        public static void printScore(HashMap<Result, Integer> resultCount) {
            int balls = resultCount.getOrDefault(Result.BALL, 0);
            int strikes = resultCount.getOrDefault(Result.STRIKE, 0);

            StringJoiner baseString = new StringJoiner(" ");
            if (balls != 0) {
                baseString.add(String.format("%d볼", balls));
            }
            if (strikes != 0) {
                baseString.add(String.format("%d스트라이크", strikes));
            }
            if (baseString.length() == 0) {
                baseString.add("낫싱");
            }
            System.out.println(baseString);
        }
    }
}

