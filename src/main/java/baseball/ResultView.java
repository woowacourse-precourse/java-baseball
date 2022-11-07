package baseball;

import java.util.HashMap;
import java.util.stream.Stream;

public class ResultView {
    private static boolean isReGame = false;
    public static void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printEndGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printResult(HashMap<MatchBalls, Long> resultHashMap){
        StringBuilder stringBuilder = new StringBuilder();

        if(resultHashMap.get(MatchBalls.볼) > 0){
            isReGame = false;
            long count = resultHashMap.get(MatchBalls.볼);
            stringBuilder.append(count).append(MatchBalls.볼).append(" ");
        }

        if(resultHashMap.get(MatchBalls.스트라이크) > 0){
            isReGame = false;
            long count = resultHashMap.get(MatchBalls.스트라이크);
            stringBuilder.append(count).append(MatchBalls.스트라이크);
        }

        if(resultHashMap.size() == 0|| resultHashMap.get(MatchBalls.스트라이크) == 0 && resultHashMap.get(MatchBalls.볼) == 0){
            isReGame = false;
            stringBuilder.append(MatchBalls.낫싱);
        }

        System.out.println(stringBuilder);

        if(resultHashMap.get(MatchBalls.스트라이크) == 3){
            printEndGame();
            isReGame = true;
        }
    }

    public static boolean isReGame(){
        return isReGame;
    }

    public static boolean determineStopOrNot(ComputerBallNumber computerBallNumber) {
        if (!isReGame) return false;
        String num = InputView.inputGameRestart();
        int restartOrNot = Integer.parseInt(num);

        if (restartOrNot == 1) {
            computerBallNumber.numbers = computerBallNumber.getComputerBalls();
            return false;
        }
        return true;
    }
}
