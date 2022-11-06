package baseball;

import baseball.inputdata.Player;
import baseball.quiz.QuizMaker;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String MESSAGE_TO_START = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        List<Integer> quiz = QuizMaker.NewQuiz();
        String PlayerInput = "";

        System.out.println(MESSAGE_TO_START);
        PlayerInput = Player.Input();

        Player.ExceptionProcess(PlayerInput);
    }
}
