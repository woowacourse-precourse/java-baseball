package baseball;

import java.util.Arrays;

public enum Status {
    PROCEEDING(0),
    RESTART(1),
    EXIT(2);

    private static final String EXCEPTION_MESSAGE = "wrong option";
    private final int gameOption;

    Status(int gameOption) {
        this.gameOption = gameOption;
    }

    
    // change Status depending on gameOption
    //not exist enum -> IllegalArgumentException
  
    
    public static Status getStatus(int gameOption) {
        return Arrays.stream(Status.values())
                .filter(status -> status.gameOption == gameOption)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_MESSAGE));
    }
}