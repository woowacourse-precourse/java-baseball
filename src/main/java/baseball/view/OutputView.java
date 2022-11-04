package baseball.view;

import baseball.dto.RefereeDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String SELECTED_NUMBER_FOR_RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String APPLICATION_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 View 클래스입니다.";
    private static final String BASEBALL_GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String DELIMITER = " ";
    private static final String NOTHING_DISPLAY = "낫싱";
    private static final String BALL_DISPLAY = "볼";
    private static final String STRIKE_DISPLAY = "스트라이크";
    
    private OutputView() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static void printApplicationStartMessage() {
        System.out.println(APPLICATION_START_MESSAGE);
    }
    
    public static void printResult(final RefereeDTO refereeDTO) {
        final List<Integer> ballStatusScores = refereeDTO.getBallStatusScores();
        final List<String> ballStatusDisplay = List.of(BALL_DISPLAY, STRIKE_DISPLAY);
        
        if (isNothing(ballStatusScores)) {
            System.out.println(NOTHING_DISPLAY);
            return;
        }
        System.out.println(parsePlayResultsMessage(ballStatusScores, ballStatusDisplay));
    }
    
    private static boolean isNothing(final List<Integer> ballStatusScores) {
        return ballStatusScores.stream()
                .noneMatch(OutputView::isBallScoreNotZero);
    }
    
    private static boolean isBallScoreNotZero(final Integer ballScore) {
        return ballScore != 0;
    }
    
    private static String parsePlayResultsMessage(final List<Integer> ballStatusScores, final List<String> ballStatusDisplay) {
        return IntStream.rangeClosed(0, 1)
                .filter(position -> isBallScoreNotZero(ballStatusScores, position))
                .mapToObj(position -> parsePlayResultMessage(ballStatusScores, ballStatusDisplay, position))
                .collect(Collectors.joining(DELIMITER));
    }
    
    private static boolean isBallScoreNotZero(final List<Integer> ballStatusScores, final int position) {
        return ballStatusScores.get(position) != 0;
    }
    
    private static String parsePlayResultMessage(final List<Integer> ballStatusScores, final List<String> ballStatusDisplay, final int position) {
        return ballStatusScores.get(position) + ballStatusDisplay.get(position);
    }
    
    public static void baseBallGameEndMessagePrint() {
        System.out.println(BASEBALL_GAME_END_MESSAGE);
    }
    
    public static void restartGuidancePrint() {
        System.out.println(SELECTED_NUMBER_FOR_RESTART_INPUT_MESSAGE);
    }
}
