package org.example;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/*
            Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
            Вилки лежат на столе между каждой парой ближайших философов.
            Каждый философ может либо есть, либо размышлять.
            Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
            Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
            Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
 */
public class Philosope implements Runnable {
    CountDownLatch countDownLatch = new CountDownLatch(2);
    List<Fork> forkList;
    private String name;
    private Fork rightFork;
    private Fork leftFork;
    private boolean isThings = true;
    private boolean isEat = false;
    Random random = new Random();
    private int countEat = 0;

    public Philosope(String name, List<Fork> forkList) {
        this.name = name;
        this.forkList = forkList;
    }

    public boolean setCountEat() {
        if (checkHands() && isThings) {
            this.countEat++;
            this.rightFork.putFork();
            this.leftFork.putFork();
            return true;
        }
        return false;
    }

    public Fork getRightFork() {
        return rightFork;
    }

    public Fork getLeftFork() {
        return leftFork;
    }

    public void setRightFork() {
        try {
            Fork current_fork = getFork(forkList);
            if (this.rightFork == null && current_fork != null && !current_fork.isBusy()) {
                this.rightFork = current_fork;
                this.rightFork.tryTake();
                if (this.rightFork.getCountTakes() > 1) {
                    System.out.println(rightFork.getCountTakes());
                    putFork();
                            Thread.sleep(2000);
                }

            } else if (getRightFork() != null) {
                getRightFork().putFork();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void putFork(){
      if(this.leftFork != null)  this.leftFork.putFork();
       if(this.rightFork != null) this.rightFork.putFork();
    }

    public void setLeftFork() {
        try {
            Fork current_fork = getFork(forkList);
            if (this.leftFork == null && current_fork != null && !current_fork.isBusy()) {
                this.leftFork = current_fork;
                this.leftFork.tryTake();
                if(leftFork.getCountTakes() > 1){
                    System.out.println(leftFork.getCountTakes());
                    putFork();
                    Thread.sleep(2100);
                }
            } else if (getRightFork() != null) {
                getRightFork().putFork();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isEat() {
        return isEat;
    }


    public boolean checkHands() {
        return getLeftFork() != null && getRightFork() != null;
    }

    private Fork getFork(List<Fork> forkList) {
        for (Fork f : forkList
        ) {
            if (!f.isBusy()) {
                return f;
            }
        }
        return null;
    }

    public void toEat() throws InterruptedException {
        try {

            if (!isEat()) {
                setRightFork();
                Thread.sleep(1000);
                setLeftFork();
                setCountEat();
                System.out.println("Философ " + name + " поел");
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            this.toEat();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
