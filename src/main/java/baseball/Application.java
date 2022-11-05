package baseball;

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
            int computer = pickNumberInRange(1,9);

            //사용자 값 입력
            System.out.println("let's guess");
            int guess = Integer.parseInt(readLine());

            //판별
            while (guess != computer){
                System.out.println("wrong, guess again");
                guess = Integer.parseInt(readLine());
            }

            System.out.println("right, ending the game");

            //재시작 1, 종료 2
            System.out.println("input 1 for restart, 2 for turn-off");
            status = Integer.parseInt(readLine());
            //1 입력시 다시 시작
        } while (status == 1);

    }
}
