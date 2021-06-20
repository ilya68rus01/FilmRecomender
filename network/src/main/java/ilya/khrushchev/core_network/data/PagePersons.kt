package ilya.khrushchev.core_network.data

data class PagePersons(
    val page: Int,
    val results: List<Person>,
    val total_pages: Int,
    val total_results: Int
)
