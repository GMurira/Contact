package com.example.contacts.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contacts.ContactState
import com.example.contacts.room.ContactEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
){
    AlertDialog(
//        icon = {
//            Icon(icon, contentDescription = "Example Icon")
//        },
        title = {
            Text(text = "Add Contact")
        },
        onDismissRequest = {
           onEvent(ContactEvent.hideDialog)
        },
        text = {
               Column(verticalArrangement = Arrangement.SpaceBetween) {
                   TextField(value = state.firstName, onValueChange = {
                       onEvent(ContactEvent.SetFirstName(it))
                   },
                       placeholder = {
                           Text(text = "First Name")
                       }
                   )

                   TextField(value = state.lastName, onValueChange = {
                       onEvent(ContactEvent.SetLastName(it))
                   },
                       placeholder = {
                           Text(text = "Last Name")
                       }
                   )
                   TextField(value = state.phoneNumber, onValueChange = {
                       onEvent(ContactEvent.SetPhoneNumber(it))
                   },
                       placeholder = {
                           Text(text = "Phone Number")
                       })
               }
        },
        confirmButton = {
            Button(
                onClick = {
                    onEvent(ContactEvent.SaveContact)
                }
            ) {
                Text("Save Contact")
            }
        }
    )
}
