package baseball;


class PlayBaseball {
    private final String computerNumber;
    private final String playerNumber;
    private final static int LENGTH = 3;
    private int strike = 0;
    private int ball = 0;


    PlayBaseball (String computerNumber, String playerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
    }

    void countStrikes () {
        for (int i = 0; i < LENGTH; i++) {
            if (computerNumber.charAt(i) == playerNumber.charAt(i)) {
                strike += 1;
            }
        }
    }

    void countBalls () {
        for (int i = 0; i < LENGTH; i++) {
            String temp = String.valueOf(playerNumber.charAt(i));
            if (computerNumber.contains(temp)) {
                ball += 1;
            }
            if (playerNumber.charAt(i) == computerNumber.charAt(i)) {
                ball -= 1;
            }
        }
    }

    void printBallCounts () {
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

    boolean check3Strikes () {
        if(strike == 3) {
            return true;
        }
        return false;
    }







}
