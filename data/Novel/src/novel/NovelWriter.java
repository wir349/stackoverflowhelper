package novel;

import java.util.ArrayList;
import java.util.List;

public class NovelWriter {
	public String writeNovel() {
		
		//...the magic goes here...
		
		return null;
	}
	
	public String shout(String s) {
		return s.toUpperCase().replaceAll("\\.", "!");
	}
	
	private List<Integer> countLetters(List<String> words) {
		List<Integer> out = new ArrayList<Integer>();
		for (String word : words) {
			out.add( word.replaceAll("[^A-Za-z]+","").length() );
		}
		return out;
	}
}
