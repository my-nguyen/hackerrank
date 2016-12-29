static int zombieCluster(String[] zombies) {
        int count = 0;
        int length = zombies.length;
        for (int i = 0; i < length-1; i++) {
            if (zombies[i+1].charAt(i) == '0')
                count++;
        }
        if (zombies[length-1].charAt(length-2) == '0')
            count++;
        return count;
    }
