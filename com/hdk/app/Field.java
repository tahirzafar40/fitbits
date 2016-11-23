/*
 * A board object
 */
package com.hdk.app;

/*
This class gives the states of the Boundary of the pitch with defined
limits.
 */
public class Field {
	private int minX = 0;
	private int minY = 0;
	private int maxX = 0;
	private int maxY = 0;

	/*
	Constructor
	 */
	public Field(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	/*
	 * Checks if position of the field is valid
	 * 
	 * @return True if valid position
	 */
	public boolean isValidPosition(int x, int y) {
		if (x > maxX || x < minX) {
			return false;
		}
		
		if (y > maxY || y < minY) {
			return false;
		}
		
		return true;
	}
	
	/*
	* Getter  Minimum x cordinate of the pitch
    */
	public int getMinX()
	{
		return minX;
	}

	/*
	* Setter Minimum x cordinate of the pitch
    */
	public void setMinX(int minX)
	{
		this.minX = minX;
	}

	/*
     * Getter Minimum x cordinate of the pitch
     */

	public int getMinY()
	{
		return minY;
	}

	/*
     * Setter Minimum x cordinate of the pitch
     */
	public void setMinY(int minY)
	{
		this.minY = minY;
	}

	/*
     * Getter Minimum x cordinate of the pitch
     */
	public int getMaxX()
	{
		return maxX;
	}

	/*
     * Setter Minimum x cordinate of the pitch
     */
	public void setMaxX(int maxX)
	{
		this.maxX = maxX;
	}

	/*
     * Getter Minimum x cordinate of the pitch
     */
	public int getMaxY()
	{
		return maxY;
	}

	/*
     *  Setter Minimum x cordinate of the pitch
     */
	public void setMaxY(int maxY)
	{
		this.maxY = maxY;
	}
}
