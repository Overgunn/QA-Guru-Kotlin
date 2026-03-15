package backend.controllers

open class Controllers {
   protected val auth get() = AuthController()

   protected val createUser get() = CreateUserController()
}
