import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] Numbers = new String[N];

        for (int i = 0; i < N; i++) {
            Numbers[i] = sc.nextLine();
        }
    }
}
