package topic.graph;

public class Pair {
    int weight;
    String path;

    public Pair() {
    }

    public Pair(int weight, String path) {
        this.weight = weight;
        this.path = path;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
