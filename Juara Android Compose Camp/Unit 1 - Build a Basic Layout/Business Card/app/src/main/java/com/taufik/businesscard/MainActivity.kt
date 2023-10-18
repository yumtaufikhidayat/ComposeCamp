package com.taufik.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taufik.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CardNameTitle(name = "Jennifer Doe", title = "Android Developer Extraordinaire")
        Spacer(modifier = Modifier.padding(top = 36.dp))
        AccountInfo(
            phoneNumber = "+11 (123) 444 555 666",
            phoneNumberIconColor = 0xFF3ddc84,
            shareText = "@Android Dev",
            shareIconColor = 0xFF3ddc84,
            email = "jen.doe@android.com",
            emailIconColor = 0xFF3ddc84
        )
    }
}

@Composable
fun CardNameTitle(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement  = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(top = 18.dp)
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Composable
fun AccountInfo(
    phoneNumber: String,
    phoneNumberIconColor: Long,
    shareText: String,
    shareIconColor: Long,
    email: String,
    emailIconColor: Long,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement  = Arrangement.Center,
        modifier = Modifier
    ) {
        Row{
            Icon(
                painter = painterResource(id = R.drawable.ic_phone),
                contentDescription = "Phone",
                tint = Color(phoneNumberIconColor),
                modifier = modifier
            )
            Text(
                text = phoneNumber,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_share),
                contentDescription = "Share",
                tint = Color(shareIconColor),
                modifier = modifier
            )
            Text(
                text = shareText,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_email),
                contentDescription = "Email",
                tint = Color(emailIconColor),
                modifier = modifier
            )
            Text(
                text = email,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}