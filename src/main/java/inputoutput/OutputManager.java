package inputoutput;

import constants.Text;

public class OutputManager {
    public static void notifyStart() {
        System.out.println(Text.NOTIFY_START);
    }

    public static void requestPlayerNumber() {
        System.out.println(Text.NUMBER_INPUT_REQUEST);
    }
}
