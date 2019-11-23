package cs146F19.Garcia.project1;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

class erdosTest {	
	
	DataShuffler data;
	
	@Test
	void test() {
		data = new DataShuffler(20);												// Create DataShuffler object with random seed 20
		data.shuffle("data\\ErdosCA.txt", "data\\GarciaBenjaminShuffled.txt");		// Perform shuffle on "ErdosCA.txt" file stored in data folder and output to "GarciaBenjaminShuffled.txt" file stored in data folder
		try {
			BufferedReader out = new BufferedReader (new FileReader ("data\\GarciaBenjaminShuffled.txt"));		// Create BufferedReader object called "out" using output file from data.shuffle() method
			BufferedReader in = new BufferedReader (new FileReader ("data\\Target2.txt"));						// Create BufferedReader object called "in" using provided text file from instructor
			String expectedLine;
			while ((expectedLine = in.readLine ()) != null) {													// Check line by line from provided text file vs program output file
				String actualLine = out.readLine ();
				assertEquals(expectedLine, actualLine);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}