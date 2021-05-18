package org.grigore;

public enum Direction {
    NORTH {
        @Override
        public Direction previous() {
            return values()[values().length - 1];
        }
    },
    EAST,
    SOUTH,
    WEST {
        @Override
        public Direction next() {
            return values()[0];
        }
    };

    public Direction next() {
        return values()[ordinal() + 1];
    }

    public Direction previous() {
        return values()[ordinal() - 1];
    }

    public static Direction getFromChar(char c) {
        if (c == 'N') {
            return Direction.NORTH;
        } else if (c == 'E') {
            return Direction.EAST;
        } else if (c == 'S') {
            return Direction.SOUTH;
        } else {
            return Direction.WEST;
        }
    }
}
