package baseball;
import baseball.*;

public class Game {
    public static void run() {
        /*
        게임 초기화
            컴퓨터 번호 뽑기
            사용자 번호 입력받기
         */
        String computerNumber = GameSet.attachComputerNumber();
        String playerNumber = GameSet.inputPlayerNumber();

         //컴퓨터와 사용자 번호 비교
         boolean isRight = CompareNumber.checkRight(computerNumber, playerNumber);

        //게임 재시작 여부
        Restart.untilRight(isRight, computerNumber);
    }



}
