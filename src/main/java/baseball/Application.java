package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        int answer = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(111,999);
        System.out.println(answer);
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = getUserInput();
        int userGuess = validateUserInput(userInput, 3);

        List<Integer> comparedResult = compareAnswerWithInput(answer,userInput);

//        printStrikeAndBall(comparedResult);


    }

    public static String getUserInput(){
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return userInput;
    }

    public static int validateUserInput(String userInput , int checkLength) throws IllegalArgumentException{
        try{
            int userGuess = Integer.parseInt(userInput);

            if (userInput.length()!=checkLength){
                throw new IllegalArgumentException("Wrong input length");
            }
            return userGuess;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Input should be 3 digit numbers in the range of 111~999");
        }
    }

    public static List<Integer> compareAnswerWithInput(int answer, int userInput){
        int strikeCount = 0;
        int ballCount = 0;

        List<Integer> answerDigits = getDigitList(answer);
        List<Integer> inputDigits = getDigitList(userInput);

        for (int i = 0; i<3; i++){
            int answerDigit = answerDigits.get(i);
            int inputDigit = inputDigits.get(i);

            if (answerDigit == inputDigit){
                strikeCount++;
                ballCount--;
            }
            if (answerDigits.contains(inputDigit)){
                ballCount++;
            }
        }

        return List.of(strikeCount,ballCount);
    }

    private static List<Integer> getDigitList(int numbers){
        int tmp = numbers;
        ArrayList<Integer> digits = new ArrayList<Integer>();

        while (tmp>0){
            int digit = tmp % 10;
            digits.add(digit);
            tmp = tmp / 10;
        }

        return digits;
    }



}
