package com.hdk.app;

/*
Trainee's coridnates and instances
 */

import com.hdk.exceptions.InvalidPositionException;

/*
Trainee class used for Fitbits callibration on the soccer ptich.
*/

public class Trainee {
	
	private int currentX;
	private int currentY;
	private Position currentPosition;
	private Field field;
	
    public Trainee() {
    }
    

    
    public boolean move() throws Exception {
    	
    	if (currentPosition == Position.N) {
    		
    		if (field.isValidPosition(currentX, (currentY + 1))){

        		currentY++;	
        		return true;
    		}else {
				throw new InvalidPositionException("Invalid Position");
    		}
    		
    	}
    	
    	if (currentPosition == Position.E) {
    		
    		if (field.isValidPosition((currentX + 1), currentY)){

        		currentX++;
        		return true;
    		}else {
				throw new InvalidPositionException("Invalid Board Position");
    		}

    	}
    	
    	if (currentPosition == Position.S) {
    		if (field.isValidPosition(currentX, (currentY - 1))){
    			 
        		currentY--;	
        		return true;
    		}else {
    			throw new InvalidPositionException("Invalid Board Position");
    		}
    	}
    	
    	if (currentPosition == Position.W) {
    		if (field.isValidPosition(currentX-1, currentY)){
        		currentX--;	
        		return true;
    		}else {
				throw new InvalidPositionException("Invalid Board Position");
    		}
    	}
    	
    	return true;
    }
       
    public void turnLeft() {
    	if (currentPosition == Position.N) {
    		currentPosition = Position.W;
    		return;
    	}
    	
    	if (currentPosition == Position.S) {
    		currentPosition = Position.E;
    		return;
    	}
    	
    	if (currentPosition == Position.E) {
    		currentPosition = Position.N;
    		return;
    	}
    	
    	if (currentPosition == Position.W) {
    		currentPosition = Position.S;
    		return;
    	}
    	
    }
    
    public void turnRight() {
    	
    	if (currentPosition == Position.N) {
    		currentPosition = Position.E;
    		return;
    	}
    	
    	if (currentPosition == Position.S) {
    		currentPosition = Position.W;
    		return;
    	}
    	
    	if (currentPosition == Position.E) {
    		currentPosition = Position.S;
    		return;
    	}
    	
    	if (currentPosition == Position.W) {
    		currentPosition = Position.N;
    		return;
    	}
    }
    
    public void currentPosition() {
    	System.out.println(" New Trainee cordinates : "+currentX + " " + currentY + " " + currentPosition);
    }
    
    // Getters and Setters
	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
}