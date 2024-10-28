@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
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
    var currentStep by remember { mutableStateOf(1) }
    var clickCount by remember { mutableStateOf(0) }

    // Scaffold provides the structure to place top bar, content, etc.
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(R.string.app_name), fontSize = 20.sp, color = Color.Green) },
                modifier = Modifier.statusBarsPadding(),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Yellow // Set the background to yellow
                )
            )
        },
        content = { innerPadding ->
            // Main content
            when (currentStep) {
                1 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),  // Ensures content doesn't overlap with TopAppBar
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_tree),
                            contentDescription = stringResource(R.string.desc_1),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(
                                    color = Color(red = 105, green = 205, blue = 216),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color(red = 105, green = 205, blue =216),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clickable { currentStep = 2 }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(R.string.content_1),
                            fontSize = 18.sp,)
                    }
                }

                2 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_squeeze),
                            contentDescription = stringResource(R.string.desc_2),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(
                                    color = Color(red = 105, green = 205, blue = 216),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color(red = 105, green = 205, blue =216),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clickable {
                                    clickCount++
                                    if (clickCount >= 3) {
                                        currentStep = 3
                                        clickCount = 0
                                    }
                                }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(R.string.content_2),
                            fontSize = 18.sp)
                    }
                }

                3 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_drink),
                            contentDescription = stringResource(R.string.desc_3),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(
                                    color = Color(red = 105, green = 205, blue = 216),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color(red = 105, green = 205, blue =216),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clickable { currentStep = 4 }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(R.string.content_3),
                            fontSize = 18.sp)
                    }
                }

                4 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_restart),
                            contentDescription = stringResource(R.string.desc_4),
                            modifier = Modifier
                                .wrapContentSize()

                                .border(
                                    width = 2.dp,
                                    color = Color(red = 105, green = 205, blue =216),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clickable { currentStep = 1 }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(R.string.content_4),
                            fontSize = 18.sp)
                    }
                }
            }
        }
    )
}








    @Preview(showSystemUi = true)
    @Composable
    fun LemonadePreview() {
        LemonadeTheme {
            LemonadeApp()
        }
    }
