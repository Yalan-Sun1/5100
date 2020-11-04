package assignment6.pets;

public class Pet {
    private String name;
    private String ownerName;
    private String color;
    protected int sexId;
    public static final int MALE=0;
    public static final int FEMALE=1;
    public static final int SPAYED=2;
    public static final int NEUTERED=3;

    public Pet(String name, String ownerName, String color) {
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }
    public String getPetName(){
        return name;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public String getColor(){
        return color;
    }
    public void setSex(int sexid){
        this.sexId=sexid;
    }
    public String getSex(){
        if (sexId == MALE)

            return "MALE";

        else if (sexId == FEMALE)

            return "FEMALE";

        else if (sexId == SPAYED)

            return "SPAYED";

        else if (sexId == NEUTERED)

            return "NEUTERED";

        else

            return "";
    }
    public String toString(){
        return name+" owned by "+ownerName+"\nColor: "+color+"\nSex: "+getSex();
    }
}
