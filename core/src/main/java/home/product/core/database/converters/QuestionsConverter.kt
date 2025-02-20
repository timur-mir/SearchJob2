package home.product.core.database.converters

import androidx.room.TypeConverter
import java.util.stream.Collectors

class QuestionsConverter {
    @TypeConverter
    fun fromQuestionsString(questions: ArrayList<String>): String {
        return questions.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toQuestionsList(data: String): ArrayList<String> {
        return kotlin.collections.ArrayList(data.split(","))

    }
}