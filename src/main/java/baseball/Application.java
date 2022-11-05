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
            // baseballGameProcess() false 일 때 까지 반복
        }
    }


    private static boolean baseballGameProcess(){
        // 기능 5. 호출 (매개변수 기능 2.)
        return repeatGuessing(makeComputerAnswer());
    }
    


    private static String makeComputerAnswer(){
        String randomResult = "";
        while(randomResult.length() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!randomResult.contains(Integer.toString(randomNumber))){
                randomResult += randomNumber;
            }
        }

        return randomResult;
    }

    private static String inputPlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");

        String guessingNumberString = Console.readLine();
        if (guessingNumberString.length() != 3)
            throw new IllegalArgumentException();

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
            else if (checkResult.equals("ball")){
                ball++;
            }
        }

        return printStrikeAndBall(strike,ball);
    }

    private static String checkIfStrikeOrBall(String computer, String findingNumber, int indexOfFindingNumber){
        if (computer.contains(findingNumber) && computer.charAt(indexOfFindingNumber) == findingNumber.charAt(0)){
            return "strike";
        }
        else if (computer.contains(findingNumber) && computer.charAt(indexOfFindingNumber) != findingNumber.charAt(0)){
            return "ball";
        }
        return "none";
    }

    private static String printStrikeAndBall(int strike, int ball){
        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        }

        else if (strike == 3){
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return "endGame";
        }
        else{
            if (ball != 0){
                System.out.print(ball + "볼 ");
            }
            if (strike != 0){
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
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
        // 프로그램을 종료시킬지 판단하는 변수
        boolean endTheProcess;

        if (Console.readLine().equals("1")) endTheProcess = true;
        else endTheProcess = false;

        return endTheProcess;

    }

}
