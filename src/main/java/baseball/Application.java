package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Number number = new Number();
        String inputNumber = readLine();
        number.setNumber(inputNumber);
    }
}
