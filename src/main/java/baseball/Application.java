package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public static void availableUserNumberIsChecked(String word){
        String regularExpression = "^[1-9^[1-9^[1-9]]]{3}$";
        boolean result = Pattern.matches(regularExpression,word);

        System.out.println(result);
        if(!result){
            throw new IllegalArgumentException("유효하지 않는 값입니다");
        }
    }

    public static String inputAvailableUserNumberService(){
        String userNumbers = "";
        userNumberMessagePrint();
        userNumbers = userNumberInput();
        availableUserNumberIsChecked(userNumbers);
        return userNumbers;
    }

    public static List<Integer> stringToListCreate(String word){
        String[] stringToArray = word.split("");
        List<Integer> arrayToList = new ArrayList<>();
        for(String arrayElementIndex : stringToArray){
            if(arrayToList.contains(Integer.parseInt(arrayElementIndex))){
                throw new IllegalArgumentException("유효하지 않은 값입니다.");
            }
            arrayToList.add(Integer.parseInt(arrayElementIndex));
        }
        return arrayToList;
    }

    public static int checkStrikeNumbers(List<Integer> computerNumbers,
                                         List<Integer> userNumbers){
        int checkedStrikeNumbers = 0;
        for(int listElements = 0; listElements < computerNumbers.size(); listElements++){
            if(computerNumbers.get(listElements).equals(userNumbers.get(listElements))){
                checkedStrikeNumbers++;
            }
        }
        return checkedStrikeNumbers;
    }

    public static int checkedBallNumbers(List computerNumbers,List userNumbers){
        int checkedBallNumbers = 0;
        for(int listElements = 0; listElements < userNumbers.size(); listElements++){
            if(computerNumbers.contains(userNumbers.get(listElements))){
                checkedBallNumbers++;
            }
        }
        return checkedBallNumbers;
    }

    public static Map<String,Integer> calculatedStrikeBallNumber(int strikeNumber,int ballNumber){
        Map<String,Integer> checkedBaseballNumbers = new HashMap<>(){{
            put("strike",0);
            put("ball",0);
        }};

        if(0 <= strikeNumber && strikeNumber <=3 ){
            checkedBaseballNumbers.put("strike",strikeNumber);
            checkedBaseballNumbers.put("ball",ballNumber - strikeNumber);
        }

        return checkedBaseballNumbers;
    }

    public static void printToRestartingGameMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종류하려면 2를 입력하세요.");
    }

    public static String inputUserAnswer(){
        String userAnswer = readLine();
        return userAnswer;
    }

    public static void availableUserAnswerIsChecked(String word){
        String userAnswer = word;
        String regularExpression = "^[1-2]{1}$";
        boolean result = Pattern.matches(regularExpression,userAnswer);
        if(!result){
            throw new IllegalArgumentException("유효하지 않는 값입니다.");
        }
    }

    public static boolean printBaseballOfResult(int strikeSize, int ballSize){
        int strikeNumber = strikeSize;
        int ballNumber = ballSize;

        if(strikeNumber == 3){
            System.out.println("3스트라이크");
        }

        return false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        baseballGameStart();
        inputAvailableUserNumberService();
    }
}
