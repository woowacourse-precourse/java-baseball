package configuration;

import java.util.Map;

public interface Factory {

    // 사용자 입력 기능
    Map<Integer, Character> inputUserNumber();

    // 상대방(컴퓨터) 입력 기능
    Map<Integer, Character> createComputerNumber();

    // 힌트 기능 동작
    void loopHint(Map<Integer, Character> userNumber, Map<Integer, Character> computerNumber);

    // 출력 기능
    String printResult();

    // 게임 기능
    String playGame();

    // 예외 기능
    boolean validationCheck(String userLine);

}
