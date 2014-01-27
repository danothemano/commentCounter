/**
 * Created with IntelliJ IDEA.
 * User: dsweet
 * Date: 1/22/14
 * Time: 8:54 AM
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.nio.file.*;

import dan.util.*;


public class CommentCounter {

    Counts counts;

    CommentCounter(){
        counts = new Counts();

    }
    public static void main(String[] args) throws IOException {
        String dirName = args[0];
        CommentCounter cc = new CommentCounter();


        cc.scanForFiles(dirName) ;
        //cc.scanFile(dirName, cc.counts);
        System.out.println("Line Count:  " + (cc.counts.getCodeCount() + cc.counts.getCommentCount()));
        System.out.println("Comment Count:  " + cc.counts.getCommentCount());
        System.out.println("File Count:  " + cc.counts.getFileCount());
    }

    private void scanFile(String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)));
        CommentScanner cs = new CommentScanner();
        try {
            counts.incrementFileCount();


            while (s.hasNext()) {

                String currentLine = s.next();
                if (cs.scanComment(currentLine) == true) {
                    //System.out.println("TRUE:  " + currentLine);
                    counts.incrementCommentCount();

                } else {
                    counts.incrementCodeCount();
                   // System.out.println("FALSE:  " + currentLine);
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    private void scanForFiles(String dirName){
         System.out.println("starting to scan for files in "+ dirName);
        try {
            Path startPath = Paths.get(dirName);
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir,
                                                         BasicFileAttributes attrs) {
                    System.out.println("Dir: " + dir.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    try{
                        if(file.toString().indexOf("assets")==-1){ //skip 3rd party
                            scanFile(file.toString());
                            System.out.println("Scanning File: " + file.toString());
                        }


                    } catch (IOException e){e.printStackTrace();}

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
