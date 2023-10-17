package com.taufik.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taufik.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskCompleted("All Task Completed", "Nice Work")
                }
            }
        }
    }
}

@Composable
fun TaskCompleted(title: String, description: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ) {
        Image(
            painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = description,
            fontSize = 16.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)

        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskCompleted("All Task Completed", "Nice Work")
    }
}