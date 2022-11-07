package baseball;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        //게임 상태값 - 1: 진행 2: 종료
        int status = 1;
        int strike = 0;

        //첫 판 시작
        do {
            //랜덤 숫자 생성
            int[] computer = pickRandomNumbers();

            //게임 시작
            while (strike == 0){
                //사용자 값 입력
                int[] guess = guessRandomNumbers();

                //스트라이크 볼 카운트 및 판정
                int[] StrikeBall = countStrikeBall(computer, guess);
                strike = judge(StrikeBall, strike);
                }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            //게임 종료되며 스트라이크 초기화
            strike = 0;

            //재시작 1, 종료 2
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            status = Integer.parseInt(readLine());
            //1 입력시 다시 시작
        } while (status == 1);

    }

    // 랜덤 숫자 생성
    public static int[] pickRandomNumbers(){
        int[] randomNumbers = new int[3];

            do {
                randomNumbers[0] = pickNumberInRange(1,9);
                randomNumbers[1] = pickNumberInRange(1,9);
                randomNumbers[2] = pickNumberInRange(1,9);
            }
            while (randomNumbers[0] == randomNumbers[1] ||
                    randomNumbers[0] == randomNumbers[2] ||
                    randomNumbers[1] == randomNumbers[2]);


        return randomNumbers;
    }

    // 사용자 값 입력, 중복되지 않은 3개의 수 String 입력후 인트 배열 반환
        // 3개 미만 초과 입력값에 에러 발생

    public static int[] guessRandomNumbers(){
        int[] randomNumbers = new int[3];
        final String REGEX = "[1-9]+";

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        if (userInput.length() > 3 || userInput.length() < 3 || !userInput.matches(REGEX)){
            throw new IllegalArgumentException();
        }

        for (int i=0; i<userInput.length(); i++){
            randomNumbers[i] = userInput.charAt(i) - '0';
        }

        return randomNumbers;
    }

    // 판별 메소드

    public static int[] countStrikeBall(int[] computer, int[] guess){

        int[] strikeBall = new int[2];
        int strike = 0;
        int ball = 0;

        for (int i=0; i<computer.length; i++){
            for (int j=0; j<guess.length; j++){
                if (computer[i] == guess[j]){
                    if (i==j){
                        strike++;
                    } else {
                        ball ++;
                    }
                }
            }
        }

        strikeBall[0] = strike;
        strikeBall[1] = ball;

        return strikeBall;
    }

    //스트라이크 볼 카운트에 맞춰 값 출력

    public static int judge(int[] strikeBall, int strike){
        if (strikeBall[0] == 0 && strikeBall[1] == 0){
            System.out.println("낫싱");
            return strike;
        } else if (strikeBall[0] != 3) {
            System.out.printf("%d볼 %d스트라이크%n",strikeBall[1],strikeBall[0]);
            return strike;
        } else if (strikeBall[0] == 3) {
            System.out.println("3스트라이크");
            strike = 1;
            return strike;
        } else {
            return strike;
        }
    }

}
