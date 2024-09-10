package intermediate.multithreading.deadlock;

public class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    void withdraw(int amount) {
        balance -= amount;
    }


    public static void main(String...args){
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public static class RyanAndMonicaJob implements Runnable {

        BankAccount bankAccount = new BankAccount();

        @Override
        public void run() {
            for(int x = 0; x < 10; x++){
                makeWithdrawal(10);
                if(bankAccount.getBalance() < 0){
                    System.out.println("Overdrawn!");
                }
            }
        }

        private synchronized void makeWithdrawal(int amount) {
            if(bankAccount.getBalance() >= amount){
                System.out.println(Thread.currentThread().getName() + " is about to withdraw");
                try{
                    System.out.println(Thread.currentThread().getName() + " is going to sleep");
                    Thread.sleep(500);
                }catch(InterruptedException e){ e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + " woke up");
                bankAccount.withdraw(amount);
                System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
            }else{
                System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
            }
        }
    }
}
