import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class HashMarkov implements MarkovInterface{
    protected String[] myWords;		// Training text split into array of words 
	protected Random myRandom;		// Random number generator
	protected int myOrder;			// Length of WordGrams used
    private HashMap<WordGram, ArrayList<String>> map;
	
    /**
	 * Default constructor creates order 2 model
	 */
	public HashMarkov() {
		this(2);
	}


	/**
	 * Initializes a model of given order and random number generator.
	 * @param order Number of words used to generate next 
	 * random word / size of WordGrams used.
	 */
	public HashMarkov(int order){
		myOrder = order;
		myRandom = new Random();
        map = new HashMap<WordGram, ArrayList<String>>();
	}

    /**
	 * Initializes training text. Should always be called prior to
	 * random text generation.
	 */
	@Override
	public void setTraining(String text){
		myWords = text.split("\\s+");
        String nextOne;
        map.clear();
        for (int i = 0; i < myWords.length+1-myOrder; i++) {
            WordGram markovWG = new WordGram(myWords, i, myOrder);
            map.putIfAbsent(markovWG, new ArrayList<String>());
            if (myWords.length>=i+myOrder) {
                map.get(markovWG).add("");
            }
            else{
                nextOne = myWords[myOrder+i];
                map.get(markovWG).add(nextOne);
            }
        }
	}


/**
	 * Get a list of Strings containing all words that follow
	 * from wgram in the training text. Result may be an empty list.
	 * Implemented by looping over training text.
	 * @param wgram is a WordGram to search for in the text
	 * @return List of words following wgram in training text.
	 * May be empty.
	 */
	@Override
	public List<String> getFollows(WordGram wgram) {
		if (map.containsKey(wgram)) {
            return map.get(wgram);
        }
		return new ArrayList<String>();
	}


	/**
	 * Returns a random word that follows kGram in the training text.
	 * In case no word follows kGram, returns a random word from the
	 * entire training text.
	 * @param wgram is being searched for in training text. Typically
	 * the previous words of the randomly generated text, but could be
	 * an arbitrary WordGram.
	 * @return a random word among those that follow after kGram in 
	 * the training text, or a random word from the training text.
	 */
	private String getNext(WordGram wgram) {
		List<String> follows = getFollows(wgram);
		if (follows.size() == 0) {
			int randomIndex = myRandom.nextInt(myWords.length);
			follows.add(myWords[randomIndex]);
		}
		int randomIndex = myRandom.nextInt(follows.size());
		return follows.get(randomIndex);
	}


	/**
	 * Generates length random words based on training text.
	 * Initial words are a random WordGram taken from the training text.
	 * Subsequent words are generated by calling getNext on the current
	 * WordGram, which is then shifted to include the newly generated 
	 * word at the end. Words are separated by spaces in returned string.
	 * @param length Number of words to generate
	 * @returns length randomly generated words using Markov model, 
	 * separated by spaces
	 */
	@Override
	public String getRandomText(int length){
        ArrayList<String> randomWords = new ArrayList<>(length);
		int index = myRandom.nextInt(myWords.length - myOrder + 1); // generate number from 0 to the
		WordGram current = new WordGram(myWords,index,myOrder);
		randomWords.add(current.toString());

		for(int k=0; k < length-myOrder; k += 1) {
			String nextWord = getNext(current);
			randomWords.add(nextWord);
			current = current.shiftAdd(nextWord);
		}
		return String.join(" ", randomWords);
	}


	/**
	 * Returns order of Markov model = the length of
	 * WordGrams used.
	 */
	@Override
	public int getOrder() {
		return myOrder;
	}


	/**
	 * Sets the seed of the random number generator
	 * Model will return same value when called with 
	 * same training text after same seed set.
	 * @param seed Random number generator seed
	 */
	@Override
	public void setSeed(long seed) {
		myRandom.setSeed(seed);
	}


}
