package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String readLine = Console.readLine();

        int randomNumber = Randoms.pickNumberInRange(1, 9);



        System.out.println("readLine = " + readLine);
        System.out.println("randomNumber = " + randomNumber);
        // TODO: 프로그램 구현
    }
}
