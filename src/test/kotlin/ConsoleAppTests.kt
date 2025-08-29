import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExtendWith(ConsoleTestExtension::class)
class ConsoleAppTests {

    @Test
    fun `console app prompts for command when started`(console: ConsoleCapture) {
        ConsoleApp().run()
        assertTrue(console.getOutput().contains("Welcome to Golf Club Accuracy"))
        assertTrue(console.getOutput().contains("Enter Command:"))
    }

    @Test
    fun `console app should accept quit command`(console: ConsoleCapture) {
        console.setInput("quit\n")
        ConsoleApp().run()
        assertTrue(console.getOutput().contains("Exiting Application"))
    }

    @Test
    fun `console app should handle invalid command`(console: ConsoleCapture) {
        console.setInput("invalid command\n")
        ConsoleApp().run()
        assertTrue(console.getError().contains("Invalid command: invalid command"))
    }

    @Test
    fun `console app should have add shot command`(console: ConsoleCapture) {
        console.setInput("shoot\n")
        ConsoleApp().run()
        assertTrue(console.getOutput().contains("Shot added"))
    }

    @Test
    fun `add shot command should request club data`(console: ConsoleCapture) {
        console.setInput("shoot\n")
        ConsoleApp().run()
        assertTrue(console.getOutput().contains("Select Club:"))
    }

    @Test
    fun `add shot command should request result data`(console: ConsoleCapture) {
        console.setInput("shoot\nDriver\n")
        ConsoleApp().run()
        assertTrue(console.getOutput().contains("Select Club:"))
        assertTrue(console.getOutput().contains("Select Result:"))
    }

    @Test
    fun `add shot command should complete successfully`(console: ConsoleCapture) {
        console.setInput("shoot\n3 wood\nOn target\n")
        ConsoleApp().run()
        assertTrue(console.getOutput().contains("Select Club:"))
        assertTrue(console.getOutput().contains("Select Result:"))
        assertTrue(console.getOutput().contains("Shot added"))
    }

    @Test
    fun `add shot should error on invalid club`(console: ConsoleCapture) {
        console.setInput("shoot\n10w\n3 wood")
        ConsoleApp().run()
        assertTrue(console.getError().contains("Invalid club: 10w"))
    }

    @Test
    fun `add shot command should request club again after invalid club`(console: ConsoleCapture) {
        console.setInput("shoot\n10 wood\n3 wood")
        ConsoleApp().run()
        val selectClubCount = console.getOutput().split("Select Club:").size - 1
        assertEquals(selectClubCount, 2)
    }

    @Test
    fun `add shot should error on invalid result`(console: ConsoleCapture) {
        console.setInput("shoot\nDriver\nRight Left\nOn target")
        ConsoleApp().run()
        assertTrue(console.getError().contains("Invalid result: Right Left"))
    }

    @Test
    fun `add shot command should request result again after invalid result`(console: ConsoleCapture) {
        console.setInput("shoot\n3 wood\nRight Left\nOn target")
        ConsoleApp().run()
        val selectClubCount = console.getOutput().split("Select Result:").size - 1
        assertEquals(selectClubCount, 2)
    }

    @Test
    fun `should prompt for new command after shot added`(console: ConsoleCapture) {
        console.setInput("shoot\n3 wood\nOn target\nquit\n")
        ConsoleApp().run()
        val enterCommandCount = console.getOutput().split("Enter command:").size - 1
        assertEquals(2, enterCommandCount)
    }
}