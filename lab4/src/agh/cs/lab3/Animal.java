package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

public class Animal
{
    private MapDirection orientation = MapDirection.NORTH; //okresla poczatkowa orientacje zwierzecia jako NORTH
    private Vector2d position = new Vector2d(2,2); //poczatkowe polozenie zwierzecia na mapie
    //zdefiniowanie pol jako PRYWATNE!

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

        if(temporaryPosition.x >=0 && temporaryPosition.x <=4 && temporaryPosition.y >= 0 && temporaryPosition.y <= 4)
        {
            this.position = temporaryPosition;
        } //sprawdzenie, czy nie wyjachalam zwierzeciem poza mape i ewentualny powrot do pozycji poczatkowej
    }

    public MapDirection getOrientation()
    {
        return this.orientation;
    }

    public Vector2d getPosition()
    {
        return this.position;
    }

    @Override
    public String toString() //informacje o polozeniu zwierzecia
    {
        StringBuilder str = new StringBuilder();
        str.append("Orientation: ");
        str.append(this.orientation.name()); //orientacja zwierzecia
        str.append("\nPosition: ");
        str.append(this.position); //pozycja zwierzecia
        return str.toString();
    }
}