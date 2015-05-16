public class CompressorRunner
{
    public static void main(String[] args)
    {
        Picture uncompressed = new Picture("dog.jpg");
        Compressor compressor = new Compressor(uncompressed);
        String compressedData = compressor.compress();
        //System.out.println(compressedData);
        Decompressor decompressor = new Decompressor(compressedData, uncompressed.getWidth(), uncompressed.getHeight());
        Picture decompressed = decompressor.decompress();
        decompressed.write("decompressed.jpg");
    }
}