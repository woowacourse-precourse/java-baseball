package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class Application {
    public static void main(String[] args) {
        boolean cont = true;
        List<Integer> computer, guess;
        int[] comparison;
        String result;
        while (cont) {
            comparison = new int[2];
            computer = generateRandomNumbers();
            printComputer(computer);
            while (comparison[1] < 3) {
                guess = inputGuess();
                comparison = compareGuessToComputer(guess, computer);
                result = gameResults(comparison);
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            cont = inputReplay();

        }

    }
    static void printComputer(List<Integer> computer) {
        for (int i = 0; i < computer.size(); i ++) {
            System.out.print(computer.get(i));
        }
        System.out.println();
    }
    static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    static void validateOnlyNumbers(String guess) {
        try {
            int numbers = Integer.parseInt(guess);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다. 프로그램을 종료합니다");
        }
    }
    static void validateNumberOfValues(String guess, int num) {
        if (guess.length() != num) {
            throw new IllegalArgumentException("숫자 세 개만 입력이 가능합니다. 프로그램을 종료합니다.");
        }
    }
    static int[] compareGuessToComputer(List<Integer> guess, List<Integer> computer) {
        int[] comparison = new int[2];
        int num;
        for (int order = 0; order < guess.size(); order ++) {
            num = guess.get(order);
            if (computer.contains(num) && (order != computer.indexOf(num))) {
                comparison[0]++;
            }
            else if (computer.contains(num) && (order == computer.indexOf(num))) {
                comparison[1]++;
            }
        }
        return comparison;
    }
    static String gameResults(int[] comparison) {
        String result = "";
        if ((comparison[0]==0) && (comparison[1]==0)) {
            result = "낫싱";
            return result;
        }
        if (!(comparison[0]==0)) {
            result += comparison[0]+"볼 ";
        }
        if (!(comparison[1]==0)) {
            result += comparison[1]+"스트라이크";
        }
        return result;
    }
    static List<Integer> inputGuess() {
        List<Integer> guess = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String guessString = Console.readLine();
        validateOnlyNumbers(guessString);
        validateNumberOfValues(guessString, 3);
        for (int idx=0; idx < guessString.length(); idx++){
            guess.add(Character.getNumericValue(guessString.charAt(idx)));
        }
        return guess;
    }
    static boolean inputReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String replay = Console.readLine();
        validateOnlyNumbers(replay);
        validateNumberOfValues(replay, 1);
        int replayNum = Integer.parseInt(replay);
        validateInRange(replayNum);
        if (replayNum == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    static void validateInRange(int num) {
        if (!(1 <= num && num <= 2)) {
            throw new IllegalArgumentException("1 또는 2만 입력이 가능합니다");
        }
    }


}
