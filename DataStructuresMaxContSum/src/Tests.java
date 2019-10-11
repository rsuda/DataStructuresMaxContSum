import static org.junit.Assert.*;

import org.junit.Test;

public class Tests 
{
	int[] array = {1, 4, 5, -5, -16, 20, -2};
	@Test
	public void testRandGen() 
	{
		subSequenceAlg.randomNumFiller(15);
	}
	
	@Test
	public void testAlg2()
	{
		int[] array2 = subSequenceAlg.algTwo(array);
		//System.out.println(array2[0] +  " " + array2[1]  + " " + array2[2]);
		
	}
	
	@Test
	public void testAlg4()
	{
		int[] array2 = subSequenceAlg.algFour(array);
		System.out.println(array2[0] +  " " + array2[1]  + " " + array2[2]);
		
	}

}
