package JusticeSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 25mins - 10/30/24
 */
public class C_TragedySalem {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int f = Integer.parseInt(parts[1]);
        int k = Integer.parseInt(parts[2]);
        int[] vamps = new int[n];
        for(int i = 0; i < n; i++) {
            vamps[i] = Integer.parseInt(br.readLine().trim());
        }

        System.out.println(solve(n,f,k,vamps));
    }

    public static String solve(int n, int f, int k, int[] vamps) {
        // solve answer here
        int nvamptakendown = 0;
        MergeSort ms = new MergeSort();
        ms.sort(vamps, 0, n-1);

        for(int i = 0; i < n && nvamptakendown < k && f-vamps[i] >= 0; i ++) {
            f-= vamps[i];
            nvamptakendown ++;
        }

        if (nvamptakendown == k) {
            return "YES";
        } else
            return "NO";
    }
}

class MergeSort {

    // Merges two subarrays of a[]
    private void merge(int a[], int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];

        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];

        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts a[l..r] using
    // merge()
    void sort(int a[], int l, int r)
    {
        if (l < r) {

            int m = (l + r) / 2;

            // Sort first and second halves
            sort(a, l, m);
            sort(a, m + 1, r);

            // Merge the sorted halves
            merge(a, l, m, r);
        }
    }

    // Driver method
    public static void main(String args[])
    {
        int a[] = { 12, 11, 13, 5, 6, 7 };

        // Calling of Merge Sort
        MergeSort ob = new MergeSort();
        ob.sort(a, 0, a.length - 1);

        int n = a.length;
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
    }
}