package com.hdk.ops;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tahir on 20-11-2016.
 */



public class LocationInputValidator {



    private static final String LOCATION_PATTERN = "^\\d\\d(N|E|S|W)$";
    //2d -> two digits (a|b) matches any of the character
    private static final String INSTRUCTION_PATTERN = "^[LMR]{0,}$";

    private static Pattern patternLoc = Pattern.compile(LOCATION_PATTERN);
    private static Pattern patternInstr = Pattern.compile(INSTRUCTION_PATTERN);
    private  static Matcher matcher;




    /**
     * Validate location with regular expression
     * @param location location for validation
     * @return true valid location, false invalid location
     */
    public static boolean validateLoc(final String location){


        matcher = patternLoc.matcher(location);
        return matcher.matches();

    }
    /**
     * Validate instruction with regular expression
     * @param instruction instruction for validation
     * @return true valid instruction, false invalid instruction
     */
    public static boolean validateInstr(final String instruction){

        matcher = patternInstr.matcher(instruction);
        return matcher.matches();

    }

}