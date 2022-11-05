package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    public List<Integer> getComputerNumberList() {
        ArrayList<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = getValidRandomNumber(computerNumberList);
            computerNumberList.add(randomNumber);
        }
        return computerNumberList;
    }

    private int getValidRandomNumber(List<Integer> lst) {
        int pickNumber;
        do {
            pickNumber = Randoms.pickNumberInRange(1, 9);
        } while (!isValidNumber(pickNumber, lst));
        return pickNumber;
    }

    public boolean isValidNumber(int number, List<Integer> lst) {
        if (number < 1 || number > 9) {
            return false;
        }
        return !lst.contains(number);
    }

    public List<Integer> getUserNumberList() {
        List<Integer> lst = new ArrayList<>();
        String input = Console.readLine();
        if (!isValidSize(input)) {
            throw new IllegalArgumentException();
        }
        for (int index = 0; index < 3; index++) {
            int indexInt = charToInt(input.charAt(index));
            if (!isValidNumber(indexInt, lst)) {
                throw new IllegalArgumentException();
            }
            lst.add(indexInt);
        }
        return lst;
    }


    private int charToInt(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }
        return c - '0';
    }

    private boolean isValidSize(String input) {
        return input.length() == 3;
    }
}
