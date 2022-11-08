package baseball.interaction;

public interface Interactive<UserInput> {

    Integer PASS_ALL_CONDITIONS_INDEX = -1;

    UserInput getUserInput();

}
