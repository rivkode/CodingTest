
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long[] sorted;
    public static long swap;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        sorted = new long[N];
        merge_sort(arr, 0, N - 1);
        System.out.println(swap);
    }

    public static void merge_sort(long[] a, int left, int right) {
        /*
         * left == right 즉, 부분리스트가 1개의 원소만 갖고 있는 경우
         * 더이상 나눌 수 없으므로 return 한다
         */
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2; // 절반 위치

        merge_sort(a, left, mid); // 절반 중 왼쪽 부분 리스트 (left ~ mid)
        merge_sort(a, mid + 1, right); // 절반 중 오른쪽 부분 리스트 (mid + 1 ~ right)

        merge(a, left, mid, right); // 병합 작업
    }

    public static void merge(long[] a, int left, int mid, int right) {
        int l = left; // 왼쪽 부분 리스트 시작점
        int r = mid + 1; // 오른쪽 부분 리스트 시작점
        int idx = left; // 채워넣을 배열의 인덱스

        /**
         * 왼쪽 포인터가 중간까지 가거나,
         * 오른쪽 포인터가 오른쪽 끝점까지 도달했을 경우 =>
         * 왼쪽 혹은 오른쪽 집합중 하나가 끝이 났다는 의미이므로
         * while문을 탈출한다
         */
        while (l <= mid && r <= right) {
            /**
             * 왼쪽 부분 리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
             * 왼쪽의 1번째 원소를 새 배열에 넣고 1과 idx를 1 증가시킨다
             */
            if (a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            /**
             * 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
             * 오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1증가 시킨다
             */
            else {
                sorted[idx] = a[r];
                idx++;
                r++;
                swap += (mid - l + 1);
            }
        }
        /**
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
         * 오른쪽 부분리스트 원소가 아직 남아있을때
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 비교하지 않고 바로 채워준다
         * 이미 정렬이 되어있으므로
         */
        if ((l > mid)) {
            while (r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        /**
         * 위와 마찬가지로 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
         * 왼쪽 부분리스트 원소가 아직 남아있을때
         * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다
         */
        else {
            while (l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        /**
         * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다
         */
        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }
}
