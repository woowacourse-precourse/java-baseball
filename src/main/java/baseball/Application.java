package baseball;


import baseball.domain.Executor;

/**
 * 객체 지향 프로그래밍
 * 1. 기능을 가지고 있는 클래스를 인스턴스화(=객체)한다.
 * 2. 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다. (의인화)
 * 3. 각 결과를 종합한다.
 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Executor executor = new Executor();
        executor.startGame();
    }
}