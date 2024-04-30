package com.example.jetpackcomposeproject

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeproject.ui.F3ScreenHandler
import com.example.jetpackcomposeproject.ui.HomeScreenHandler
import com.example.jetpackcomposeproject.ui.ThirdScreenHandler
import com.example.jetpackcomposeproject.ui.dashboard.DashboardViewModel
import com.example.jetpackcomposeproject.ui.f3ScreenPreview
import com.example.jetpackcomposeproject.ui.theme.JetPackComposeProjectTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            NavigationApp()


//                JetPackComposeProjectTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    MessageCard(Message("Android", "Jetpack Compose"))
//                }
//            }

//                    Greeting("Name")

        }

    }



    object SampleData {
        val conversationSample = listOf(
            Message(
                "User1", "Hello! lksadlka slkaslkdlasdk ldkaslkdas " +
                        "dsadasd dsadasdasdasdasdasd "
            ),
            Message("User2", "Hi there!"),
            Message("User1", "How are you?"),
            Message("User2", "I'm good, thanks! How about you? I'm good, thanks! How about you?")
        )
    }

    @Composable
    fun NavigationApp() {
        val navController = rememberNavController()
        val homeScreenHandler = HomeScreenHandler(navigateBack = { navController.popBackStack() },
            navigateToThirdScreen = { navController.navigate("third") }
        )


        NavHost(navController, startDestination = "main") {
            composable("main") {
                JetPackComposeProjectTheme {
                    MainScreen(navController)
                }
            }
            composable("home") {
                JetPackComposeProjectTheme {
                    homeScreenHandler.HomeScreen()
                }
            }
            composable("third") {
                val thirdScreenHandler = ThirdScreenHandler()
                thirdScreenHandler.ThirdScreen(navController = navController)
            }
            composable("f3") {
                val f3ScreenHandler = F3ScreenHandler(activity = LocalContext.current as ComponentActivity)
                f3ScreenHandler.f3HomePage(navController = navController)
            }
        }
    }

    @Composable
    fun MainScreen(navController: NavController) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {

            Text(text = "Home Screen", modifier = Modifier
                .size(20.dp)   /// height + weight
                .padding(10.dp)  // margin ****
                .background(Color.Green)
                .padding(10.dp)  // padding

            )

            Conversation(SampleData.conversationSample)

            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Go to Home Screen")
            }
        }
    }


    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewConversation() {
        JetPackComposeProjectTheme {
           // Conversation(SampleData.conversationSample)
            MainScreen(navController = rememberNavController())
        }
    }

    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.image1),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            // We keep track if the message is expanded or not in this
            // variable
            var isExpanded by remember { mutableStateOf(false) }

            // We toggle the isExpanded variable when we click on this Column
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                ) {
                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(all = 4.dp),
                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)
//
//@Composable
//fun MessageCard(msg: Message) {
//    Row (modifier = Modifier.padding(all = 8.dp)){
//        Image(
//            painter = painterResource(R.drawable.image1),
//            contentDescription = "Contact profile picture",
//            modifier = Modifier
//                // Set image size to 40 dp
//                .size(40.dp)
//                // Clip image to be shaped as a circle
//                .clip(CircleShape)
//                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
//        )
//        // Add a horizontal space between the image and the column
//        Spacer(modifier = Modifier.width(8.dp))
//
//        Column {
//            Text(
//                text = msg.author ,
//                color = MaterialTheme.colorScheme.secondary,
//                style = MaterialTheme.typography.titleSmall
//
//            )
//
//
//            // Add a vertical space between the author and message texts
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(text = msg.body,
//                modifier = Modifier.padding(all = 4.dp),
//                style = MaterialTheme.typography.bodyMedium
//            )
//        }
//    }
//}


//@Preview(name = "Light Mode")
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
//)
//
//@Preview
//@Composable
//fun PreviewMessageCard() {
//    JetPackComposeProjectTheme {
//            MessageCard(
//                msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
//            )
//        }
//    }


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    JetPackComposeProjectTheme {
//        Greeting("Android")
//    }





