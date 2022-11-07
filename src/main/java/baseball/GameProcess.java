package baseball;

import baseball.InputOutput;

public class GameProcess {
    public static final int NUMBER_LENGTH = 3;
    int[] answer = new int[10];
    int[] userNum;
    Boolean isCorrect;
    int ball, strike;
    public GameProcess(){
        InputOutput.printGameStart();
    }

    public void gameStart(){

        // 게임 진행
        isCorrect = false;
        setAnswer();


        // 맞을 때 까지 게임 진행
        while (!isCorrect){
            userNum = InputOutput.getThreeNumber();
            // 스트라이크, 볼 구하기
            countStrikeBall(userNum);
            InputOutput.printStrikeBall(strike, ball);

            isCorrect = checkCorrect();
        }
        InputOutput.printCorrectNumber();

        // 게임 종료 후 재시작 묻기
        if (isRestart()){
            gameRestart();
        }
        gameEnd();
    }

    private Boolean checkCorrect(){
        return strike == 3;
    }

    private void setStrikeOrBall(int check, int idx){
        if (answer[check] == idx + 1){
            strike += 1;
            return;
        }
        if (answer[check] > 0){
            ball += 1;
            return;
        }
    }

    private void countStrikeBall(int[] user){
        strike = 0;
        ball = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            setStrikeOrBall(user[i], i);
        }
    }

    private void setAnswer(){
        // 랜덤으로 지정된 3자리 입력받기, temp = 입력받은거;
        int[] gotThreeNumber = InputOutput.getRandomAnswer();
        answer = new int[10];
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            answer[gotThreeNumber[i]] = i + 1;
        }
    }

    private void gameRestart(){
        gameStart();
    }

    private void gameEnd(){
    }

    private Boolean isRestart(){
        // 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. <- 출력
        return InputOutput.getRestartNumber() == 1;
    }
}
