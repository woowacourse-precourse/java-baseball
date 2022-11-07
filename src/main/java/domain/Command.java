package domain;

public class Command {
    private final String RESTART = "1";
    private final String EXIT = "2";
    private String value;

    public Command(String inputCommand){
        validateInput(inputCommand);
        this.value = inputCommand;
    }

    private void validateInput(String inputCommand){
        if(inputCommand.equals(RESTART) || inputCommand.equals(EXIT)){
           return;
        }
        throw new IllegalArgumentException("1또는 2를 입력해야합니다.");
    }

    public boolean isExit(){
        if(value.equals(EXIT)){
            return true;
        }
        return false;
    }
}
