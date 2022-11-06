package baseball;

import baseball.hint.Hint;
import baseball.inputdata.Player;
import baseball.quiz.QuizMaker;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String MESSAGE_TO_START = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        String quiz = QuizMaker.NewQuiz();
        String playerInput = "";
        List<Integer> hintList = new ArrayList<>();

        System.out.println(quiz);
        System.out.println(MESSAGE_TO_START);
        playerInput = Player.Input();
        Player.ExceptionProcess(playerInput);

        hintList = Hint.CompareTo(quiz, playerInput);
        Hint.Print(hintList);
    }
}
