
import java.util.Scanner;
//ALi alzobaidi  _ YouTube channel -> TheNewBabil
public class shortest_job_first_non_preemptive_with_arrival_time {

	private static float sumwait, sumturn;
	private static int n, CpuTime, ar[], br[], wait_time[], turn_time[];
	private static String id[];
	private static Scanner r;

	public static void main(String[] args) {
		r = new Scanner(System.in);
		System.out.println("input number process");
		n = r.nextInt();
		ar = new int[n];
		br = new int[n];
		wait_time = new int[n];
		turn_time = new int[n];
		id = new String[n];
		read();
		sort();
		sjf2();
		print();

	}

	private static void sort() {
		int t;
		String p;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (ar[i] < ar[j]) {
					t = ar[i];
					ar[i] = ar[j];
					ar[j] = t;
					t = br[i];
					br[i] = br[j];
					br[j] = t;
					p = id[i];
					id[i] = id[j];
					id[j] = p;
				}
			}
	}

	private static void read() {
		for (int i = 0; i < n; i++) {
			System.out.println("input name ID and ArrivelTime and BursTime");
			id[i] = r.next();
			ar[i] = r.nextInt();
			br[i] = r.nextInt();
		}

	}

	private static void sjf2() {
		for (int i = 1; i < n; i++) {

			CpuTime += br[i - 1];
			compare(i);
			wait_time[i] = CpuTime - ar[i];
			sumwait += wait_time[i];

			if (i == 1) {
				wait_time[0] = 0;
				turn_time[i - 1] = wait_time[i - 1] + br[i - 1];
				sumturn += turn_time[i - 1];
			}
			turn_time[i] = wait_time[i] + br[i];
			sumturn += turn_time[i];

		}
	}

	private static void compare(int postion) {
		int t;
		String p;
		for (int i = postion; i < n; i++)
			for (int j = postion; j < n; j++) {
				if (br[i] < br[j]) {
					if (ar[i] <= CpuTime) {
						t = ar[i];
						ar[i] = ar[j];
						ar[j] = t;
						t = br[i];
						br[i] = br[j];
						br[j] = t;
						p = id[i];
						id[i] = id[j];
						id[j] = p;
					}
				}
			}

	}

	private static void print() {

		System.out.println("Process \t ArTime \t BTime \t WaitTime \t TurnTime");
		for (int i = 0; i < n; i++) {
			System.out.println(
					"   " + id[i] + "\t\t" + ar[i] + "\t\t" + br[i] + "\t\t" + wait_time[i] + "\t\t" + turn_time[i]);

		}
		System.out.println("Avwait_time :" + sumwait / n + "\nAvturn_time :" + sumturn / n);
		// ALi alzobaidi  _ YouTube channel -> TheNewBabil
	}
}
