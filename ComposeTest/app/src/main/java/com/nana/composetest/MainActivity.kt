package com.nana.composetest

import android.location.Criteria
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 시작할 때 보여줄 화면, 여기서 보여줄 함수를 정의할 수 있다.
        setContent {
            MessageCard(Message("랄라", "뿜뿌","히잉", "냠냠"))
        }
    }
}

data class Message(val main : String, val sub : String,
                   val main1 : String, val sub1 : String)

@Composable
fun MessageCard(msg : Message) {
    // 수평정렬
    // padding
    Row (modifier = Modifier.padding(all = 8.dp)){
        Image(
            // 이미지 파일 설정
            painter = painterResource(R.drawable.img),
            // 이미지 설명글? 시각장애인들을 위한 글
            // 이미지를 클릭하면 이 글이 읽힌다.
            // 근데 나는 안나옴;
            contentDescription = "냥냥냥냥",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // 수직정렬
        Column {
            Text(text = msg.main)
            Text(text = msg.sub)
            Spacer(modifier = Modifier.height(4.dp))

            Column {
                Text(text = msg.main1)
                Text(text = msg.sub1)
                Spacer(modifier = Modifier.height(4.dp))
            }

        }
    }
}

// 여기가 미리보기!
@Preview(showBackground = true)
@Composable
fun previewMessage() {
    MessageCard(
        msg = Message("랄라", "뿜뿌","히잉", "냠냠")

    )
}
