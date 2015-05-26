import java.util.Scanner;
public class Decompressor
{
    private String compressedData;
    private Picture canvas;
    private int x, y; //dimensions of the picture to be decompressed
    public Decompressor(String compressed, int x, int y)
    /**
     * Default constructor for objects of class Decompressor.
     * @param compressed The STring containing the compressed data about the picture.
     * @param x,y the x and y dimensions of the picutre that needs to be compressed
     */
    {
        compressedData = compressed;
        this.x=x;
        this.y=y;
        canvas = new Picture(y,x);
    }

    public Picture decompress()
    /**
     * Main decompress method returns the decompressed picture from the String data.
     * @return canvas the uncompressed picture
     */
    {
        Pixel[][] decompressedPicture = canvas.getPixels2D();
        Scanner in = new Scanner(compressedData);
        for (Pixel[] pixelRow : decompressedPicture)
        {
            int pixelNum = 0;
            while (in.hasNext() && pixelNum < pixelRow.length)
            {                
                int red = Integer.parseInt(in.next());
                int green = Integer.parseInt(in.next());
                int blue = Integer.parseInt(in.next());
                int blockLength = Integer.parseInt(in.next());
                int startBlock = pixelNum;
                while(pixelNum < startBlock + blockLength && pixelNum<pixelRow.length)
                {
                    pixelRow[pixelNum].setRed(red);
                    pixelRow[pixelNum].setGreen(green);
                    pixelRow[pixelNum].setBlue(blue);
                    pixelNum++;
                }                
            }
        }
        return canvas;
    }
}