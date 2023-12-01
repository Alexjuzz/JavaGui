package org.example;

import java.util.List;
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
            if (this.rightFork == null &&  current_fork != null && !current_fork.isBusy()) {
                this.rightFork = current_fork;
                this.rightFork.takeFork();

            }else if(getRightFork() != null){
                Thread.sleep(1000);
                getRightFork().putFork();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void setLeftFork() {
        try {
            Fork current_fork = getFork(forkList);
            if (this.leftFork == null && current_fork != null &&!current_fork.isBusy()) {
                this.leftFork = current_fork;
                this.leftFork.takeFork();
            }else  if(getRightFork() != null){
                Thread.sleep(1000);
                getRightFork().putFork();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean isEat() {
        return isEat;
    }



    public boolean checkHands(){
        if(getLeftFork() != null && getRightFork() != null){
           return true;
        }
        return false;
    }
    private Fork getFork(List<Fork> forkList){
        for (Fork f: forkList
             ) {
            if(!f.isBusy){
                return f;
            }
        }
        return null;
    }

    public void toEat() throws InterruptedException {
      try {
          countDownLatch.countDown();
          setRightFork();
          setLeftFork();
          setCountEat();
          countDownLatch.await();
          System.out.println("Философ " + name + " поел");
      }catch (InterruptedException e){

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
