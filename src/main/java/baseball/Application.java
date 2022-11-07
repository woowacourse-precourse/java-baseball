package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        baseballGameProcessStart();
    }

    private static void baseballGameProcessStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (baseballGameProcess()){
        }
    }

    private static boolean baseballGameProcess(){
        return repeatGuessing(makeComputerAnswer());
    }

    private static String makeComputerAnswer(){
        StringBuilder randomResult = new StringBuilder();
        while(randomResult.length() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!randomResult.toString().contains(Integer.toString(randomNumber))){
                randomResult.append(randomNumber);
            }
        }
        return randomResult.toString();
    }

    private static String inputPlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String guessingNumberString = Console.readLine();
        if (guessingNumberString.length() != 3){
            throw new IllegalArgumentException();
        }
        return guessingNumberString;
    }

    private static String compareComputerAndPlayer(String computer, char[] guessingNumberArray){
        int strike = 0;
        int ball = 0;
        int indexOfFindingNumber = 0;

        for (Character findingNumber : guessingNumberArray){
            String checkResult = checkIfStrikeOrBall(computer, findingNumber.toString(), indexOfFindingNumber);
            indexOfFindingNumber++;
            if (checkResult.equals("strike")){
                strike++;
            }
            if (checkResult.equals("ball")){
                ball++;
            }
        }
        return printStrikeAndBall(strike,ball);
    }

    private static String checkIfStrikeOrBall(String computer, String findingNumber, int indexOfFindingNumber){
        if (computer.contains(findingNumber) && computer.charAt(indexOfFindingNumber) == findingNumber.charAt(0)){
            return "strike";
        }
        if (computer.contains(findingNumber) && computer.charAt(indexOfFindingNumber) != findingNumber.charAt(0)){
            return "ball";
        }
        return "none";
    }

    private static String printStrikeAndBall(int strike, int ball){
        StringBuilder printResult = new StringBuilder();
        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        }
        if (strike == 3){
            printResult.append(strike);
            printResult.append("스트라이크\n");
            printResult.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            printResult.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            System.out.println(printResult);
            return "endGame";
        }
        if (strike < 3){
            if (ball != 0){
                printResult.append(ball);
                printResult.append("볼 ");
            }
            if (strike != 0){
                printResult.append(strike);
                printResult.append("스트라이크");

            }
            System.out.println(printResult);
        }
        return "continueGame";
    }

    private static boolean repeatGuessing(String computer){
        String endOrContinue = "continueGame";
        while (endOrContinue.equals("continueGame")){
            endOrContinue = compareComputerAndPlayer(computer, inputPlayerNumber().toCharArray());
        }
        return selectContinueProgram();
    }

    private static boolean selectContinueProgram(){
        boolean endTheProcess;
        endTheProcess = Console.readLine().equals("1");
        return endTheProcess;
    }
}
