package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {

    static int scanStartNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int userNumber = scanStartNumber();
    }
}