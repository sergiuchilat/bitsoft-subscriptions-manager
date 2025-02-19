import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class ApiErrorResponse(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val path: String,
    val errors: Map<String, String> = HashMap<String, String>()  // New field for validation errors
)
