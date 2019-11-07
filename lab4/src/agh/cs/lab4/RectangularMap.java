package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.ArrayList;
import java.util.List;

//OptionsParser.java (lab3): mapa

public class RectangularMap implements IWorldMap
//klasa RectangularMap implementuje interfejs IWorldMap
//definicja prostokatnej mapy
{
    public final int width; //szerokosc mapy
    public final int height; //wysokosc mapy
    
    protected MapVisualizer mapVisualizer=new MapVisualizer(this);

    private List<Animal> animals = new ArrayList<>(); //lista zwierzat
    //umozliwia wystepowanie wiecej niez jednego zwierzecia na mapie

    public RectangularMap(int width, int height)
    //konstruktor
    {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString()
    //rysuje aktualna konfiguracje mapy przy pomocy MapVisualizer
    {
        return mapVisualizer.draw(getLowerLeft(), getUpperRight());
    }
    
    @Override
    public boolean isOccupied(Vector2d position)
    //czy jakies zwierze jest juz na tej pozycji
    {
      return (objectAt(position)!=null);
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0, 0)) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal)
    {
        if(canMoveTo(animal.getPosition()))
        {
            animals.add(animal);
            return true;
        } else {return false;}
    }

    @Override
    public void run(MoveDirection[] directions)
    {
        for(int i = 0; i < directions.length; i++)
        {
            animals.get(i%animals.size()).move(directions[i]);
        }
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        return animals.stream().filter(animal -> position.equals(animal.getPosition())).findAny().orElse(null);
    }

    @Override
    public Vector2d getUpperRight()
    {
        return new Vector2d(width, height);
    }

    @Override
    public Vector2d getLowerLeft()
    {
        return new Vector2d(0,0);
    }
}
