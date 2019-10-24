package agh.cs.lab2;

public class Vector2d
{
    public final int x;
    public final int y;

    public Vector2d(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public String toString() //nadpisanie istniejącej już metody
    {
        return "("+this.x+", "+this.y+")";
    }

    public boolean precedes(Vector2d other)
    {
        return (this.x <= other.x && this.y <= other.y);
    }

    public boolean follows(Vector2d other)
    {
        return (this.x >= other.x && this. y >= other.y);
    }

    public Vector2d upperRight(Vector2d other)
    {
        int newX, newY;
        if(this.x >= other.x) newX=this.x;
        else newX=other.x;
        if(this.y >= other.y) newY=this.y;
        else newY=other.y;
        return new Vector2d(newX, newY);
    }

    public Vector2d lowerLeft(Vector2d other)
    {
        int newX, newY;
        if(this.x <= other.x) newX=this.x;
        else newX=other.x;
        if(this.y <= other.y) newY=this.y;
        else newY=other.y;
        return new Vector2d(newX, newY);
    }

    public Vector2d add(Vector2d other)
    {
        int newX=(this.x)+(other.x);
        int newY=(this.y)+(other.y);
        return new Vector2d(newX, newY);
    }

    public Vector2d subtract(Vector2d other)
    {
        int newX=(this.x)-(other.x);
        int newY=(this.y)-(other.y);
        return new Vector2d(newX, newY);
    }

    public boolean equals(Object other) // OBJECT!!!
    {
        if(other == null) return false;
        if(this == other) return true; // jeżeli są dwoma wskazaniami na to samo
        if(!(other instanceof Vector2d)) return false; // jeżeli other nie jest wektorem
        // tutaj wiem, że other jest wektorem, ale mają oddzielne adresy w pamięci
        Vector2d that = (Vector2d) other; // JAWNE rzutowanie
        // chociaż other i tak był wektorem, skoro doszliśmy do tego miejsca
        return ((this.x == that.x) && (this.y == that.y));
    }

    public Vector2d opposite()
    {
        return new Vector2d((this.x)*(-1), (this.y)*(-1));
    }
}
