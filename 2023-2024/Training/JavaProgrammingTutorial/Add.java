interface Operation {
    int perform(int x, int y);
}

// Complete the classes below by implementing the Operation interface and providing your own implementation of the perform method.
public class Add implements Operation {
    @Override
    public int perform(int x, int y) {
        return x + y;
    }
}

class Subtract implements Operation {
    @Override
    public int perform(int x, int y) {
        return Math.abs(y - x);
    }
}

class Divide implements Operation {
    @Override
    public int perform(int x, int y) {
        if( y == 0 )
            return - 1;
        return x/y;
    }
}