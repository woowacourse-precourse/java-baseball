package baseball;

public class GameProcess {
    public GameProcess(){

    }

    public void gameStart(){
        // 게임 진행


        if (isRestart()){
            gameRestart();
        }
        gameEnd();
    }

    private void gameRestart(){
        gameStart();
    }

    private void gameEnd(){
        // 게임 종료 출력하기
    }

    private Boolean isRestart(){
        // 1 또는 2를 입력받아 재시작 여부 확인
        return false;
    }
}
