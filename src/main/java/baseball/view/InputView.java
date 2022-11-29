package baseball.view;

import static baseball.Rendering.ERROR;
import static baseball.Rendering.PUT;
import static baseball.view.Number.LENGTH;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public String putReadLine() {
        System.out.println(PUT.print());
        return Console.readLine();
    }

    public void validate(String readLine) {
        readLine = putReadLine();
        validateNumeric(readLine);
        distinct(readLine);

        if (readLine.length() != LENGTH.getNumber()) {    throw new IllegalArgumentException(ERROR.print());    }
    }

    public String distinct(String readLine) {
        return List.of(readLine).stream()
                .distinct()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR.print()));
    }

    private static String validateNumeric(String readLine) {
        return List.of(readLine).stream()
                .filter(character -> character.matches("[0-9]"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR.print()));
    }

}
