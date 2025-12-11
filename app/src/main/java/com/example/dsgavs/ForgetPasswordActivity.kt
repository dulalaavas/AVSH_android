package com.example.dsgavs

import android.app.Activity
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dsgavs.repository.UserRepoImpl
import com.example.dsgavs.ui.theme.Blue
import com.example.dsgavs.ui.theme.DSGAVSTheme
import com.example.dsgavs.ui.theme.PurpleGrey80
import com.example.dsgavs.viewmodel.UserViewModel

class ForgetPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForgetPasswordBody()

        }
    }
}

@Composable
fun ForgetPasswordBody(){
    var email by remember { mutableStateOf("") }

    val userViewModel = remember { UserViewModel(UserRepoImpl()) }

    val context = LocalContext.current
    val activity = context as Activity


    Scaffold { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center
            ) {
            Text("Forget Password",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Blue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                ),
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.padding(15.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { data ->
                    email = data
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text("example@gmail.com")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = PurpleGrey80,
                    unfocusedContainerColor = PurpleGrey80,
                    focusedIndicatorColor = Blue,
                    unfocusedIndicatorColor = Color.Transparent
                )

            )

            Button(
                onClick = {
                    userViewModel.forgetPassword(email) { success, message ->
                        if (success) {
                            Toast.makeText(
                                context,
                                message,
                                Toast.LENGTH_SHORT
                            )
                            activity.finish()
                        } else {
                            Toast.makeText(
                                context,
                                message,
                                Toast.LENGTH_SHORT
                            )
                        }

                        activity.finish()
                    }
                },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Text("Change Password")

            }
        }
    }
}

@Preview
@Composable
fun ForgetPasswordPreview() {
    ForgetPasswordBody()
}