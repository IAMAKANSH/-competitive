package topic.graph;

public class Edge {
    private int src;
    private int nbr;
    private int weight;

    public Edge(int src, int des, int weight) {
        this.src = src;
        this.nbr = des;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
