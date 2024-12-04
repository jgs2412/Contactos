package com.example.contactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contactos.ui.theme.ContactosTheme
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactosTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    contactos(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


data class Contact(val name: String)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun contactos(modifier: Modifier) {
    val contacts = listOf(
        Contact("Zoe"),
        Contact("Marcelo"),
        Contact("Victoria"),
        Contact("Diego"),
        Contact("Teodoro"),
        Contact("Santiago"),
        Contact("Rigoberto"),
        Contact("Ana"),
        Contact("Pedro"),
        Contact("Óscar"),
        Contact("Nicolás"),
        Contact("Manuela"),
        Contact("Leonardo"),
        Contact("Isabella"),
        Contact("Hugo"),
        Contact("Gustavo"),
        Contact("Fátima"),
        Contact("Elena"),
        Contact("Damián"),
        Contact("Cecilia"),
        Contact("Benjamín"),
        Contact("Álvaro")
    ).sortedBy { it.name }

    val groupedContacts = contacts.groupBy { it.name.first().uppercaseChar() }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        groupedContacts.forEach { (initial, contacts) ->
            stickyHeader {
                Text(
                    text = initial.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .padding(8.dp)
                )
            }

            items(contacts) { contact ->
                ContactItem(contact)
            }
        }
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Text(
        text = contact.name,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}
