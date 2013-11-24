package Algorithm.Sort;

public class Quick_Sort
{
    public static void quickSort(int[] data)
    {
        subSort(data,0,data.length-1);
    }

    private static void subSort(int[] data, int start, int end)
    {
        if (start < end)
        {
            int base = data[start];
            int i = start;
            int j = end + 1;
            while (true)
            {
                while (i < end && data[++i] < base);
                while (j > start && data[--j] > base);
                if (i < j)
                    swap(data,i,j);
                else
                    break;
            }
            swap(data,start,j);
            subSort(data, start, j-1);
            subSort(data, j+1, end);
        }
    }

    private static void swap(int[] data, int i, int j)
    {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] a = {7,3,2,1,6,5,4};
        quickSort(a);
        for (int t : a)
            System.out.print(t+" ");
    }
}
