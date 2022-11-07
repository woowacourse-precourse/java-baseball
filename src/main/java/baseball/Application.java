package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {

        boolean run = true;

        try {
            while (run) {
                proceedGame();

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                run = BaseballInput.nextGameSelect();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
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
        while (proceedTurn(baseballNum) == 1);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 한 번의 턴을 진행한다.
     * 비교 결과를 출력하고 승리 여부를 파악한다.
     * @return 게임이 종료되면 0, 다음 턴을 수행해야 하면 1을 반환
     */
    private static int proceedTurn(BaseballNum baseballNum) {
        int input = BaseballInput.nextBaseballNum();
        TurnResult result = TurnResult.compare(baseballNum, input);
        System.out.println(result);

        if (result.getStrikes() == 3)
            return 0;
        return 1;
    }
}
