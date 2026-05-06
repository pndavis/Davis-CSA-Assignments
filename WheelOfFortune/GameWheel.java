import java.awt.Color;
import java.util.ArrayList;

public class GameWheel
{
    public ArrayList<Slice> slices; // List of slices making up the wheel
    private int currentPos;   // Position of currently selected slice on wheel


    /* START CODING BELOW */
    
    // Removes the last slice from the slices ArrayList
    public void removeSlice()
    {

    }

    // Returns a String consisting of a numbered list of all slices of GameWheel (using the slice’s toString method), one on each line.  
    public String toString()
    {
        //Create the toString to send back

        return "";
    }

    // Adds a new slice at the end of the slices ArrayList. You must create a new slice to then add to the ArrayList
    public void addSlice()
    {

    }

    /* Creates a wheel based with numSlices number of Slices
     * takes in a parameter numSlices and makes a wheel with that many slices. 
     * You must use at least 3 different colors for the slices and generate different numbers for the prizes. 
     * How you want your wheel to look exactly is up to you.
     * Make sure to update playGame.java so that when it calls this constructor it sends in an int number
    */
    public GameWheel(int numSlices)
    {

    }

    // Randomizes the positions of the slices that are in the wheel
    public void scramble()
    {

    }

    /* Sorts the positions of the slices that are in the wheel by prize amount */
    public void sort()
    {
        
    }

    /* COMPLETED METHODS BELOW - YOU DO NOT NEED TO CHANGE THESE */
    /* COMPLETED METHODS BELOW - YOU DO NOT NEED TO CHANGE THESE */

    /* Creates a wheel with 20 preset slices*/
    public GameWheel()
    {
        currentPos = 0;
        slices = new ArrayList<Slice>();
        
        for (int i = 0; i < 20; i++)
        {
            if (i % 2 == 0)
            {
                slices.add(new Slice(new Color(0,0,0), new Color(255,255,255), i));
            }
            else
            {
                slices.add(new Slice(new Color(255,255,255), new Color(0,0,0), i));
            }
        }
    }

    /* Spins the wheel by so that a different slice is selected. */
    public Slice spinWheel()
    {
        currentPos = (int)(Math.random()*slices.size());
        return slices.get(currentPos);
    }

    /* Spins the wheel by so that a different slice is selected. */
    public Slice getSlice(int sliceNum)
    {
        return slices.get(sliceNum);
    }

    /* Returns the currentPosition on the wheel */
    public int getCurrentPos()
    {
        return currentPos;
    }

    /* Returns the total number of slices in the array */
    public int numSlices()
    {
        return slices.size();
    }
}
