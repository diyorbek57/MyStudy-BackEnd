package uz.ayizor.futures.user

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import uz.ayizor.DatabaseFactory.dbQuery

class UserRepo {
    suspend fun addUser(user: User) {
        dbQuery {
            UserTable.insert { ut ->
                ut[UserTable.id] = user.id
                ut[UserTable.first_name] = user.first_name
                ut[UserTable.last_name] = user.last_name
            }
        }
    }

    suspend fun findUserById(id: String) = dbQuery {
        UserTable.select { UserTable.id.eq(id) }
            .map { rowToUser(it) }
            .singleOrNull()
    }

    private fun rowToUser(row: ResultRow?): User? {
        if (row == null) {
            return null
        }

        return User(
            id = row[UserTable.id],
            first_name = row[UserTable.first_name],
            last_name = row[UserTable.last_name]
        )
    }
}