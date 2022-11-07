package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameChecker {
    boolean restartGame;
    public void startGame(){
        BaseballGame game=new BaseballGame();
        game.setComputer();
        game.playing();
    }

    public void askContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String restart= Console.readLine();

        if(restart.equals("2")){
            this.restartGame =false;
        }
        else if(restart.equals("1")){
            this.restartGame =true;
        }
        else if(!restart.equals("1")){
            IllegalArgumentException e=new IllegalArgumentException("재시작 입력 오류");
            throw e;
        }
    }
}
