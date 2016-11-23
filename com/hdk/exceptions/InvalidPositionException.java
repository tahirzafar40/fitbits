package com.hdk.exceptions;

import java.io.IOException;

/**
 * Created by Tahir on 20-11-2016.
 */
public class InvalidPositionException extends Exception{

    public InvalidPositionException(String message){
        super(message);


    }
    @Override
    public void printStackTrace() {
        //Logger TODO
        super.printStackTrace();
    }
}
