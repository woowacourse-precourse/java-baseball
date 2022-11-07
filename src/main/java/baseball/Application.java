package baseball;

import java.awt.desktop.SystemEventListener;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        String computerNumber = "";
        Computer computer = new Computer();
        Player player = new Player();
        Start start = new Start();
        Restart restart = new Restart();
        boolean again = true;
        Judge judge = new Judge();
        Rule rule = new Rule();

        start.start(); // 게임 시작

        while (again){ // 3 indent
            // 컴퓨터 숫자 입력
            String result = "";
            String computerNumber = computer.getComputerNumber();
            System.out.println("컴퓨터 숫자는 : " + computerNumber);
            // 플레이어 숫자 입력
            /// ball 계산은 total 에서 strike 빼면 될듯? 예를들어 2개가 겹친다 치고 스트라이크가 1 이면 나머지 1이 볼이된다.
            while (!result.equals("3스트라이크")){
                result = Judge.GameStart(computerNumber, Player.getNumber());
                System.out.println(result);

            }
            again = restart.reStart();
            /// 몇개 숫자가 같은지 = total

        } // while close

    }


}

