package domain;

import java.util.HashMap;
import java.util.Map;

public enum Command {
    RESTART("1"),
    EXIT("2");

    private final String value;

    private Command(String value){
        this.value = value;
    }

    private static final Map<String, Command> map = new HashMap<>();
    static{
        for(Command command : Command.values()){
            map.put(command.value, command);
        }
    }

    public static Command findByValue(String inputCommand){
        if(!map.containsKey(inputCommand)){
            throw new IllegalArgumentException(String.format("%s또는 %s를 입력해야합니다.", RESTART.value, EXIT.value));
        }
        return map.get(inputCommand);
    }
}
