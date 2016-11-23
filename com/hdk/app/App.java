package com.hdk.app;

import com.hdk.exceptions.InvalidPositionException;
import com.hdk.ops.InputFileHandler;
import com.hdk.ops.LocationInputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


/**
 * Fitbits main application
 * *
 */
public class App
{

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )

    {

        InputFileHandler fileHandler = null;

        //Assign input data file path to the
        String filePath = getInputFilePath();

        try {
            fileHandler = new InputFileHandler(filePath);
            List<String> lineInput = fileHandler.processInputData();

            // Fixing the boundary limit
            Field board = fileHandler.setFieldBoundary(lineInput.get(0));
            Trainee trainee = null;
            char[] directionArray = null;

            for (int i = 1; i < lineInput.size(); i++) {


                if (((i % 2) == 1) ){

                    String trimData = lineInput.get(i).replaceAll("\\s+","");
                    boolean loc = LocationInputValidator.validateLoc(trimData);
                    log.debug("Intial location of the trainee --> "+loc);
                    trainee = fileHandler.validateTraineeCordinates(trimData);

                    trainee.setField(board);
                    log.debug("Intialized Trainee with mentioned cordinates");
                    // trainee.currentPosition();

                } else if ((i % 2) == 0) { // Parse Series of Instructions

                    if (LocationInputValidator.validateInstr((lineInput.get(i).toString().trim()))){
                        directionArray = lineInput.get(i).toCharArray();
                    if (fileHandler.isValidMemberCommands(directionArray)) {
                        moveAhead(directionArray, trainee);
                        trainee.currentPosition();
                    }
                }
                else{
                    throw new InvalidPositionException("Instructions not valid");
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        validateInputFile();

    }
/*
Move trainee one step ahead
 */

    public static void moveAhead(char[] directionArray, Trainee trainee)
            throws Exception {


        // Iterate character array and move the trainee
        for (int i = 0; i < directionArray.length; i++) {

            // Turn Left
            if (directionArray[i] == 'L') {
                trainee.turnLeft();
            } else if (directionArray[i] == 'M') {
                trainee.move();
            } else if (directionArray[i] == 'R') {
                trainee.turnRight();
            }
        }
    }

/*
Get input file as User Input
 */

    public static String getInputFilePath(){


        Scanner input = new Scanner(System.in);
        System.out.print("Enter FilePath ");
        String inputString = input.nextLine();
        System.out.print("You entered : ");
        System.out.println(inputString);
        return  inputString;

       }
    public static void validateInputFile(){



    }
}
