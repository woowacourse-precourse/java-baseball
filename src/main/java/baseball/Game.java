package baseball;

import java.util.List;

public class Game {
    private int strike;
    private int ball;
    private List<Integer> computer;
    private List<Integer> user;

    public Game(List<Integer> computer) {
        this.computer = computer;
    }

    public void setStrike() {
        this.strike = 0;
    }

    public void setBall() {
        this.ball = 0;
    }


    public void setUser(List<Integer> user) {
        this.user = user;
    }

    public void isSameNumber(){
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }
    }

    public String numberToString() {
        String answer;
        if (strike == 3) {
            System.out.printf("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return "게임 종료";
        } else if (strike != 0 && ball != 0) {
            answer = ball + "볼 " + strike + "스트라이크";
        } else if (strike != 0) {
            answer = strike + "스트라이크";
        } else if (ball != 0) {
            answer = ball + "볼";
        } else {
            answer = "낫싱";
        }
        return answer;
    }

    public String gameRun(List<Integer> user){
        setUser(user);
        setStrike();
        setBall();
        isSameNumber();
        return numberToString();
    }
}
