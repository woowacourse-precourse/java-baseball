package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void welcomeMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber))
                computerNumber.add(randomNumber);
        }
        return computerNumber;
    }

    public static List<Integer> getUserInputNumber() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 :");
        String userInput = readLine();
        List<Integer> userInputList = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            try{
                int digit = returnOneDigit(userInput, i);
                userInputList.add(digit);
            }catch (Exception e){
                throw new IllegalArgumentException();
            }

        }
        return userInputList;
    }

    public static Integer returnOneDigit(String userInput, int startIndex) throws NumberFormatException{

        int digit = Integer.parseInt(userInput.substring(startIndex, startIndex + 1));
        if (digit <= 0 || digit > 9) {
            throw new NumberFormatException();
        }
        return digit;
    }


}
