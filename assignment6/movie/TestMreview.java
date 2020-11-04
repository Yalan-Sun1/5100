package assignment6.movie;


public class TestMreview {

    public static void main(String[] args) {

        Mreview movie=new Mreview("Kill Bill");
        movie.addRating(3);
        movie.addRating(4);
        movie.addRating(3);
        System.out.println(movie.toString()+"\n");
        System.out.println("Average Rating is " + movie.aveRating());


    }
}
