package baseball;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            NumberBaseball Game = new NumberBaseball();
            Game.playBall();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int replay = Console.readLine().charAt(0) - 48; // value of '0' = 48
            if( replay == 1){
                continue;
            }
            else if( replay == 2){
                break;
            }
            else{ // wrong input
                throw new IllegalArgumentException();
            }
        }
    }
}
