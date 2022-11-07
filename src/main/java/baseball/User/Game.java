package baseball.User;

import baseball.Count.TotalCount;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    //
    private static int InputNum() {
        String playerNum = readLine();


        return Integer.parseInt(playerNum);
    }
    static String InputSt(){
        String playerSt = readLine();
        return playerSt;
    }

    TotalCount ballCount = new TotalCount();

    public boolean startGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int op = InputNum();
        if(op==1){
            return true;
        }
        if(op==2){
            System.out.println("게임 종료");
            return false;
        }
        throw new IllegalArgumentException();

    }

    public void InputPlayerCheck(int [] answer){
        InputPlayer inputPlayer = new InputPlayer();
        while(true){
            int [] userNumber = inputPlayer.enterAnswer();

            if(ballCount.printBallCount(answer, userNumber)==1)
                break;
        }
    }


}