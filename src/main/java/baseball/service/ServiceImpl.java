package baseball.service;
import baseball.domain.Game;
public class ServiceImpl implements Service {
    Game game;
    public ServiceImpl() {
    }
    @Override
    public void readyGame() throws IllegalArgumentException{
        if (game == null){
            game = new Game().getInstance(1,9);
        } else{
            game = game.getInstance(1,9);
        }
        while(game.getPlayer().getStrike() != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            game.getPlayer().inputGenerate();
            //System.out.println(game.getNumber());
            baseBall(game);
            game.printBaseBallCount();
        }
    }
    @Override
    public void baseBall(Game game) {
        for(int i = 0; i < 3; ++i) {
            game.check(i);
        }
    }
}
