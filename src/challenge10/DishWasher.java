package challenge10;

public class DishWasher {

    private boolean hasWorkToDo;

    public boolean isHasWorkToDo() { return hasWorkToDo; }
    public void setHasWorkToDo(boolean hasWorkToDo) { this.hasWorkToDo = hasWorkToDo; }

    public void doDishes() {
        if (hasWorkToDo) {
            System.out.println("DishWasher: washing dishes...");
            hasWorkToDo = false;
        }
    }
}
