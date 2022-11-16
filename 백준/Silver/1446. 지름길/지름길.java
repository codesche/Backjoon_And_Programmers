import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> list[];
    static int N, D, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList[10001];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[] {b, c});
        }
        int dp[] = new int[10001];
        init(dp);
        for (int i = 0; i <= D; i++) {
            if (i != 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            }

            if (list[i].size() > 0) {
                for (int tmp[] : list[i]) {
                    int val = tmp[1];
                    int end = tmp[0];
                    if (dp[end] > dp[i] + val) {
                        dp[end] = dp[i] + val;
                    }
                }
            }
        }
        System.out.println(dp[D]);
    }

    static void init(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }
}
