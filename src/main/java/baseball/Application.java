package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        
        //프로그램 종료 의사를 확인하는 변수

        
        // TODO : 1. 숫자 야구 게임 시작 문구 출력, 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // TODO  : 7. 1을 입력 받으면 2. 에서 6. 까지의 과정을 다시 반복, 2을 입력 받으면 종료
        // 기능 2. 에서 6을 묶어놓은 baseballGameProcess()
        // 게임 한 번이 끝나면 다른 게임을 할 지 안 할 지 결과값을 리턴해준다
        while (baseballGameProcess()==1){
            //baseballGameProcess() 가 1이면 계속 반복, 아니면 끝난다.
        }
    }

    // 기능 2. 에서 6. 묶어놓은 함수
    private static int baseballGameProcess(){
        int endTheProcess = 1;

        String computer = makeComputerAnswer();


        // TODO : 5. 답을 맞추지 못하면 3. 다시 실행, 아니면 반복 멈춤

        // 사용자가 맞출 때 까지의 무한 반복
        while (true){

            // TODO : 3. 사용자가 도전할 숫자를 입력
            System.out.print("숫자를 입력해주세요 : ");

            //사용자가 입력하는 숫자에 대한 문자열
            String guessingNumberString = Console.readLine();

            if (guessingNumberString.length() != 3)
                throw new IllegalArgumentException();




            // TODO : 4. 컴퓨터의 정답과 사용자가 입력한 숫자를 비교 후 결과 출력
            int strike=0;
            int ball=0;

            char[] guessingNumberArray = guessingNumberString.toCharArray();

            int indexOfFindingNumber = 0;
            for (Character findingNumber : guessingNumberArray){
                //strike, ball 인지 판단하는 함수
                String checkResult = checkIfStrikeOrBall(computer, findingNumber.toString(), indexOfFindingNumber);
                indexOfFindingNumber++;
                if (checkResult.equals("strike")){
                    strike++;
                }
                else if (checkResult.equals("ball")){
                    ball++;
                }
            }


            if (strike == 0 && ball == 0){
                System.out.println("낫싱");
            }
            // TODO : 5. 답을 맞추지 못하면  3. 다시 실행, 아니면 반복 멈춤
            else if (strike == 3){
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
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
        }




        //TODO : 6. 다른 게임을 진행할 지 , 아니면 프로그램을 멈출 지 1 나 2 입력 받기
        if (Console.readLine().equals("1")) endTheProcess=1;
        else endTheProcess=2;

        return endTheProcess;
    }

    // TODO : 2. 컴퓨터가 가지고 있는 정답 문자열을 랜덤으로 지정
    // (각 자리마다 숫자가 다르게)
    private static String makeComputerAnswer(){
        String randomResult="";
        while(randomResult.length() < 3){
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if (!randomResult.contains(Integer.toString(randomNumber))){
                randomResult += randomNumber;
            }
        }

        return randomResult;
    }


    //strike, ball 인지 판단하는 함수
    private static String checkIfStrikeOrBall(String computer, String findingNumber, int indexOfFindingNumber){
        if (computer.contains(findingNumber) && computer.charAt(indexOfFindingNumber) == findingNumber.charAt(0)) {
            return "strike";
        }
        else if (computer.contains(findingNumber) && computer.charAt(indexOfFindingNumber) != findingNumber.charAt(0)) {
            return "ball";
        }

        return "none";
    }
}
