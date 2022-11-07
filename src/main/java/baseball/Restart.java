package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Restart {

    public static void untilRight(boolean isRight, String computerNumber){
        if(isRight){
            restartGame();
        }
        else{
            String playerNumber = GameSet.inputPlayerNumber();
            isRight = CompareNumber.checkRight(computerNumber, playerNumber);
            untilRight(isRight, computerNumber);
        }
    }

    public static void restartGame(){
        //System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String menu = readLine();

        if(menu.equals("1")){
            Game.run();
        }
        else if(menu.equals("2")){
            System.out.println("게임 종료");
            return ;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
