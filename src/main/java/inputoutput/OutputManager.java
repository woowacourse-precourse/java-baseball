package inputoutput;

import constants.Text;

public class OutputManager {
    public static void notifyStart() {
        System.out.print(Text.NOTIFY_START);
    }

    public static void requestPlayerNumber() {
        System.out.print(Text.NUMBER_INPUT_REQUEST);
    }
}
