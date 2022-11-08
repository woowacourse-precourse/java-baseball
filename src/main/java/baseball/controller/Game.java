public class Game {
    private static int newGameCode = 1;
    private static int shutDownCode = 2;
    public static int getNewGameCode() {
        return newGameCode;
    }
    public static int getShutDownCode() {
        return shutDownCode;
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
}
