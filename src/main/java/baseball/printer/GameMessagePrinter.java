package baseball.printer;

import baseball.dto.BallStrikeDto;

public class GameMessagePrinter {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 압력해주세요 : ";

    private final ResultMessageGenerator resultMessageGenerator;

    public GameMessagePrinter() {
        this.resultMessageGenerator = new ResultMessageGenerator();
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printNumberInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public void printResultMessage(BallStrikeDto dto) {
        System.out.println(resultMessageGenerator.generateMessage(dto));
    }
}
