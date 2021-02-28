package parcurgere_string;

public class Start extends Thread{

    CommonMemory commonMemory = new CommonMemory();
    public Start(CommonMemory commonMemory) {
        this.commonMemory=commonMemory;
    }

    public void run(){
        int i=0;
        int j= commonMemory.getS().length()/2;
        while(i<=j){
            try {
                System.out.println("Start is reading: " + commonMemory.getS().charAt(i));
                i++;
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
