package baseball;

import camp.nextstep.edu.missionutils.Console;


public class BaseballGameInputFilter {

    private static BaseballGameInputFilter baseballGameInputFilter = new BaseballGameInputFilter();
    private static int numberLength = BaseballGameRule.LENGTH.getValue();


    private BaseballGameInputFilter() {}

    protected static boolean isValidLength(String input) {
        return input.length() == numberLength;
    }

    protected static boolean isNumeric(String input) {
        return input.matches(String.format("[%d-%d]+",
                BaseballGameRule.RANGEFROM.getValue(), BaseballGameRule.RANGETO.getValue()));
    }

    protected static boolean isNotDuplicated(String input) {
        boolean[] isNumberOfIndex = new boolean[10];

        for (char ch : input.toCharArray()){
            if (isNumberOfIndex[Character.getNumericValue(ch)]) return false;
            isNumberOfIndex[Character.getNumericValue(ch)] = true;
        }
        return true;
    }

    public static String readNumbers(){
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        if (!isValidLength(input)) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(input)) {
            throw new IllegalArgumentException();
        }
        if (!isNotDuplicated(input)) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public boolean readIsContinued() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String flag = Console.readLine();

        if (flag.equals("1")) return true;
        else if (flag.equals("2")) return false;

        throw new IllegalArgumentException();
    }

    public static BaseballGameInputFilter getInstance() {
        return baseballGameInputFilter;
    }

}
