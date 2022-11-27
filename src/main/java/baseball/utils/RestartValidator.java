package baseball.utils;

public class RestartValidator {

    String restart;

    public RestartValidator(String restart) {
        this.restart = restart;
        validate(restart);
    }

    private void validate(String restart) {
        validateType(restart);
        validateValue(restart);
    }

    private void validateValue(String restart) {
        if(Integer.parseInt(restart)!=1&&Integer.parseInt(restart)!=2){
            throw new IllegalArgumentException("[ERROR] SSIBAL");
        }
    }

    private void validateType(String restart) {
        try {
            Integer.parseInt(restart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }
}
