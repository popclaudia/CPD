package functionari;

import java.util.ArrayList;

//resource
public class Documents {
    private ArrayList<String>docs=new ArrayList<String>();

    public synchronized void documentNou(String docNAme){
        // try {
        System.out.println("Se adauga in coada " + docNAme);
        docs.add(docNAme);
        //
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        notifyAll();

    }

    public synchronized void documentPrintat(){
        System.out.println("\nSe printeaza " + docs.get(0) + "...");
        System.out.println(docs.get(0) + " a fost printat.\n");
        docs.remove(0);
    }

    public ArrayList<String> getDocs() {
        return docs;
    }
}
