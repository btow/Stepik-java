package BasicJava.lesson_3_3;

/**
 * The class contains methods robot.
 * Created by btow on 27.10.2016.
 */
public class Robot {

    private int coordinateX, coordinateY;
    private final int MAX_COORDINATE;
    private Direction direction;

    public Robot (int coordinateX, int coordinateY, Direction direction, final int MAX_COORDINATE) throws IllegalArgumentException {
        this.MAX_COORDINATE = MAX_COORDINATE;
        if (coordinateX <= MAX_COORDINATE & coordinateX > -1) {
            this.coordinateX = coordinateX;
        } else {
            new IllegalArgumentException("The value of the X coordinates must be in the range from 0 to " + MAX_COORDINATE + ".");
        }
        if (coordinateY <= MAX_COORDINATE & coordinateY > -1) {
            this.coordinateY = coordinateY;
        } else {
            new IllegalArgumentException("The value of the Y coordinates must be in the range from 0 to " + MAX_COORDINATE + ".");
        }
        this.direction = direction;
        System.out.println("Robot created with parameters: coordinate X - \" " + this.coordinateX
                + "\", coordinate Y - \" " + this.coordinateY + "\", direction - \" " + this.direction.toString() + "\'");
    }

    public static void main(String[] args) {

        Robot testsRobot = null;

        try {
            testsRobot = new Robot(0, 2, Direction.LEFT, 4);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        int[][] testsValuesXandY = {
                {3, 3},
                {4, 0}
        };

        int indexTest = 0;
        for (int[] testsValueXandY : testsValuesXandY) {
            System.out.println("Begin of the test number " + indexTest);
            System.out.println("to hold the robot on the ground with coordinates X: " + testsValueXandY[0] +
                    " and Y: " + testsValueXandY[1] + ".\n");
            moveRobot(testsRobot, testsValueXandY[0], testsValueXandY[1]);
            System.out.println("The end of test number " + indexTest++ +
            "\n");
        }
    }

    public static void moveRobot(final Robot robot, final int toX, final int toY) {
        // your implementation here
        int stepsToX = toX - robot.getX(), stepsToY = toY - robot.getY();
        Direction movesDirectX = getMovesDirect(stepsToX, 'X');
        Direction movesDirectY = getMovesDirect(stepsToY, 'Y');
        int board;

        try {
            while (robot.getDirection() != movesDirectX) {
                if (stepsToX < 0) {
                    robot.turnLeft();
                } else {
                    robot.turnRight();
                }
            }

            while (robot.getX() != toX) {
                robot.stepForward();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            while (robot.getDirection() != movesDirectY) {
                if (stepsToY < 0) {
                    robot.turnLeft();
                } else {
                    robot.turnRight();
                }
            }

            while (robot.getY() != toY) {
                robot.stepForward();
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }

    public static Direction getMovesDirect(int stepsToGoal, char coordinatesName) throws IllegalArgumentException {

        Direction movesDirect = null;

        if (coordinatesName != 'X' && coordinatesName != 'Y') {
            throw new IllegalArgumentException("Name the coordinates are incorrect. Must be X or Y.");
        }

        switch (coordinatesName) {
            case 'X':
                if (stepsToGoal < 0) {
                    movesDirect = Direction.LEFT;
                } else {
                    movesDirect = Direction.RIGHT;
                }
                break;
            case 'Y':
                if (stepsToGoal < 0) {
                    movesDirect = Direction.DOWN;
                } else {
                    movesDirect = Direction.UP;
                }
                break;
        }

        return movesDirect;
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return direction;
    }

    public int getX() {
        // текущая координата X
        return coordinateX;
    }

    public int getY() {
        // текущая координата Y
        return coordinateY;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        switch (direction) {
            case DOWN:
                direction = Direction.RIGHT;
                System.out.println("Rotated 90 degrees counterclockwise. " + Direction.DOWN.toString() + " -> " + Direction.RIGHT.toString());
                break;
            case LEFT:
                direction = Direction.DOWN;
                System.out.println("Rotated 90 degrees counterclockwise. " + Direction.LEFT.toString() + " -> " + Direction.DOWN.toString());
                break;
            case UP:
                direction = Direction.LEFT;
                System.out.println("Rotated 90 degrees counterclockwise. " + Direction.UP.toString() + " -> " + Direction.LEFT.toString());
                break;
            case RIGHT:
                direction = Direction.UP;
                System.out.println("Rotated 90 degrees counterclockwise. " + Direction.RIGHT.toString() + " -> " + Direction.UP.toString());
                break;
        }
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        switch (direction) {
            case DOWN:
                direction = Direction.LEFT;
                System.out.println("Rotated 90 degrees clockwise. " + Direction.DOWN.toString() + " -> " + Direction.LEFT.toString());
                break;
            case LEFT:
                direction = Direction.UP;
                System.out.println("Rotated 90 degrees clockwise. " + Direction.LEFT.toString() + " -> " + Direction.UP.toString());
                break;
            case UP:
                direction = Direction.RIGHT;
                System.out.println("Rotated 90 degrees clockwise. " + Direction.UP.toString() + " -> " + Direction.RIGHT.toString());
                break;
            case RIGHT:
                direction = Direction.DOWN;
                System.out.println("Rotated 90 degrees clockwise. " + Direction.RIGHT.toString() + " -> " + Direction.DOWN.toString());
                break;
        }
    }

    public void stepForward() throws IllegalArgumentException{
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        switch (direction) {
            case DOWN:
                if (coordinateY > 0) {
                    --coordinateY;
                    System.out.println("Made a step in the direction " + Direction.DOWN.toString() + " coordinate Y -> " + coordinateY);
                } else {
                    new IllegalArgumentException("In the downward direction reached a field boundary");
                }
                break;
            case LEFT:
                if (coordinateX > 0) {
                    --coordinateX;
                    System.out.println("Made a step in the direction " + Direction.LEFT.toString() + " coordinate X -> " + coordinateX);
                } else {
                    new IllegalArgumentException("Towards the left reached the field boundary");
                }
                break;
            case UP:
                if (coordinateY < MAX_COORDINATE) {
                    ++coordinateY;
                    System.out.println("Made a step in the direction " + Direction.UP.toString() + " coordinate Y -> " + coordinateY);
                } else {
                    new IllegalArgumentException("Upward reached a field boundary");
                }
                break;
            case RIGHT:
                if (coordinateX < MAX_COORDINATE) {
                    ++coordinateX;
                    System.out.println("Made a step in the direction " + Direction.RIGHT.toString() + " coordinate X -> " + coordinateX);
                } else {
                    new IllegalArgumentException("Toward the right is reached the field boundary");
                }
                break;
        }
    }
}
