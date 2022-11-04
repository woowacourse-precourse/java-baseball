package baseball.playerUser;

public class PlayerUser {
	private static final PlayerUser instance = new PlayerUser();

	private PlayerUser() {
	}

	public static PlayerUser getInstance() {
		return instance;
	}


}
