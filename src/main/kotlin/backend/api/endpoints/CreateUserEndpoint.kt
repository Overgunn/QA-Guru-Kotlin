package backend.api.endpoints

import backend.api.models.createUser.CreateRequest
import backend.api.models.createUser.CreateResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateUserEndpoint {
    @POST("users/create")
    fun postCreateUser (@Body body: CreateRequest) : Call<CreateResponse>
}