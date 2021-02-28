package parcurgere_string;

public class Main {

    public static void main(String[] args) {

        CommonMemory cm = new CommonMemory();
        System.out.println("Creating threads");
        Start start = new Start(cm);
        End end = new End(cm);
        System.out.println("Starting threads");
        start.start();
        end.start();
    }
}
