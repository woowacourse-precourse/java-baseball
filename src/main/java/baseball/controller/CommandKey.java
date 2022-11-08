package baseball.controller;

import java.util.Arrays;

/**
 * 사용자로부터 입력을 받아서 종료, 재시도를 결정할 때
 * 각각에 해당하는 1,2를 모아둔 enum입니다
 */
enum CommandKey {
    RETRY(1),
    FINISH(2);

    private final int value;

    CommandKey(int value) {
        this.value = value;
    }

    /**
     * 정적 팩토리 메서드로 1,2사이에 해당하는 숫자를 받아서 해당하는 enum을 반환해줍니다
     *
     * @param value 1,2에 해당하는 정수
     * @return 실제 값을 감싼 CommandKey의 enum객체
     */
    public static CommandKey from(int value) {
        return Arrays.stream(CommandKey.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
