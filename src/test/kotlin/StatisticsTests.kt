import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StatisticsTests {

    @Test
    fun `calcDispersion should return map`() {
        val shots = listOf<Shot>()

        val expected = mapOf(
            ShotResult.LONG to 0.0,
            ShotResult.LONG_LEFT to 0.0,
            ShotResult.LONG_RIGHT to 0.0,
            ShotResult.LEFT to 0.0,
            ShotResult.RIGHT to 0.0,
            ShotResult.ON_TARGET to 0.0,
            ShotResult.SHORT to 0.0,
            ShotResult.SHORT_LEFT to 0.0,
            ShotResult.SHORT_RIGHT to 0.0,
            )
        assertEquals(expected, calcDispersion(shots))
    }

    @Test
    fun `calcDispersion should return map with all long`() {
        val shots = listOf(Shot(Club.DR, ShotResult.LONG))

        val expected = mapOf(
            ShotResult.LONG to 100.0,
            ShotResult.LONG_LEFT to 0.0,
            ShotResult.LONG_RIGHT to 0.0,
            ShotResult.LEFT to 0.0,
            ShotResult.RIGHT to 0.0,
            ShotResult.ON_TARGET to 0.0,
            ShotResult.SHORT to 0.0,
            ShotResult.SHORT_LEFT to 0.0,
            ShotResult.SHORT_RIGHT to 0.0,
        )
        assertEquals(expected, calcDispersion(shots))
    }

    @Test
    fun `calcDispersion should return map with half left and half right`() {
        val shots = listOf(Shot(Club.DR, ShotResult.LEFT), Shot(Club.DR, ShotResult.RIGHT))

        val expected = mapOf(
            ShotResult.LONG to 0.0,
            ShotResult.LONG_LEFT to 0.0,
            ShotResult.LONG_RIGHT to 0.0,
            ShotResult.LEFT to 50.0,
            ShotResult.RIGHT to 50.0,
            ShotResult.ON_TARGET to 0.0,
            ShotResult.SHORT to 0.0,
            ShotResult.SHORT_LEFT to 0.0,
            ShotResult.SHORT_RIGHT to 0.0,
        )
        assertEquals(expected, calcDispersion(shots))
    }

    @Test
    fun `calcDispersion should return map with two decimals`() {
        val shots = listOf(Shot(Club.DR, ShotResult.LEFT), Shot(Club.DR, ShotResult.RIGHT), Shot(Club.DR, ShotResult.ON_TARGET))

        val expected = mapOf(
            ShotResult.LONG to 0.0,
            ShotResult.LONG_LEFT to 0.0,
            ShotResult.LONG_RIGHT to 0.0,
            ShotResult.LEFT to 33.33,
            ShotResult.RIGHT to 33.33,
            ShotResult.ON_TARGET to 33.33,
            ShotResult.SHORT to 0.0,
            ShotResult.SHORT_LEFT to 0.0,
            ShotResult.SHORT_RIGHT to 0.0,
        )
        assertEquals(expected, calcDispersion(shots))
    }

    @Test
    fun `calcClubDispersion should return map`() {
        val shots = listOf(Shot(Club.DR, ShotResult.LEFT), Shot(Club.DR, ShotResult.RIGHT), Shot(Club.DR, ShotResult.ON_TARGET))

        val expected = mapOf(
            ShotResult.LONG to 0.0,
            ShotResult.LONG_LEFT to 0.0,
            ShotResult.LONG_RIGHT to 0.0,
            ShotResult.LEFT to 0.0,
            ShotResult.RIGHT to 0.0,
            ShotResult.ON_TARGET to 0.0,
            ShotResult.SHORT to 0.0,
            ShotResult.SHORT_LEFT to 0.0,
            ShotResult.SHORT_RIGHT to 0.0,
        )
        assertEquals(expected, calcClubDispersion(shots, Club.SIX_IRON))
    }

    @Test
    fun `calcClubDispersion should return zero when club has not been used`() {
        val shots = listOf(Shot(Club.DR, ShotResult.LEFT), Shot(Club.DR, ShotResult.RIGHT), Shot(Club.DR, ShotResult.ON_TARGET))

        val expected = mapOf(
            ShotResult.LONG to 0.0,
            ShotResult.LONG_LEFT to 0.0,
            ShotResult.LONG_RIGHT to 0.0,
            ShotResult.LEFT to 0.0,
            ShotResult.RIGHT to 0.0,
            ShotResult.ON_TARGET to 0.0,
            ShotResult.SHORT to 0.0,
            ShotResult.SHORT_LEFT to 0.0,
            ShotResult.SHORT_RIGHT to 0.0,
        )
        assertEquals(expected, calcClubDispersion(shots, Club.SIX_IRON))
    }

    @Test
    fun `calcClubDispersion should return map with only results for passed club`() {
        val shots = listOf(Shot(Club.DR, ShotResult.LEFT), Shot(Club.DR, ShotResult.RIGHT), Shot(Club.NINE_IRON, ShotResult.RIGHT))

        val expected = mapOf(
            ShotResult.LONG to 0.0,
            ShotResult.LONG_LEFT to 0.0,
            ShotResult.LONG_RIGHT to 0.0,
            ShotResult.LEFT to 50.0,
            ShotResult.RIGHT to 50.0,
            ShotResult.ON_TARGET to 0.0,
            ShotResult.SHORT to 0.0,
            ShotResult.SHORT_LEFT to 0.0,
            ShotResult.SHORT_RIGHT to 0.0,
        )
        assertEquals(expected, calcClubDispersion(shots, Club.DR))
    }
}