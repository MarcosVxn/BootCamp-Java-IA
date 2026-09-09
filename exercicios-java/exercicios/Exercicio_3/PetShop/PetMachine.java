package PetShop;

public class PetMachine {

    private boolean clean = true;

    public int water = 30;

    public int shampoo = 10;

    private PetShop petShop;



    public void takeAShower(){
        if(this.petShop == null){
            System.out.println("Coloque o Pet na maquina para iniciar o banho");
            return;
        }

        this.shampoo -=2;
        this.water -= 10;
        petShop.setClean(true);
        System.out.println("O pet " + petShop.getName() + " está limpo");

    }

    // Essa função ira adicionar Água
    public void addWater(){
        if(water == 30){
            System.out.println("A capacidade de água da máquina está no máximo");
            return;
        }

        water += 2;
    }

    // Essa função ira adicionar Shampoo
    public void addShampoo(){
        if(shampoo == 10){
            System.out.println("A capacidade de shampoo da máquina está no máximo");
            return;
        }

        shampoo += 2;
    }

    // Aqui iremos verificar a quantidade de Água com base no return
    public int getWater(){
        return water;
    }

    // Aqui iremos verificar a quantidade de Shampoo com base no return
    public int getShampoo(){
        return shampoo;
    }


    public boolean hasPet(){
        return petShop != null;
    }


    public void setPet(PetShop get){
        if (!this.clean){
            System.out.println("A máquina está suja. para colocar o pet é necessário limpa-la");
            return;
        }
        if(hasPet()){
            System.out.println("O pet " + this.petShop.getName() + " está na máquina nesse momento");
            return;
        }
        this.petShop = get;
    }


    public void removePet(){
        this.clean = this.petShop.isClean();


        System.out.println("O pet "+ this.petShop.getName() + " está limpo");
        this.petShop = null;
    }


    public void  wash(){
        this.water -= 10;
        this.shampoo -= 10;
        this.clean = true;

        System.out.println("A máquina está limpa");
    }



}


