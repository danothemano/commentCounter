package dan.util;
/**
 * Created with IntelliJ IDEA.
 * User: dsweet
 * Date: 1/22/14
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */



public class Counts extends Object {

    private int codeCount = 0;
    private int commentCount = 0;
    private int fileCount = 0;

     public Counts (){};
     public Counts (int initialCodeCount, int initialCommentCount, int initialFileCount){
         setCodeCount(initialCodeCount);
         setCommentCount(initialCommentCount);
         setFileCount(initialFileCount);

    }

     public void incrementCodeCount (){
        setCodeCount(getCodeCount() + 1);
     }
    public void incrementCommentCount(){
        setCommentCount(getCommentCount() + 1);
    }
    public void incrementFileCount(){
        setFileCount(getFileCount() + 1);
    }

    public void resetCounts(){
        setCodeCount(0);
        setCommentCount(0);
        setFileCount(0);
    }


    public int getCodeCount() {
        return codeCount;
    }

    public void setCodeCount(int codeCount) {
        this.codeCount = codeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }
}
