package baseball.player.playerImpl;


import baseball.player.playerMember.Player;
import baseball.player.playerMember.PlayerNumbers;
import baseball.player.playerInterface.JudgeAble;

import java.util.List;

public class Computer extends Player implements JudgeAble {

    public Computer(PlayerNumbers playerNumbers) {
        super(playerNumbers);
    }

    @Override
    public List<Integer> judge(PlayerNumbers playerNumbers) {
        PlayerNumbers basePlayerNumber = this.getPlayerNumbers();
        return basePlayerNumber.makeHints(playerNumbers);
    }
}

