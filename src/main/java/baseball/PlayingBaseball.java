package baseball;


class PlayingBaseball {
    private final String numberOfComputer;
    private final String numberOfPlayer;
    private final int LENGTH = 3;
    private int strike = 0;
    private int ball = 0;


    PlayingBaseball (String numberComputer, String numberPlayer) {
        this.numberOfComputer = numberComputer;
        this.numberOfPlayer = numberPlayer;
    }

    void countStrikes () {
        for (int i = 0; i < LENGTH; i++) {
            if (numberOfComputer.charAt(i) == numberOfPlayer.charAt(i)) {
                strike += 1;
            }
        }
    }

    void countBalls () {
        for (int i = 0; i < LENGTH; i++) {
            String temp = String.valueOf(numberOfPlayer.charAt(i));
            if (numberOfComputer.contains(temp)) {
                ball += 1;
            }
            if (numberOfPlayer.charAt(i) == numberOfComputer.charAt(i)) {
                ball -= 1;
            }
        }
    }

    void printResult () {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(ball+"볼 "+strike+"스트라이크");
    }

    boolean has3Strikes () {
        if(strike == 3) {
            return true;
        }
        return false;
    }







}
