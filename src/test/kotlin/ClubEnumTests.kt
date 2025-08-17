import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ClubEnumTests {
    @Test
    fun `of should find club enum if it exists`() {
        val actual = Club.ofClubName("Lob wedge")
        assertEquals(Club.LOB_WEDGE, actual)
    }

    @Test
    fun `of should return null if club doesn't exist`() {
        assertNull(Club.ofClubName("Lob"))
    }
}