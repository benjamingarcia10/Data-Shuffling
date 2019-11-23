package cs146F19.Garcia.project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DataShuffler {
	
	Random rand;
	BufferedReader fileReader;
	PrintWriter printWriter;
	File file;
	int dataSize;
	String[] data;
	//ArrayList<String> data = new ArrayList<String>();
	long startTime;
	long fileReadStart;
	long fileReadEnd;
	long shuffleEnd;
	long outputEnd;
	
	// Create new Object DataShuffler without a seed for random object.
	public DataShuffler() {
		rand = new Random();
	}
	
	// Create new Object DataShuffler with a seed for random object.
	public DataShuffler(int randSeed) {
		rand = new Random(randSeed);
	}
	
	// Main method that is called for shuffle on passed in file.
	public void shuffle(String input, String output) {
		startTime = System.currentTimeMillis();							// Log start time for program
		initialize(input, output);										// Initialize all required variables
		
		fileReadStart = System.currentTimeMillis();
		createArray();													// Create array with all lines from passed in file
		fileReadEnd = System.currentTimeMillis();
		//createArrayList();
		
		fisherYatesShuffle();											// Perform in place shuffle on array
		shuffleEnd = System.currentTimeMillis();
		
		createOutputFile();												// Output shuffled array to output file
		outputEnd = System.currentTimeMillis();
		
		// Calculate and output the time to read from file, to shuffle the elements, and to create the output.
		System.out.printf("This program took %d ms to read from the input file.\n", calculateTime(fileReadStart, fileReadEnd));
		System.out.printf("This program took %d ms to shuffle elements.\n", calculateTime(fileReadEnd, shuffleEnd));
		System.out.printf("This program took %d ms to create the output file.\n", calculateTime(shuffleEnd, outputEnd));
		System.out.printf("This program ran for a total of %d ms.\n", calculateTime(startTime, outputEnd));
	}
	
	// Initialize all variables in program.
	private void initialize(String input, String output) {
		try {
			fileReader = new BufferedReader(new FileReader(input));			// Set the BufferedReader to read from the passed in file name
			file = new File(input);											// Create a File object for use in the createArray() method for a scanner
			printWriter = new PrintWriter(output);							// Create a file to write the final shuffled result to
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Method to create the array with all lines from the file.
	private void createArray() {
		try {
			Scanner scan = new Scanner(file);				// Create scanner using File created in initialize method
			scan.next();									// Scan past "%" in file
			scan.next();									// Scan past 1st int in file
			scan.next();									// Scan past 2nd int in file
			dataSize = scan.nextInt();						// 3rd int in file = size of data (how many slots array should hold)
			scan.close();
			data = new String[dataSize];					// Initialize array with size of data
			fileReader.readLine();							// Read past 1st line (line that was already read with Scanner)
			for(int i = 0; i < dataSize; i++)
				data[i] = fileReader.readLine();			// Add every line into corresponding spot in array
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	// Add all elements from passed in file into an ArrayList (one line = one element)
	private void createArrayList() {
		String insert;
		try {
			while((insert = fileReader.readLine()) != null)
				data.add(insert);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println(data.size());
	}
	*/
	
	// Perform the Fisher-Yates shuffle algorithm.
	// Start from the last element, swap it with a randomly selected element from the whole dataset (including last).
	// In the next step you will consider the rows from 0 to n-2 (size reduced by 1), and repeat the process until you reach the first element.
	private void fisherYatesShuffle() {
		int randInt;
		String temp;
		for(int i = dataSize - 1; i > 0; i--) {
			randInt = rand.nextInt(i);						// rand.nextInt(i) generates "random" int from 0 (inclusive) to i (exclusive)
			temp = data[i];
			data[i] = data[randInt];
			data[randInt] = temp;
		}
	}
	
	// Output all shuffled elements into text file specified in the initialize method.
	private void createOutputFile() {
		for(int i = 0; i < dataSize; i++) {
			printWriter.println(data[i]);
		}
		printWriter.close();
	}
	
	// Calculate total run time based on start and end parameters.
	private long calculateTime(long start, long end) {
		return end - start;
	}
}
