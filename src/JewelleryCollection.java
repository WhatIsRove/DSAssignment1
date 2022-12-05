public class JewelleryCollection{
    public DisplayCase head = null;

    private int caseUID = 0;

    public void addDisplayCase(String dType, boolean lighting) {
        DisplayCase dc = new DisplayCase();
        caseUID ++;
        dc.setID(caseUID);
        dc.setDisplayType(dType);
        dc.setLighting(lighting);

        if (head == null) {
            head = dc;
        } else {
            DisplayCase temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = dc;
        }
    }

    public DisplayCase getFirstDisplayCase() {
        return head;
    }

    public DisplayCase getLastDisplayCase() {
        if (head == null) {
            return null;
        } else {
            DisplayCase temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public DisplayCase getDisplayCaseWithID(int i) {
        if (head == null) {
            return null;
        } else {
            DisplayCase temp = head;
            while (temp.next != null && temp.getID() != i) {
                temp = temp.next;
            }
            if (temp.getID() == i) {
                return temp;
            } else return null;
        }
    }

    public void removeCaseWithID(int i) {
        if (head != null) {
            DisplayCase temp = head;
            if (temp.getID() == i) {
                head = temp.next;
            } else {
                while (temp.next != null && temp.next.getID() != i) {
                    temp = temp.next;
                }
                if (temp.next.getID() == i) {
                    temp.next = temp.next.next;
                }
            }
        }
    }

    public void setCaseUID(int caseUID) {
        this.caseUID = caseUID;
    }

    public void clearCollection() {
        head=null;
    }
}
