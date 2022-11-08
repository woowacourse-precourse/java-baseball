package baseball.domain;

import baseball.dto.MessageDTO;
import baseball.dto.ScoreDTO;
import baseball.service.GameService;
import baseball.util.MessageMaker;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private Boolean isEnd;
    private Boolean isNew;
    private final GameService gameService;
    private final MessageMaker messageMaker;

    public Game() {
        this.isEnd = false;
        this.isNew = false;
        this.gameService = new GameService();
        this.messageMaker = new MessageMaker();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        while(!isEnd) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            ScoreDTO scoreDTO = gameService.calculate(input, isNew);
            MessageDTO messageDTO = messageMaker.makeMessage(scoreDTO);
            System.out.println(messageDTO.getMessage());
            if (messageDTO.getIsOver()) {
                System.out.println(messageMaker.makeEndMessage());
                String endInput = Console.readLine();
                if (endInput.equals("2"))
                    isEnd = true;
                else
                    isNew = true;
            }
            else
                isNew = false;
        }
    }
}
