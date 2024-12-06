package pl.helenium.aoc24.util.board

typealias Direction = Cell

class Directions {
    @Suppress("MemberVisibilityCanBePrivate")
    companion object {
        val UP = Direction(-1, 0)
        val UP_RIGHT = Direction(-1, 1)
        val RIGHT = Direction(0, 1)
        val DOWN_RIGHT = Direction(1, 1)
        val DOWN = Direction(1, 0)
        val DOWN_LEFT = Direction(1, -1)
        val LEFT = Direction(0, -1)
        val UP_LEFT = Direction(-1, -1)
        val ALL_DIRECTIONS = sequenceOf(UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT, UP_LEFT)
    }
}
