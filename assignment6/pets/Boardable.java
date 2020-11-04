package assignment6.pets;

public interface Boardable {
    public abstract void setBoardStart(int month, int day, int year);
    public abstract void setBoardEnd(int month, int day, int year);
    public abstract boolean boarding(int month, int day, int year);
}
