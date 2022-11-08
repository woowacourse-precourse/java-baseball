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
        while (true){
        int strike = 0;
        List<Integer> randomNumber = makeRandomNumber();
        while (strike <3){
            strike = playBaseBallGameOneCycle(randomNumber);
        }
            Integer userInput = selectPlayMoreGame();
            if(userInput==1){
              continue;
            }
            else if(userInput==2){
                return;
            }else {
               throw new IllegalArgumentException();
            }
        }
    }
//유저 입력으로 더 게임을 할지 말지 결정
    public static Integer selectPlayMoreGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String s = Console.readLine();
        Integer userInput = Integer.parseInt(s);
        return userInput;
    }

    public static int playBaseBallGameOneCycle(List<Integer> randomNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userInput = getUserInput();
        Map<String, Integer> outputManager = checkMatchNumber(randomNumber,userInput);
        Integer strike = outputManager.get("스트라이크");
        Integer ball = outputManager.get("볼");
        printResult(strike, ball);
        return strike;
    }

    public static void printResult(Integer strike, Integer ball) {
        if(ball ==0&& strike ==0){
            System.out.println("낫싱");
        }else if(strike ==0){
            System.out.println(ball +"볼");
        }else if(ball ==0){
            System.out.println(strike +"스트라이크");
        }else {
            System.out.println(ball +"볼 "+ strike +"스트라이크");
        }
    }

    public static Map<String, Integer> checkMatchNumber(List<Integer> randomNumber, List<Integer> userInput) {
        Map<String, Integer> outputManager = new HashMap<>();
        int ballCount = 0;
        int strikeCount = 0;
        for (Integer number : userInput) {
            ballCount = getBallCount(randomNumber,userInput, ballCount, number);
            strikeCount = getStrikeCount(randomNumber, userInput, strikeCount, number);
        }
        outputManager.put("스트라이크", strikeCount);
        outputManager.put("볼", ballCount);
        return outputManager;
    }

    public static int getStrikeCount(List<Integer> randomNumber, List<Integer> userInput, int strikeCount, Integer number) {
        if(randomNumber.contains(number)){
            if(randomNumber.indexOf(number)== userInput.indexOf(number)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static int getBallCount(List<Integer> randomNumber,List<Integer> userInput, int ballCount, Integer number) {
        if (randomNumber.contains(number)) {
            if(randomNumber.indexOf(number)!=userInput.indexOf(number))
            ballCount++;
        }
        return ballCount;
    }

    public static List<Integer> getUserInput() {
        ArrayList<Integer> result = new ArrayList<>();
        String userInputString = Console.readLine();
        checkUserInput(result, userInputString);
        return result;
    }

    public static void checkUserInput(ArrayList<Integer> result, String userInputString) {
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
        System.out.println(computer);
        return computer;
    }

    public static void makeRandomNumbers(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addRandomOneNumber(computer, randomNumber);
        }
    }

    public static void addRandomOneNumber(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}
