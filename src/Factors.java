import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class Check
{
    int a;
    int b;
    Check(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
class Compare implements Comparator<Check> {
    public int compare(Check o1, Check o2)
    {
        if (o1.a == o2.a) {
            return 0;
        }
        else if (o1.a < o2.a) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
public class Factors {
    static void sortArray(int arr[], int n)
    {
        ArrayList<Check> v = new ArrayList<Check>();
        int count=0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 1; j * j <= arr[i]; j++) {
                if (arr[i] % j == 0) {
                    count++;
                    if (arr[i] / j != j)
                        count++;
                }
            }
            v.add(new Check(count,arr[i]));
        }
        Collections.sort(v, new Compare());
        for (Check i : v)
            System.out.print(i.b+" ");
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        sortArray(arr,n);
    }
}