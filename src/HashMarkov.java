import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class HashMarkov extends BaseMarkov{
    private HashMap<WordGram, ArrayList<String>> map;

	public HashMarkov() {
		this(2);		
	}

	public HashMarkov(int order){
		super(order);
		map = new HashMap<WordGram, ArrayList<String>>();
	}

	@Override
	public void setTraining(String text){
		super.myWords = text.split("\\s+"); // separates words by spaces or newlines
		map.clear(); // clears the map to avoid previous data used on other trainings
		WordGram tempWG; // variable to create WordGrams to populate map
		// Time Complexity: O(n^2)
		for (int i = 0; i < myWords.length-super.myOrder; i++) {
			tempWG = new WordGram(myWords, i, super.myOrder);
			map.putIfAbsent(tempWG, new ArrayList<String>());
			if (myWords.length==myOrder+i) {
				map.get(tempWG).add("");
			}
			else{
			map.get(tempWG).addAll(Arrays.asList(Arrays.copyOfRange(myWords, i+super.myOrder, i+super.myOrder+1))); // insert all following words to the hashmap of the given WordGram object
			}
		}
	}

    @Override
	// Time Complexity: O(1)
	public List<String> getFollows(WordGram wgram) {
		List<String> followWords = map.get(wgram);
        if(followWords!=null){
            return followWords;
        }
        return new ArrayList<String>();
	}
}
