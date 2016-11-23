/**
 * Handle Parsing of text file
 * Take each line of file and stuff into arraylist
 * Line 1 is always size of board
 * Line 2 is initial position of member on board
 * Line 3 is Commands 
 * Line 2 and Line 3 are repeated for n times
 */
package com.hdk.ops;

import com.hdk.app.Field;
import com.hdk.app.Position;
import com.hdk.app.Trainee;
import com.hdk.exceptions.FileInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputFileHandler {

	protected static final Logger log = LoggerFactory.getLogger(InputFileHandler.class);
	private Path fFilePath = null;

	private int maxX = 0;
	private int maxY = 0;

	/*
	 * If file exists, accept, else throw IOException
	 */
	public InputFileHandler(String aFileName) throws FileInputException {
		setfFilePath(Paths.get(aFileName));
		if (!fFilePath.toFile().exists()) {
			throw new FileInputException("File Doesn't Exist");
		}
	}

	public List<String> processInputData() throws IOException {
		List<String> instructionsList = new ArrayList<String>();

		try (Scanner scanner = new Scanner(fFilePath, "UTF-8")) {
			while (scanner.hasNextLine()) {
				String line = processLine(scanner.nextLine());
				instructionsList.add(line);
			}
			return instructionsList;
		}

	}

	/*
	 * Set Upper Coordinates of Field String to max X and maxY
	 */
	public Field setFieldBoundary(String coordString)
			throws FileInputException {

		Field field = null;
		// Tokenize String by space
		StringTokenizer stringTokenizer = new StringTokenizer(coordString, " ");

		if (stringTokenizer.countTokens() == 2) {
			try {
				setMaxX(Integer.parseInt(stringTokenizer.nextToken()));
				setMaxY(Integer.parseInt(stringTokenizer.nextToken()));
				field = new Field(maxX, maxY);
			} catch (Exception ex) {
				throw new FileInputException("Field Coordinates Not valid ");
			}

		} else {
			throw new FileInputException("Invalid Field Size");
		}
		return field;
	}

	/*
	 * Parse Trainee Coordinates on Field String
	 */
	public Trainee validateTraineeCordinates(String memberCoordinatesString)
			throws FileInputException {
		
		Trainee trainee = new Trainee();

			int x = Integer.parseInt(String.valueOf(memberCoordinatesString.charAt(0)));
			int y = Integer.parseInt(String.valueOf(memberCoordinatesString.charAt(1)));

			Position currentPosition = null;

			String direction = String.valueOf(memberCoordinatesString.charAt(2));

			if (direction.equals("N")) {
				currentPosition = Position.N;

			} else if (direction.equals("E")) {
				currentPosition = Position.E;

			} else if (direction.equals("S")) {
				currentPosition = Position.S;

			} else if (direction.equals("W")) {
				currentPosition = Position.W;
			}else {
				throw new FileInputException("Invalid Trainee Cooridnates on Field");
			}

			// Create new trainee
			trainee.setCurrentX(x);
			trainee.setCurrentY(y);
			trainee.setCurrentPosition(currentPosition);


		return trainee;
	}
	
	
	/*
	 * Check if commands for member are valid
	 */
	public boolean isValidMemberCommands(char[] charDirectionArray) {
		boolean valid = false;
		for (char c: charDirectionArray)
		{
		    valid = ((c == 'L') || (c == 'R')) || ((c == 'M'));

		    if (!valid)
		    {
		        break;
		    }
		}
		return valid;
	}

	
	protected String processLine(String aLine) {
		String line = null;
		//  Parse line of input data
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("\n");
		if (scanner.hasNext()) {

			line = scanner.next();
		    log.debug("line input : "+line);

		} else {
			 log.error("Incorrect Data");
		}
		scanner.close();
		return line;
	}

	public Path getfFilePath() {
		return fFilePath;
	}

	public void setfFilePath(Path fFilePath) {
		this.fFilePath = fFilePath;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

}
