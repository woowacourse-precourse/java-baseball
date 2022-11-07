package baseball;

public class Status {

	private String status;
	private static final String STATUS_INIT = "INIT";
	private static final String STATUS_PLAYING = "PLAYING";
	private static final String STATUS_TERMINATING = "TERMINATING";

	Status() {
		initStatus();
	}

	private void initStatus() {
		status = STATUS_INIT;
	}

	public void setStatusPlaying() {
		status = STATUS_PLAYING;
	}

	public void setStatusTerminating() {
		status = STATUS_TERMINATING;
	}

	public String getStatus() {
		return status;
	}
}
