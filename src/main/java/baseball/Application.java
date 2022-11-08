package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        welcomeMessage();
        int isGameNotOver = 1;

        while (isGameNotOver == 1) {
            List<Integer> computer = generateComputerNumber();
            List<Integer> userInput = getUserInputNumber();
            while(compareUserNumberToComputers(userInput, computer)==1){
                userInput = getUserInputNumber();
            };
            isGameNotOver = isGameOver();
        }

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

    public static int compareUserNumberToComputers(List<Integer> userInput, List<Integer> computer){
        // 3스트라이크로 종료될 경우 0을 리턴.
        // 그렇지 않은 경우, 1을 리턴.
        int balls = 0;
        int strikes = 0;
        for (int i=0;i<userInput.size();i++){
            Integer digit = userInput.get(i);
            if (!computer.contains(digit))
                continue;
            if (digit.equals(computer.get(i))) {
                strikes += 1;
                continue;
            }
            balls += 1;
        }

        printBallsAndStrikes(balls,strikes);
        if (strikes == 3) {
            return 0;
        }
        return 1;
    }
    public static void printBallsAndStrikes(int balls, int strikes){
        if (balls == 0) {
            if (strikes == 0) {
                System.out.println("낫싱");
                return;
            }
            System.out.println(strikes+"스트라이크");
            return;
        }

        System.out.print(balls+"볼");
        if (strikes!=0){
            System.out.print(" "+strikes+"스트라이크");
        }
        System.out.println();
    }

    public static Integer isGameOver() throws IllegalArgumentException{
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        Integer userInputNumber = 1;
        if (userInput.length() != 1) {
            throw new IllegalArgumentException();
        }
        try{
            userInputNumber = Integer.parseInt(userInput);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return userInputNumber;
    }


}
