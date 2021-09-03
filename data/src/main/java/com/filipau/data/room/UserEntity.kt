package com.filipau.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_base_info_table")
class UserEntity(

    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val nickname: String,
    @ColumnInfo val email: String,
    @ColumnInfo val web: String,
    @ColumnInfo val phone: String,
    @ColumnInfo val city: String,
)

