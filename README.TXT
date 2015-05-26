CAPSTONE: Compressing pictures with Picture classes from MediaComputation
Goal: Compress a picture by storing data about its pixels as a continuous String. Write a Decompressor that can reconstruct a picture from this compressed data.
Synthesis of concepts throughout the year:
Arrays and array indexing: works with 2D arrays of pixels by using for and while loops to manipulate index variables (this also covers decisions and looping structures)
Object-oriented design: Arrays contain pixel objects, which I call methods on. The Compressor and Decompressor classes demonstrate good class design by having private instance variables and private helper methods, while leaving public the methods that are to be used by other classes.
Computational Media: this is essentially a MediaComputation project.

Additional research: I did research on image compression algorithms, such as DST (Discrete Cosine Transform), but found them to complicated to implement in my chosen design. I also researched working with the Java Thread class to create multithreaded programs (this acutally would have also exhibited inheritance and polymorphism) but I wasn't able to make that a part of my program.

Instructions: Run the static void main() method in the CompressorRunner class. 