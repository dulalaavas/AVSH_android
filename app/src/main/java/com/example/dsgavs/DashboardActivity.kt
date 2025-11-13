package com.example.dsgavs

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
            Row{
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