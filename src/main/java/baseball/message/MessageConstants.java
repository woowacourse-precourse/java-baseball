package baseball.message;

public interface MessageConstants {

	String START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
	String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	String STRIKE_MESSAGE_FORMAT = "%d스트라이크\n";
	String BALL_MESSAGE_FORMAT = "%d볼\n";
	String BALL_AND_STRIKE_MESSAGE_FORMAT = "%d볼 %d스트라이크\n";
	String NOTHING_MESSAGE = "낫싱\n";
	String ANSWER_MESSAGE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
	String END_MESSAGE_FORMAT = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n";
	String USER_INPUT_ERROR_MESSAGE = "user input error\n";
}
