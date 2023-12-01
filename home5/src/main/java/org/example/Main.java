package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fork> forkList = new ArrayList<>();
        Philosope p1 = new Philosope("Buga",forkList);
        Philosope p2 = new Philosope("Qua",forkList);
        Philosope p3 = new Philosope("MUI",forkList);
        Philosope p4 = new Philosope("OOGAA",forkList);
        Philosope p5 = new Philosope("XaE",forkList);
        Thread thread = new Thread(p1);
        Thread thread2 = new Thread(p2);
        Thread thread3= new Thread(p3);
        Thread thread4 = new Thread(p4);
        Thread thread5 = new Thread(p5);
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}