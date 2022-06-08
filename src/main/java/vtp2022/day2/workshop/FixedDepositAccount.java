package vtp2022.day2.workshop;

    public class FixedDepositAccount extends BankAccount {
        private float interest = 3;
        private int interestCounter = 0;
        private int duration = 6;
        private int durationCounter = 0;

        public FixedDepositAccount(String name, float initialAmount) {
            super(name, initialAmount);   
        }

        public FixedDepositAccount(String name, float initialAmount, float interest) {
            super(name, initialAmount);
            this.interest = interest;
        }

        public FixedDepositAccount(String name, float initialAmount, float interest, int duration) {
            super(name, initialAmount);
            this.interest = interest;
            this.duration = duration;
        }

        @Override
        public float withdraw(String withdrawAmt) {
            //NOP
            return 0;
        }

        @Override
        public void deposit(String depositAmt) {
            //NOP
            //return 0;
        }

        @Override
        public float getBalance() {
            return super.getBalance() + interest;
        }

        public void setDuration (int duration) {
            if (durationCounter > 0)
                throw new IllegalArgumentException("Can change duration only once.");
            this.duration = duration;
            durationCounter++;
        }

        public int getDuration() {
            return this.duration;
        }

        public void setInterest (float interest) {
            if (interestCounter > 0)
                throw new IllegalArgumentException("Can change interest only once");
            this.interest = interest;
            interestCounter++;
        }

        @Override
        public float getInterest() {
            return this.interest;
        }
    }
