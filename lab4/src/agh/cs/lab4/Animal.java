package agh.cs.lab4;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal
{
    private MapDirection orientation = MapDirection.NORTH; //okresla poczatkowa orientacje zwierzecia jako NORTH
    private Vector2d position = new Vector2d(2,2); //poczatkowe polozenie zwierzecia na mapie
    //zdefiniowanie pol jako PRYWATNE!
    private IWorldMap;

    public Animal()
    {
        super();
    }

    public Animal(IWorldMap map)
    //konstruktor
    {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    //konstruktor, ktory dodatkowo okresla poczatkowe polozenie zwierzecia na mapie
    {
        this.position = initialPosition;
        this.map = map;
    }

    public void move(MoveDirection direction)
    {
        Vector2d temporaryPosition = this.position;

        switch (direction)
        {
            case FORWARD:
                temporaryPosition = temporaryPosition.add(this.orientation.toUnitVector());
                break;
            case BACKWARD:
                temporaryPosition = temporaryPosition.add(this.orientation.toUnitVector().opposite());
                break;
            case LEFT:
                orientation = this.orientation.previous();
                break;
            case RIGHT:
                orientation = this.orientation.next();
                break;
        }

        if((map != null && map.canMoveTo(temporaryPosition))) 
        //odwolanie do mapy i sprawdzenie, czy zwierze moze sie przesunac na dana pozycje
        {
            this.position = temporaryPosition;
        }
//      else if(map == null &&  (temporaryPosition.x >=0 && temporaryPosition.x <= 4 && temporaryPosition.y >= 0 && temporaryPosition.y <= 4))
//      {this.position = temporaryPosition;}
        //sprawdzenie, czy nie wyjachalam zwierzeciem poza mape i ewentualny powrot do pozycji poczatkowej
    }

    public MapDirection getOrientation()
    {
        return this.orientation;
    }

    public Vector2d getPosition()
        //zwraca pozycje zwierzecia
    {
        return this.position;
    }

    @Override
    public String toString()
    //zwraca schematyczną orientację zwierzęcia
    {
        String s = this.orientation.name();
        return s.charAt(0)+"";
    }
}
