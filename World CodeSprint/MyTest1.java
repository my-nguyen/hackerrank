class MyTest1 {
    static class Inner1 {
        private int data;

        public Inner1(int data) {
            this.data = data;
        }

        public String toString() {
            return "" + data;
        }

        public void process() {
            Inner2 in2 = new Inner2("Nguyen");
            System.out.println(in2);
        }
    }

    static class Inner2 {
        private String data;

        public Inner2(String data) {
            this.data = data;
        }

        public String toString() {
            return data;
        }
    }

    public static void main(String[] args) {
        Inner1 in1 = new Inner1(50);
        System.out.println(in1);
        in1.process();        
    }
}
