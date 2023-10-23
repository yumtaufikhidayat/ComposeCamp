package com.taufik.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taufik.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    LemonadeImageBehavior()
}

@Composable
fun LemonadeImageBehavior() {
    var currentStep by remember { mutableStateOf(1) }
    when (currentStep) {
        1 -> LemonadeImageText(
            imageResource = R.drawable.lemon_tree,
            textResource = R.string.tap_tree,
            contentDescriptionResource = R.string.lemon_tree_content_description,
            onImageClick = {
                currentStep = 2
            })
        2 -> LemonadeImageText(
            imageResource = R.drawable.lemon_squeeze,
            textResource = R.string.tap_lemon_to_squeeze,
            contentDescriptionResource = R.string.lemon_content_description,
            onImageClick = {
                currentStep = 3
            }
        )

        3 -> LemonadeImageText(
            imageResource = R.drawable.lemon_drink,
            textResource = R.string.tap_lemon_to_drink,
            contentDescriptionResource = R.string.lemonade_content_description,
            onImageClick = {
                currentStep = 4
            }
        )

        else -> LemonadeImageText(
            imageResource = R.drawable.lemon_restart,
            textResource = R.string.tap_empty_glass,
            contentDescriptionResource = R.string.empty_glass_content_description,
            onImageClick = {
                currentStep = 1
            }
        )
    }
}

@Composable
fun LemonadeImageText(
    imageResource: Int,
    textResource: Int,
    contentDescriptionResource: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize(),
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = contentDescriptionResource),
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = textResource)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}