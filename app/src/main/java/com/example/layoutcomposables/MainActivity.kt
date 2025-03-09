package com.example.layoutcomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutcomposables.ui.theme.LayoutComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    LayoutComposablesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            //ProfileCard()
            //RowColumnWeightExample()
            //Quadrant()
            //PersonList()
            ScaffoldExample()

        }
    }

}

@Composable
fun ProfileCard(modifier: Modifier = Modifier)
{
    Box{
        BackgroundImage()
        ProfileBody()
    }

}

@Composable
fun BackgroundImage(modifier: Modifier = Modifier)
{
    Image(
        painter = painterResource(id = R.drawable.backgroundpic),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth().height(200.dp)
    )
}

@Composable
fun ProfileBody(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = 125.dp)
    ){
        ProfilePicture()
        Spacer(modifier = Modifier.height(20.dp))
        HeaderSection()
        Dividier()
        ContactInfo()
        Dividier()
        ButtonSection()


    }
}

@Composable
fun ProfilePicture(modifier: Modifier=Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.size(150.dp).border(border = BorderStroke(5.dp, Color.Magenta), CircleShape).clip(
            CircleShape)
    )

}

@Composable
fun HeaderSection(modfiier: Modifier = Modifier)
{
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modfiier){
        Text(text = "Alek Lyskawa", fontSize = 22.sp)
        Text(text = "Student", fontSize = 16.sp, fontStyle = FontStyle.Italic, color = Color.Gray)

    }
}

@Composable
fun Dividier(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Black)
            .border(BorderStroke(width = 1.dp, color = Color.Gray))
    ) {

    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxWidth().padding(16.dp)){
        Row(modifier = modifier.fillMaxWidth().padding(16.dp)){
            Icon(Icons.Rounded.Call, contentDescription = null)
            Text(text = "+48 881 385 039", modifier = modifier.padding(start = 10.dp))
        }
        Row(modifier = modifier.fillMaxWidth().padding(16.dp)){
            Icon(Icons.Rounded.Email, contentDescription = null)
            Text(text = "alek.lyskawa@gmail.com", modifier = modifier.padding(start = 10.dp))
        }
        Row(modifier = modifier.fillMaxWidth().padding(16.dp)){
            Icon(Icons.Rounded.LocationOn, contentDescription = null)
            Text(text = "Wroclaw, Poland", modifier = modifier.padding(start = 10.dp))
        }

    }
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxHeight().wrapContentSize()
    ){
        Button(
            modifier = modifier.size(200.dp, 50.dp).padding(2.dp),
            onClick = {},
            shape = RoundedCornerShape(percent = 16)
        ){
            Text(text = "More information", fontSize = 16.sp)
        }
        Button(
            modifier = modifier.size(200.dp, 50.dp).padding(2.dp),
            onClick = {},
            shape = RoundedCornerShape(percent = 16)
        ){
            Text(text = "My portfolio", fontSize = 16.sp)
        }


    }
}





@Preview(showBackground = true)
@Composable
fun MyAppPreview(){
    MyApp()
}






