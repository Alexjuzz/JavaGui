package org.example;

/*
            Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
            Вилки лежат на столе между каждой парой ближайших философов.
            Каждый философ может либо есть, либо размышлять.
            Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
            Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
            Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
 */
public class Philosope {
    private String name;
    private Fork rightFork;
    private Fork leftFork;
    private boolean isEat = false;

    private int countEat = 0;

    public void setCountEat() {
        if (this.rightFork != null && this.leftFork != null) {
            this.countEat++;
        }
    }

    public Fork getRightFork() {
        return rightFork;
    }

    public void setRightFork(Fork rightFork) {
        if (this.rightFork == null && !rightFork.isBusy()) {
            this.rightFork = rightFork;
            this.rightFork.takeFork();
        }
    }

    public Fork getLeftFork() {
        return leftFork;
    }

    public void setLeftFork(Fork leftFork) {
        if (this.leftFork == null && !leftFork.isBusy()) {
            this.leftFork = leftFork;
            this.leftFork.takeFork();
        }else {
            System.out.println("Левая рука занята");
        }
    }

    public boolean isEat() {
        return isEat;
    }

    public void setEat(boolean eat) {

        if (countEat <= 2) {
            isEat = eat;
        }

    }

    public Philosope(String name) {
        this.name = name;
    }
}
