package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static List<Integer> generateRandomNumber() {
        List<Integer> generatedNumber = new ArrayList<>();
        while (generatedNumber.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumber.contains(randomNumber)){
                generatedNumber.add(randomNumber);
            }
        }
        return generatedNumber;
    }

    public static List<Integer> checkStrike (List<Integer> generatedNumber, List<Integer> userNumber){
        List<Integer> standardNumber = new ArrayList<>(generatedNumber);
        List<Integer> inputNumber = new ArrayList<>(userNumber);
        List<Integer> strikeIndex = new ArrayList<>();
        for(int listIndex=0; listIndex < 3; listIndex ++){
            if(standardNumber.get(listIndex).equals(inputNumber.get(listIndex))){
                strikeIndex.add(listIndex);
            }
        }
        return strikeIndex;
    }

    public static int checkBall (List<Integer> generatedNumber, List<Integer> userNumber, List<Integer> indexOfStrike){
        List<Integer> standardNumber = new ArrayList<>(generatedNumber);
        List<Integer> inputNumber = new ArrayList<>(userNumber);
        List<Integer> strikeIndex = new ArrayList<>(indexOfStrike);
        int count = 0;
        for(int listIndex=0; listIndex < 3; listIndex++){
            if(standardNumber.contains(inputNumber.get(listIndex))){
                count += 1;
            }
            if(strikeIndex.contains(listIndex)){
                count -= 1;
            }
        }
        return count;
    }

    public static List<Integer> stringToList (String input){
        int integerInput = Integer.parseInt(input);
        List<Integer> listInput = new ArrayList<>();
        while(integerInput > 0){
            listInput.add(integerInput % 10);
            integerInput /= 10;
        }
        Collections.reverse(listInput);
        return listInput;
    }

    public static void runBaseballGame (){
        List<Integer> standardNumber = new ArrayList<>(generateRandomNumber());
        int strikeCount = 0;
        int ballCount;

        while(strikeCount != 3){
            System.out.print("숫자를 입력해 주세요 : ");

            String userString = Console.readLine();
            List<Integer> userNumber =stringToList(userString);
            List<Integer> strikeIndex =checkStrike(standardNumber, userNumber);
            strikeCount = strikeIndex.size();
            ballCount =checkBall(standardNumber, userNumber, strikeIndex);

            if((strikeCount == 0) && (ballCount == 0)){
                System.out.println("낫싱");
                continue;
            }

            if(strikeCount == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하시려면 2를 입력하세요.");
                break;
            }

            String ballCountString = "";
            if(ballCount > 0){
                ballCountString = ballCount + "볼 ";
            }

            String strikeCountString = "";
            if(strikeCount > 0){
                strikeCountString = strikeCount + "스트라이크";
            }

            System.out.println(ballCountString + strikeCountString);
        }
    }

    public static void main(String[] args) {
        int gameStatus = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameStatus == 1){
            runBaseballGame();
            String userStatus = Console.readLine();
            gameStatus = Integer.parseInt(userStatus);
        }
    }
}
