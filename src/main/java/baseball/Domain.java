package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Domain {

    String userNumber;
    List<Integer> computerNumber;
    List<Integer> userNumberList;



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

    public static List<Integer> computerRandomNumberExtract() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String getInputUserNumber() { // test 입력시오류경우_확인
        String inputUserNumber = Console.readLine();

        isInputAlright(inputUserNumber);

        return inputUserNumber;
    }


    public static void isInputAlright(String userNumber) { // test 입력시오류경우_확인
        //입력시 길이가 숫자길이가 3이 아닌경우
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("입력 오류");
        }
        //중복된 숫자가 있는지?
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                char nowIndexUserNumber = userNumber.charAt(i);
                char otherIndexUserNumber = userNumber.charAt(j);
                inputOverlapCheck(nowIndexUserNumber, otherIndexUserNumber);
            }
        }
    }

    public static List<Integer> inputProcess(String userNumber) { // test 입력시오류경우_확인
        return convertStringToIntegerList(userNumber);
    }

    public static List<Integer> convertStringToIntegerList(String userNumber) { // test 입력시오류경우_확인
        List<Integer> userNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int putNumber = Character.getNumericValue(userNumber.charAt(i));
            userNumberList.add(putNumber);
        }
        return userNumberList;
    }

    public static void inputOverlapCheck(char nowIndexUserNumber,
        char otherIndexUserNumber) {  // test 입력시오류경우_확인
        if (nowIndexUserNumber == otherIndexUserNumber) {
            throw new IllegalArgumentException("입력 숫자중 중복");
        }
    }
}
