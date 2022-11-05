package baseball;

public class Status {
	String status;
	String STATUS_INIT = "INIT";
	String STATUS_PLAYING = "PLAYING";
	String STATUS_TERMINATING = "TERMINATING";

	Status() {
		initStatus();
	}

	public void initStatus() {
		status = STATUS_INIT;
	}

	public void setStatusPlaying() {
		status = STATUS_PLAYING;
	}

	public void setStatusTerminating() {
		status = STATUS_TERMINATING;
	}
}
