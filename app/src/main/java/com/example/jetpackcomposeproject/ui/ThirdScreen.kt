package com.example.jetpackcomposeproject.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class ThirdScreenHandler {
    @Composable
    fun ThirdScreen(navController: NavController) {

        Column(modifier = Modifier
            .background(Color.Blue)
            .padding(20.dp)
            .fillMaxSize()){

            LazyRow {
                items(4) { index ->
                    BannerItem(index = index, navController = navController)
                }
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }

            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Outlined Button")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null,
                    tint = Color.Red
                    )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
                Text(text = "Text Button")
                
            }
        }


    }

    @Composable
    fun BannerItem(index: Int, navController: NavController) {
        // Dummy banner content, replace with your actual banner content
        Surface(
            modifier = Modifier
                .width(170.dp)
                .padding(8.dp)
                .padding(top = 55.dp) // Add margin above the banner
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, Color.Blue, RoundedCornerShape(8.dp)) // Add blue border
                .clickable {
                    // Navigate to MainActivity screen
                    navController.navigate("f3")
                },
            contentColor = Color.Black
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement =Arrangement.spacedBy(8.dp) // space between all views inside column
            ) {
                Text(
                    text = "Banner $index",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Banner description",
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview
@Composable
fun ThirdScreenPreview() {
    val navController = rememberNavController()
    val thirdScreenHandler = ThirdScreenHandler()
    thirdScreenHandler.ThirdScreen(navController = navController)
}