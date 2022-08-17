import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
 private static int newWidth = 300;
    public static void main(String[] args) {
        String srcFolder = "C:\\\\multithreading\\src";
        String dstFolder = "C:\\\\multithreading\\dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int middle= files.length/2;
        File[] files1 = new File[middle];
        System.arraycopy(files, 0,files1,0, files1.length);


        File[] files2=new File[files.length-middle];
        System.arraycopy(files, middle,files2, 0, files2.length);


        int middle1=files1.length/2;
        int middle2=files2.length/2;
        File[] file1=new File[middle1];
        System.arraycopy(files1,0,file1,0,file1.length);
        ImageResizer resizer1=new ImageResizer(file1,newWidth,dstFolder,start);
        new Thread(resizer1).start();

        File[] file2=new File[files1.length-middle1];
        System.arraycopy(files1,middle1,file2,0,file2.length);
        ImageResizer resizer2=new ImageResizer(file2,newWidth,dstFolder,start);
        new Thread(resizer2).start();

        File[] file3= new File[middle2];
        System.arraycopy(files2,0,file3,0,file3.length);
        ImageResizer resizer3=new ImageResizer(file3,newWidth,dstFolder,start);
        new Thread(resizer3).start();

        File[] file4=new File[files2.length-middle2];
        System.arraycopy(files2,middle2,file4,0,file4.length);
        ImageResizer resizer4=new ImageResizer(file4,newWidth,dstFolder,start);
        new Thread(resizer4).start();






    }
}
