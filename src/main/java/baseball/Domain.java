package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Domain {

    String userNumber;
    List<Integer> computerNumber;
    final int NUMBER_SIZE =3;


    public List<Integer> getUserNumber() {
        return convertStringToIntegerList(getInputUserNumber());
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public List<Integer> getComputerNumber() {
        return computerRandomNumberExtract();
    }

    public void setComputerNumber(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
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

    public String getInputUserNumber() { // test 입력시오류경우_확인
        String inputUserNumber = Console.readLine();

        isInputAlright(inputUserNumber);

        return inputUserNumber;
    }


    public void isInputAlright(String userNumber) { // test 입력시오류경우_확인

        //입력된 것이 숫자가 아닌 경우 ex) 알파벳이 올 수도 있음
        if (!isNumber(userNumber)) {
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

    private boolean isDuplicate(String userNumber, long count_exceptDuplicate) {
        return count_exceptDuplicate != userNumber.length();
    }


    private boolean isNumber(String userNumber) {

        for (int index = 0; index < userNumber.length(); index++) {
            char c = userNumber.charAt(index);
            if (c >= '1' && c <= '9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public List<Integer> inputProcess(String userNumber) { // test 입력시오류경우_확인
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
