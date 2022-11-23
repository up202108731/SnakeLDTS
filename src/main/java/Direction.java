public class Direction {
    private String direction_;

    public Direction(String direction) {
        direction_ = direction;
    }

    public String getDirection() {
        return direction_;
    }

    public void setDirection(String direction) {
        direction_ = direction;
    }

    public boolean inverse(String initialDirection, String finalDirection) {
        if (initialDirection.equals("Right") && finalDirection.equals("Left")) {return false;}
        if (initialDirection.equals("Left") && finalDirection.equals("Right")) {return false;}
        if (initialDirection.equals("Up") && finalDirection.equals("Down")) {return false;}
        if (initialDirection.equals("Down") && finalDirection.equals("Up")) {return false;}
        return true;
    }
}
