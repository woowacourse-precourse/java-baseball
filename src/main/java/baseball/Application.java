package baseball;

public class Application {

	public static void main(String[] args) {
		Core core = new Core();

		View.start();
		core.init();

		while (core.start) {
			View.waitInput();
			core.user.inputNum();
			core.checkStrikeBall();
			core.user.calResult();
			View.result(core.user.getResult());
			core.checkFinish();
			core.user.init();
		}
	}
}
