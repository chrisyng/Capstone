import java.util.Scanner;
public class Decompressor
{
    private String compressedData;
    private Picture canvas;
    private int x, y; //dimensions of the picture to be decompressed
    public Decompressor(String compressed)
    {
        compressedData = compressed;
        canvas = new Picture(x,y);
    }
    
    public Picture decompress()
    {
        Pixel[][] decompressedPicture = compressed.getPixels2D();
        Scanner in = new Scanner(compressedData);
        while (in.hasNext())
        {
            int red = in.next().parseInt();
            int green = in.next().parseInt();
            int blue = in.next().parseInt();
            int blockLength = in.next().parseInt();
            for (int[] pixelRow : pixels)
            {
                for (
                {
                    
                }
            }
        }
        return canvas;
    }
}