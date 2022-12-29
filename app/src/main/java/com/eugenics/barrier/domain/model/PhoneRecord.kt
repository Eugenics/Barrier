package com.eugenics.barrier.domain.model

import android.os.Parcelable
import com.eugenics.barrier.data.dao.PhoneRecordEntity
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class PhoneRecord(
    val id: String,
    val name: String,
    val rem: String,
    val phoneNumber: String
) : Parcelable {
    fun mapToEntity() =
        PhoneRecordEntity(
            id = id,
            name = name,
            rem = rem,
            phoneNumber = phoneNumber
        )

    companion object {
        fun newEmptyInstance(): PhoneRecord =
            PhoneRecord(
                id = UUID.randomUUID().toString(),
                name = "",
                rem = "",
                phoneNumber = "+7"
            )
    }
}

