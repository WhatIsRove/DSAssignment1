public class DisplayCase{

    public DisplayCase next=null;
    public DisplayTray head=null;
    private int trayUID = 0;

    private int id;
    private String displayType;
    private boolean isLit;

    public int getID() {
        return this.id;
    }

    public String getDisplayType() {
        return displayType;
    }

    public boolean isLit() {
        return isLit;
    }

    public void setID(int i) {
        this.id = i;
    }

    public void setDisplayType(String st) {
        if (st!=null) {
            this.displayType = st;
        }
    }

    public void setLighting(boolean lit) {
        this.isLit = lit;
    }

    public void addDisplayTray(String color, String dimensions) {
        DisplayTray dt = new DisplayTray();
        trayUID++;
        dt.setTrayID(trayUID);
        dt.setInlayColor(color);
        dt.setTrayDimensions(dimensions);

        if (head == null) {
            head = dt;
        } else {
            DisplayTray temp = head;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = dt;
        }
    }

    public DisplayTray getFirstDisplayTray() {
        return head;
    }

    public DisplayTray getLastDisplayTray() {
        if (head == null) {
            return null;
        } else {
            DisplayTray temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public void setTrayUID(int trayUID) {
        this.trayUID = trayUID;
    }

    public void clearDisplayTrays() {
        head = null;
    }

    public DisplayTray getDisplayTrayWithID(int i) {
        if (head == null) {
            return null;
        } else {
            DisplayTray temp = head;
            while (temp.next != null && temp.getTrayID() != i) {
                temp = temp.next;
            }
            if (temp.getTrayID() == i) {
                return temp;
            } else return null;
        }
    }

    public String toString() {
        return id +" "+ displayType +" "+ isLit;
    }

}
