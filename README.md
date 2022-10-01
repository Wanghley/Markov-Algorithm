![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

<!-- LOGO -->
<br />
<h1>
<p align="center">
  <img src="figures/MarkovLogo.gif" alt="Logo" height="250">
  <br>Markov Algorithm Implementation
</h1>
  <p align="center">
    Example of implementation of the Markov Algorithm using efficient runtime complexity using the Java API and data structures. Based on HashMap and O(1) implementation. 
    <br />
    </p>
</p>
<p align="center">
  <a href="#about-the-project">About The Project</a> •
  <a href="#Cloning">How To Use</a>
</p>                                                                                                                             
                                                                                                                                                      
## About The Project
Computer science uses random Markov processes frequently to analyze many types of data. In this research, a generative model for producing text with a realistic appearance using data-driven techniques is examined in an occasionally comic approach.

Researchers studying artificial intelligence and machine learning in general, and those specializing in natural language processing (the application of algorithmic and statistical AI/ML techniques to human language), are particularly interested in generative models. The [OpenAI GPT-3](https://openai.com/blog/gpt-3-apps/) is a powerful and current example of such a text-generation model using statistical machine learning software.

### Wordgrams
Like a Java String represents a sequence of letters, WordGram represents a succession of words (expressed as strings). The WordGram class is an immutable sequence of strings, similar to how the Java String class is an immutable sequence of characters. An immutable WordGram object is one that cannot be changed once it has been created. A WordGram object's content cannot be altered. A new WordGram can be made from an existing one, though.

The order of a WordGram is occasionally referred to as the total number of strings it contains. To view some examples of order-3 WordGram objects, expand the section below.


<details>
<Summary>Example of order-3 Wordgrams</summary>

| | | |
| --- | --- | --- |
| "wanghley" | "soares" | "martins" |
| | | |

and 
| | | |
| --- | --- | --- |
| "Humans" | "are" | "destroying" |
| | | |

</details> 
<details>
<Summary>Example of order-5 Wordgrams</summary>

| | | |
| --- | --- | --- |
| "wanghley" | "soares" | "martins" | "is" | "crazy" |
| | | |

and 
| | | | | |
| --- | --- | --- | --- | --- |
| "Humans" | "are" | "destroying" | "the" | "planet" |
| | | | | |

</details> 


### Markov Model
Models with the Markov property are random models. In this instance, our goal is to develop a Markov model for generating random text that resembles training text. The Markov property in our context means that the probability for each subsequent word will be predicated on those of the preceding words. We shall produce one random word at a time.

When predicting text, an order-k Markov model uses order-k WordGrams, often known as k-grams (where k is the order). First, we choose a k-gram at random from the training text (the data we use to create our model; we want to generate random text similar to the training text). After that, we search for occurrences of that k-gram in the training text to determine the probabilities associated with possible next words. Then, using the final k-1 words from the prior k-gram and the newly formed word, we repeat the process, this time generating a new word in accordance with these probabilities. Continue in this manner until the necessary number of random words has been generated.

Read more about Markov Models and applications [HERE](http://dx.doi.org/10.1007/978-3-540-68947-8_8)

## Cloning

Import from GitHub:
```sh
git clone https://github.com/Wanghley/Markov-Algorithm
cd Markov-Algorithm
```

## Folder Structure

```bash
    Markov-Algorithm/
    ├── data
    ├── figures
    ├── lib
    ├── src/
    │   ├── BaseMarkov.java
    │   ├── HashMarkov.java
    │   ├── MarkovDriver.java
    │   ├── MarkovInterface.java
    │   ├── MarkovTest.java
    │   ├── TextSource.java
    │   ├── WordGram.java
    │   └── WordGramTest.java
    └── README.md
```

## Usage
In order to implement the following project you must use the ```MarkovDriver.java``` everytime you want to execute the code and generate a model by changing its constants of the order of the wordgram and the size of the output.

The ```BaseMarkov.java``` is the implementation without efficiency of the Markov algorithm while the ```HashMarkov.java``` is the implementation of HashMaps in the Markov algorithm and it is MORE efficient than the primer class.

The JUnit test is implemented in this project and, therefore, if you want to execute automatic tests in any adaptations of this code and of the WordGram class. YOu can use ```MarkovTest.java``` and     ```WordGramTest.java``` for testing Markov and WordGram, respectively.

## Credits
- Credit to [Professor Brandon Fain](https://sites.duke.edu/btfain/) for the base Markov code used on this project.   
- Credit to [Joseph Rocca](https://medium.com/@joseph.rocca) for the descriptive gif of the Markov Algorithm used in the head of this document.