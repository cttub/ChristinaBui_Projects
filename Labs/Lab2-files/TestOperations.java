//package Lab2Student;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.*;//Makes JUnit (annotations etc.) work
import static org.junit.Assert.*;//Makes asserts work. Note, Assert methods are static

public class TestOperations {
	
	private int result;
	private int maxValue = Integer.MAX_VALUE;//2,147,483,647
	private int minValue = Integer.MIN_VALUE;//-2,147,483,648
		
	@Before
	public void setUp(){
		result = 0;
	}
	
	@Test
	public void testAdd(){
		System.out.println("Result testAdd: " + result);
		result = Operations.add(5, 3);
		assertTrue(result == 8);
		result = Operations.add(maxValue, 1);
		assertEquals(result, minValue);
		assertFalse((Operations.add(maxValue, 1)) > 0);
		System.out.println("Result testAdd: " + result);
	}
	
	@Test
	public void testSubtract(){
		System.out.println("Result testSubtract: " + result);
		result=Operations.subtract(5,3);
		assertTrue(result==2);
		result=Operations.subtract(minValue,1);
		assertEquals(result,maxValue);
		assertFalse(Operations.subtract(1,minValue)>0);
		System.out.println("Result testSubtract: " + result);
	}
	//#TODO
	//tester method for subtract()
	//name it testSubtract()
		//First line should be System.out.println("Result testSubtract: " + result);
		
		//Do 5 minus 3 using the subtract() method and store the result in variable result
		
		//Assert that it is true that result equals 2
	
		//Do minValue minus 1 using the subtract() method and store the result in variable result
	
		//Using this value (that is stored in result), write an assertEquals() statement
		//that will cause the test to pass (ie, a valid assertEquals statement)
	
		//IN ONE LINE subtract 1 from minValue using the subtract method and assert 
		//that it is false that this value is less than 0
		
		//Last line should be System.out.println("Result testSubtract: " + result);
		//END METHOD
	@Test
	public void testMultiply(){

		System.out.println("Result testMultiply: " + result);
		result=Operations.multiply(5,3);
		assertTrue(result==15);
		result=Operations.multiply(1073741824,2);
		assertEquals(result,minValue);
		assertFalse((Operations.multiply(1073741824,2))>0);
		System.out.println("Result testMultiply: " + result);

	}
	
	//#TODO
	//tester method for multiply()
	//name it testMultiply()
		//First line should be System.out.println("Result testMultiply: " + result);
		
		//Do 5 times 3 using the multiply() method and store the result in variable result
		
		//Assert that it is true that result equals 15
	
		//Do 1073741824 times 2 using the multiply() method and store the result in variable result
		
		//Using this value (that is stored in result), write an assertEquals() statement
		//that will cause the test to pass (ie, a valid assertEquals statement)
	
		//IN ONE LINE multiply 1073741824 by 2 using the multiply method and assert 
		//that it is false that this value is greater than 0
	
		//Last line should be System.out.println("Result testMultiply: " + result);
		//END METHOD
	
	
	
	@Test
	public void testDivide(){
		
		result = Operations.divide(5, 3);
		assertTrue(result == 1);
		
		String errorMessage = "";
		
		try {
			Operations.divide(3, 0);
		} catch (ArithmeticException e) {
			errorMessage = e.getMessage();
		}
		
		System.out.println(errorMessage);
		assertTrue(errorMessage.equals("Divide by 0!"));
	}

}
