package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List<Integer> randomNumber;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        StartGame();
    }

    public static void StartGame(){
        GetRandomNumber();
        boolean continueGame = true;
        while(continueGame){
            List<Integer> userNumber = GetInputNumber();
            if(userNumber == null) return;


        }
    }

    public static List<Integer> GetInputNumber(){
        //잘못입력된 경우 추가 체크
        try {
            String userInput = GetUserInput();

            if(!CheckMandatory(userInput))
                throw new IllegalArgumentException("입력을 잘못하여 게임이 종료됩니다.");

            return ParseStringToIntList(userInput);
        }
        catch (Exception e) {
            return null;
        }
    }

    public static List<Integer> ParseStringToIntList(String numStr){
        List<Integer> result = new ArrayList<>();
        for(String str : numStr.split("")){
            result.add(Integer.parseInt(str));
        }
        return result;
    }

    public static String GetUserInput(){
        Scanner s = new Scanner(System.in);
        System.out.printf("숫자를 입력해주세요 : ");
        return s.next();
    }

    /*
    입력이 잘못되었다고 판단 되는 경우
    1.글자가 3개가 아닌 경우
    2.글자에 숫자아닌 글자가 포함된 경우
    3.같은 숫자가 2개이상 포함된 경우
     */
    public static boolean CheckMandatory(String userInput){
        if(userInput.length() != 3) return false;

        boolean[] checkSameNumArray = new boolean[10];
        for(int i =0 ; i < 3; i++){
            char userInputWord = userInput.charAt(i);

            if(userInputWord < '0' || userInputWord >'9')
                return false;

            if(checkSameNumArray[userInputWord])
                return false;

            checkSameNumArray[userInputWord] = true;
        }

        return true;
    }


    public static void GetRandomNumber(){
        randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Application.randomNumber.contains(randomNumber)) {
                Application.randomNumber.add(randomNumber);
            }
        }
    }
}
