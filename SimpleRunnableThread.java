package edu.my.home.thread.examples;

public class SimpleRunnableThread implements Runnable {

	private String getName() {
		return Thread.currentThread().getName();
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.printf("%s : %d\n", getName(), i + 1);
			Double sleepTime = Math.random() * 1000;
			try {
				Thread.sleep(sleepTime.longValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(getName() + " is done!");
	}

	public static void main(String[] args) {
		Thread runner1 = new Thread(new SimpleRunnableThread(), "runner 1");
		Thread runner2 = new Thread(new SimpleRunnableThread(), "runner 2");
		runner2.start();
		runner1.start();
	}

}
