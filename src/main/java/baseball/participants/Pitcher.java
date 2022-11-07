package baseball.participants;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Pitcher {
    public StrikeZone pitchZone;

    public Pitcher() {
    }

    public void pitch() {
        System.out.println("3자리 숫자를 입력해주세요 : ");
        String pitch = readLine();
        this.pitchZone = new StrikeZone(pitch);
    }
}