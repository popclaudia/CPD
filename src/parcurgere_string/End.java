package parcurgere_string;

public class End extends Thread{

    private CommonMemory commonMemory;
    public End(CommonMemory commonMemory) {
        this.commonMemory = commonMemory;

    }

    public void run(){
        int i = commonMemory.getS().length()/2 +1;
        int j = commonMemory.getS().length()-1;
        while(j>=i){
            try {
                System.out.println("End is reading: " + commonMemory.getS().charAt(j));
                j--;
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
