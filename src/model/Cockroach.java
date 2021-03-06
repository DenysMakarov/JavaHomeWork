package model;

import java.io.*;

public class Cockroach implements Runnable {
    private String name;
    private int dist;
    private int chunks = 0;
    private final int MIN = 2;
    private final int MAX = 5;

    public Cockroach(String name, int dist) {
        this.name = name;
        this.dist = dist;
    }

    private int randomMs(int min, int max){
        return (int) ((Math.random() * ( (max) - min )) + min);
    }

    @Override
    public void run() {
        int time;
        for (int i = 0; i < dist; i++) {
            time = randomMs(MIN, MAX);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.chunks++;
            if (chunks == dist) {
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/results.txt", true))) {
                    writer.write(name + ",");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Finshed = " + name);
            }
        }
    }
}
