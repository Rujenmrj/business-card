package com.rujenm.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rujenm.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Main()
            }
        }
    }
}
@Composable
private fun Main() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ProfileContainer()
        ProfileName()
        IconWithText(
            icon = Icons.Outlined.LocationOn,
            text = stringResource(R.string.country),
            color = Color(0xFF006167)
        )
        Space(
            size =50.dp
        )
        SizableImage(img = painterResource(R.drawable.frame))
        Space(
            size = 40.dp
        )
        IconWithText(
            icon = Icons.Outlined.Phone,
            text = stringResource(R.string.PhonrNumber)
        )
        Space()
        IconWithText(
            icon = Icons.Outlined.Email,
            text = stringResource(R.string.email)
        )
        Space()
        IconWithText(
            alt = painterResource(R.drawable.github),
            text = stringResource(R.string.github)
        )
    }
}

@Composable
fun Space(size: Dp = 10.dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun IconWithText(icon: ImageVector?=null,alt:Painter?=null , text: String,color: Color = Color.Black) {
    Row {
        if (icon == null){
            Icon(
                painter =alt!!,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(24.dp)
            )
        }
        else
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color
            )

        Space(
            size=20.dp
        )
        Text(
            text = text,
            color = color
        )
    }
}
// Background with curved bottom shape
@Composable
fun CurvedBottomBackground() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(CurvedBottomShape())
            .background(Color(0xFF004E91)) // Use your preferred color
    )
}

//Profile Container
@Composable
fun ProfileContainer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f),

        contentAlignment = Alignment.TopCenter
    ) {
        CurvedBottomBackground()
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .background(Color.Blue)
                .align(Alignment.BottomCenter)

        ) {
            SizableImage(
                modifier = Modifier.fillMaxSize(1f),
                size = 200.dp,
                img = painterResource(R.drawable.profile)
            )
        }
    }
}


//Image placer
@Composable
fun SizableImage(modifier: Modifier = Modifier,img:Painter,size: Dp =200.dp) {
    Image(
        painter = img,
        contentDescription = null,
        modifier = modifier.size(size),
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun ProfileName() {
    Text(
        text = stringResource(R.string.name),
        modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}




@Preview(showBackground = false, showSystemUi = true)
@Composable
fun FullPreview() {
    BusinessCardTheme {
        Main()
    }
}

@Preview(showBackground = false)
@Composable
fun UnitPreview() {
    BusinessCardTheme {
        IconWithText(
            icon = Icons.Outlined.LocationOn,
            text = "Nepal",
            color = Color.Red
        )
    }
}