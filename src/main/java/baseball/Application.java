package baseball;

import camp.nextstep.edu.missionutils.Console;


/**
 * 야구게임 시작
 * */
public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        int select = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (select == 1){
            game.start();
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            select = Integer.parseInt(Console.readLine());
        }
        System.out.println("게임 종료");
        //야구 게임 시작
        //do while 문 시작
        //랜덤 수 생성
        //3 스트라이크 전까지 while 문
        //숫자를 입력받고 검증한 뒤 결과 반환하는 메소드
    }
}
