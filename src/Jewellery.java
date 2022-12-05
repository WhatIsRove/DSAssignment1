public class Jewellery {

    public Jewellery next = null;

    private int jewelID;
    private String desc;
    private String jType;
    private String gender;
    private String price;
    private Materials mats = new Materials();

    public int getJewelID() {
        return jewelID;
    }

    public String getDescription() {
        return desc;
    }

    public String getJType() {
        return jType;
    }

    public String getGender() {
        return gender;
    }

    public String getPrice() {
        return price;
    }

    public Materials getMats() {
        return mats;
    }

    public void setJewelID(int i) {
        this.jewelID = i;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public void setJType(String jType) {
        this.jType = jType;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPrice(String p) {
        this.price = p;
    }

    public void setMaterials(String type, String description, int weight, int quality) {
        mats.setType(type);
        mats.setDescription(description);
        mats.setWeight(weight);
        mats.setQuality(quality);
    }

    @Override
    public String toString() {
        return "Jewellery{" +
                "jewelID=" + jewelID +
                ", desc='" + desc + '\'' +
                ", jType='" + jType + '\'' +
                ", gender='" + gender + '\'' +
                ", price=" + price +
                ", Materials=" + mats +
                '}';
    }
}
