package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.io.*;
public class Application {
    public static List<Integer> Computer_Number() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void isValidLength(String s) {
        if (s.length() != 3) {
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = Computer_Number();

        String user = Console.readLine();
        isValidLength(user);
    }
}
