import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BridgeCrossing {
	static ArrayList<Integer> haveCrossed = new ArrayList<Integer>();
	static ArrayList<Integer> haveNotCrossed = new ArrayList<Integer>(Arrays.asList(10, 2, 5, 1));
	static int elapsedTime = 0;

	public static void main(String[] args) {
		sendTwoFastestAcross();
		sendFastestBack();
		sendTwoSlowestAcross();
		sendFastestBack();
		sendTwoFastestAcross();
		printSummary();
	}

	/**
	 * Send the fastest person on the other side of the bridge back across.
	 */
	public static void sendFastestBack() {
		int fastest = haveCrossed.indexOf(Collections.min(haveCrossed));
		System.out.println("Moving the fastest person back with the flashlight: " + haveCrossed.get(fastest));
		haveNotCrossed.add(haveCrossed.get(fastest));
		elapsedTime += haveCrossed.get(fastest);

		haveCrossed.remove(fastest);
	}

	/**
	 * Send across the two fastest people who are still on the wrong side of the
	 * bridge.
	 */
	public static void sendTwoFastestAcross() {
		int personIndex1 = haveNotCrossed.indexOf(Collections.min(haveNotCrossed));
		int personValue1 = haveNotCrossed.get(personIndex1);

		haveNotCrossed.remove(personIndex1);
		haveCrossed.add(personValue1);

		int personIndex2 = haveNotCrossed.indexOf(Collections.min(haveNotCrossed));
		int personValue2 = haveNotCrossed.get(personIndex2);

		haveNotCrossed.remove(personIndex2);
		haveCrossed.add(personValue2);
		elapsedTime += personValue2;
		System.out.println("Moving across the bridge: " + personValue1 + " with " + personValue2);

	}

	/**
	 * Send across the two slowest people who are still on the wrong side of the
	 * bridge.
	 */
	public static void sendTwoSlowestAcross() {
		int personIndex1 = haveNotCrossed.indexOf(Collections.max(haveNotCrossed));
		int personValue1 = haveNotCrossed.get(personIndex1);

		haveNotCrossed.remove(personIndex1);
		haveCrossed.add(personValue1);
		elapsedTime += personValue1;

		int personIndex2 = haveNotCrossed.indexOf(Collections.max(haveNotCrossed));
		int personValue2 = haveNotCrossed.get(personIndex2);

		haveNotCrossed.remove(personIndex2);
		haveCrossed.add(personValue2);

		System.out.println("Moving from across the bridge: " + personValue1 + " with " + personValue2);
	}

	/**
	 * Print a summary statement of the results of the crossing.
	 */
	public static void printSummary() {
		System.out.print("People who have not crossed: ");

		for (int i = 0; i < haveNotCrossed.size(); i++) {
			System.out.print(haveNotCrossed.get(i) + " ");
		}

		System.out.println("");
		System.out.print("People who have crossed: ");

		for (int i = 0; i < haveCrossed.size(); i++) {
			System.out.print(haveCrossed.get(i) + " ");
		}
		System.out.println("");
		System.out.println("Elapsed Time: " + elapsedTime + " minutes.");
	}
}
