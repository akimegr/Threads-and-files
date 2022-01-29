import java.io.*;
import java.util.Scanner;

public class Potok {
    public static void main(String[] args) throws InterruptedException, IOException {
        Th t = new Th();
        try {
            FileReader rd = new FileReader("c.txt");
            Scanner scan = new Scanner(rd);
            System.out.println(scan.nextLine());
            rd.close();
        } catch (FileNotFoundException e) {
            System.out.println("SS");
        }


        Th t2 = new Th();
        Th t3 = new Th();
        t.start();
        //t3.start();
        t2.start();
        Thread.sleep(100,40);
        t.interrupt();
        Thread.sleep(0,10);


    }
}

class Th extends Thread {
    public void run(){


        Thread cur = Thread.currentThread();
        for (int i = 0; i < 1000 && !cur.isInterrupted(); i++) {
            System.out.println(i);
            if(i==500){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try(FileWriter writer = new FileWriter("q.txt", true))
            {
                writer.write(Integer.toString(i)+"\n");
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }
}
