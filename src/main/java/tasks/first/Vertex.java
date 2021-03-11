package tasks.first;

public class Vertex {
    private final int index;
    private boolean isVisited;

    public Vertex(int index) {
        this.index = index;
        this.isVisited = false;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getIndex() {
        return index;
    }
}