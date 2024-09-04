//Leetcode Problem: 874. Walking Robot Simulation
class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Initialize the direction of the robot
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        
        // Initialize the position of the robot
        int x = 0;
        int y = 0;
        
        // Initialize the maximum distance
        int maxDistance = 0;
        
        // Initialize the obstacles
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + " " + obstacle[1]);
        }
        
        // Iterate through the commands
        for (int command : commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    if (obstacleSet.contains(nextX + " " + nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }
        return maxDistance;
    }
}