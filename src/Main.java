import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] numbers = new String[N];
        int[] countAlphabets = new int[10];
        boolean[] notZero = new boolean[10];
        List<Number> counting = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextLine();
        }

        for (String str : numbers) {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                if ( i == 0 ) {
                    notZero[str.charAt(i) - 'A'] = true;
                }
                countAlphabets[str.charAt(i) - 'A'] += times(len - i);
            }
        }

        for (int i = 0; i < countAlphabets.length; i++) {
            if( countAlphabets[i] == 0) continue;
            counting.add(new Number(countAlphabets[i], notZero[i]));
        }
        counting.sort(Comparator.naturalOrder());

        int minNum = 10 - counting.size();
        int result = 0;
        int zeroCount = minNum;

        for (int i = 0; i < counting.size(); i++) {
            if (minNum == 0 && counting.get(i).notZero){
                counting.get(i).alphabet = zeroCount++;
                result += counting.get(i).alphabet * counting.get(i).num;
            } else {
                counting.get(i).alphabet = minNum++;
                result += counting.get(i).alphabet * counting.get(i).num;
            }
        }

        System.out.println(result);





    }

    static int times(int num){
        int result = 1;
        for (int i = 0; i < num - 1; i++) {
            result *= 10;
        }
        return result;
    }
}

class Number implements Comparable<Number> {
    int num;
    boolean notZero;
    int alphabet;

    public Number(int num, boolean notZero) {
        this.num = num;
        this.notZero = notZero;
    }

    @Override
    public int compareTo(Number o) {
        return this.num - o.num;
    }
}
