package baseball.util;

import baseball.dto.MessageDTO;
import baseball.dto.ScoreDTO;

public class MessageMaker {

    public MessageDTO makeMessage(ScoreDTO scoreDTO) {

        MessageDTO messageDTO = new MessageDTO();

        if (scoreDTO.getStrikeCount() == 3) {
            messageDTO.setMessage("3스트라이크");
            messageDTO.setOver(true);
        }
        else if (scoreDTO.getBallCount() > 0 && scoreDTO.getStrikeCount() >0)
            messageDTO.setMessage(scoreDTO.getBallCount() + "볼 " + scoreDTO.getStrikeCount() + "스트라이크");
        else if (scoreDTO.getBallCount() > 0 && scoreDTO.getStrikeCount() == 0)
            messageDTO.setMessage(scoreDTO.getBallCount() + "볼");
        else if (scoreDTO.getBallCount() == 0 && scoreDTO.getStrikeCount() > 0)
            messageDTO.setMessage(scoreDTO.getStrikeCount() + "스트라이크");
        else
            messageDTO.setMessage("낫싱");

        return messageDTO;
    }

    public String makeEndMessage() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
