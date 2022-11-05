package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int status = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");

        int answer = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(111,999);
        System.out.println(answer);
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = getUserInput();
        int userGuess = validateUserInput(userInput,3);

        List<Integer> comparedResult = compareAnswerWithInput(answer,userGuess);

        status = printStrikeAndBall(comparedResult);




    }

    public static String getUserInput(){
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return userInput;
    }

    private static int validateUserInput(String userInput , int checkLength) throws IllegalArgumentException{
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

    public static int printStrikeAndBall(List<Integer> comparedResult){
        int strikeCount = comparedResult.get(0);
        int ballCount = comparedResult.get(1);

        if (ballCount == 0 && strikeCount == 0){
            System.out.println("낫싱");
            return 0;
        }

        if (strikeCount==3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return 1;
        }

        if (ballCount>0){
            System.out.print(ballCount+"볼 ");
        }

        if (strikeCount>0){
            System.out.print(strikeCount+"스트라이크 ");
        }
        return 0;
    }


}
