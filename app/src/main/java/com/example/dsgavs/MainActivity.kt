package com.example.dsgavs

import android.R.attr.fontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dsgavs.ui.theme.DSGAVSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainBody()
        }
    }
}

@Composable
fun MainBody() {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize().padding(paddingValues = padding)
                .background(Color(0xFFDAA520))
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text("Yo my name is android", style = TextStyle(
                Color.White,
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                letterSpacing = 2.sp,
                fontStyle = FontStyle.Italic
            )
            )
            Text("hello android", style = TextStyle(
                Color.White,
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                letterSpacing = 2.sp,
                fontStyle = FontStyle.Italic
            )
            )
            Text("Welcome", style = TextStyle(
                Color.White,
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                letterSpacing = 2.sp,
                fontStyle = FontStyle.Italic
            )
            )
        }
        
    }
}

@Preview
@Composable
fun MainBodyPreview() {
    MainBody()
}