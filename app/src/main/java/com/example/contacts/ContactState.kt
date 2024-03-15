package com.example.contacts

import com.example.contacts.room.Contact
import com.example.contacts.room.SortType

data class ContactState (
    val contacts: List<Contact> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.firstName

)