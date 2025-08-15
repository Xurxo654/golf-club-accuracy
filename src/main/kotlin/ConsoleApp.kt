class ConsoleApp {
    fun run() {
        println("Welcome to Golf Club Accuracy\nEnter Command:")
        parseCommand()
    }

    private fun parseCommand() {
        val command = readlnOrNull() ?: return
        when (command) {
            "quit" -> println("Exiting Application")
            else -> System.err.println("Invalid command: $command")
        }
    }
}