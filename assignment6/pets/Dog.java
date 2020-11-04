package assignment6.pets;

public class Dog extends Pet implements Boardable{
    private String size;
    public int startMonth;
    public int startDay;
    public int startYear;
    public int endMonth;
    public int endDay;
    public int endYear;
    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size=size;
    }

    public String getSize() {
        return size;
    }
    public String toString(){
        return "DOG\n"+getPetName()+" owned by "+getOwnerName()+"\nColor: "+getColor()
                +"\nSex: "+getSex()+"\nSize: "+getSize();
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        this.startMonth = month;
        this.startDay = day;
        this.startYear = year;
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        this.endMonth = month;
        this.endDay = day;
        this.endYear = year;
    }

    @Override
    public boolean boarding(int month, int day, int year) {

        if(month>12||month <1||day<1||day>31||year<1000||year>9999)return false;

        if(month ==4||month==6||month ==9||month==11) {
            if (day == 31) return false;
        }
        if(month==2){
            if(year%100!=0){
                if(year%4!=0) {
                    if (day > 28) return false;
                }else if(day>29)return false;

            }else{
                if(year%400==0){
                    if(day>29)return false;
                }else if(day>28)return false;
            }
        }
        if(year<startYear||year>endYear)return false;
        else if((year>startYear&&year<endYear)||(startYear+endYear-2*year>0))return true;
        else if (month<startMonth||month>endMonth)return false;
        else if((month>startMonth&&month<endMonth)||(startMonth+endMonth-2*month>0))return true;
        else if(day<startDay||day>endDay)return false;
        else if((day>startDay&&day<endDay)||(startDay+endDay-2*day>0))return true;

        return true;
    }
}
