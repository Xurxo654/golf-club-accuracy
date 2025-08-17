import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

class ConsoleTestExtension : BeforeEachCallback, AfterEachCallback, ParameterResolver {
    private lateinit var originalIn: InputStream
    private lateinit var originalErr: PrintStream
    private lateinit var originalOut: PrintStream

    private val outputCapture = ByteArrayOutputStream()
    private val errorCapture = ByteArrayOutputStream()
    private var inputText: String = ""

    override fun beforeEach(context: ExtensionContext?) {
        originalIn = System.`in`
        originalOut = System.out
        originalErr = System.err

        System.setOut(PrintStream(outputCapture))
        System.setErr(PrintStream(errorCapture))

        if (inputText.isNotEmpty()) {
            System.setIn(ByteArrayInputStream(inputText.toByteArray()))
        }
    }

    override fun afterEach(context: ExtensionContext?) {
        System.setIn(originalIn)
        System.setErr(originalErr)
        System.setOut(originalOut)

        outputCapture.reset()
        errorCapture.reset()
        inputText = ""
    }

    override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Boolean {
        return parameterContext.parameter.type == ConsoleCapture::class.java
    }

    override fun resolveParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Any {
        return ConsoleCapture(outputCapture, errorCapture) { input ->
            inputText = input
            System.setIn(ByteArrayInputStream(input.toByteArray()))
        }
    }
}

data class ConsoleCapture(
    private val outputStream: ByteArrayOutputStream,
    private val errorStream: ByteArrayOutputStream,
    private val inputSetter: (String) -> Unit
) {
    fun getOutput(): String = outputStream.toString()
    fun getError(): String = errorStream.toString()
    fun setInput(input: String) = inputSetter(input)
    fun clearOutput() = outputStream.reset()
    fun clearError() = errorStream.reset()
}