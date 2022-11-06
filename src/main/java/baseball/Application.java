package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1.랜덤한 3자리수를 생성한다.
//2.플레이어에게 세자리 수를 입력받는다.
//3.입력받은 세 자리 수 중 컴퓨터가 생성한 랜덤한 수와 같은 숫자가 있으면 1볼
//4.그 중에 자리까지 같으면 1스트라이크가 된다.
//5.최종 결과를 보고 다 맞추면 3스트라이크
//6.아니라면 힌트를 반환
//7.이후 유저 입력으로 새로운게임을 할지 종료할지 결정
public class Application {
    public static void main(String[] args) {

        playBaseBallGameOneCycle();


    }

    private static void playBaseBallGameOneCycle() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> randomNumber = makeRandomNumber();
        List<Integer> userInput = getUserInput();
        Map<String, Integer> outputManager = checkMatchNumber(randomNumber,userInput);
        Integer strike = outputManager.get("스트라이크");
        Integer ball = outputManager.get("볼");
        printResult(strike, ball);
    }

    private static void printResult(Integer strike, Integer ball) {
        if(ball ==null&& strike ==null){
            System.out.println("낫싱");
        }else if(strike ==null&& ball !=null){
            System.out.println(ball +"볼");
        }else if(strike !=null&& ball ==null){
            System.out.println(strike +"스트라이크");
        }else {
            System.out.println(ball +"볼 "+ strike +"스트라이크");
        }
    }

    private static Map<String, Integer> checkMatchNumber(List<Integer> randomNumber, List<Integer> userInput) {
        Map<String, Integer> outputManager = new HashMap<>();
        int ballCount = 0;
        int strikeCount = 0;
        for (Integer number : userInput) {
            ballCount = getBallCount(randomNumber, ballCount, number);
            strikeCount = getStrikeCount(randomNumber, userInput, strikeCount, number);
        }
        outputManager.put("스트라이크", strikeCount);
        outputManager.put("볼", ballCount);
        return outputManager;
    }

    private static int getStrikeCount(List<Integer> randomNumber, List<Integer> userInput, int strikeCount, Integer number) {
        if(randomNumber.contains(number)){
            if(randomNumber.indexOf(number)== userInput.indexOf(number)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static int getBallCount(List<Integer> randomNumber, int ballCount, Integer number) {
        if (randomNumber.contains(number)) {
            ballCount++;
        }
        return ballCount;
    }

    private static List<Integer> getUserInput() {
        ArrayList<Integer> result = new ArrayList<>();
        String userInputString = Console.readLine();
        checkUserInput(result, userInputString);
        return result;
    }

    private static void checkUserInput(ArrayList<Integer> result, String userInputString) {
        if (userInputString.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < userInputString.length(); i++) {
            int userInputOneNum = Integer.parseInt(String.valueOf(userInputString.charAt(i)));
            if (result.contains(userInputOneNum)) {
                throw new IllegalArgumentException();
            }
            result.add(userInputOneNum);
        }
    }

    public static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        makeRandomNumbers(computer);

        return computer;
    }

    private static void makeRandomNumbers(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addRandomOneNumber(computer, randomNumber);
        }
    }

    private static void addRandomOneNumber(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}
