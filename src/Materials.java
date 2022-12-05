public class Materials {

    private String type;
    private String description;
    private int weight;
    private int quality;

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int getQuality() {
        return quality;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", quality=" + quality +
                '}';
    }
}
