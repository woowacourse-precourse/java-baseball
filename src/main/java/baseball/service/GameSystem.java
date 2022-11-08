package baseball.service;

import java.io.IOException;
import java.util.List;

public class GameSystem {
    public void start() throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean game_on = true;
        List<Integer> answer = Computer.getAnswerNum();

        while(game_on==true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> guess = User.inputGuess();

            String result = AnswerCheck.checkGuess(answer, guess);
            System.out.println(result);
            if (result.equals("3스트라이크")){
                game_on = Ending.endGame();
                if(game_on == true) answer = Computer.getAnswerNum();
            }else{ continue; }
        }
        return;
    }

}
