package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

public class Game {

    private Computer computer;
    private User user;
    private InputValidation inputValidation = new InputValidation();

    public Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    /**
     * 게임 시작 문구 출력
     */
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 전달된 컴퓨터 숫자가 모든 입력 검증 사항을 통과하는지 확인
     */
    public boolean validateComputerNumber(String computerNumber){
        return inputValidation.checkAllValidation(computerNumber);
    }

    /**
     * 스트라이크, 볼, 낫싱 여부를 판단한 뒤 요구 포멧에 맞게 변환해 반환
     */
    public String getScoreMent(String computer, String user) {

        List<Integer> score = getScore(computer, user);

        int strike = score.get(0);
        int ball = score.get(1);

        String resultMent = "";

        if(strike == 0 && ball == 0) {
            return "낫싱";
        }

        if(ball != 0) {
            resultMent += ball + "볼 ";
        }

        if(strike != 0) {
            resultMent += strike + "스트라이크" ;
        }

        return resultMent;

    }

    /**
     * 스트라이크, 볼, 낫싱 개수를 저장해 리스트로 반환
     */
    private List<Integer> getScore(String computer, String user) {

        int strike = getStrike(computer, user);
        int ball = getBall(computer, user);
        int nothing = getNothing(computer, user);

        return new ArrayList<Integer>(Arrays.asList(strike, ball, nothing));

    }

    private int getStrike(String computer, String user) {
        return (int)(computer.chars()
                .mapToObj(c -> (char)c)
                .filter(n -> n == user.charAt(computer.indexOf(n))))
                .count();
    }

    private int getBall(String computer, String user) {

        return (int)(computer.chars()
                .mapToObj(c -> (char)c)
                .filter(n -> n != user.charAt(computer.indexOf(n))))
                .filter(n -> user.chars()
                        .mapToObj(c -> (char)c)
                        .anyMatch(Predicate.isEqual(n)))
                .count();
    }

    private int getNothing(String computer, String user) {

        return (int)(computer.chars()
                .mapToObj(c -> (char)c)
                .filter(n -> user.chars()
                        .mapToObj(c -> (char)c)
                        .noneMatch(Predicate.isEqual(n)))
                .count());
    }

}
