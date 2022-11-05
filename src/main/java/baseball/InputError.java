package baseball;

/**
 * 사용자 입력
 * 서로 다른 3자리 수
 * 게임이 끝난 경우 재시작 => 1, 종료 => 2
 * 잘못된 입력일 경우 IllegalArgumentException을 발생시킨 후 종료
 */
public class InputError {

    public String replayOrStopException(String answer) {
        // 1, 2가 아닌 다른 값인지 검사

        if(answer.equals("1"))
            return answer;
        if(answer.equals("2"))
            return answer;
        throw new IllegalArgumentException("잘못된 입력값입니다. 게임을 종료하겠습니다.");
    }
}
