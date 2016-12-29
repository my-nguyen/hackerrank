static class Gate implements Comparable<Gate> {
        int time;
        boolean isDepart;

        public Gate(int time, boolean isDepart) {
            this.time = time;
            this.isDepart = isDepart;
        }

        public int compareTo(Gate other) {
            return this.time - other.time;
        }
    }

    static int findMinGates(int[] arrivals, int[] departures, int flights) {
        Gate[] gates = new Gate[arrivals.length * 2];
        for (int i = 0; i < arrivals.length; i++) {
            gates[i] = new Gate(arrivals[i], false);
        }
        int start = arrivals.length;
        for (int i = 0; i < departures.length; i++) {
            gates[start+i] = new Gate(departures[i], true);
        }
        Arrays.sort(gates);
        int max = 0;
        int count = 0;
        for (Gate gate : gates) {
            if (gate.isDepart)
                count--;
            else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }
