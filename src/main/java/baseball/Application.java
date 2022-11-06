package baseball;

import baseball.hint.Hint;
import baseball.inputdata.Player;
import baseball.quiz.QuizMaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String MESSAGE_TO_START = "숫자 야구 게임을 시작합니다.";
    private static final String MESSAGE_TO_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int LENGTH_OF_QUIZ = 3;

    public static void main(String[] args) {
        String quiz = QuizMaker.NewQuiz();
        String playerInput = "";
        List<Integer> hintList = Arrays.asList(0);

        System.out.println(MESSAGE_TO_START);
        while(hintList.get(0) != LENGTH_OF_QUIZ) {
            playerInput = Player.Input();
            Player.ExceptionProcess(playerInput);

            hintList = Hint.CompareTo(quiz, playerInput);
            Hint.Print(hintList);
        }
        System.out.println(MESSAGE_TO_END);
    }
}
