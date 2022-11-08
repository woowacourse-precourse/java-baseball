package baseball;

public interface GameInterface {

    abstract void run(); // 게임의 한 과정을 모두 수행한다.

    abstract void start(); // 게임을 시작한다. 시작 메시지를 띄워 준다.

    abstract boolean end(); // 사용자에게 게임을 다시 시작할 것인지 묻고, 종료할 것이라면 true, 아니면 false 를 반환한다.

    abstract boolean askRestart(); // 사용자에게 게임을 다시 시작할 것인지 묻는다.

    abstract String getUserInput(); // 사용자로부터 값을 입력받는다.

    abstract boolean validateInput(String input); // 사용자로부터 입력받는 수를 검증한다.

    abstract void exceptionHandler(boolean flag); // 검증 결과에 따라서 예외를 발생시킨다.
}
