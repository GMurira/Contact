package com.example.contacts.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun CloudContacts(){
    val database =  Firebase.database


    var name by remember{ mutableStateOf( "")}
    var email by remember{ mutableStateOf( "")}
    var phone by remember{ mutableStateOf( "")}


    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { newText -> name = newText},
            label = { Text(text = "Enter Your Name")}
        )
        OutlinedTextField(
            value = email,
            onValueChange = { newText -> email = newText},
            label = { Text(text = "Enter Your E-mail")}
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { newText -> phone = newText},
            label = { Text(text = "Enter Your Phone")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        val context = LocalContext.current
        Button(
            onClick = {
                val contactsRef = database.reference.child("Contacts")
                val contactRef = contactsRef.child(name)
                val contact = Contact(name, email)
                contactRef.setValue(contact)
                Toast.makeText(context, "Save Contact",Toast.LENGTH_SHORT).show()
                name = ""
                email   = ""
                phone = ""
                      },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Submit")
        }
    }
}


data class Contact(
    val email: String,
    val phone: String
)