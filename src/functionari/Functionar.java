package functionari;

import functionari.Documents;

//producer
public class Functionar extends Thread {

    private Documents docs;
    private long delay;
    private int id;
    public Functionar(int id, long delay, Documents doc){
        this.docs=doc;
        this.delay=delay;
        this.id=id;

    }

    public void run(){

        //try to print 5 documents
        for(int i=1;i<=5;i++){
            try{
                System.out.println("Functionarul " + id + " vrea sa printeze documentul cu numarul " + i);
                sleep(delay);
                docs.documentNou("documentul " + i + " de la functionarul " + id);

            }
            catch(Exception e){
                e.printStackTrace();

            }
        }


    }


}
