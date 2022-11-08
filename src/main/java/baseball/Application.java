package baseball;

import baseball.domain.manager.NumberBaseballManager;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            NumberBaseballManager numberBaseBallManager = new NumberBaseballManager();
            numberBaseBallManager.start();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
