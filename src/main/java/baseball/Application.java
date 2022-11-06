package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> createComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int askUserTheNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        int input = Integer.parseInt(Console.readLine());
        if (!isNumberValid(input)) throw new IllegalArgumentException();
        return input;
    }

    public static boolean isNumberValid(int number) {
        List<Integer> prototype = breakInteger(number);
        return hasDuplicates(prototype) && !hasZero(prototype) && isNumberInRange(number);
    }

    public static List<Integer> breakInteger(int number) {
        List<Integer> list = new ArrayList<>();
        int reverse = 0;
        // reverse the number
        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        while (reverse > 0) {
            list.add(reverse % 10);
            reverse /= 10;
        }
        return list;
    }

    public static boolean hasZero(List<Integer> list) {
        int sum = 1;
        for (int elem : list) sum *= elem;
        return sum == 0;
    }

    public static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (int elem : list) {
            if (!set.add(elem)) return false;
        }
        return true;
    }

    public static boolean isNumberInRange(int number){
        return ((number / 100 >= 1) && (number / 100 < 10));
    }
}
