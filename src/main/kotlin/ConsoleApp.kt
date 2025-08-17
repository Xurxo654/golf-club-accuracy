class ConsoleApp {
    fun run() {
        println("Welcome to Golf Club Accuracy\nEnter Command:")
        parseCommand()
    }

    private fun parseCommand() {
        val command = readlnOrNull() ?: return
        when (command) {
            "quit" -> println("Exiting Application")
            "shoot" -> addShot()
            else -> System.err.println("Invalid command: $command")
        }
    }

    private fun addShot() {
        while (true) {
            println("Select Club:")
            val clubInput = readlnOrNull() ?: continue
            val club = Club.ofClubName(clubInput)
            if (club == null) {
                System.err.println("Invalid club: $clubInput")
                continue
            } else {
                break
            }
        }
        while (true) {
            println("Select Result:")
            val resultInput = readlnOrNull() ?: continue
            val result = ShotResult.ofResultName(resultInput)
            if (result == null) {
                System.err.println("Invalid result: $resultInput")
                continue
            } else {
                break
            }
        }
        println("Shot added")
    }
}