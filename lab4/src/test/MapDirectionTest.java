package test;

import org.junit.Assert;
import org.testng.annotations.Test;
import agh.cs.lab2.*;

public class MapDirectionTest
{
    @Test
    public void next()
    {
        Assert.assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        Assert.assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        Assert.assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
    }

    @Test
    public void previous()
    {
        Assert.assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        Assert.assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        Assert.assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
    }
}