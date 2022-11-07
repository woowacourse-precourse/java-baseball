package baseball;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player extends BaseballNumber {

//    public void getPlayerInput(Scanner scanner) {
//        System.out.println("숫자를 입력해주세요 :");
//        String playerInput = scanner.nextLine();
//
//        List<Integer> playerInputNumbers = isValidBaseballNumber(playerInput);
//        setBaseballNumber(playerInputNumbers);
//    }

    public List<Integer> isValidBaseballNumber(String playerInput) {
        List<Integer> playerNumber = changePlayerInputToList(playerInput);
        boolean checkNumberLength = this.isBaseballNumberLength3(playerNumber);
        boolean checkDuplicateNum = this.isNotDuplicatedNumber(playerNumber);
        boolean checkRangeNum = this.isValidRange(playerNumber);

        if (!checkNumberLength) {
            throw new InputMismatchException("3자리 수를 입력해주세요");
        }

        if (!checkDuplicateNum) {
            throw new InputMismatchException("중복된 수를 입력할 수 없습니다");
        }

        if (!checkRangeNum) {
            throw new InputMismatchException("1~9까지의 수를 입력해주세요");
        }
        return playerNumber;
    }

    public List<Integer> changePlayerInputToList(String playerInput) {
        try {
            List<Integer> playerNumber = Stream.of(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
            this.isValidBaseballNumber(playerNumber);
            return playerNumber;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력해주세요");
        }
    }
}
