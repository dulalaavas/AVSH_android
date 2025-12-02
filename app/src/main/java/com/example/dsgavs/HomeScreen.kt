package com.example.dsgavs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(){
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth().padding(15.dp)

    ) {
        OutlinedTextField(
            value = search,
            onValueChange = { data ->
                search = data
            },
            leadingIcon ={ Icon(painter = painterResource(R.drawable.round_search_24),
                contentDescription = null) },
            trailingIcon ={
                Icon(
                    painter = painterResource(
                        R.drawable.baseline_mic_24),
                        contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            shape = RoundedCornerShape(15.dp),
            placeholder = {
                Text("Search here")
            }
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()

    ) {

    }
}

@Preview
@Composable
fun HomePreview(){
    HomeScreen()
}