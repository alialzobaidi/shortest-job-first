import java.util.Scanner;
// ALi alzobaidi  _ YouTube channel -> TheNewBabil
public class shortest_job_first_preemptive {

	private static float sumwait, sumturn, complete = 0;
	private static int n, st = 0, ar[], br[], wait_time[], turn_time[], curnt_t[], f[], br_copy[];
	private static String id[];
	private static Scanner r;

	public static void main(String[] args) {
		r = new Scanner(System.in);
		System.out.println("input number process");
		n = r.nextInt();
		ar = new int[n];
		br = new int[n];
		br_copy = new int[n];
		curnt_t = new int[n];
		f = new int[n];
		wait_time = new int[n];
		turn_time = new int[n];
		id = new String[n];
		read();
		sjf_p();
		print();

	}

	private static void read() {
		for (int i = 0; i < n; i++) {
			System.out.println("input name ID and ArrivelTime and BursTime");
			id[i] = r.next();
			ar[i] = r.nextInt();
			br[i] = r.nextInt();
		}

	}

	private static void sjf_p() {

		int index = 0;

		for (int i = 0; i < n; i++) {
			br_copy[i] = br[i];
			f[i] = 0;
		}
		while (complete != n) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {

				if ((ar[i] <= st) && (f[i] == 0) && (br[i] < min)) {
					min = br[i];
					index = i;
				}
			}
			if (index == n) {
				st++;
			} else {
				br[index]--;
				st++;
				if (br[index] == 0) {
					curnt_t[index] = st;
					f[index] = 1;
					complete++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			wait_time[i] = curnt_t[i] - ar[i] - br_copy[i];
			turn_time[i] = wait_time[i] + br_copy[i];
			sumturn += turn_time[i];
			sumwait += wait_time[i];
		}

	}

	private static void print() {

		System.out.println("Process \t ArTime \t BTime \t WaitTime \t TurnTime \t complete");
		for (int i = 0; i < n; i++) {
			System.out.println("   " + id[i] + "\t\t" + ar[i] + "\t\t" + br_copy[i] + "\t\t" + wait_time[i] + "\t\t"
					+ turn_time[i] + "\t\t" + curnt_t[i]);

		}
		System.out.println("Avwait_time :" + sumwait / n + "\nAvturn_time :" + sumturn / n);
		// ALi alzobaidi  _ YouTube channel -> TheNewBabil
	}
}
