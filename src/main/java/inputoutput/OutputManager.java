package inputoutput;

import constants.Rule;
import constants.Text;

import java.util.Map;

public class OutputManager {
    public static void notifyStart() {
        System.out.print(Text.NOTIFY_START);
    }

    public static void requestPlayerNumber() {
        System.out.print(Text.NUMBER_INPUT_REQUEST);
    }

    public static void printHint(Map<Text, Integer> hintRecord) {
        if (hintRecord == null) {
            System.out.println(Text.NOTING);
            return;
        }

        StringBuilder output = new StringBuilder();

        if (hintRecord.get(Text.BALL) != Rule.HINT.getMin()) {
            output.append(hintRecord.get(Text.BALL));
            output.append(Text.BALL);
            output.append(" ");
        }

        if (hintRecord.get(Text.STRIKE) != Rule.HINT.getMin()) {
            output.append(hintRecord.get(Text.STRIKE));
            output.append(Text.STRIKE);
        }

        System.out.println(output);
    }
}
