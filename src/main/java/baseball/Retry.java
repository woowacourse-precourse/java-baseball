package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Retry {
    public static void printSentence(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        requestNum();
    }
    public static void requestNum(){
        int requestNum = Integer.parseInt(Console.readLine());

        if (requestNum == 1){
            //Play.run();
        } else if (requestNum == 2){
            System.out.println("종료합니다");
        }
    }
}
