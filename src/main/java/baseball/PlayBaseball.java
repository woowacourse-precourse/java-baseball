package baseball;


class PlayBaseball {
    private final String numberComputer;
    private final String numberPlayer;
    private final int LENGTH = 3;
    private int strike = 0;
    private int ball = 0;


    PlayBaseball (String numberComputer, String numberPlayer) {
        this.numberComputer = numberComputer;
        this.numberPlayer = numberPlayer;
    }

    void countStrikes () {
        for (int i = 0; i < LENGTH; i++) {
            if (numberComputer.charAt(i) == numberPlayer.charAt(i)) {
                strike += 1;
            }
        }
    }

    void countBalls () {
        for (int i = 0; i < LENGTH; i++) {
            String temp = String.valueOf(numberPlayer.charAt(i));
            if (numberComputer.contains(temp)) {
                ball += 1;
            }
            if (numberPlayer.charAt(i) == numberComputer.charAt(i)) {
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
