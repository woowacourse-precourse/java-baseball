package baseball;
import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class user {
    public static List<Integer> inputUserNumber() {
        System.out.println("숫자를 입력해 주세요.");
        String enterUserNumber = readLine();
        List<Integer> userNumber = new ArrayList<>();
        userNumber = checkValidUserNumber(enterUserNumber);
        return userNumber;
    }

    public static List<Integer> checkValidUserNumber(String str){
        List<Integer> userNumber;
        checkDataType(str);
        checklength(str);
        userNumber = checkNotEqual(str);
        return userNumber;
    }

    private static void checkDataType(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private static void checklength(String str) {
        if (str.length() != 3){
            throw new IllegalArgumentException("숫자 3개를 입력해 주세요.");
        }
    }

    private static void checkArray(String str){
        for (char number = str.toCharArray()){
            if (number == '0'){
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력해 주세요.");
            }
        }
    }

    private static List<Integer> checkNotEqual(String str) {
        List<Integer> userNumberList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int Number = Character.getNumericValue(str.charAt(i));
            if (userNumberList.contains(Number)) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해 주세요.");
            }
            userNumberList.add(Number);
        }
        return userNumberList;
    }
}
