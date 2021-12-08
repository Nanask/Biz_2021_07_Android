package com.nana.composetest

import android.content.res.Configuration
import android.location.Criteria
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nana.composetest.ui.theme.ComposeTestTheme

// 기본테마를 사용하여 머티리얼디자인 하기
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 시작할 때 보여줄 화면, 여기서 보여줄 함수를 정의할 수 있다.
        setContent {
            ComposeTestTheme {
                MessageCard(Message("랄라", "뿜뿌","히잉", "냠냠"))
            }
        }
    }
}

data class Message(val main : String, val sub : String,
                   val main1 : String, val sub1 : String)

@Composable
fun MessageCard(msg : Message) {

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                // 기본 테마로 설정되어있는 색상
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)

                )


        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.main,
                color = MaterialTheme.colors.secondaryVariant,
                // 글씨체
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.sub)
        }
        Column {
            Text(
                text = msg.main1,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.body2
            )

            Spacer(modifier = Modifier.height(4.dp))

            // 중간크기의 도형을 3dp의 그림자로 보여주겠다. , elevation : 그림자의 높이
            Surface(shape = MaterialTheme.shapes.medium, elevation = 3.dp) {

                Text(
                    text = msg.sub1

                )
            }

        }
    }
}

@Preview(name = "Light Mode")
// 보이는 화면에서 darkmode 설정
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

// 여기가 미리보기!
@Composable
fun previewMessage() {
    ComposeTestTheme {
        MessageCard(
            msg = Message("랄라", "뿜뿌","히잉", "냠냠")
        )
    }

}
