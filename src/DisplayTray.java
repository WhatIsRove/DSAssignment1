public class DisplayTray {

    public DisplayTray next=null;
    public Jewellery head=null;

    private int trayID;
    private int jID = 0;
    private String inlayColor;
    private String trayDimensions;

    public int getTrayID() {
        return trayID;
    }

    public String getInlayColor() {
        return inlayColor;
    }

    public String getTrayDimensions() {
        return trayDimensions;
    }

    public void setTrayID(int i) {
        this.trayID = i;
    }

    public void setInlayColor(String s) {
        this.inlayColor = s;
    }

    public void setTrayDimensions(String s) {
        this.trayDimensions = s;
    }

    public void addJewellery(String s1, String s2, String s3, String s4){
        Jewellery j = new Jewellery();
        jID++;
        j.setJewelID(jID);
        j.setDescription(s1);
        j.setJType(s2);
        j.setGender(s3);
        j.setPrice(s4);

        if (head == null) {
            head = j;
        } else {
            Jewellery temp = head;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = j;
        }
    }

    public Jewellery getFirstJewelleryItem() {
        return head;
    }

    public Jewellery getLastJewelleryItem() {
        if (head == null) {
            return null;
        } else {
            Jewellery temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public Jewellery getDisplayJewelleryWithID(int i) {
        if (head == null) {
            return null;
        } else {
            Jewellery temp = head;
            while (temp.next != null && temp.getJewelID() != i) {
                temp = temp.next;
            }
            if (temp.getJewelID() == i) {
                return temp;
            } else return null;
        }
    }

    public String toString() {
        return trayID +" "+ inlayColor +" "+ trayDimensions;
    }
}
