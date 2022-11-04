package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // TODO : 1. 숫자 야구 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // TODO : 2. 컴퓨터가 가지고 있는 정답 문자열을 랜덤으로 지정
        // TODO : (각 자리마다 숫자가 다르게)
        String computer="";
        while(computer.length() < 3){
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if (!computer.contains(Integer.toString(randomNumber))){
                computer += randomNumber;
            }
        }

        // TODO : 3. 사용자가 도전할 숫자를 입력
        System.out.print("숫자를 입력해주세요 : ");
        String guessingNumberString = Console.readLine();

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
        else{
            if (ball != 0){
                System.out.print(ball + "볼 ");
            }
            if (strike != 0){
                System.out.print(strike + "스트라이크");
            }
        }
        System.out.println();
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
