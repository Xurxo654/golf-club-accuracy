import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertTrue


class ConsoleAppTests {

    @Test
    fun `console app prompts for command when started`() {
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out

        try {
            System.setOut(PrintStream(outputStream))

            val app = ConsoleApp()
            app.run()

            val output = outputStream.toString()

            assertTrue(output.contains("Welcome to Golf Club Accuracy"))
            assertTrue(output.contains("Enter Command:"))

        } finally {
            System.setOut(originalOut)
        }
    }

    @Test
    fun `console app should accept quit command`() {
        val input = "quit\n"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val originalIn = System.`in`

        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out

        try {
            System.setIn(inputStream)
            System.setOut(PrintStream(outputStream))

            val app = ConsoleApp()
            app.run()

            val output = outputStream.toString()

            assertTrue(output.contains("Exiting Application"))

        } finally {
            System.setIn(originalIn)
            System.setOut(originalOut)
        }
    }

    @Test
    fun `console app should handle invalid command`() {
        val input = "dne\n"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val originalIn = System.`in`

        val errorStream = ByteArrayOutputStream()
        val originalErr = System.err

        try {
            System.setIn(inputStream)
            System.setErr(PrintStream(errorStream))

            val app = ConsoleApp()
            app.run()

            val output = errorStream.toString()

            assertTrue(output.contains("Invalid command: dne"))

        } finally {
            System.setIn(originalIn)
            System.setErr(originalErr)
        }
    }

    @Test
    fun `console app should have add shot command`() {
        val input = "shoot\n"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val originalIn = System.`in`

        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out

        try {
            System.setIn(inputStream)
            System.setOut(PrintStream(outputStream))

            val app = ConsoleApp()
            app.run()

            val output = outputStream.toString()

            assertTrue(output.contains("Shot added"))

        } finally {
            System.setIn(originalIn)
            System.setOut(originalOut)
        }
    }

    @Test
    fun `console app add shot command should request data`() {
        val input = "shoot\n"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val originalIn = System.`in`

        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out

        try {
            System.setIn(inputStream)
            System.setOut(PrintStream(outputStream))

            val app = ConsoleApp()
            app.run()

            val output = outputStream.toString()

            assertTrue(output.contains("Shot added"))

        } finally {
            System.setIn(originalIn)
            System.setOut(originalOut)
        }
    }

    @Test
    fun `console app add shot should error on invalid club`() {
        val input = "dne\n10w"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val originalIn = System.`in`

        val errorStream = ByteArrayOutputStream()
        val originalErr = System.err

        try {
            System.setIn(inputStream)
            System.setErr(PrintStream(errorStream))

            val app = ConsoleApp()
            app.run()

            val output = errorStream.toString()

            assertTrue(output.contains("Invalid club: 10w"))

        } finally {
            System.setIn(originalIn)
            System.setErr(originalErr)
        }
    }

}