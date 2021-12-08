package com.nana.composetest

import android.content.res.Configuration
import android.location.Criteria
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
                Conversation(SampleData.conversationSample)
            }
        }
    }
}

data class Message(val main : String, val sub : String)

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
            // 중간크기의 도형을 3dp의 그림자로 보여주겠다. , elevation : 그림자의 높이
            Surface(shape = MaterialTheme.shapes.medium, elevation = 3.dp) {
                Text(
                    text = msg.main,
                    color = MaterialTheme.colors.secondaryVariant,
                    // 글씨체
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.sub)
        }

    }
}

@Preview(name = "Light Mode", showBackground = true)
// 보이는 화면에서 darkmode 설정
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

// 여기가 미리보기!
// @Composable : 함수를 구성하게 하는 것, 이 어노테이션을 사용해야 함수를 불러오는게 가능해진다.
@Composable
fun previewMessage() {
    ComposeTestTheme {
        MessageCard(
            msg = Message("랄라", "뿜뿌")
        )
    }

}

@Composable
// Conversation : 여러메세지를 보여주는 함수
fun Conversation(messages : List<Message>) {
    LazyColumn {
        items(messages) {
                messages -> MessageCard(messages)
        }
    }
}


@Preview
@Composable
fun PreviewConversation() {
    // 기본테마를 적용시키고
    // Conversation 함수에 sampleData 넣어주기
    ComposeTestTheme {
        Conversation(SampleData.conversationSample)
    }
}
