package baseball;

public class BaseballSystem {
    public void startOneGameSet() {
        int[] computerNums = new ComputerNumGenerator().nums;
        boolean gameClear;
        do {
            BaseballCount set = new BaseballCount(new UserNumGenerator().nums, computerNums);
            printGameResult(set);
            gameClear = isMaxStrike(set);
        } while (!gameClear);
    }

    private static void printGameResult(BaseballCount set) {
        printOnlyBall(set);
        printOnlyStrike(set);
        printBallAndStrike(set);
        printNoting(set);
    }

    private static boolean isMaxStrike(BaseballCount set) {
        if (set.strikeCount == Constant.NUMS_LENGTH) {
            System.out.println(Constant.NUMS_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static void printOnlyBall(BaseballCount set) {
        if (set.ballCount != 0 && set.strikeCount == 0) {
            System.out.println(set.ballCount + "볼");
        }
    }

    private static void printOnlyStrike(BaseballCount set) {
        if (set.ballCount == 0 && set.strikeCount != 0) {
            System.out.println(set.strikeCount + "스트라이크");
        }
    }

    private static void printBallAndStrike(BaseballCount set) {
        if (set.ballCount != 0 && set.strikeCount != 0) {
            System.out.println(set.ballCount + "볼 " + set.strikeCount + "스트라이크");
        }
    }

    private static void printNoting(BaseballCount set) {
        if (set.ballCount == 0 && set.strikeCount == 0) {
            System.out.println("낫싱");
        }
    }
}
