class InMemoryShotRepository(): ShotRepository {
    private val shots: MutableList<Shot> = mutableListOf()

    override fun saveShot(shot: Shot): Shot {
        shots.add(shot)
        return shot
    }

    override fun getShots() = shots

    override fun getShotsByClub(club: Club) = shots.filter { it.club == club }
}