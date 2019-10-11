import java.util.Random;
import java.util.Scanner;
public class subSequenceAlg 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the size of the problem (N): ");
		int n = in.nextInt();
		int[] array = randomNumFiller(n);
		if (n < 50)
		{
			for (int i = 0; i < n; i++)
			{
				if (i != n-1)
				{
					System.out.print(array[i] + " ");
				}
				else
				{
					System.out.print(array[i]);
				}
			}
		}
		long startTime = System.nanoTime();
		int[] algTwoArray = algTwo(array);
		long endTime = System.nanoTime();
		long alg2duration = (endTime - startTime);
		alg2duration = alg2duration / 1000000;
		startTime = System.nanoTime();
		int[] algFourArray = algFour(array);
		endTime = System.nanoTime();
		long alg4duration = (endTime - startTime);
		alg4duration = alg4duration / 100;
		startTime = System.nanoTime();
		int algThreeArray = algThree(array, 0, array.length - 1);
		endTime = System.nanoTime();
		long alg3duration = (endTime - startTime);
		alg3duration = alg3duration / 10000;
		//duration = duration / 1000000;
		System.out.println("Algorithm 2:");
		System.out.println("MaxSum: " + algTwoArray[0] + ", S_index: " + algTwoArray[1] 
				+ ", E_index: " + algTwoArray[2]);
		System.out.println("Execution Time: " + alg2duration + " milliseconds");
		System.out.println("Algorithm 3:");
		System.out.println("MaxSum: " + algThreeArray + ", S_index: %d, E_index: %dS");
		System.out.println("Execution Time: " + alg3duration + " milliseconds");
		System.out.println("Algorithm 4:");
		System.out.println("MaxSum: " + algTwoArray[0] + ", S_index: " + algTwoArray[1] 
				+ ", E_index: " + algTwoArray[2]);
		System.out.println("Execution Time: " + alg4duration + " milliseconds");
	}
	
	public static int[] randomNumFiller(int n)
	{
		Random rand = new Random();
		int max = 9999;
		int min = -9999;
		int[] array = new int[n];
		for (int i = 0; i < n; i++)
		{
			array[i] = rand.nextInt((max-min)+1) + min;
		}
		return array;
	}
	
	public static int[] algTwo(int [] n)
	{
		int maxSum = 0;
		int firstIndex = n[0];
		int lastIndex = n[0];
		
		for( int i = 0; i < n.length; i++ )
		{
			int thisSum = 0;
			for( int j = i; j < n.length; j++)
			{
				thisSum += n[j];
				
				if (thisSum > maxSum)
				{
					maxSum = thisSum;
					firstIndex = i;
					lastIndex = j;
				}	
			}
		}
		int[] algTwoArray = new int[3];
		algTwoArray[0] = maxSum;
		algTwoArray[1] = firstIndex;
		algTwoArray[2] = lastIndex;
		return algTwoArray;
	}
	
	public static int algThree(int[] a, int left, int right )
	{
		if(left == right) // Base case
			if(a[left] > 0)
				return a[left];
			else
				return 0;
		
		int center = (left + right) / 2;
		int maxLeftSum = algThree(a, left, center);
		int maxRightSum = algThree(a, center + 1, right);
		int maxLeftBorderSum = 0; 
		int	leftBorderSum = 0;
		for(int i = center; i >= left; i--)
		{
			leftBorderSum += a[i];
			if(leftBorderSum > maxLeftBorderSum)
			{
				maxLeftBorderSum = leftBorderSum;
			}
		}
		int maxRightBorderSum = 0; 
		int rightBorderSum = 0;
		for(int i = center + 1; i <= right; i++)
		{
			rightBorderSum += a [i];
			if (rightBorderSum > maxRightBorderSum)
			{
				maxRightBorderSum = rightBorderSum;
			}
		}
		return maxHelper(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
	}

	private static int maxHelper(int maxLeftSum, int maxRightSum, int borderSum)
	{
		 int max = Math.max(maxLeftSum, maxRightSum);
		 int maximum = Math.max(max, borderSum);
		 return maximum;
	}
	
	public static int[] algFour(int []n)
	{
		int maxSum = 0;
		int thisSum = 0;
		int lastIndex = 1;
		int tempFirst = 0;
		int firstIndex = 0;
		
		for (int j = 0; j < n.length; j++)
		{
			thisSum += n[j];
			
			if(thisSum > maxSum)
			{
				maxSum = thisSum;
				lastIndex = j;
				firstIndex = tempFirst;
			}
			else if (thisSum < 0)
			{
				thisSum = 0;
				tempFirst = (j+1);
			}
		}
		int[] array = new int[3];
		array[0] = maxSum;
		array[1] = firstIndex;
		array[2] = lastIndex;
		return array;
	}
}
