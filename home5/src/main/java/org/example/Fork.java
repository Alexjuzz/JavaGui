package org.example;
/*
        Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
        Вилки лежат на столе между каждой парой ближайших философов.
        Каждый философ может либо есть, либо размышлять.
        Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
        Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
        Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны

 */
//
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class Fork {
   public  volatile boolean isBusy = false;
   private int idFork;
   private Lock lock = new ReentrantLock();




    public boolean isBusy() {
        return isBusy;
    }

    private void setBusy(boolean busy) {
        isBusy = busy;
    }
    public void takeFork(){
        lock.lock();
        setBusy(true);
    }
    public void putFork(){
        setBusy(false);
        lock.unlock();
    }
}
