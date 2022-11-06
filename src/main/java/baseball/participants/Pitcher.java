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
}