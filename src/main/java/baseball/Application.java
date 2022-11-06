package baseball;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //시작 안내 문구 출력
        System.out.println("시작");

        //게임 상태값 - 1: 진행 2: 종료
        int status = 1;

        //DO
        do {
            //랜덤 숫자 생성

            int[] computer = pickRandomNumbers();
            System.out.println(Arrays.toString(computer));



            int strike = 0;

            while (strike == 0){

                //사용자 값 입력
                System.out.print("let's guess : ");
                int[] guess = guessRandomNumbers();
                System.out.println(Arrays.toString(guess));


                //판별
                int[] StrikeBall = countStrikeBall(computer, guess);
                System.out.println(Arrays.toString(StrikeBall));

                if(judge(StrikeBall, strike) == 1){
                    break;
                } else {
                    judge(StrikeBall, strike);
                }
            }
//            while (guess != computer){
//                System.out.println("wrong, guess again");
//                guess = Integer.parseInt(readLine());
//            }

            System.out.println("right, ending the game");

            //재시작 1, 종료 2
            System.out.println("input 1 for restart, 2 for turn-off");
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
            while (randomNumbers[0] == randomNumbers[1] &&
                    randomNumbers[0] == randomNumbers[2] &&
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
            System.out.printf("%d볼 %d스트라이크",strikeBall[1],strikeBall[0]);
            return strike;
        } else if (strikeBall[0] == 3) {
            strike = 1;
            return strike;
        } else {
            return strike;
        }
    }

    // 재시작 or 종료 메소드
}
