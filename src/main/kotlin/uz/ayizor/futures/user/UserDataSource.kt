package uz.ayizor.futures.user

interface UserDataSource {
    suspend fun insertUser(user: User): Boolean
    suspend fun getUserById(id: String): User?
}