package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public List<Integer> IsCorrectInputNum(String userInput) {
        List<Integer> userNum = new ArrayList<>();

        try{
            Integer.parseInt(userInput);
        }
        catch (NumberFormatException e) {
            System.out.println("숫자만 입력해 주세요");
            throw new IllegalArgumentException();
        }

        if(Integer.parseInt(userInput)> 999 || Integer.parseInt(userInput) < 100) {
            System.out.println("세자리 수를 입력해 주세요");
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < userInput.length(); i++) {
            userNum.add(Character.getNumericValue(userInput.charAt(i)));
        }

        Set<Integer> checkDuplication = new HashSet<>(userNum);

        if(checkDuplication.size() != userNum.size()) {
            System.out.println("중복 되지 않는 수를 입력해 주세요");
            throw new IllegalArgumentException();
        }
        return userNum;
    }
    
    public String checkGameRestart(String userInput) {
        if(userInput.equals("1") == false && userInput.equals("2") == false) {
            System.out.println("1 또는 2만 입력해 주세요");
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    public List<Integer> computerNumber(){
        List<Integer> num = new ArrayList<>();
        while(num.size()<3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
        return num;
    }

    public int checkStrike(List<Integer>computerNum, List<Integer>userNum) {
        int countStrike = 0;
        for(int i = 0; i < computerNum.size(); i++) {
            if(computerNum.get(i) == userNum.get(i)) {
                countStrike++;
            }
        }

        return countStrike;
    }

    public int checkBall(List<Integer>computerNum, List<Integer>userNum, int countStrike) {
        int countBall = 0;
        for(int i = 0; i < computerNum.size(); i++) {
            if(userNum.contains(computerNum.get(i))) {
                countBall++;
            }
        }
        countBall = countBall - countStrike;
        return countBall;
    }

    public String printResult(List<Integer>computerNum, List<Integer>userNum) {
        int strikeCount = checkStrike(computerNum, userNum);
        int ballCount = checkBall(computerNum, userNum, strikeCount);

        if(strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        if(strikeCount == 0) {
            return ballCount+"볼";
        }

        if(ballCount == 0) {
            return strikeCount+"스트라이크";
        }

        return ballCount+"볼 "+strikeCount+"스트라이크";

    }

    public void gameRun() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNum = computerNumber();
        List<Integer> userNum;

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            userNum = IsCorrectInputNum(input);
            System.out.println(printResult(computerNum, userNum));

            if(printResult(computerNum, userNum).equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = Console.readLine();

                if(checkGameRestart(input).equals("1")) {
                    computerNum = computerNumber();
                }

                if (checkGameRestart(input).equals("2")) {
                    System.out.println("게임 종료");
                    break;
                }
            }

        }
    }


    public static void main(String[] args) {
        Application application = new Application();
        application.gameRun();
    }


}
