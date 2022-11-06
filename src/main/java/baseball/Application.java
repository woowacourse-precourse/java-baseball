package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void baseballGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> randomNumberCreate(){
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public static void userNumberMessagePrint(){
        System.out.print("숫자를 입력하세요 : ");
    }

    public static String userNumberInput(){
        String userNumber = readLine();
        return userNumber;
    }

    public static boolean availableUserNumberIsChecked(String word) throws IllegalAccessError{
        String regularExpression = "^[0-9]{3}^+$";
        boolean result = Pattern.matches(regularExpression,word);

        try{
            if(!result){
                throw new IllegalAccessError("유효하지 않은 값입니다.");
            }
        }catch(IllegalAccessError illegalAccessError){
            illegalAccessError.printStackTrace();
            result = true;
        }
        return result;
    }

    public static String inputAvailableUserNumberService(){
        String userNumbers = "";
        boolean availableUserNumberIsChecking = false;
        userNumberMessagePrint();
        userNumbers = userNumberInput();
        return "";
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        baseballGameStart();
        randomNumberCreate();
        userNumberMessagePrint();
        String userNumbers = userNumberInput();
        boolean results = availableUserNumberIsChecked(userNumbers);
    }
}
