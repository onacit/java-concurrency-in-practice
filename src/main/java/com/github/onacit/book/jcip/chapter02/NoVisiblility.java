package com.github.onacit.book.jcip.chapter02;

class NoVisiblility {

    private static boolean ready; // false

    private static int number; // 0

    private static class ReaderThread extends Thread {

        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(final String... args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
