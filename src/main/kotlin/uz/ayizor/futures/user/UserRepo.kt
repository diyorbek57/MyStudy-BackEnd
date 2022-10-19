package uz.ayizor.futures.user

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import uz.ayizor.DatabaseFactory.dbQuery

class UserRepo {
    suspend fun addUser(user: User) {
        dbQuery {
            UserTable.insert { ut ->
                ut[id] = user.id
                ut[first_name] = user.first_name
                ut[last_name] = user.last_name
                ut[phone_number] = user.phone_number
                ut[password] = user.password
                ut[birthday] = user.birthday
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
            last_name = row[UserTable.last_name],
            phone_number = row[UserTable.phone_number],
            password = row[UserTable.password],
            birthday = row[UserTable.birthday],
        )
    }
}