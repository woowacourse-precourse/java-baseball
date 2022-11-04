package features;

import java.util.Map;

public interface Factory {

    // 입력 기능
    Map<Integer, Character> inputUserNumber();

    // 힌트 기능 동작
    void loopHint(Map<Integer, Character> userNumber, Map<Integer, Character> computerNumber);

    // 출력 기능
    String printResult();

}
