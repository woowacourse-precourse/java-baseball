package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameStringTest extends NsTest {

    private final GameString gameString;

    public GameStringTest() {
        this.gameString = new GameString();
    }

    @Test
    public void getPlayingStringCase1(){
        String playingString = this.gameString.getPlayingString(0,0);

        assertThat(playingString).isEqualTo("낫싱");
    }

    @Test
    public void getPlayingStringCase2(){
        String playingString = this.gameString.getPlayingString(1,0);

        assertThat(playingString).isEqualTo("1스트라이크");
    }

    @Test
    public void getPlayingStringCase3(){
        String playingString = this.gameString.getPlayingString(0,2);

        assertThat(playingString).isEqualTo("2볼");
    }

    @Test
    public void getPlayingStringCase4(){
        String playingString = this.gameString.getPlayingString(1,2);

        assertThat(playingString).isEqualTo("2볼 1스트라이크");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{
                }
        );
    }
}