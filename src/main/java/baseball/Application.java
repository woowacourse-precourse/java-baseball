package baseball;

import baseball.domain.manager.NumberBaseBallManager;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            NumberBaseBallManager numberBaseBallManager = new NumberBaseBallManager();
            numberBaseBallManager.start();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
