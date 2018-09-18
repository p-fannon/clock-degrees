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
		if (minute == 0) {
			minute = 60;
		}
		int degreesHour = (360 * hour) / 12;
		int degreesMinute = (360 * minute) / 60;
		if (minute > 49) {
			degreesHour += 5;
		} else if (minute > 39) {
			degreesHour += 4;
		} else if (minute > 29) {
			degreesHour += 3;
		} else if (minute > 19) {
			degreesHour += 2;
		} else if (minute > 9) {
			degreesHour += 1;
		}
		Integer[] candidateResults = {Math.abs(degreesHour - degreesMinute), Math.abs(degreesMinute - degreesHour), 
		Math.abs(degreesHour - (360 + degreesMinute)), Math.abs(degreesMinute - (360 + degreesHour))};
		int result = Collections.min(Arrays.asList(candidateResults));
		System.out.println("The circular degree between the two clock hands is " + result);
		}
}