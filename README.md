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
  <a href="#usage">How To Use</a> •
  <a href="#examples">Examples</a> •
  <a href="#best-practice">Best Practice</a> •
  <a href="#credits">Credits</a> •
  <a href="examples.md">More Examples</a>
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
</br></br>

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

```sh
usage: fast-copy.py [-h HELP] source destination [-d DELETE] [-s SYNC] [-r REPLACE]

optional arguments:
  -h --help            show this help message and exit
  source                the drive you are copying from
  destination           the drive you are copying to
  -d --delete           delete the source files after copy
  -s --sync             delete files in destination if not found in source (do not use, if using with rsync)
  -r --replace          replace files if they exist
  -t --thread           set the amount of parallel threads used
  -l --size-limit       set max size of files copied (supports gb, mb, kb) eg 1.5gb
```
The `source` and `destination` fields are required. Everything else is optional.

## Examples
```py
from google.colab import drive
drive.mount('/gdrive', force_remount=False)
import os
!wget -q https://raw.githubusercontent.com/L0garithmic/fastcolabcopy/main/fastcopy.py
import fastcopy
!python fastcopy.py /gdrive/Shareddrives/Source/. /gdrive/Shareddrives/Destination --thread 20 --size-limit 400mb
```
If you want to see copy execution time:
```mod
!pip install -q ipython-autotime
%load_ext autotime
```
Check out <a href="examples.md">examples.md</a> for some more examples.

## Best Practice
Colab has wildly varying transfer speeds, because of this, the best we can offer are suggestions:
- For large groups of medium/small files, 15-40 threads seems to work best.
- For 50+ files with significantly varying sizes, try 2 sequentially copies. `-t 15 -l 400` then `-t 2`
- For files that are 100MB+, it is best to use 2 threads. It is still faster then rsync.   
- Currently `--sync` breaks if rsync is ran after. If you are mirroring drives. Disable `--sync` and use the rsync's `--delete` function.

## Credits
- Credit to [Professor Brandon Fain](https://sites.duke.edu/btfain/) for the base Markov code used on this project.   