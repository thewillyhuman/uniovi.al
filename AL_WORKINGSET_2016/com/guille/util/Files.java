package com.guille.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Files {

    /**
     * Writes a file with the provided parameters.
     * 
     * @param path where the file will be stored.
     * @param fileName if the name for the file.
     * @param file the file itself, its content.
     * @param extension of the file(text, bat). Without the point.
     * @param encoding to use during writing process.
     * @throws FileNotFoundException if there's any problem during creating
     *             file/directory.
     * @throws UnsupportedEncodingException if the exception provided is not
     *             correct/supported.
     */
    public static void writeFileFromString(String path, String fileName,
	    String file, String extension, String encoding)
	    throws FileNotFoundException, UnsupportedEncodingException {
	PrintWriter writer = new PrintWriter(path + fileName + "." + extension,
		encoding);
	writer.println(file);
	writer.close();
    }

    /**
     * Creates a file in the path given with the name given and .log extension.
     * 
     * @param path for the log.
     * @param filename to the log.
     * @return a PrintWriter object to print on.
     */
    public static PrintWriter createLogger(String path, String filename) {
	PrintWriter log = null;
	try {
	    log = new PrintWriter(new BufferedWriter(new FileWriter(path
		    + filename + ".log", true)));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	SimpleDateFormat sdf = new SimpleDateFormat(
		"dd - MMM - YYYY 'at' HH:mm:ss");
	log.println("**** LOG CREATED "
		+ sdf.format(Calendar.getInstance().getTime()) + " ****");
	log.close();
	return log;
    }
    
    /**
     * Creates a file in the path given with the name given and .log extension.
     * 
     * @param path for the log.
     * @param filename to the log.
     * @return a PrintWriter object to print on.
     */
    public static PrintWriter writeFileAndAppend(String path, String filename, String mess) {
	PrintWriter log = null;
	try {
	    log = new PrintWriter(new BufferedWriter(new FileWriter(path
		    + filename + ".log", true)));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	SimpleDateFormat sdf = new SimpleDateFormat(
		"dd - MMM - YYYY 'at' HH:mm:ss");
	log.println("**** LOG CREATED "
		+ sdf.format(Calendar.getInstance().getTime()) + " ****");
	log.println(mess);
	log.close();
	return log;
    }

    /**
     * Given a PrintWriter object and a message will append the file with the
     * message.
     * 
     * @param file to append.
     * @param message to write at the end of the file.
     */
    public static void writeLog(PrintWriter file, String message) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd - MMM - YYYY  HH:mm:ss");
	file.print(sdf.format(Calendar.getInstance().getTime()) + " :: \t");
	file.println(message);
	file.close();
    }
}