import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] Numbers = new String[N];
        int[] countAlphabets = new int[10];
        boolean[] notZero = new boolean[10];

        for (int i = 0; i < N; i++) {
            Numbers[i] = sc.nextLine();
        }

        for (String str : Numbers) {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                if ( i == 0 ) {
                    notZero[str.charAt(i - 'A')] = true;
                }
                countAlphabets[str.charAt(i - 'A')] += times(len - i);
            }
        }
    }
}
