# 기능목록에 따른 클래스와 필드, 메소드 이름 명세

- getter()와 setter(), 기본 생성자는 기술하지 않는다.

## 클래스

### 클래스 NumberBaseballResultDto

1. 필드
    1. `public final int cntBalls`
    2. `public final int cntStrikes`
2. 메소드: 기술할 대상 없음

### 클래스 NumberBaseballGameServer

1. 필드
    1. `private static final int GAME_NUMBER_RANGE_MAX`: 게임 숫자의 각 자리 수의 최대값 9
    2. `private static final int GAME_NUMBER_RANGE_MIN`: 게임 숫자의 각 자리 수의 최소값 1
    3. `private int gameNumber`: GAME_NUMBER_RANGE 범위에서, 서로 다른 숫자로 이뤄진 3자리의 숫자
2. 메소드
    1. `public static void run()`: 슷지 야구 게임 관리 (게임의 흐름과 순서 관리)
    2. `private int makeNewGameNumber()`
    3. `private NumberBaseballGameDto judgeInputNumber(int inputNumber)`

### 클래스 NumberBaseballGameClient

1. 필드
    1. `private static final string MSG_GAME_START`
    2. `private static final string MSG_ASK_INPUT_NUMBER`
    3. `private static final string MSG_JUDGED_RESULT_BALLS`
    4. `private static final string MSG_JUDGED_RESULT_STRIKES`
    5. `private static final string MSG_JUDGED_RESULT_NOTHING`
    6. `private static final string MSG_GAME_END`
    7. `private static final string MSG_ASK_MORE_GAME`
2. 메소드
    1. `private NumberBaseballGameConsole()`: 객체로 생성 금지
    2. `public static void showGameStartMessage()`
    3. `public static int askInputNumber()`
    4. `public static void showJudgedResult(NumberBaseballGameDto dto)`
    5. `public static void showGameEndMessage()`
    6. `public static boolean askMoreGame()`

### 클래스 Application

1. 필드: 없음
2. 메소드
    1. `public static void main(String[] args)`: 어플리케이션 관리 (숫자 야구 게임 객체 생성 및 본 게임 호출)
