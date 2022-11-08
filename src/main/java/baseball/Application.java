package baseball;

import baseball.manager.Manager;
import baseball.manager.Manager.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Manager swJeong98 = new Manager();

        while(!swJeong98.play());
    }
}
