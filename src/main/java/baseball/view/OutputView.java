package baseball.view;

import baseball.dto.ScoresDTO;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String APPLICATION_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 View 클래스입니다.";
    private static final String BASEBALL_GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String SPACE_DELIMITER = " ";
    private static final String NOTHING_DISPLAY = "낫싱";
    private static final String BALL_DISPLAY = "볼";
    private static final String STRIKE_DISPLAY = "스트라이크";
    private static final int MIN_SCORES_INDEX = 0;
    private static final int MAX_SCORES_INDEX = 1;
    
    private OutputView() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static void printApplicationStartMessage() {
        System.out.println(APPLICATION_START_MESSAGE);
    }
    
    public static void printResult(final ScoresDTO scoresDTO) {
        final List<Integer> scores = scoresDTO.getScores();
        final List<String> ballStatusDisplay = List.of(BALL_DISPLAY, STRIKE_DISPLAY);
        
        if (isNothing(scores)) {
            System.out.println(NOTHING_DISPLAY);
            return;
        }
        System.out.println(parsePlayResults(scores, ballStatusDisplay));
    }
    
    private static boolean isNothing(final List<Integer> scores) {
        return scores.stream()
                .noneMatch(Predicate.not(OutputView::isScoreZero));
    }
    
    private static String parsePlayResults(final List<Integer> scores, final List<String> ballStatusDisplay) {
        return IntStream.rangeClosed(MIN_SCORES_INDEX, MAX_SCORES_INDEX)
                .filter(scoresIndex -> !isScoreZero(scores, scoresIndex))
                .mapToObj(scoresIndex -> scores.get(scoresIndex) + ballStatusDisplay.get(scoresIndex))
                .collect(Collectors.joining(SPACE_DELIMITER));
    }
    
    private static boolean isScoreZero(final Integer score) {
        return score == MIN_SCORES_INDEX;
    }
    
    private static boolean isScoreZero(final List<Integer> scores, final int resultIndex) {
        return scores.get(resultIndex) == MIN_SCORES_INDEX;
    }
    
    public static void printBaseBallGameEndMessage() {
        System.out.println(BASEBALL_GAME_END_MESSAGE);
    }
}
