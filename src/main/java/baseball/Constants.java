package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 상수를 관리하기 쉽도록 한 곳에 모아두었습니다.
 */
public class Constants {

    public static final int DEFAULT_NUMBER_COUNT = 3;
    public static final boolean PROCESS_CONTINUE = true;
    public static final boolean PROCESS_FINISH = false;

    public enum Status {
        PLAYING, DONE
    }
    public enum Result {
        STRIKE, BALL, OUT
    }

    /**
     * 게임 종료 후 명령어 입력으로 관련 상수를 찾아주는 열거형 클래스입니다.
     * if문 사용 없이 명령어를 찾아주기 위해 해시맵을 사용했습니다.
     */
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

    /**
     * 콘솔 출력을 담당하는 열거형 클래스입니다.
     * 점수 출력 함수의 분기점들도 해시맵을 이용해 처리하고 싶었으나, 실패했습니다.
     * 혹시 다른 방법이 있다면 추천 부탁드립니다.
     */
    public enum Messages{

        ASK("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
        INIT("숫자 야구 게임을 시작합니다."),
        INPUT("숫자를 입력해주세요 : ");

        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public void printMessage() {
            System.out.println(this.message);
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

