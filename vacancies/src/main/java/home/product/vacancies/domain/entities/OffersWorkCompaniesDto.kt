package home.howework.domain.entities

data class OffersWorkCompaniesDto(
      var offers    : ArrayList<OffersDto> = arrayListOf(),
      var vacancies :ArrayList<VacanciesDto> = arrayListOf()
)