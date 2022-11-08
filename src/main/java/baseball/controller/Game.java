public class Game {
    private static int newGameCode = 1;
    private static int shutDownCode = 2;
    public static int getNewGameCode() {
        return newGameCode;
    }
    public static int getShutDownCode() {
        return shutDownCode;
    }

    /** 게임 라운드 시작 */
    private static void startRound(List<Integer> answer){
        int input = getInputNums();
        List<Integer> numList = getNumsArr(input);
        // 체크
        Baseball result = checkAnswer(numList, answer);
        // 결과 출력
        System.out.println(printRoundResult(result));
        // 종료 체크
        if (clear(result)) {
            Printer.showClear();
            return;
        } else {
            startRound(answer);
        }
    }

    private static int getInputNums() {
        showRequestInput();
        int nums = 0;
        try {
            nums = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            // 0인채로 리턴
        }
        return nums;
    }

    /** 사용자 입력값을 정수 ArrayList 반환 */
    private static List<Integer> getNumsArr(int num) {
        List<Integer> numsArr = Arrays.asList(0,0,0);

        vaildNum(num);

        for (int i=0; i<numsArr.size(); i++){
            numsArr.set(2 - i, num % 10);
            num = num/10;
        }
        return numsArr;
    }

    private static Baseball checkAnswer(List<Integer> answer, List<Integer> input) {
        Baseball result = new Baseball();
        // strike 판별
        for (int i=0; i<answer.size(); i++) {
            if(answer.get(i) == input.get(i)) {
                result.strike();
            } else if (answer.contains(input.get(i))) {
                result.ball();
            }
        }
        return result;
    }

    // 모두 맞춘 경우
    public static boolean clear(Baseball game) {
        if (game.getStrike()==3) {
            return true;
        }
        return false;
    }

    public static boolean getShutDownCheck() {
        int input = 0;
        Printer.showShutDownCheck();
        try {
            input = Integer.parseInt(readLine());
            vaildShutDownInput(input);
        } catch (NumberFormatException e) {
        }
        vaildShutDownInput(input);
        return input==1;
    }
}
