import java.util.*;

public class ClockDegrees {
	public static void main (String[] args) {
		ClockDegrees theMain = new ClockDegrees();
		theMain.go();
	}
	public void go() {
		Scanner in = new Scanner(System.in);
		boolean isHour = false;
		boolean isMinute = false;
		int hour;
		int minute;
		do {
			System.out.println("Give me an hour hand of a clock:");
			hour = in.nextInt();
			if (hour < 1 || hour > 12) {
				System.out.println("Try again!");
			} else {
				isHour = true;
			}
		} while (!isHour);
		do {
			System.out.println("Give me a minute hand of a clock:");
			minute = in.nextInt();
			if (minute < 0 || minute > 59) {
				System.out.println("Try again!");
			} else {
				isMinute = true;
			} 
		} while (!isMinute);
		int convertMin = minute;
		if (minute == 0) {
			convertMin = 60;
		}
		int degreesHour = (360 * hour) / 12;
		int degreesMinute = (360 * convertMin) / 60;
		if (minute > 49) {
			degreesHour += 25;
		} else if (minute > 39) {
			degreesHour += 20;
		} else if (minute > 29) {
			degreesHour += 15;
		} else if (minute > 19) {
			degreesHour += 10;
		} else if (minute > 9) {
			degreesHour += 5;
		}
		Integer[] candidateResults = {Math.abs(degreesHour - degreesMinute), Math.abs(degreesMinute - degreesHour), 
		Math.abs(360 - (degreesHour - degreesMinute)), Math.abs(360 - (degreesMinute - degreesHour))};
		int result = Collections.min(Arrays.asList(candidateResults));
		System.out.println("The circular degree between the two clock hands is " + result);
	}
}