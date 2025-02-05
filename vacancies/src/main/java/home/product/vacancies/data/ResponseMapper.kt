package home.product.vacancies.data

import home.howework.data.mocknetwork.model.OffersWorkCompaniesResponse
import home.product.vacancies.domain.entities.AddressDto
import home.product.vacancies.domain.entities.ExperienceDto
import home.product.vacancies.domain.entities.OffersDto
import home.product.vacancies.domain.entities.OffersWorkCompaniesDto
import home.product.vacancies.domain.entities.SalaryDto
import home.product.vacancies.domain.entities.VacanciesDto


fun OffersWorkCompaniesResponse.mapToOffersWorkCompaniesDto(): OffersWorkCompaniesDto {
    return with(this) {
        OffersWorkCompaniesDto(
            offers.map { it -> OffersDto(it.id, it.title, it.link) } as ArrayList<OffersDto>,
            vacancies.map { it ->
                VacanciesDto(
                    id = it.id,
                    lookingNumber = it.lookingNumber,
                    title = it.title,
                    address = AddressDto(it.address.town, it.address.street, it.address.house),
                    company = it.company,
                    experience = ExperienceDto(it.experience.previewText, it.experience.text),
                    publishedDate = it.publishedDate,
                    isFavorite = it.isFavorite,
                    salary = SalaryDto(it.salary.full),
                    schedules = it.schedules,
                    appliedNumber = it.appliedNumber,
                    description = it.description,
                    responsibilities = it.responsibilities,
                    questions = it.questions
                )
            } as ArrayList<VacanciesDto>
        )

    }
}
