package baseball.participants;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Pitcher {
    public StrikeZone pitchZone;

    public Pitcher() {
    }

    public void pitch() {
        String pitch = readLine();
        this.pitchZone = new StrikeZone(pitch);
    }

    public String playGameAgainOrTerminate() {
        String againOrTerminate = readLine();
        if (!validateGameAgain(againOrTerminate)) {
            playGameAgainOrTerminate();
        }
        return againOrTerminate;
    }

    private boolean validateGameAgain(String againOrTerminate) {
        return againOrTerminate.equals("1") || againOrTerminate.equals("2");
    }
}