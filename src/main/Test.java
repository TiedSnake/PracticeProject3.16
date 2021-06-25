/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;

/**
 *
 * @author m-w-n
 */
public class Test
{
    public static void main(String[] args) throws IOException
    {
        FileManagement obj = new FileManagement();
        //System.out.println(obj.createFile("textFile1.txt"));
//        obj.writeInsideFile("textFile1.txt", "This is the first modification in textFile1.txt\nand this is a new line.");
//        obj.writeInsideFile("textFile2.txt", "This is the first modification in textFile2.txt\nand this is a new line.");
//        System.out.println(obj.readFile("textFile2.txt"));
        System.out.println(obj.appendToFile("textFile2.txt", "\nThis line is added using appendToFile method!"));
    }
    
}
