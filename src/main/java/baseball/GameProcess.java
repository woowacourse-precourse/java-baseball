package baseball;

public class GameProcess {
    int[] answer;
    int[] havingNum = new int[10];
    public GameProcess(){
    }

    public void gameStart(){
        // 게임 진행
        setAnswer();

        if (isRestart()){
            gameRestart();
        }
        gameEnd();
    }

    private void setAnswer(){
        // 랜덤으로 지정된 3자리 입력받기, answer = 입력받은거;
        answer =  new int[]{1, 2, 3};
        for (int i : answer) {
            havingNum[i] = 1;
        }
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
