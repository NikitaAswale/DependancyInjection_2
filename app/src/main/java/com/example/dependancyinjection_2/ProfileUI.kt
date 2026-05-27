package com.example.dependancyinjection_2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ProfileUI(
    navController: NavController,
    characterName: String,
    characterSpecies: String,
    characterType : String,
    characterID: String,

){
    Scaffold(bottomBar = {
        BottomAppBar() {

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {

                Icon(Icons.Outlined.Home, contentDescription = "",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { navController.popBackStack() },
                    tint = Color.DarkGray)

                Icon(Icons.Outlined.Info, contentDescription = "",
                    modifier = Modifier.size(28.dp),
                    tint = Color.DarkGray)

                Icon(Icons.Outlined.Notifications, contentDescription = "",
                    modifier = Modifier.size(28.dp),
                    tint = Color.DarkGray)

                Icon(Icons.Outlined.Person, contentDescription = "",
                    modifier = Modifier.size(28.dp),
                    tint = Color.DarkGray)
            }
        }
    }) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {

            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "",
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Color.Black),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(color = Color.White)
            )

            Spacer(Modifier.height(20.dp))

            Card(modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)) {

                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Name",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )

                    Text("${characterName}",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    )
                }
            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {

                Card(modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)) {

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Species",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )

                        Text("${characterSpecies}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }


                Card(modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)) {

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Type",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )

                        Text("${characterType}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }

            }

            Spacer(Modifier.height(20.dp))

            Row(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .wrapContentWidth()
                .background(color = Color.LightGray,
                    RoundedCornerShape(20.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {

                Icon(Icons.Default.Lock, contentDescription = "",
                    modifier = Modifier,
                    tint = Color.Gray
                )

                Text("Character ID: ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )

                Text("${characterID}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
        }
    }
}