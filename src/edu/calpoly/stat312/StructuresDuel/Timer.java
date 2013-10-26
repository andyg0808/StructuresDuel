package edu.calpoly.stat312.StructuresDuel;

public class Timer {

	private long startTime = 0;
	private long stopTime = 0;
	boolean running = false;
	private boolean run = false;

	public long elapsedTime() {
		if (!run) {
			throw new RuntimeException(
					"Attempt to get elapsed time from an unrun timer");
		}
		if (running) {
			return System.nanoTime() - startTime;
		} else {
			return stopTime - startTime;
		}
	}

	public void startTimer() {
		// Set the start time
		startTime = System.nanoTime();

		running = true;
		run = true;
	}

	public void stopTimer() {
		// Set the stop time
		stopTime = System.nanoTime();
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean hasRun() {
		return run;
	}

}
