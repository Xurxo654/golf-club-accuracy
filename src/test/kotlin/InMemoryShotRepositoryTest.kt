class InMemoryShotRepositoryTest: ShotRepositoryContract() {
    override fun createRepo() = InMemoryShotRepository()
}