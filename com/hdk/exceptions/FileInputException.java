package com.hdk.exceptions;

import java.io.IOError;
import java.io.IOException;

/**
 * Created by Tahir on 20-11-2016.
 */
public class FileInputException extends IOException{

    public FileInputException(String message){

        super(message);
    }
    @Override
    public void printStackTrace() {
        //Logger TODO
        super.printStackTrace();
    }
}
