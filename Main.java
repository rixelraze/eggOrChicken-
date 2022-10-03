public class Main {

    public static void main(String[] args) {

        Debate egg = (new Debate("Яйцо"));
        Debate chicken = (new Debate("Курица"));

        try {
            egg.thread.join();

            if (chicken.thread.isAlive()) {
                System.out.print("Спор окончен. Победило яйцо!");
            } else {
                System.out.print("Спор окончен. Победила курица!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class Debate implements Runnable {

    Thread thread;

    public Debate(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(500);

                System.out.println(thread.getName());

            } catch (InterruptedException e) {

                e.printStackTrace();
            }


        }
    }
}