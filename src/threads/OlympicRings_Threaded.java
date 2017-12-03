package threads;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	public static void main(String[] args) {
		OlympicRings_Threaded tr = new OlympicRings_Threaded();
		tr.move();
	}
	public void move() {
		Robot bot1 = new Robot();Robot bot2 = new Robot();Robot bot3 = new Robot();Robot bot4 = new Robot();Robot bot5 = new Robot();
		bot1.moveTo(250, 300);
		bot2.moveTo(600, 300);
		bot3.moveTo(950, 300);
		bot4.moveTo(350, 500);
		bot5.moveTo(850, 500);
		Robot[] bot = {bot1,bot2,bot3,bot4,bot5};
		for(Robot bota : bot) {
			new Thread(()->doCircle(bota)).start();
		}
	}
	public void doCircle(Robot bot) {
		bot.setSpeed(150);
		bot.hide();
		bot.penDown();
		bot.setRandomPenColor();
		for (int i = 0; i < 360; i++) {
			bot.move(3);
			bot.turn(1);
		}
	}

}
