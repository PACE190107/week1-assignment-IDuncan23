package com.revature.eval.java.core;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String acronym = "";
		
		String[] phraseSplit = phrase.split(" |-");
		
		for(int i = 0; i <= phraseSplit.length - 1; i++) {
			acronym = acronym.concat(phraseSplit[i].substring(0,1).toUpperCase());
		}
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(sideOne == sideTwo && sideOne == sideThree && sideTwo == sideThree) {
				return true;
			}else {
				return false;
			}
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if(
					(sideOne == sideTwo && sideOne != sideThree) ||
					(sideOne == sideThree && sideOne != sideTwo) ||
					(sideTwo == sideThree && sideTwo != sideOne)) {
				return true;
				
			}
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree) {
				return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
String word = string.toLowerCase();
		
		int points = 0;
		
		char[] chars = word.toCharArray();
		
		for(int i = 0; i <= chars.length - 1; i++) {
			switch (chars[i]) {
			
			case 'e': 
			case 'a': 
			case 'o': 
			case 't':
			case 'i':
			case 'n':
			case 'r': 
			case 's':
			case 'l':
			case 'u': 
				points += 1;
				break;
			case 'd':
			case 'g':
				points += 2;
				break;
			case 'c':
			case 'm':
			case 'b':
			case 'p':
				points += 3;
				break;
			case 'h':
			case 'f':
			case 'w':
			case 'y':
			case 'v':
				points += 4;
				break;
			case 'k':
				points += 5;
				break;
			case 'j':
			case 'x':
				points += 8;
				break;
			case 'q':
			case 'z':
				points += 10;
				break;
			}
			
		}
		System.out.println(points);
		return points;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException{
	
		String result = string.replaceAll("[^\\w\\s]","");
		System.out.println("this is user input: ");
		result = result.replaceAll("\\s+","");
		System.out.println(result);
		result = result.replaceAll("[^\\d.]", "");
		
		int size = result.length();
		int excess = size - 10;
		
		//System.out.println(result);
		if(size == 11) {
			if(result.substring(0,1).equals("1")) {
				if(!result.substring(1,2).equals("0") && !result.substring(1,2).equals("1")) {
					if(!result.substring(4,5).equals("0") && !result.substring(4,5).equals("1")) {
						result = result.substring(excess);
						return result;
					}else{
						System.out.println("The second set of three digits cannot start with a 0 or 1!");
					}
				}else {
					System.out.print("The area code cannot start with a 0 or 1!");
				}
			}else{
				System.out.println("The national code must be +1!");
			}
		}else if(size == 10){
			System.out.println(result);	
			return result;
		}else if(size > 11) {
			throw new IllegalArgumentException("Number invalid.");
		}else{
			throw new IllegalArgumentException("Number invalid.");
		}
		return result;
	}
		
	

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		String cleanString = string.replaceAll("\n", "");
		String[] stringSplit = cleanString.split(" |,");
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		
		for(int i = 0; i < stringSplit.length; i++) {
			
			//System.out.println(wordMap);
			
			if(!wordMap.containsKey(stringSplit[i])) {
				wordMap.put(stringSplit[i], 1);
				System.out.println("Testing");
			}else{
				wordMap.put(stringSplit[i], wordMap.get(stringSplit[i]) + 1);
			}
			
			
		}
		//System.out.println(wordMap);
		//System.out.println(stringSplit[1]);
		return wordMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// split string into any array separated by spaces
		String[] splitString = string.split(" ");
		//create empty string for new translated word or phrase
		String translated = "";
		
		//loops through and address each index of splitString array
		for(int i = 0; i < splitString.length; i++) {
			
			// set first letter of current array index value to variable
			String firstLetter = splitString[i].substring(0,1);
			//set first two letters of current array index value to variable
			String firstTwo = splitString[i].substring(0,2);
			// set first three letters of current array index value to variable
			String firstThree = splitString[i].substring(0,3);

			
			//if the first two letter are not equal to "th", "qu", and "sch"
			//then run switch statement
			if(!firstTwo.equals("th") && !firstTwo.equals("qu") && !firstThree.equals("sch")) {
				//System.out.println("Test");
				//depending on the first letter of current index value
				//if vowel, just add "ay" to end
				switch (firstLetter) {
				case "a":
				case "e":
				case "i":
				case "o":
				case "u":
					splitString[i] = splitString[i] + "ay";
					translated = splitString[i];
					return translated;
					//break;
				//if not a vowel, place first letter on end and add "ay"
				default:
					splitString[i] = splitString[i].substring(1, splitString[i].length()) + firstLetter + "ay";
					translated = splitString[i];
					//break;
				}
			//else if the first two letters are equal to "th" OR "qu"
			//add the two letters to the end of word and add "ay"
			}else if(firstTwo.equals("th") || firstTwo.equals("qu")){
				splitString[i] = splitString[i].substring(2, splitString[i].length()) + firstTwo + "ay";
				translated = splitString[i];
			//else if the first three letters are equal to "sch"
			//add the three letters to the end of word and add "ay"
			}else if(firstThree.equals("sch")){
				splitString[i] = splitString[i].substring(3, splitString[i].length()) + firstThree + "ay";
				translated = splitString[i];
			}
		}
		//if array has more than one word in it
		//join the array as a string separated by a space
		//else just return the single word
		if(splitString.length > 1) {
			translated = String.join(" ", splitString);
			return translated;
		}else {
			return translated;
		}
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		
		//convert input into string and assign to variable
		String stringNumber = Integer.toString(input);
		//split string (by digits) into string array, assign to variable
		String[] strNumArr = stringNumber.split("");
		//length of string array (# of digits)
		int length = strNumArr.length;
		//calculated value to compare original input to
		int calculate = 0;
		
		for(int i = 0; i < length; i++) {
			double baseNum = Double.parseDouble(strNumArr[i]);
			double powerNum = Double.valueOf(length);
			strNumArr[i] = String.valueOf(Math.pow(baseNum, powerNum));
			
			calculate = calculate + Integer.parseInt(strNumArr[i].replace(".0", ""));
		}
		if(input != calculate) {
			return false;
		}else {
			return true;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> primeFactors = new ArrayList<Long>();
		//count how many times number is divided by 2
		int count = 0;
		
		//as long as l divided by 2 leaves nothing for remainder, keep halving it
		//and add it to array
		while(l % 2 == 0) {
			l = l / 2;
			count += 1;
		}
		
		if(count != 0) {
			for(long i = 0; i < count; i++) {
				primeFactors.add(2L);
			}
		}
		
        for (long i = 3; i <= Math.sqrt(l); i+= 2) 
        { 
            // as long as l divided my i leaves no remainder, divide l by i 
        	// and add to list
            while (l % i == 0) 
            { 
                primeFactors.add(i);
                l = l / i; 
            } 
        } 
  
        // if prime is greater than 2
        // add it to list
        if (l > 2) 
			primeFactors.add(l); 

		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			
			// assign input to string variable
			String myString = string;
			//assign input to StringBuilder object
			StringBuilder rotateString = new StringBuilder(myString);
			//create variable to store new string created from StringBuilder object
			String myNewPhrase = "";
			
			// loop through characters of element to address each character of element
			for(int i = 0; i < rotateString.length(); i++) {
						
				//if the character is a letter at the index of the string
				//continue to process code
				if(Character.isLetter(rotateString.charAt(i))) {
					//if the character is uppercase, set it acording to ASCII code
					if(Character.isUpperCase(rotateString.charAt(i))) {
						
						char myChar = (char) (((int)rotateString.charAt(i) + key - 65) % 26 + 65);
						System.out.println("myChar = " + myChar); //test
						rotateString.setCharAt(i, myChar);
						System.out.println("if uppercase: " + rotateString); //test
						
						//if the character is lowercase, set it acording to ASCII code
					}else if(Character.isLowerCase(rotateString.charAt(i))){
						char myChar = (char) (((int)rotateString.charAt(i) + key - 97) % 26 + 97);
						rotateString.setCharAt(i, myChar);
					}
					
				}else {
					continue;
				}
			}
			myNewPhrase = rotateString.toString();
			return myNewPhrase;
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException {
		
		if(i < 1) {
			throw new IllegalArgumentException("Ooo... Yeah... You messed up. We can't accept anything lower than 2.");
		}
		//set input to theNth variable
		int theNth = i;
		//the number that's being compared
		int candidate;
		//counts how many prime numbers
		int count;
	    for(candidate = 2, count = 0; count < theNth; ++candidate) {
	        if (isPrime(candidate)) {
	            ++count;
	        }
	    }
	    // the candidate will increment when count reaches theNth
	    return candidate-1;
		    
	}
	
	public boolean isPrime(int primeNum) {
        for(int i = 2; i < primeNum; ++i) {
            if (primeNum % i == 0) {
                // if the number is divisible by anything other than itself, return false
                // it's not a prime number
                return false;
            }
        }
        return true;
    }

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			Map<Character, Character> alphaMap = new HashMap<Character, Character>();
			alphaMap.put('a', 'z'); alphaMap.put('b', 'y'); alphaMap.put('c', 'x');
			alphaMap.put('d', 'w'); alphaMap.put('e', 'v'); alphaMap.put('f', 'u');
			alphaMap.put('g', 't'); alphaMap.put('h', 's'); alphaMap.put('i', 'r');
			alphaMap.put('j', 'q'); alphaMap.put('k', 'p'); alphaMap.put('l', 'o');
			alphaMap.put('m', 'n'); alphaMap.put('n', 'm'); alphaMap.put('o', 'l');
			alphaMap.put('p', 'k'); alphaMap.put('q', 'j'); alphaMap.put('r', 'i');
			alphaMap.put('s', 'h'); alphaMap.put('t', 'g'); alphaMap.put('u', 'f');
			alphaMap.put('v', 'e'); alphaMap.put('w', 'd'); alphaMap.put('x', 'c');
			alphaMap.put('y', 'b'); alphaMap.put('z', 'a');
			
			String myString = string;
			myString = myString.toLowerCase();
			myString = myString.replace(",", "");
			myString = myString.replace(".", "");
			myString = myString.replace(" ", "");
			StringBuilder encodeString = new StringBuilder(myString);
			//System.out.println(decodeString); //test
			int charGroupNum = 5;
			
			for(int i = 0; i < encodeString.length(); i++) {
				if(Character.isLetter(encodeString.charAt(i))) {
					encodeString.setCharAt(i, alphaMap.get(encodeString.charAt(i)));
				}
			}
			//System.out.println(decodeString);
			String result = encodeString.toString();
			result = result.replaceAll("(.{" + charGroupNum + "})", "$0 ").trim();
			System.out.println(result);
			return result;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			Map<Character, Character> alphaMap = new HashMap<Character, Character>();
			alphaMap.put('a', 'z'); alphaMap.put('b', 'y'); alphaMap.put('c', 'x');
			alphaMap.put('d', 'w'); alphaMap.put('e', 'v'); alphaMap.put('f', 'u');
			alphaMap.put('g', 't'); alphaMap.put('h', 's'); alphaMap.put('i', 'r');
			alphaMap.put('j', 'q'); alphaMap.put('k', 'p'); alphaMap.put('l', 'o');
			alphaMap.put('m', 'n'); alphaMap.put('n', 'm'); alphaMap.put('o', 'l');
			alphaMap.put('p', 'k'); alphaMap.put('q', 'j'); alphaMap.put('r', 'i');
			alphaMap.put('s', 'h'); alphaMap.put('t', 'g'); alphaMap.put('u', 'f');
			alphaMap.put('v', 'e'); alphaMap.put('w', 'd'); alphaMap.put('x', 'c');
			alphaMap.put('y', 'b'); alphaMap.put('z', 'a');
			
			String myString = string;
			myString = myString.toLowerCase();
			myString = myString.replace(" ", "");
			StringBuilder decodeString = new StringBuilder(myString);

			for(int i = 0; i < decodeString.length(); i++) {
				if(Character.isLetter(decodeString.charAt(i))) {
					decodeString.setCharAt(i, alphaMap.get(decodeString.charAt(i)));
				}
			}
			String result = decodeString.toString();
			
			return result;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		
		//assign input to variable for manipulation
		String myString = string;
		//replace all dashes in the ISBN number
		myString = myString.replace("-","");
		//store whether ISBN is valid
		boolean isValidIsbn = false;
		//set the sum to 0 to start
		int sum = 0;
		//loop through string characters to address each
		//multiply each character by 10 decrementing to 1 with each iteration
		for(int i=0, j=10; i < myString.length(); i++, j--) {
			//if character is not a digit and if last character is not an X
			//the ISBN is invalid
			if(!Character.isDigit(myString.charAt(i)) && myString.charAt(myString.length()-1) != 'X') {
				isValidIsbn = false;
				break;
			//if character is a digit OR if any character (which would be X) is equal to X, run ode
			}else if(Character.isDigit(myString.charAt(i)) || myString.charAt(i) == 'X'){
					//if character is digit, convert character to int and add it to sum after 
					//multiplying by decrementing value
					if(Character.isDigit(myString.charAt(i))) {
						int storeAsInt = Character.getNumericValue(myString.charAt(i));
						sum = sum + (storeAsInt * j);
					//else if the character is equal to X, add 10 to the sum
					}else if(myString.charAt(i) == 'X') {
						int myX = 10;
						sum = sum + myX;
					}	
			}
		}
		
		if(sum % 11 == 0) {
			isValidIsbn = true;
		}
		return isValidIsbn;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// store input into string variable
		String myString = string;
		myString = myString.toLowerCase();
		boolean isValidPangram = false;
		//create a new map to store unique alphabet value
		Map<Character, Integer> alphabetCheck = new HashMap<Character, Integer>();
		alphabetCheck.put('a', 0); alphabetCheck.put('b', 1); alphabetCheck.put('c', 2); alphabetCheck.put('d', 3);
		alphabetCheck.put('e', 4); alphabetCheck.put('f', 5); alphabetCheck.put('g', 6); alphabetCheck.put('h', 7);
		alphabetCheck.put('i', 8); alphabetCheck.put('j', 9); alphabetCheck.put('k', 10); alphabetCheck.put('l', 11);
		alphabetCheck.put('m', 12); alphabetCheck.put('n', 13); alphabetCheck.put('o', 14); alphabetCheck.put('p', 15);
		alphabetCheck.put('q', 16); alphabetCheck.put('r', 17); alphabetCheck.put('s', 18); alphabetCheck.put('t', 19);
		alphabetCheck.put('u', 20); alphabetCheck.put('v', 21); alphabetCheck.put('w', 22); alphabetCheck.put('x', 23);
		alphabetCheck.put('y', 24); alphabetCheck.put('z', 25); 
		
		
		for(int i = 0; i < myString.length(); i++) {
			//if character at index is in the map, remove that index from map
			if(alphabetCheck.containsKey(myString.charAt(i))) {
				alphabetCheck.remove(myString.charAt(i));
			}
		}
		//if there are no elements in index, return valid pangram
		if(alphabetCheck.isEmpty()) {
			isValidPangram = true;
		}
		return isValidPangram;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given){
		LocalDateTime date = LocalDateTime.of(1,Month.JANUARY,1,0,0,0);
		
		date = date.withYear(given.get(ChronoField.YEAR));
		date = date.withMonth(given.get(ChronoField.MONTH_OF_YEAR));
		date = date.withDayOfMonth(given.get(ChronoField.DAY_OF_MONTH));
		
		try {
			
			date = date.withHour(given.get(ChronoField.HOUR_OF_DAY));
			date = date.withMinute(given.get(ChronoField.MINUTE_OF_HOUR));
			date = date.withSecond(given.get(ChronoField.SECOND_OF_MINUTE));
			
		}catch (Exception e){
			
		}
		
		return date.plusSeconds(1_000_000_000);
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {

		int maxNum = i;
		int[] findMultipleOf = set.clone();
		List<Integer> storeMultiples = new ArrayList<Integer>();
		
		int sum = 0;
		
		for(int j = 0; j < findMultipleOf.length; j++) {
				
			for(int y = findMultipleOf[j]; y < maxNum; y++) {
					
				if(y % findMultipleOf[j] == 0) {
					if(!storeMultiples.contains(y)) {
						storeMultiples.add(y);
					}
				}			
			}
		}

		for(Integer x : storeMultiples) {
			sum += x;
		}
		
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {

		//store input as string
		String myString = string;
		//replace all spaces with no space
		myString = myString.replace(" ", "");
		//create new stringbuild object to manipulate string
		StringBuilder myStringBuild = new StringBuilder(myString);
		int sum = 0;
		boolean isLuhn = false;
		
		//if the string length is greater than 1, run code
		//else return false
		if(myString.length() > 1) {
			
			//if string has any letters, it's invalid, return false
			//else, run code
			if(myString.matches("[a-zA-Z]")) {
				isLuhn = false;
			}else {
				//loop through from the end of the string and skip every other character
				for(int i = myString.length() -2; i > 0; i -= 2) {
					
					//store character as int so it can be calculated and multiply it by 2
					int storeAsNum = Character.getNumericValue(myStringBuild.charAt(i));
					storeAsNum = storeAsNum * 2;
					if(storeAsNum > 9) {
						storeAsNum -= 9;
					}
					//convert int to a string and then to char to input back into string 
					String storeAsString = Integer.toString(storeAsNum);
					char storeAsChar = storeAsString.charAt(0);
					myStringBuild.setCharAt(i, storeAsChar);
				}
					
				for(int j = 0; j < myString.length(); j++) {
					sum = sum + Character.getNumericValue(myStringBuild.charAt(j));
					if(!Character.isDigit(myStringBuild.charAt(j))) {
						isLuhn = false;
						break;
					}else if(j == myString.length() - 1) {
						if(sum % 10 == 0) {
							isLuhn = true;
							return isLuhn;
						}else {
							isLuhn = false;
							return isLuhn;
						}
					}
				}
			}		
		}
		return isLuhn;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 * @throws ScriptException 
	 */
	public int solveWordProblem(String string) throws ScriptException {
		
		//create script engine manager object to calculate string
		ScriptEngineManager mngr = new ScriptEngineManager();
	    ScriptEngine engine = mngr.getEngineByName("JavaScript");
	    //declare expression and calculation variables
	    String expression = "";
	    int calculation = 0;
	    
	    String myString = string;
	    myString = myString.replace("?", "");
	    String[] myStringArr = myString.split(" ");
	    
	    for(int i=0; i<myStringArr.length; i++) {
	    	
	    	if(myStringArr[i].equals("plus")) {
	    		myStringArr[i] = "+";
	    		expression = expression + myStringArr[i];
	    	}else if(myStringArr[i].equals("minus")) {
	    		myStringArr[i] = "-";
	    		expression = expression + myStringArr[i];
	    	}else if(myStringArr[i].equals("multiplied")) {
	    		myStringArr[i] = "*";
	    		expression = expression + myStringArr[i];
	    	}else if(myStringArr[i].equals("divided")) {
	    		myStringArr[i] = "/";
	    		expression = expression + myStringArr[i];
	    	}else if(myStringArr[i].matches("[0-9]+") || myStringArr[i].contains("-")) {
	    		expression = expression + myStringArr[i];
	    	}
	    	
	    }
	    
	    calculation = (int) engine.eval(expression);
		return calculation;
	}

}
