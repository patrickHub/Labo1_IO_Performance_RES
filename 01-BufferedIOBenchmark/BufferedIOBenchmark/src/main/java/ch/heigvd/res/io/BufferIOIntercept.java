/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.io;
import ch.heigvd.res.io.BufferedIOBenchmark.IOStrategy;
import java.io.*;
import java.util.LinkedList;

/**
 *
 * @author PatrickDesle
 */
/**
 * this classe will be use to register mesures of each IO test as object So
 * at the end of the tests will be more easier to save those mesures in an external file
 * @author PatrickDesle
 */
public class BufferIOIntercept {
    
    private long time;
    private String op;
    private IOStrategy strategy;
    private long numberBte;
    private int blkSize;
    private boolean fromOut;
    public static LinkedList<BufferIOIntercept> bufferIOList = new LinkedList<>(); // Will contain the instances created at the end of each IO test
    
    /**
     * Constructor of the class
     * @param time time of execution
     * @param strategy strategy of the IO test
     * @param numberBte total number of data that have been write or read
     * @param blkSize block size of the data
     * @param op name of the operation either write or read
     */
    
    public BufferIOIntercept(long time, IOStrategy strategy, long numberBte, int blkSize, String op) {
        this.time = time;
        this.strategy = strategy;
        this.numberBte = numberBte;
        this.blkSize = blkSize;
        this.op = op;
    }
    
    /**
     * this method saves the mesures of each instance of this class in an external file.
     * @param fileName name of the external file the save data in
     * @throws IOException 
     */
    public static void write2File(String fileName) throws IOException{
        BufferedWriter output = null;
        try {
            File file = new File(fileName);
            output = new BufferedWriter(new FileWriter(file));
            for(BufferIOIntercept ob : bufferIOList){
                
                output.write(ob.op + "," + ob.strategy + "," + ob.numberBte + "," + ob.blkSize + "," + ob.time + "\n");
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) output.close();
        }
    }
    
}
