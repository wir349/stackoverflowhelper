package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import novel.NovelWriter;

import org.junit.BeforeClass;
import org.junit.Test;

public class NovelWriterTest {

	public static NovelWriter novelWriter;

	@BeforeClass
	public static void beforeClass() {
		novelWriter = new NovelWriter();
	}

	@Test
	public void privateShout() throws NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {
		
		String input = "This is magic.";

		String output = novelWriter.shout(input);
		
		assertThat(output, notNullValue());
		assertThat(output, is("THIS IS MAGIC!"));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void privateCountLettersInList() throws NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {

		List<String> input = Arrays.asList("Foo", "Foobar123", "Foo Bar Baz");
		
		List<Integer> output = novelWriter.countLetters(input);

		assertThat(output, notNullValue());
		assertThat(output.size(), is(3));
		assertThat(output, hasItems(3, 6, 9));
	}
}
