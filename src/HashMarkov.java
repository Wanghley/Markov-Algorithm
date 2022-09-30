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
		for (int i = 0; i < myWords.length+1-super.myOrder; i++) {
			tempWG = new WordGram(myWords, i, super.myOrder);
			map.putIfAbsent(tempWG, new ArrayList<String>());
			map.get(tempWG).addAll(Arrays.asList(Arrays.copyOfRange(myWords, i+super.myOrder, i+super.myOrder+1))); // insert all following words to the hashmap of the given WordGram object
		}
	}

    @Override
	public List<String> getFollows(WordGram wgram) {
		List<String> followWords = map.get(wgram);
        if(followWords!=null){
            return followWords;
        }
        return new ArrayList<String>();
	}

    // @Override
	// public String getRandomText(int length){
	// 	ArrayList<String> randomWords = new ArrayList<>(length);
	// 	int index = myRandom.nextInt(myWords.length - myOrder + 1);
	// 	WordGram current = new WordGram(myWords,index,myOrder);
	// 	randomWords.add(current.toString());

	// 	for(int k=0; k < length-myOrder; k += 1) {
	// 		String nextWord = getNext(current);
	// 		randomWords.add(nextWord);
	// 		current = current.shiftAdd(nextWord);
	// 	}
	// 	return String.join(" ", randomWords);
	// }
}
