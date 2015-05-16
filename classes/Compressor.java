import java.util.Scanner;
public class Compressor
{
    private Picture original;
    private Pixel[][] uncompressedPixels;    
    public Compressor(Picture picture)
    /**
     * Makes a new compressor object by with a passed in picture object
     */
    {
        original = picture;
        uncompressedPixels = picture.getPixels2D();
    }

    public String compress()
    /**
     * Run the compression algorithm: go row-by-row, find matching pixels with RGB values within 5 of each other, and store it as a String of integers in the order red, green, blue, and length of the block.
     * @return string with compressed data, in the format R, G, B, length, with spaces as delimiters 
     */
    {
        String compressedData = "";
        for (int i=0; i< uncompressedPixels.length; i++)
        {
            Pixel previousPixel;
            int numMatching=1; //stores amount of similar pixels in a row
            for (int j=1; j<uncompressedPixels[0].length; j++)
            {
                previousPixel=uncompressedPixels[i][j-1];
                if (checkSameColor(previousPixel, uncompressedPixels[i][j]))
                {
                    numMatching++; // check if the pixels are the "same" and increment the block size
                }
                else // calculate the average RGB values and send that to the compressed String of data
                {
                    Pixel[] thisBlock = new Pixel[numMatching];
                    int a = 0;
                    for (int n=j-numMatching; n<j; n++)
                    {
                        thisBlock[a] = uncompressedPixels[i][n];
                        a++;
                    }                   
                    int[] blockColors = calculateAverageRGB(thisBlock);
                    compressedData += (" " + blockColors[0] + " " + blockColors[1] + " " + blockColors[2] + " " + numMatching + " ");
                    numMatching = 1; //reset the counter, but include this pixel since it still needs to be scanned
                }
            }
        }
        return compressedData;
    }   

    public int[] calculateAverageRGB(Pixel[] block)
    /**
     * Helper method that finds the average of a given block of RGB values
     * @param block the block of pixels that needs to have its average color calculated
     * @return the average RGB values of a given "pixel block" as a 3-integer array
     */
    {
        int totalRed=0;
        int totalGreen=0;
        int totalBlue = 0;
        int blockLength = block.length;
        for (Pixel pixel: block)
        {
            totalRed += pixel.getRed();
            totalGreen += pixel.getGreen();
            totalBlue += pixel.getBlue();
        }
        return new int[]{totalRed/blockLength, totalGreen/blockLength, totalBlue/blockLength};
    }

    public boolean checkSameColor(Pixel first, Pixel second)
    /**
     * Helper method that checks for similarity between pixels.
     * @param first first pixel for comparison
     * @param second second pixel for comparison
     */
    {
        if (Math.abs(first.getRed()-second.getRed()) < 10 &&
        Math.abs(first.getGreen()-second.getGreen()) < 10 &&
        Math.abs(first.getBlue()-second.getBlue()) < 10)
        {
            return true;
        }
        return false;
    }
}