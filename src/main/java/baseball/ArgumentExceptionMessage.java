package baseball;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public enum ArgumentExceptionMessage {
    INPUT_UNCONFORMABLE_LENGTH("입력된 데이터의 길이가 요구사항과 다릅니다.")
    ,INPUT_OVERLAP("입력하신 데이터 중 중복되는 수가 존재합니다.")
    ,INPUT_NOT_INTEGER("입력된 데이터가 숫자가 아닙니다.")
    ,COMMAND_NOT_FOUND("입력된 명령어를 확인할 수 없습니다.")
    ;

    private final String message;

    public String getMessage() {
        return message;
    }

    ArgumentExceptionMessage(String message) {
        this.message = message;
    }
}
