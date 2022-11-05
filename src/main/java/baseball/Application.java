package baseball;

import java.util.Random;

public class Application {

    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
