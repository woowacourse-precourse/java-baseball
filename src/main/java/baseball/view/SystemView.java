package baseball.view;

import baseball.Exception.SystemException;
import camp.nextstep.edu.missionutils.Console;

public class SystemView {
    private static final String INPUT = "숫자를 입력해주세요 : ";
    private static final String Choose_Restart_Or_Exit = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final SystemException systemException = new SystemException();

    public SystemView() {
    }
}