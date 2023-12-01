package org.example;

import java.util.List;


/*
            Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
            Вилки лежат на столе между каждой парой ближайших философов.
            Каждый философ может либо есть, либо размышлять.
            Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
            Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
            Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
 */
public class Philosope implements Runnable {
    List<Fork> forkList;
    private final String name;
    private Fork rightFork;
    private Fork leftFork;
    private final boolean isEat = false;
    private int countEat = 0;

    public Philosope(String name, List<Fork> forkList) {
        this.name = name;
        this.forkList = forkList;
    }

    /**
     * Обновление количества ужинов.
     * Изменение статуса текущей вилки в руке.
     */
    public void setCountEat() {
        if (checkHands() && !isEat) {
            this.countEat++;
            this.rightFork.putFork();
            this.leftFork.putFork();
        }
    }

    public Fork getRightFork() {
        return rightFork;
    }

    public Fork getLeftFork() {
        return leftFork;
    }

    /**
     * Взятие правой рукой.
     * Ищем свободную вилку
     * далее смотрим нет ли в левой руке вилки уже(Вдруг забыл) если нет, проверяем это вообще вилка ли?!
     * если оказывается что и вилка свободна, то смотрим не держит ли её кто-то ещё помимо нас.
     * Пробуем взять, вдруг это не первая попытка, если не первая, придется пока положить, если первая то берем,
     * дальше нужно немного подумать.
     * В этот момент Происходит взятие в другую руку по тойже схеме, если все удачно кушаем и не думаем.
     */
    public void setRightFork() {
        try {
            Fork current_fork = getFork(forkList);
            if (this.rightFork == null && current_fork != null && !current_fork.isBusy()) {
                this.rightFork = current_fork;
                this.rightFork.tryTake();
                if (this.rightFork.getCountTakes() > 1) {
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

    public void putFork() {
        if (this.leftFork != null) this.leftFork.putFork();
        if (this.rightFork != null) this.rightFork.putFork();
    }

    /**
     * Взятие левой рукой.
     * Ищем свободную вилку
     * далее смотрим нет ли в левой руке вилки уже(Вдруг забыл) если нет, проверяем это вообще вилка ли?!
     * если оказывается что и вилка свободна, то смотрим не держит ли её кто-то ещё помимо нас.
     * Пробуем взять, вдруг это не первая попытка, если не первая, придется пока положить, если первая то берем,
     * дальше нужно немного подумать.
     * В этот момент Происходит взятие в другую руку по тойже схеме, если все удачно кушаем и не думаем.
     */
    public void setLeftFork() {
        try {
            Fork current_fork = getFork(forkList);
            if (this.leftFork == null && current_fork != null && !current_fork.isBusy()) {
                this.leftFork = current_fork;
                this.leftFork.tryTake();
                if (leftFork.getCountTakes() > 1) {
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

    /**
     * Проверка думает или ест.
     */
    public boolean isEat() {
        return isEat;
    }

    /**
     * Проверка рук, то что в обеих руках находятся свободные вилки.
     */
    public boolean checkHands() {
        return getLeftFork() != null && getRightFork() != null;
    }

    /**
     * Из полученого списка проверяем свободные вилки, если есть такие, то выдаем.
     */
    private Fork getFork(List<Fork> forkList) {
        for (Fork f : forkList
        ) {
            if (!f.isBusy()) {
                return f;
            }
        }
        return null;
    }

    /**
     * Проверяем чем занят филосов isEat - true - eст или false - думает, далее пробуем взять вилку
     * в правую руку, потом отдыхаем дальше тоже самое с левой рукой.
     * и пробуем покушать.
     */
    public void toEat() throws InterruptedException {
        while (countEat != 2) {
            if (!isEat()) {
                setRightFork();
                setLeftFork();
                setCountEat();
            }
        }
        System.out.println("Философ " + name + " поел");
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
