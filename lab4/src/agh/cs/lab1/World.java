package agh.cs.lab1;

import static java.lang.System.out;
import java.util.Scanner;

enum Direction {FORWARD, BACKWARD, RIGHT, LEFT}

public class World
{
    public static Direction[] toEnum(String gdzie)
    {
        int howlong=gdzie.length();
        int counter=0; char value;
        for(int i=0; i<howlong; i++)
        {
            value=gdzie.charAt(i);
            if(value=='f'||value=='b'||value=='r'||value=='l') counter++;
        }
        Direction[] array=new Direction[counter];
        int index=0;
        for(int i=0; i<howlong; i++)
        {
            value = gdzie.charAt(i);
            switch (value)
            {
                case 'f':
                    array[index] = Direction.FORWARD;
                    index++;
                    break;
                case 'b':
                    array[index] = Direction.BACKWARD;
                    index++;
                    break;
                case 'r':
                    array[index] = Direction.RIGHT;
                    index++;
                    break;
                case 'l':
                    array[index] = Direction.LEFT;
                    index++;
                    break;
                default :
                    break;
            }
        }
        return array;
    }

    public static void run(Direction[] array)
    {
        int j=array.length;
        for(int i=0; i<j; i++)
        {
            if(array[i]==Direction.FORWARD) out.println("Zwierzak idzie do przodu");
            if(array[i]==Direction.BACKWARD) out.println("Zwierzak idzie do tylu");
            if(array[i]==Direction.LEFT) out.println("Zwierzak skreca w lewo");
            if(array[i]==Direction.RIGHT) out.println("Zwierzak skreca w prawo");
        }
    }

    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        out.println("Start");
        String wpisz=scan.nextLine();
        Direction[] array=toEnum(wpisz);
        run(array);
        out.println("Stop");
    }
}