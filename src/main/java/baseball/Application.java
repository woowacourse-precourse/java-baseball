package baseball;

import static baseball.Constant.gameStartMessage;

public class Application {
    public static void main(String[] args){
        GameSystem gameSystem = new GameSystem();
        boolean exit;

        do{
            //게임 시작 메시지 출력
            System.out.println(gameStartMessage);
            //게임 시작
            gameSystem.gameStart();
            //게임 종료 여부 선택
            exit = gameSystem.gameReStart();
        }while(!exit);
    }
}
