package baseball.service;
import baseball.domain.Game;
public class ServiceImpl implements Service {
    public ServiceImpl() {
    }
    @Override
    public void readyGame() throws IllegalArgumentException{
        Game game = new Game(1,9);
        while(game.getPlayer().getStrike() != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            game.getPlayer().inputGenerate();
            System.out.println(game+" "+game.getPlayer());
            baseBall(game);
            game.getPlayer().printBaseBallCount();
        }
    }
    @Override
    public void baseBall(Game game) {
        for(int i = 0; i < 3; ++i) {
            game.getPlayer().check(game,i);
        }
    }
}
