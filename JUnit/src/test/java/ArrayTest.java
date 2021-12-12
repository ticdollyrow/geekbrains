import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ArrayTest {
	Array array;

	@BeforeEach
	void init(){
		array = new Array();
	}
	
	@Test
	public void getSubarrayTest() {
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1, 2, 4, 4, 2, 3, 4, 1, 7) );
		Iterable<Integer> out = new ArrayList<>(Arrays.asList(1, 7) );
		assertIterableEquals(out, array.getSubarray(in));
	}

	@Test
	public void testThrow(){
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 7) );
		Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> { array.getSubarray(in); });
	}

	@Test
	public void getSubarrayLastFourTest() {
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 7, 4) );
		Iterable<Integer> out = new ArrayList<>();
		assertIterableEquals(out, array.getSubarray(in));
	}

	@Test
	public void getSubarrayFirstFourTest() {
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(4, 1, 2, 2, 3, 1, 7) );
		Iterable<Integer> out = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 7));
		assertIterableEquals(out, array.getSubarray(in));
	}

}
