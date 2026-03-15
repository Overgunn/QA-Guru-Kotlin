package backend.api.models.createUser

data class CreateResponse(
    val createdAt: Long,
    val email: String,
    val id: Int,
    val phoneNumber: String,
    val username: String
)