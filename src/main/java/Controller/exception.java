package Controller;

public enum exception {
    OVERLAP_EXCEPTION(new IllegalArgumentException("중복된 숫자가 있습니다.")),

    INPUT_BLANK_EXCEPTION(new IllegalArgumentException("값을 입력해주세요.")),

    NOT_EXACT_FORMAT_EXCEPTION(new IllegalArgumentException("3글자 수가 아닙니다.")),

    NOT_NUMBER_RANGE_EXCEPTION(new IllegalArgumentException("1~9숫자를 입력해주세요."));

    private IllegalArgumentException Exception;

    exception(IllegalArgumentException Exception) {

        this.Exception = Exception;
    }
    public IllegalArgumentException getexception(){return Exception;}
}
