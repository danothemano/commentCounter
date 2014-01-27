package dan.util;

/**
 * Created with IntelliJ IDEA.
 * User: dsweet
 * Date: 1/22/14
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */

public class CommentScanner extends Object {

        public CommentScanner(){}
        public static boolean scanComment(String line){

          //System.out.println("scanning for comment...");
            int inlineComment = line.indexOf("//");
            int startComment = line.indexOf("/*");
            int endComment = line.indexOf("*/");
            int midComment = line.indexOf("*");

            if (inlineComment != -1 || startComment != -1 || endComment!=-1 || midComment!=-1) {
               /* System.out.println("inline "+inlineComment);
                System.out.println("start "+startComment);
                System.out.println("end "+endComment);
                System.out.println("mid "+midComment); */
                return true;
            }

         else{return false; }
      }
}

