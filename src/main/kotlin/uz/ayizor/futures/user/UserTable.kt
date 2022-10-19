package uz.ayizor.futures.user

import org.jetbrains.exposed.sql.Table

object UserTable : Table() {

    val id = varchar("id",255)
    val first_name = varchar("first_name",255)
    val last_name = varchar("last_name",255)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
