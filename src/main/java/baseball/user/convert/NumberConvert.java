package baseball.user.convert;

public class NumberConvert {
    public Integer stringNumberToInteger(String number) {
        Integer result = Integer.valueOf(number);
        return result;
    }
    public String IntegerNumberToString(Integer number) {
        String result = String.valueOf(number);
        return result;
    }
    public Integer[] integerToIntegerArrOfEachElement(Integer number) {
        String strNum = IntegerNumberToString(number);

        Integer[] result = new Integer[strNum.length()];
        for(int i = 0; i < result.length; i++) {
            result[i] = Character.getNumericValue(strNum.charAt(i));
        }

        return result;
    }
}
