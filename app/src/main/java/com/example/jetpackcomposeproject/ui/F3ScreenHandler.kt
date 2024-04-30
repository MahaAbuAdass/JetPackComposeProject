package com.example.jetpackcomposeproject.ui

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeproject.R
import com.example.jetpackcomposeproject.network.RetrofitBuilder
import com.example.jetpackcomposeproject.ui.dashboard.DashboardViewModel
import com.example.jetpackcomposeproject.ui.dashboard.ServicesDataModel
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import coil.compose.rememberImagePainter


class F3ScreenHandler (private val activity: ComponentActivity) {


    private val retrofitBuilder = RetrofitBuilder()

    val auth =
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJUZXN0MkBnbWFpbC5jb20iLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiJiZTA3NWVmOC1jYTU0LTQ5YTQtYWNmZi02MTkyMTI3MzlkZTciLCJleHAiOjE3MDkzNzk1MTEsImlzcyI6Ik5ld0Flb24iLCJhdWQiOiJOZXdBZW9uIn0.lXPZsH3xLpqbjh7l9JhYe115kE6RitRhfxf6V-gSESY"
    val villaId = "27"
    private val dashboardViewModel: DashboardViewModel by activity.viewModels()
    val language: String = "1"



    @Composable
    fun f3HomePage(navController: NavController) {
        // Obtain an instance of DashboardViewModel

        var menuExpanded by remember { mutableStateOf(false) }
        val menuItems = listOf("Account", "Notification", " Logout")
        var currentIndex by remember { mutableStateOf(0) } // Current index of the image being displayed

        val homeViewModel: DashboardViewModel = viewModel()
      // var getAllServiceResponseModel by remember { mutableStateOf<List<ServicesDataModel>>(emptyList()) }
        val getAllServiceResponseModel by homeViewModel.getAllServiceResponseModel.collectAsState()





        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        ) { // Set white background color for the entire screen
            Column(
                modifier = Modifier.padding(8.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.menu_24),
                    contentDescription = "Image",
                    modifier = Modifier

                        .size(50.dp)
                        .clickable { menuExpanded = true }
                )
                DropdownMenu(
                    expanded = menuExpanded,
                    onDismissRequest = { menuExpanded = false },

                    ) {
                    menuItems.forEach { item ->
                        DropdownMenuItem(text = { item },
                            onClick = { menuExpanded = false })


                    }
                }




                Text(text = "Welcome")
                Text(text = "Maha")




                LazyColumn() {

//                    items(getAllServiceResponseModel) { item ->
//                        if (item != null) {
//                            showService(item)
//                        }


                    }
                }
//                Surface(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp),
//                    color = Color.White
//                ) {
//                    Column(modifier = Modifier.padding(8.dp)) {
//                        // First Row
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(bottom = 15.dp),
//                            horizontalArrangement = Arrangement.SpaceBetween
//                        ) {
//                            Box(
//                                modifier = Modifier
//                                    .width(110.dp)
//                                    .aspectRatio(1f)
//                                    .padding(3.dp)
//                                    .clip(RoundedCornerShape(5.dp))
//                                    .border(
//                                        width = 1.dp,
//                                        color = colorResource(id = R.color.yellow_new),
//                                        shape = RoundedCornerShape(8.dp)
//                                    )
//                                    .clickable { navController.navigate("main") },
//                                contentAlignment = Alignment.Center
//                            ) {
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(4.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally
//                                ) {
//                                    Text(
//                                        text = "House Keeping",
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(bottom = 7.dp),
//                                        textAlign = TextAlign.Center,
//
//
//                                        )
//                                    Image(
//                                        painter = painterResource(id = R.drawable.house_keeping),
//                                        contentDescription = "house keeping",
//                                        modifier = Modifier
//                                            .size(50.dp)
//                                            .fillMaxWidth()
//                                    )
//                                }
//                            }
//                            Box(
//                                modifier = Modifier
//                                    .width(110.dp)
//                                    .aspectRatio(1f)
//                                    .padding(3.dp)
//                                    .clip(RoundedCornerShape(5.dp))
//                                    .border(
//                                        width = 1.dp,
//                                        color = colorResource(id = R.color.yellow_new),
//                                        shape = RoundedCornerShape(8.dp)
//                                    )
//                                    .clickable { navController.navigate("main") },
//                                contentAlignment = Alignment.Center
//                            ) {
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(4.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally
//
//                                )
//                                {
//
//                                    Text(
//                                        text = "House keeping",
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(bottom = 7.dp),
//                                        textAlign = TextAlign.Center
//                                    )
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.house_keeping),
//                                        contentDescription = "image 2",
//                                        modifier = Modifier
//                                            .size(50.dp)
//                                            .fillMaxWidth()
//                                    )
//
//
//                                }
//                            }
//
//                            Box(
//                                modifier = Modifier
//                                    .width(110.dp)
//                                    .aspectRatio(1f)
//                                    .padding(3.dp)
//                                    .clip(RoundedCornerShape(5.dp))
//                                    .border(
//                                        width = 1.dp,
//                                        color = colorResource(id = R.color.yellow_new),
//                                        shape = RoundedCornerShape(8.dp)
//                                    )
//                                    .clickable { navController.navigate("main") },
//                                contentAlignment = Alignment.Center
//                            ) {
//
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(4.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally
//                                ) {
//
//                                    Text(
//                                        text = "House Keeping",
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(bottom = 7.dp),
//                                        textAlign = TextAlign.Center
//                                    )
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.house_keeping),
//                                        contentDescription = "image 3",
//                                        modifier = Modifier
//                                            .size(50.dp)
//                                            .fillMaxWidth()
//                                    )
//                                }
//                            }
//                        }
//                        // Second Row
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.SpaceBetween
//                        ) {
//                            Box(
//                                modifier = Modifier
//                                    .width(110.dp)
//                                    .aspectRatio(1f)
//                                    .padding(3.dp)
//                                    .clip(RoundedCornerShape(5.dp))
//                                    .border(
//                                        width = 1.dp,
//                                        color = colorResource(id = R.color.yellow_new),
//                                        shape = RoundedCornerShape(8.dp)
//                                    )
//                                    .clickable { navController.navigate("main") },
//                                contentAlignment = Alignment.Center
//                            ) {
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(4.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally
//                                ) {
//                                    Text(
//                                        text = "House Keeping",
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(bottom = 7.dp),
//                                        textAlign = TextAlign.Center,
//
//
//                                        )
//                                    Image(
//                                        painter = painterResource(id = R.drawable.house_keeping),
//                                        contentDescription = "house keeping",
//                                        modifier = Modifier
//                                            .size(50.dp)
//                                            .fillMaxWidth()
//                                    )
//                                }
//                            }
//                            Box(
//                                modifier = Modifier
//                                    .width(110.dp)
//                                    .aspectRatio(1f)
//                                    .padding(3.dp)
//                                    .clip(RoundedCornerShape(5.dp))
//                                    .border(
//                                        width = 1.dp,
//                                        color = colorResource(id = R.color.yellow_new),
//                                        shape = RoundedCornerShape(8.dp)
//                                    )
//                                    .clickable { navController.navigate("main") },
//                                contentAlignment = Alignment.Center
//                            ) {
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(4.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally
//
//                                )
//                                {
//
//                                    Text(
//                                        text = "House keeping",
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(bottom = 7.dp),
//                                        textAlign = TextAlign.Center
//                                    )
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.house_keeping),
//                                        contentDescription = "image 2",
//                                        modifier = Modifier
//                                            .size(50.dp)
//                                            .fillMaxWidth()
//                                    )
//
//
//                                }
//                            }
//
//                            Box(
//                                modifier = Modifier
//                                    .width(110.dp)
//                                    .aspectRatio(1f)
//                                    .padding(3.dp)
//                                    .clip(RoundedCornerShape(5.dp))
//                                    .border(
//                                        width = 1.dp,
//                                        color = colorResource(id = R.color.yellow_new),
//                                        shape = RoundedCornerShape(8.dp)
//                                    )
//                                    .clickable { navController.navigate("main") },
//                                contentAlignment = Alignment.Center
//                            ) {
//
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(4.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally
//                                ) {
//
//                                    Text(
//                                        text = "House Keeping",
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(bottom = 7.dp),
//                                        textAlign = TextAlign.Center
//                                    )
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.house_keeping),
//                                        contentDescription = "image 3",
//                                        modifier = Modifier
//                                            .size(50.dp)
//                                            .fillMaxWidth()
//                                    )
//                                }
//                            }
//                        }
//                    }
//                }






                LazyRow {
                    items(8) { index ->
                        BannerItem(index = index, navController = navController)
                    }
                }

            }
        }

    }


    @Composable
    fun showService(serviceData : ServicesDataModel) {
        val imagerPainter = rememberImagePainter(data = serviceData.iconImg)


        Image(painter = imagerPainter, contentDescription ="image" )

        Text(text = "maha")

    }


    @Composable
    fun BannerItem(index: Int, navController: NavController) {
        // Dummy banner content, replace with your actual banner content
        Surface(
            modifier = Modifier
                .width(300.dp) // Increase width of the banner
                .height(260.dp) // Increase height of the banner
                .padding(8.dp)
                .padding(top = 55.dp) // Add margin above the banner
                .clip(RoundedCornerShape(8.dp))
                .border(
                    1.dp,
                    colorResource(id = R.color.yellow_new),
                    RoundedCornerShape(8.dp)
                ) // Add blue border
                .clickable {
                    // Navigate to MainActivity screen
                    navController.navigate("f3")
                },
            contentColor = Color.Black
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "banner",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }





    data class ServiceModel(val title: String, val imageRes: Int)





@Preview
@Composable
fun f3ScreenPreview() {
    val navController = rememberNavController()
    val activity = androidx.activity.ComponentActivity()
    val f3ScreenHandler = F3ScreenHandler(activity)
    f3ScreenHandler.f3HomePage(navController = navController)
}