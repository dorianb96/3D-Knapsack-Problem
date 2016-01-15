package part1ab;

public class Item {
    public Item(double type, int widthX, int heightY, int lengthZ, double value){
        /** the x,y,z dimensions are multiplied by 2 as agreement of representing
         the smallest cell unit with dimensions of 1, not 0.5 just for easier iteration*/
        this.type = type;
        this.widthX = widthX;
        this.heightY = heightY;
        this.lengthZ = lengthZ;
        this.value = value;
    }
    /* here are the usual getters */
    public int getWidthX(){
        return this.widthX;
    }
    public int getHeightY(){
        return this.heightY;
    }
    public int getLengthZ(){
        return this.lengthZ;
    }
    public double getValue(){
        return this.value;
    }
    public double getType(){
        return this.type;
    }
    public double getVolume(){
        return (this.widthX * this.heightY * this.lengthZ);};

    /*all instance fields*/
    private int widthX;
    private int heightY;
    private int lengthZ;

    private double value;    // represents the value of item for problem b
    private double type;    // maybe useful for 3D display
    private int ID;     // maybe useful for 3D display
    /* in the form of eg 2.024 or 1.002, where the number before dot is
    the type of item and behind the dot is the number of the item
     */
}
