package problems;

public class EggDropTest {

	public static void findIdealTrialFloors(int floors) {
		int trialFloor = floors;
		while (trialFloor > 1) {
			trialFloor = (int) (Math.sqrt(1 + (8 * trialFloor)) - 1) / 2;
			System.out.println(trialFloor);
		}
	}
	
	public static void main(String[] args) {
		findIdealTrialFloors(100);
	}
}
