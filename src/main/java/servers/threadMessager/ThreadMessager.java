package servers.threadMessager;
public class ThreadMessager extends Thread{

    public void run() {
        while(true) {
            try {
                Thread.sleep(3000);
                System.out.println("\n\nsend\n\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
