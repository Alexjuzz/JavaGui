package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fork> forkList = new ArrayList<>();
        forkList.add(new Fork());
        forkList.add(new Fork());
        forkList.add(new Fork());
        forkList.add(new Fork());
        Philosope philosope = new Philosope("U");
        Philosope philosope2 = new Philosope("Z");
        Philosope philosope3 = new Philosope("A");
        philosope3.setLeftFork(forkList.get(0));
        philosope3.setRightFork(forkList.get(1));
        System.out.println(forkList.get(0).isBusy);
        System.out.println(forkList.get(1).isBusy);
        philosope2.setLeftFork(forkList.get(0));
    }
}