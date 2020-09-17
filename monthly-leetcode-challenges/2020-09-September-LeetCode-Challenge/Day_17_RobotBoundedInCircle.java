class Solution {
    public boolean isRobotBounded(String instructions) {
        var robot = new RobotInfo(0, 0, 0);

        int minY = 0, minX = 0, maxY = 0, maxX = 0;
        var instructionArray = instructions.toCharArray();

        for (int i = 0; i < 4; i++) {
            for (var instruction : instructionArray) {
                robot = executeInstruction(robot, instruction);

                minY = Math.min(minY, robot.y);
                minX = Math.min(minX, robot.x);
                maxY = Math.min(maxY, robot.y);
                maxX = Math.min(maxX, robot.x);
            }
        }

        int minY2 = robot.y, maxY2 = robot.y, minX2 = robot.x, maxX2 = robot.x;

        for (int i = 0; i < 4; i++) {
            for (var instruction : instructionArray) {
                robot = executeInstruction(robot, instruction);

                minY2 = Math.min(minY2, robot.y);
                minX2 = Math.min(minX2, robot.x);
                maxY2 = Math.min(maxY2, robot.y);
                maxX2 = Math.min(maxX2, robot.x);
            }
        }

        return minY == minY2 &&
            minX == minX2 &&
            maxY == maxY2 &&
            maxX == maxX2;
    }

    private RobotInfo executeInstruction(RobotInfo info, char instruction) {
        return switch (instruction) {
                case 'G' -> switch (info.dir) {
                        case 0 -> new RobotInfo(info.dir, info.y + 1, info.x);
                        case 1 -> new RobotInfo(info.dir, info.y, info.x + 1);
                        case 2 -> new RobotInfo(info.dir, info.y - 1, info.x);
                        case 3 -> new RobotInfo(info.dir, info.y, info.x - 1);
                        default -> info;
                };
                case 'L', 'R' -> new RobotInfo(getNewDirection(info.dir, instruction), info.y, info.x);
                default -> info;
        };
    }

    private int getNewDirection(int dir, char instruction) {
        return switch (dir) {
            case 0 -> instruction == 'L' ? 3 : 1;
            case 1 -> instruction == 'L' ? 0 : 2;
            case 2 -> instruction == 'L' ? 1 : 3;
            case 3 -> instruction == 'L' ? 2 : 0;
            default -> dir;
        };
    }
}

class RobotInfo {
    int dir;
    int y;
    int x;

    RobotInfo(int dir, int y, int x) {
        this.dir = dir;
        this.y = y;
        this.x = x;
    }
}
