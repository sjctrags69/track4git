package org.ssglobal.training.codes;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.FunList;
import org.ssglobal.training.codes.Word;

public class TestFunList {
	
	private  FunList funList;
	private Word word;
	
	@BeforeEach
	public void setup() {
		//System.out.println("initialization");
		funList = new FunList("test/config/myfile.txt");
	}
	
	// Sunny Day Testing
	
	// Testing on count returning a value
	@Disabled
	@Test
	public void testCountEqualsValue() {
		long count = funList.countWords();
		// do not program here
		Assertions.assertEquals(6, count);
	}
	// There is an algo problem.
	@Disabled
	@Test
	public void testCountNonNegativeFile1() {
		long count = funList.countWords();
		Assertions.assertTrue( count > 0);
	}
	
	@Test
	public void testCountNonNegativeFile2() {
		FunList funList = new FunList("test/config/myfile2.txt");
		long count = funList.countWords();
		Assertions.assertEquals(0, count);
		funList = null;
	}
	
	@Disabled
	@Test
	public void testContentListNotNull() {
		List<String> temp = funList.getContentList();
		Assertions.assertNotNull(temp);
	}
	
	// Enum, constants object, or pointers pointing to one object
	
	@Disabled
	@Test
	public void testSameContentArrays() {
		Assertions.assertDoesNotThrow(()->{
			String[] content = {"The fox jumps over the window."};
			String[] temp= funList.getContentArray();
			Assertions.assertSame(content, temp);
		});
	}
	
	@Disabled
	@Test
	public void testSameContentArraysRainy() {
		
		Assertions.assertThrows(ClassCastException.class, ()->{
			String[] content = {"The fox jumps over the window."};
			String[] temp= funList.getContentArray();
			Assertions.assertSame(content, temp);
		});
		
	}
	
	@Disabled
	@Test
	public void testSameContentArraysValue() {
		String[] content = {"The fox jumps over the window."};
		String[] temp= funList.getContentArray();
		Assertions.assertArrayEquals(content, temp);
	}
	
	
	
	
	// Rainy Day Testing
	
	@Disabled
	@Test
	public void testCountNonNegativeFile1Rainy() {
		long count = funList.countWords();
		Assertions.assertFalse(count <= 0);
	}
	
	@Disabled
	@Test
	public void testCountNonNegativeFile2Rainy() {
		FunList funList = new FunList("test/config/myfile2.txt");
		long count = funList.countWords();
		Assertions.assertNotEquals(6, count );
		funList = null;
	}
	
	@Test
	public void testContentListNotNullRainy() {
		List<String> temp = funList.getContentList();
		Assertions.assertNull(temp);
	}
	
		
	@Test
	public void testDisplayInSeconds() {
		
		Assertions.assertTimeout(Duration.ofSeconds(2), ()->{
			funList.showLines();
		});
		
	}
	
	@Test
	public void testDisplayInMillis() {
		
		Assertions.assertTimeout(Duration.ofMillis(10), ()->{
			funList.showLines();
		});
		
	}
	
	@RepeatedTest(value = 5)
	public void testSameContentArraysValueRepeat() {
		String[] content = {"The fox jumps over the window."};
		String[] temp= funList.getContentArray();
		Assertions.assertArrayEquals(content, temp);
	}
	
	
	
	@AfterEach
	public void teardown() {
		//System.out.println("destroyer");
		funList = null;
	}
}
