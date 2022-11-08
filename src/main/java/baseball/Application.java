package baseball;

import baseball.gameRule.GameRule;
import baseball.gameRule.GameRuleDetail;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.initGame(new GameRuleDetail());
    }

    /**
     * 게임 진행을 담당하는 함수
     */
    public void initGame(GameRule gameRule) {
        GameStatus status = GameStatus.CONTINUE;
        do {
            if (GameStatusUtil.isStopStatus(status)) {
                break;
            }
            GameStatusUtil.validateExceptionStatus(status);
            GameFormatter.gameStartMessage();
            String answer = initComputerAnswer();
            gameRule.playByGameRule(answer);
            GameFormatter.gameEndMessage();
            status = GameStatusUtil.setGameStatus(Console.readLine());
        } while (true);
    }

    /**
     * 상대방(컴퓨터)가 1부터 9까지 셔플한 결과 중 3개를 뽑아 문자열로 반환
     *
     * @return answer
     */
    String initComputerAnswer() {
        StringBuffer answer = new StringBuffer();
        // pickNumberInRange를 이용하는 함수를 호출해 문자열로 변환 후 반환
        for(Integer num : getRandomNumberList()){
            answer.append(num);
        }
        return answer.toString();
    }

    List<Integer> getRandomNumberList(){
        List<Integer> list = new ArrayList<>();
        while(list.size() < 3){
            int randNum = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randNum)){
                list.add(randNum);
            }
        }
        return list;
    }

}
