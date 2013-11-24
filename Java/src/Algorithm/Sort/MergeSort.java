package Algorithm.Sort;

public class MergeSort
{
    public static void mergeSort(int[] data)
    {
        sort(data,0,data.length-1);
    }

    private static void sort(int[] data, int left, int right)
    {
        if (left < right)
        {
            int center = (left + right)/2;
            sort(data,left,center);
            sort(data,center+1,right);
            merge(data,left,center,right);
        }
    }

    private static void merge(int[] data ,int left, int center, int right)
    {
        int tempArr[] = new int[data.length];
        int mid = center+1;
        int third = left;
        int temp = left;

        while (left <= center && mid <= right)
        {
            if (data[left] < data[mid])
            {
                tempArr[third++] = data[left++];
            }
            else
                tempArr[third++] = data[mid++];
        }

        while (mid <= right)
        {
            tempArr[third++] = data[mid++];
        }
        while (left <= center)
        {
            tempArr[third++] = data[left++];
        }

        while (temp <= right)
            data[temp] = tempArr[temp++];
    }

    public static void main(String[] args)
    {
        int a[] = {2,5,4,3,1};
        mergeSort(a);
        for (int t : a)
            System.out.print(t+" ");
    }
}
