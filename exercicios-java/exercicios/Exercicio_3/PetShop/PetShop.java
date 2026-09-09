package PetShop;

public class PetShop {
    private final String name;

    private boolean clean;

    public PetShop(String name) {
        this.name = name;
        this.clean = false;
    }

    public String getName() {
        return name;
    }

    public boolean isClean(){
        return clean;
    }

    public void setClean(boolean clean){
        this.clean = clean;
    }


}
