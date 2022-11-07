package baseball;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        /*do while문 사용*/
        do{
            //1 재시작, 2 종료
            int judgeNum = JudgeNum();
            if(judgeNum == 2) {
                break;
            }
        }
        while(true);

        /*재시작 종료 판별 메소드 구현*/
        /* 사용자 입력값이 1 재시작, 2 종료 메소드 구현 */
        /* 사용자 입력 메소드 구현*/
        /* 난수 발생 메소드 구현 */
        /* 스트라이크,볼,낫싱 판단 메소드 구현*/
        /*입력 예외 처리, 예외 발생시 IllegalArgumentException 발생 시키기.*/

    }

    /* 재시작, 종료 판별 메소드 구현*/
    private static int JudgeNum(){
        while(true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int inputNum = Integer.parseInt(readLine());
            if(inputNum == 1 )
                return 1;
            if(inputNum == 2)
                return 2;
            System.out.println("잘못된 값을 입력하셨습니다.");
        }
    }
}
