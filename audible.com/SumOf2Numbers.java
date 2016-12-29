static class Index {
        int index;
        int value;

        public Index(int index, int value) {
            this.index = index;
            this.value = value;
        }
        public int hashCode() {
            int code = 1;
            code = code*37 + index;
            code = code*37 + value;
            return code;
        }

        public boolean equals(Object other) {
            if (!(other instanceof Index))
                return false;

            Index rhs = (Index)other;
            return this.index == rhs.index && this.value == rhs.value;
        }
    }
    static int numberOfPairs(int[] a, long k) {
        Set<Integer> usedIndices = new HashSet<>();
        Map<Integer, Integer> indices = new HashMap<>();
        // Map<Integer, Index> indices = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            indices.put(a[i], i);
        }
        for (int i = 0; i < a.length; i++) {
            int complement = (int)(k - a[i]);
            Integer index = indices.get(complement);
            if (index != null && index != i) {
                // System.out.println("i: " + i + ", index: " + index);
                int pre = usedIndices.size();
                usedIndices.add(i);
                usedIndices.add(index);
                /*
                Index one = new Index(i, a[i]);
                usedIndices.add(one);
                Index two = new Index(index, a[index]);
                usedIndices.add(two);
                */
                // System.out.println("added " + a[i] + " and " + a[index] + ", pre-size: " + pre + ", post-size: " + usedIndices.size());
            }
        }
        return usedIndices.size() / 2;
    }
