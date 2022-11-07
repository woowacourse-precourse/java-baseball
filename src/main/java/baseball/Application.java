package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameRestartWhether = true;
        while (gameRestartWhether){
            System.out.println("숫자 야구 게임을 시작합니다.");
            startGame(new Game());
            gameRestartWhether = getGameRestartWhether();
        }
    }


    static void startGame(Game game){
    }

    static boolean getGameRestartWhether(){
        while (true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            final String input = Console.readLine();

            if (input.equals("1")){
                return true;
            }
            else if(input.equals("2")){
                return false;
            }
            else{
                System.out.println("입력값을 다시 확인해주세요.");
                continue;
            }
        }
    }
}
