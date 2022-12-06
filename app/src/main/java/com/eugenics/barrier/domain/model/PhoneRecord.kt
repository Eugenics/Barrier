package com.eugenics.barrier.domain.model

import java.util.UUID

data class PhoneRecord(
    val id: String,
    val name: String,
    val phoneNumber: String
) {
    companion object {
        fun newEmptyInstance(): PhoneRecord =
            PhoneRecord(
                id = UUID.randomUUID().toString(),
                name = "",
                phoneNumber = ""
            )
    }
}

