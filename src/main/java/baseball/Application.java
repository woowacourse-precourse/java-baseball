package baseball;

import baseball.numbers.ComputerNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        ComputerNumbers computerNumbers = new ComputerNumbers(Randoms.pickNumberInRange(1, 9),
                Randoms.pickNumberInRange(1, 9), Randoms.pickNumberInRange(1, 9));

    }
}
