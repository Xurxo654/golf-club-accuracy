interface ShotRepository {
    fun saveShot(shot: Shot): Shot
    fun getShots(): List<Shot>
    fun getShotsByClub(club: Club): List<Shot>
}