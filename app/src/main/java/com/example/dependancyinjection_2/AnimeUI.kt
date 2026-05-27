package com.example.dependancyinjection_2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmineUI(viewModel: UserViewModel = hiltViewModel(), navController: NavController){

    val character = viewModel.character.collectAsLazyPagingItems()

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text("All",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(color = Color.Blue)
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    )

                    Text("Humanoid",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(color = Color.LightGray)
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    )

                    Text("Alien",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(color = Color.LightGray)
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    )

                    Text("Unknown",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(color = Color.LightGray)
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }
        )
    },
        bottomBar = {
            BottomAppBar() {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically) {

                    Icon(Icons.Outlined.Home, contentDescription = "",
                        modifier = Modifier.size(28.dp),
                        tint = Color.DarkGray)

                    Icon(Icons.Outlined.Info, contentDescription = "",
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(color = Color(0xFF89CFF0))
                            .padding(8.dp)
                            .size(28.dp)
                        ,
                        tint = Color.DarkGray)

                    Icon(Icons.Outlined.Notifications, contentDescription = "",
                        modifier = Modifier.size(28.dp),
                        tint = Color.DarkGray)

                    Icon(Icons.Outlined.Person, contentDescription = "",
                        modifier = Modifier.size(28.dp),
                        tint = Color.DarkGray)
                }
            }
        }) {
        paddingValues ->

        LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {

            items(character.itemCount){
                index ->
                character[index]?.let {
                    UserList(character = it, navController)
                }
            }
        }


    }
}

@Composable
fun UserList(character: Result, navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {

        Card(modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)) {

            Row(modifier = Modifier.fillMaxWidth()
                .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically) {

                AsyncImage(model = character.image, contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Black)
                        .size(100.dp)
                )

                Column(modifier = Modifier.weight(1f)
                    .padding(start = 10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly) {

                    Text("${character.name}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.clickable{
                            val type = character.type.ifEmpty { "unknown" }
                            navController.navigate("Screen2/${character.name}/${character.species}/$type/${character.id}")
                        }
                    )

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "${character.species}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(color = Color.LightGray)
                                .padding(horizontal = 6.dp, vertical = 4.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            "${character.type}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(color = Color.LightGray)
                                .padding(horizontal = 6.dp, vertical = 4.dp)
                        )
                    }

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically) {

                        Text( text = ".",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(8.dp)
                                .background(color = Color.Gray)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text("Status: ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )


                        Text("${character.status} ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                    }
                }

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Options",
                    modifier = Modifier
                        .align(Alignment.Top),
                    tint = Color.Gray
                )
            }
        }
    }

}