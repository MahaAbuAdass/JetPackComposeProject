package com.example.jetpackcomposeproject.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeproject.R

class HomeScreenHandler(private val navigateBack: () -> Unit ,
                        private val navigateToThirdScreen: () -> Unit,
) {


    @Composable
    fun HomeScreen() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Home Screen")
            Spacer(modifier = Modifier.height(16.dp))

            // Add whatever UI and functionality you need for the HomeScreen
            // For example:
            Button(
                onClick = { /* Add functionality here */ navigateBack() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Navigate Back")
            }
            Button(
                onClick = { /* Add functionality here */ navigateToThirdScreen() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Go to Third Screen")
            }

            Box(
                modifier = Modifier
                    .size(150.dp)
                    .rotate(45f)
                    .alpha(0.2f)
                    .background(Color.Cyan)
                ,
                contentAlignment = Alignment.Center

            ) {
                Surface(
                    modifier = Modifier.matchParentSize(),
                    color = Color.Transparent,
                    border = BorderStroke(2.dp, Color.Black),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image1),
                            contentDescription = "Image",
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "Image Text",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold ,
                            color = Color.Red // Set text color to white
                        )

                        Spacer(modifier = Modifier.height(8.dp)) // Add Spacer for spacing

                        Text(
                            text = "Maha",
                            color = Color.Red // Set text color to white

                        )


                    }
                }

            }
        }
    }
}



@Preview
@Composable
fun HomeScreenPreview() {
    val homeScreenHandler = HomeScreenHandler(
        navigateBack = {},
        navigateToThirdScreen = {}
    )
    homeScreenHandler.HomeScreen()
}

