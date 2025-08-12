data class Shot(val club: Club,val result: ShotResult)

enum class Club(name: String) {
    DR("Driver"),
    THREE_WOOD("3 Wood"),
    FIVE_WOOD("5 Wood"),
    SEVEN_WOOD("7 Wood"),
    TWO_IRON("2 iron"),
    THREE_IRON("3 iron"),
    FOUR_IRON("4 iron"),
    FIVE_IRON("5 iron"),
    SIX_IRON("6 iron"),
    SEVEN_IRON("7 iron"),
    EIGHT_IRON("8 iron"),
    NINE_IRON("9 iron"),
    PITCHING_WEDGE("Pitching wedge"),
    GAP_WEDGE("Gap wedge"),
    SAND_WEDGE("Sand wedge"),
    LOB_WEDGE("Lob wedge")
}

enum class ShotResult(name: String) {
    LONG("Long"),
    LONG_LEFT("Long Left"),
    LONG_RIGHT("Long Right"),
    LEFT("Left"),
    RIGHT("Right"),
    ON_TARGET("On target"),
    SHORT("Short"),
    SHORT_LEFT("Short left"),
    SHORT_RIGHT("Short right")
}