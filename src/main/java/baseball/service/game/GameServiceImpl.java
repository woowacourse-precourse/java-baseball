package baseball.service.game;

import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.facade.ComputerFacade;
import baseball.facade.RefereeFacade;
import baseball.facade.UserFacade;

public class GameServiceImpl implements GameService {
    private final UserFacade userFacade = new UserFacade();
    private final ComputerFacade computerFacade = new ComputerFacade();
    private final RefereeFacade refereeFacade = new RefereeFacade();


    private final Referee referee = new Referee();
    private final Player computer = new Player();
    private final Player user = new Player();

    public void playGame() {

        do {
            // 볼, 스트라이크 초기화
            referee.clear();

            // 유저에 input 값 세팅
            var userInput = userFacade.getInputValue();
            user.setInput(userInput);

            // 컴퓨터에 random 값 세팅
            var computerInput = computerFacade.getRandomValue();
            computer.setInput(computerInput);

            // 볼, 스트라이크 점수 집계
            refereeFacade.countScore(computer.input, user.input, referee);
            // 결과 출력
            refereeFacade.answerResult(referee.ball, referee.strike);

            //  게임 종료 판단
        } while(refereeFacade.judgeResult(referee.strike));
    }
}
