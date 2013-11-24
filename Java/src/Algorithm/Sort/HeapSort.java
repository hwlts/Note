package Algorithm.Sort;

public class HeapSort
{
    public static void heapSort(int[] data)
    {
        int len = data.length;
        for (int i = 0; i < len - 1; ++i)
        {
            bulidMaxHeap(data,len-1-i);
            swap(data,0,len-1-i);
        }
    }

    private static void bulidMaxHeap(int[] data, int lastIndex)
    {
        for (int i = (lastIndex-1)/2; i >=0; --i)
        {
            int k = i;
            while (k*2+1 <= lastIndex)
            {
                int biggerIndex = 2*k+1;

                if (biggerIndex < lastIndex)
                {
                    if (data[biggerIndex] < data[biggerIndex+1])
                        biggerIndex++;
                }

                if (data[k] < data[biggerIndex])
                {
                    swap(data,k,biggerIndex);
                    k = biggerIndex;
                }
                else
                    break;
            }
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
        int a[] = {2,5,4,3,1};
        heapSort(a);
        for (int t : a)
            System.out.print(t+" ");
    }
}
