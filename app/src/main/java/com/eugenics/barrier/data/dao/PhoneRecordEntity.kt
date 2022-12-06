package com.eugenics.barrier.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eugenics.barrier.domain.model.PhoneRecord

@Entity(tableName = "phone_records")
data class PhoneRecordEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "phone_number") val phoneNumber: String
) {
    fun mapToModel(): PhoneRecord =
        PhoneRecord(
            id = id,
            name = name,
            phoneNumber = phoneNumber
        )
}
