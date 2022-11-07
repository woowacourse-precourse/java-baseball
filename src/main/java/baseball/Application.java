package baseball;

public class Application {
    public static void main(String[] args) {

        boolean run = true;

        try {
            while (run) {
                proceedGame();

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                run = BaseballInput.nextGameSelect();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 승리하기 전까지 턴을 반복하며 게임을 진행한다.
     */
    private static void proceedGame() {
        BaseballNum baseballNum = new BaseballNum();

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
        }
        while (proceedTurn(baseballNum));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 한 번의 턴을 진행한다.
     * 비교 결과를 출력하고 승리 여부를 파악한다.
     * @return 게임이 종료되면 false, 다음 턴을 수행해야 하면 true를 반환
     */
    private static boolean proceedTurn(BaseballNum baseballNum) {
        int input = BaseballInput.nextBaseballNum();
        TurnResult result = TurnResult.compare(baseballNum, input);
        System.out.println(result);

        if (result.getStrikes() == 3)
            return false;
        return true;
    }
}
