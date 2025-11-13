package com.example.dsgavs

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dsgavs.ui.theme.DSGAVSTheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        }
    }
}

@Composable
fun ProfileBody(){
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    painter = painterResource(
                            id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = null
                    )
                Text(text = "DSGAVS")
                Icon(
                    painter = painterResource(
                        id = R.drawable.baseline_more_horiz_24),
                    contentDescription = null
                )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround) {
                Image(
                    painter = painterResource(R.drawable.avshsq),
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("300")
                    Text("Posts")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("1.2M")
                    Text("Followers")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("9")
                    Text("Followings")
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