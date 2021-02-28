package functionari;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Documents docs = new Documents();
        Random random = new Random();
        System.out.println("Starting threads...");
        for(int i=0;i<8;i++){
            long delay = 1000 + random.nextInt(1000);
            Functionar f = new Functionar(i+1, delay, docs);
            f.start();
        }
        Printer printer = new Printer(2000, docs);
        printer.start();

    }
}
