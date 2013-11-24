package ACM.GoogleCodeJam0923;


import java.io.*;

import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * User: hwlts
 * Date: 13-10-12
 * Time: 上午9:33
 * To change this template use File | Settings | File Templates.
 */
public class ProblemA
{
    public static boolean determine(int[][] matrix,int N)
    {
        int len = matrix.length;
        boolean status = true;
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();

        for(int i = 0; i < len; i++)
        {
            SetHashMap(map,len);
            for(int j = 0; j < len; j++)
            {
                if(map.containsKey(matrix[i][j]) && map.get(matrix[i][j]) == false)
                {
                    map.put(matrix[i][j],true);
                }
                else
                {
                    return false;
                }
            }
        }

        for(int i = 0; i < len; i++)
        {
            SetHashMap(map,len);
            for(int j = 0; j < len; j++)
            {
                if(map.containsKey(matrix[j][i]) && map.get(matrix[j][i]) == false)
                {
                    map.put(matrix[j][i],true);
                }
                else
                {
                    return false;
                }
            }
        }

        for(int i = 0; i < len; i += N)
        {
            SetHashMap(map,len);
            for(int j = 0; j < len; j += N)
            {
                if(map.containsKey(matrix[j][i]) && map.get(matrix[j][i]) == false)
                {
                    map.put(i,true);
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void SetHashMap(HashMap<Integer,Boolean> map,int len)
    {
        for(int i = 1; i < len + 1; i++)
        {
            map.put(i,false);
        }
    }

    public static void main(String[] args) throws Exception
    {
        //int[][] test = {{5,3,4,6,7,8,9,1,2},{6,7,2,66,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
        FileInputStream file = new FileInputStream("C:\\Users\\hwlts\\Desktop\\A-large.in");
        Scanner in = new Scanner(file);

        File fileout = new File("C:\\Users\\hwlts\\Desktop\\out.txt");
        FileWriter out = new FileWriter(fileout);

        int T = in.nextInt();
        in.nextLine();
        for(int i = 1; i <= T; i++)
        {
            int N = in.nextInt();
            int len = N*N;
            int[][] matrix = new int[len][len];
            for(int m = 0; m < len; m++)
            {
                for(int n = 0; n < len ;n++)
                {
                    matrix[m][n] = in.nextInt();
                }
                if (in.hasNextLine())
                in.nextLine();
            }
            boolean status = determine(matrix,N);
            if(status == true)
            {
                out.write("Case #" + i + ": " + "Yes" + "\r\n");

            }
            else
            {
                out.write("Case #" + i + ": " + "No" + "\r\n");
            }
        }

        out.close();


    }

}
