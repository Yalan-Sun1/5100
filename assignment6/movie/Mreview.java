package assignment6.movie;

import java.util.ArrayList;

public class Mreview implements Comparable {

    private String title;
    private ArrayList<Integer> ratings;
//3 constructors
    public Mreview() {
        this.title="";
        ratings=new ArrayList<>();
    }

    public Mreview(String ttl) {

        this.title = ttl;
        ratings=new ArrayList<>();
    }

    public Mreview(String ttl, int firstRating) {
        this.title = ttl;
        ratings.add(firstRating);
    }
    // 7 methods
    public String getTitle(){

        return title;
    }
    public void addRating(int r){

        ratings.add(r);
    }
    public double aveRating(){
//        double totalRatings=0;
//        int i=0;
//        for(double i = 0,i<=ratings.size(),i++) {
//            totalRatings += ratings.get(i);
//        }
//        return totalRatings/ratings.size();
        return this.ratings.stream().mapToDouble((s)->s).sum()/this.ratings.size();
    }
    public int numRatings(){

        return ratings.size();
    }

    @Override
    public int compareTo(Mreview obj) {

        return title.compareTo(obj.title);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString(){
       return title+", average "+aveRating()+ " out of "+ratings.size()+" ratings";
    }

}
