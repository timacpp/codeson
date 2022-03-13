package codeson.processor.wrapper;

import java.io.File;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Scanner wrapper for reading Codeson files */
public class CodesonReader implements Closeable {
    private final Scanner scanner;
    
    public CodesonReader(String filename, String delimiter) throws FileNotFoundException {
        this.scanner = new Scanner(new File(filename)).useDelimiter(delimiter);
    }
    
    public String next() {
        return scanner.next();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
