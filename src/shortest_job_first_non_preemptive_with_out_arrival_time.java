import java.util.Scanner;
//ALi alzobaidi  _ YouTube channel -> TheNewBabil
public class shortest_job_first_non_preemptive_with_out_arrival_time {

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
		sjf();
		print();
	}

	private static void sort() {
		int t, b;
		String p;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (br[i] < br[j]) {
					t = ar[i];
					ar[i] = ar[j];
					ar[j] = t;
					b = br[i];
					br[i] = br[j];
					br[j] = b;
					p = id[i];
					id[i] = id[j];
					id[j] = p;
				}
			}
	}

	private static void read() {
		for (int i = 0; i < n; i++) {
			System.out.println("input name ID and BursTime");
			id[i] = r.next();
			ar[i] = 0;
			br[i] = r.nextInt();
		}

	}

	private static void sjf() {
		for (int i = 1; i < n; i++) {

			CpuTime += br[i - 1];
			wait_time[i] = CpuTime - ar[i];
			sumwait += wait_time[i];
			if (i == 1) {
				wait_time[0] = 0;
				turn_time[0] = wait_time[0] + br[0];
				sumturn += turn_time[0];
			}
			turn_time[i] = wait_time[i] + br[i];
			sumturn += turn_time[i];

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
