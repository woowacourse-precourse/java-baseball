package baseball;

public enum Errors {

    INPUT_BLANK("공백은 입력할 수 없습니다."),
    NUMBER_RANGE("숫자는 0~9 사이 값만 입력가능합니다."),
    NUMBERS_THREE_DIGITS("3자리 숫자를 입력해주세요."),
    NUMBERS_DUPLICATE_NUMBER ("각각 다른 숫자를 입력해주세요."),
    REPLAY_NUMBER_RANGE("0 혹은 1만 입력할 수 있습니다.");



    private String message;

    Errors(String message){
        this.message = message;
    }

    public String getValue(){
        return this.message;
    }
}
