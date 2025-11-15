package com.example.dsgavs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dsgavs.ui.theme.DSGAVSTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        }
    }
}

@Composable
fun ProfileBody() {
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.round_home_24),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.round_search_24),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.outline_smart_display_24),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.round_send_24),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.round_person_outline_24),
                    contentDescription = null
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {

            // Top Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                    contentDescription = null
                )
                Text(text = "DSGAVS")
                Icon(
                    painter = painterResource(id = R.drawable.baseline_more_horiz_24),
                    contentDescription = null
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(R.drawable.avshsq),
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("300")
                    Text("Posts")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("1.2M")
                    Text("Followers")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("9")
                    Text("Followings")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    "Aavash Dulal",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text("Hello my name is Aavash. Hehe 😂✌")
            }
            Row  (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround) {
            Button(
                onClick = {

                },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black
                )
            ) {
                Text("Follow")
            }
                OutlinedButton(onClick = {}) {
                    Text("Message")
                }
            }
        }
    }
}


@Preview
@Composable
fun ProfileBodyPreview() {
    DSGAVSTheme {
        ProfileBody()
    }
}