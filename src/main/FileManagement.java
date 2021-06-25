/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author m-w-n
 */
public class FileManagement
{

    static String Directory = "C:\\Users\\m-w-n\\Documents\\NetBeansProjects\\FileHandling3.16\\files\\";
    static Path path = Paths.get(Directory);

    public String exist(String fileName)
    {
        String output = "";
        if (Files.exists(path))
        {
            output = "Directroy exist";
            if (Files.exists((Path) Paths.get(Directory + fileName)))
            {
                output = "File already exist";
            } else
            {
                output = "File does not exist";
            }
        } else
        {
            output = "Directory does not exist";
        }
        return output;
    }

    public String createFile(String fileName) throws IOException
    {
        File file = new File(Directory + fileName);
        if (exist(fileName).contains("File does not exist"))
        {
            file.createNewFile();
            return ("File " + fileName + " is created in: " + Directory);
        } else if (exist(fileName).contains("File already exist"))
        {
            return ("The file " + fileName + " already exist");
        } else
        {
            return "The directory you just specified\n" + Directory + "\ndoes not exist";
        }
    }

    public void writeInsideFile(String fileName, String content) throws IOException
    {
        FileOutputStream out = new FileOutputStream(Directory + fileName);
        if (createFile(fileName).contains("already exist"))
        {
            out.write(content.getBytes());
            out.close();
        } else
        {
            createFile(fileName);
            out.write(content.getBytes());
            out.close();
        }
    }

    public String readFile(String fileName) throws IOException
    {
        if (exist(fileName).contains("already exist"))
        {
            String content = new String(Files.readAllBytes(Paths.get(Directory + fileName)));
            return content;
        }else
        {
            return exist(fileName);
        }
    }

    public String appendToFile(String fileName, String content) throws IOException
    {
        if (exist(fileName).contains("already exist"))
        {
            StringBuffer output = new StringBuffer(readFile(fileName));
            output.append(content);
            writeInsideFile(fileName, output.toString());
            return readFile(fileName);
        }else
        {
            return exist(fileName);
        }
    }
}
