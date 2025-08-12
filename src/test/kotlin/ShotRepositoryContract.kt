import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class ShotRepositoryContract {
    protected abstract fun createRepo(): ShotRepository

    @Test
    fun `save should return shot`() {
        val repo = createRepo()
        val result = repo.saveShot(Shot(Club.DR, ShotResult.ON_TARGET))

        assertEquals(ShotResult.ON_TARGET, result.result)
        assertEquals(Club.DR, result.club)
    }

    @Test
    fun `getShots should return empty list`() {
        val repo = createRepo()
        val result = repo.getShots()
        assertTrue(result.isEmpty())
    }

    @Test
    fun `getShots should return list of shots`() {
        val repo = createRepo()
        repo.saveShot(Shot(Club.DR, ShotResult.ON_TARGET))
        repo.saveShot(Shot(Club.DR, ShotResult.ON_TARGET))
        val result = repo.getShots()
        assertEquals(2, result.size)
    }

    @Test
    fun `getShotsByClub should return empty list`() {
        val repo = createRepo()
        repo.saveShot(Shot(Club.NINE_IRON, ShotResult.ON_TARGET))
        val result = repo.getShotsByClub(Club.DR)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `getShotsByClub should return list of shots`() {
        val repo = createRepo()
        repo.saveShot(Shot(Club.THREE_WOOD, ShotResult.LEFT))
        repo.saveShot(Shot(Club.SIX_IRON, ShotResult.SHORT))
        val result = repo.getShotsByClub(Club.THREE_WOOD)
        assertTrue(result.size == 1)
    }
}