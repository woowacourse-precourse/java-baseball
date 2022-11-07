package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Domain {

    final int NUMBER_SIZE = 3;


    public List<Integer> getUserNumber() {
        return convertStringToIntegerList(getInputUserNumber());
    }

    public List<Integer> getComputerNumber() {
        return computerRandomNumberExtract();
    }

    public List<Integer> computerRandomNumberExtract() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public String getInputUserNumber() {
        String inputUserNumber = Console.readLine();

        isInputAlright(inputUserNumber);

        return inputUserNumber;
    }


    public void isInputAlright(String userNumber) {

        //입력된 것이 숫자가 아닌 경우 ex) 알파벳이 올 수도 있음
        if (isNotNumber(userNumber)) {
            throw new IllegalArgumentException("숫자가 아님");
        }

        //입력시 길이가 숫자길이가 3이 아닌경우
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("입력 오류");
        }

        //중복된 숫자가 있는지?
        Stream<String> overlapCheck = Arrays.stream(userNumber.split(""));
        long count_exceptDuplicate = overlapCheck.distinct().count();
        if (isDuplicate(userNumber, count_exceptDuplicate)) {
            throw new IllegalArgumentException("입력 숫자 중복");
        }


    }

    private boolean isNotNumber(String userNumber) {
        long isNotNumber_count = userNumber.chars().filter(c -> !(c >= '1' && c <= '9')).count();
        if (isNotNumber_count > 0) {
            return true;
        }
        return false;
    }

    private boolean isDuplicate(String userNumber, long count_exceptDuplicate) {
        return count_exceptDuplicate != userNumber.length();
    }


    public List<Integer> inputProcess(String userNumber) {
        return convertStringToIntegerList(userNumber);
    }

    public List<Integer> convertStringToIntegerList(String userNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        for (int index = 0; index < NUMBER_SIZE; index++) {
            int putNumber = Character.getNumericValue(userNumber.charAt(index));
            userNumberList.add(putNumber);
        }
        return userNumberList;
    }

}
