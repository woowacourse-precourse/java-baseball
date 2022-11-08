package baseball.view;

import baseball.model.Answer;

import java.util.List;

public class InitAnswer {
    private static final String INIT_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.\n";

    public List<Integer> initAnswerList(Answer answer){
        System.out.println(INIT_GAME_MESSAGE);
        answer.generateRandomAnswer();
        return answer.getAnswer();
    }
}
