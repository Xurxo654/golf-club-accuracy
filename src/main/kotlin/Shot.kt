data class Shot(val club: Club,val result: ShotResult)

enum class Club( val clubName: String) {
    DR("Driver"),
    THREE_WOOD("3 wood"),
    FIVE_WOOD("5 wood"),
    SEVEN_WOOD("7 wood"),
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
    LOB_WEDGE("Lob wedge");

    companion object {
        infix fun ofClubName(name: String): Club? = entries.find { it.clubName == name }
    }

}

enum class ShotResult(val resultName: String) {
    LONG("Long"),
    LONG_LEFT("Long Left"),
    LONG_RIGHT("Long Right"),
    LEFT("Left"),
    RIGHT("Right"),
    ON_TARGET("On target"),
    SHORT("Short"),
    SHORT_LEFT("Short left"),
    SHORT_RIGHT("Short right");

    companion object {
        infix fun ofResultName(resultName: String): ShotResult? = entries.find { it.resultName == resultName }
    }
}