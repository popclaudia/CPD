package functionari;

import functionari.Documents;

//consumer
public class Printer extends Thread {

    Documents docs;
    private long delay;
    public Printer(long delay, Documents doc){
        this.docs=doc;
        this.delay=delay;

    }

    public void run(){
        try{
            while(true){
                System.out.print("");
                if(docs.getDocs().size()>=1) {
                    sleep(delay);
                    docs.documentPrintat();
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
