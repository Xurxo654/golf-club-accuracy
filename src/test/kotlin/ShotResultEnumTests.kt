import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ShotResultEnumTests {
    @Test
    fun `ofResultName should find shot result enum if it exists`() {
        val actual = ShotResult.ofResultName("Long")
        assertEquals(ShotResult.LONG, actual)
    }

    @Test
    fun `ofResultName should return null if it doesn't exist`() {
        assertNull(ShotResult.ofResultName("Nothing"))
    }
}