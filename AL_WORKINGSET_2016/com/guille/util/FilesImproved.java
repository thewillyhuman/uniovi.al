package com.guille.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class FilesImproved {

    public static final String UTF_8 = "UTF-8";

    /**
     * Creates a file in the path given with the name given and .log extension.
     * 
     * @param path
     *            for the log.
     * @param filename
     *            to the log.
     * @return a PrintWriter object to print on.
     */
    public static PrintWriter createLogger(String path, String filename) {
	PrintWriter log = null;
	try {
	    log = new PrintWriter(new BufferedWriter(new FileWriter(path + filename + ".log", true)));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	SimpleDateFormat sdf = new SimpleDateFormat("dd - MMM - YYYY 'at' HH:mm:ss");
	log.println("**** LOG CREATED " + sdf.format(Calendar.getInstance().getTime()) + " ****");
	log.close();
	return log;
    }

    /**
     * From a given file will return a list of the same files in the same directory.
     * 
     * @param oneOfFiles is just any of the files to merge.
     * @return a list of files that follow the same naming structure.
     */
    public static List<File> listOfFilesToMerge(File oneOfFiles) {
	String tmpName = oneOfFiles.getName();
	String destFileName = tmpName.substring(0, tmpName.lastIndexOf('.'));
	File[] files = oneOfFiles.getParentFile()
		.listFiles((File dir, String name) -> name.matches(destFileName + "[.]\\d+"));
	Arrays.sort(files);
	return Arrays.asList(files);
    }

    /**
     * Merges some files on to a unique file.
     * 
     * @param oneOfFiles is one of the files to merge
     * @param into the final destination file.
     * @throws IOException
     */
    public static void mergeFiles(File oneOfFiles, File into) throws IOException {
	mergeFiles(listOfFilesToMerge(oneOfFiles), into);
    }

    /**
     * Merges files into one file from a list of given files.
     * 
     * @param files to merge as a list of files.
     * @param into final file.
     * @throws IOException
     */
    public static void mergeFiles(List<File> files, File into) throws IOException {
	System.out.println("Merging to file: " + into.getName());
	try (BufferedOutputStream mergingStream = new BufferedOutputStream(new FileOutputStream(into))) {
	    for (File f : files) {
		Files.copy(f.toPath(), mergingStream);
	    }
	}
	System.out.println("The file " + into.getName() + " has been merged.");
    }

    /**
     * 
     * @param path
     * @param fileName
     * @param extension
     * @throws IOException
     */
    public static void splitFile(String path, String fileName, String extension) throws IOException {
	splitFile(new File(path+fileName+"."+extension));
    }
    
    /**
     * Splits one file into pieces of 1MB.
     * 
     * @param f
     * @throws IOException
     */
    public static void splitFile(File f) throws IOException {
	System.out.println("Splitting file: " + f.getName());
	int partCounter = 1;
	int sizeOfFiles = 1024 * 1024 * 100; // 100MB
	byte[] buffer = new byte[sizeOfFiles];

	try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))) {
	    String name = f.getName();
	    int tmp = 0;
	    while ((tmp = bis.read(buffer)) > 0) {
		File newFile = new File(f.getParent(), name + "." + String.format("%03d", partCounter++));
		try (FileOutputStream out = new FileOutputStream(newFile)) {
		    out.write(buffer, 0, tmp);
		}
	    }
	}
	System.out.println("File: " + f.getName() + ". Splitted into: " + partCounter + " parts");
    }

    /**
     * Writes a file with the provided parameters.
     * 
     * @param path
     *            where the file will be stored.
     * @param fileName
     *            if the name for the file.
     * @param file
     *            the file itself, its content.
     * @param extension
     *            of the file(text, bat). Without the point.
     * @param encoding
     *            to use during writing process.
     * @throws FileNotFoundException
     *             if there's any problem during creating file/directory.
     * @throws UnsupportedEncodingException
     *             if the exception provided is not correct/supported.
     */
    public static void writeFileFromString(String path, String fileName, String file, String extension, String encoding)
	    throws FileNotFoundException, UnsupportedEncodingException {
	PrintWriter writer = new PrintWriter(path + fileName + "." + extension, encoding);
	writer.println(file);
	writer.close();
    }

    /**
     * Given a PrintWriter object and a message will append the file with the
     * message.
     * 
     * @param file
     *            to append.
     * @param message
     *            to write at the end of the file.
     */
    public static void writeLog(String path, String filename, String message) {
	PrintWriter file = null;
	try {
	    file = new PrintWriter(new BufferedWriter(new FileWriter(path + filename + ".log", true)));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	SimpleDateFormat sdf = new SimpleDateFormat("dd - MMM - YYYY  HH:mm:ss");
	file.print(sdf.format(Calendar.getInstance().getTime()) + " :: \t");
	file.println(message);
	file.close();
    }
    
    
}