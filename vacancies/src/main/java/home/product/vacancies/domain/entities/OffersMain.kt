package home.howework.domain.entities

sealed class OffersMain{
    data class VacanciesNear(
        var id    : String,
        var title : String,
        var link  : String
    ): OffersMain()
    data class ResumeRaise(
        var id    : String,
        var title : String,
        var link  : String
    ): OffersMain()
    data class TemporaryJob(
        var id    : String,
        var title : String,
        var link  : String
    ): OffersMain()

}
