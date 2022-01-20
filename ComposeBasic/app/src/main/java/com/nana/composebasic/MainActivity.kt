package com.nana.composebasic

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nana.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}
//뷰
// scaffold 처럼 지원하는 것들을 가져와서 사용할 수 있음
@Composable
fun Greeting(name: String) {
    // Scaffold 마테리얼 디자인을 갖고 올 수 있다.
    Scaffold(topBar ={
        TopAppBar(title = { Text("TopAppbar")}
        , backgroundColor = Color.Cyan) },
    floatingActionButtonPosition = FabPosition.End,
    floatingActionButton = {
        FloatingActionButton(onClick = { Toast.LENGTH_LONG }) {
            Text("클릭")
        }
    }) {
//        Text(text = "Hello $name!")
        // MyComposableView() Greeting 안에 내가 만든 위젯(컴포즈)을 넣어주기
        MyComposableView()
    }
}

@Composable
fun MyRowItems(column: Unit) {
    Row(
        // Modifier padding, margin , bord 등 이렇게 주면 됨
        // width를 주면 Row로 했기 때문에 세로로 글씨들이 벌어지게 됨
        Modifier
            .padding(10.dp)
            .background(Color(0xffeaffd0))
                // 옆을 가득 채워주는 기능
            .fillMaxWidth(),
        // 그래비티와 같은 기능
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "나도 한다 compose", Modifier.padding(all = 10.dp))
        // Spacer 는 공간을 주는 것
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "나도 한다 compose2")
    }
}

@Composable
fun MyComposableView() {
    Log.d("TAG", "MyComposableView")
    // 함수를 사용했을 경우는 밑에 칼럼을 꼭 만들어주고 그 밑에 넣어줘야 문제가 발생하지 않는다.
    MyRowItems(
        Column {
            MyRowItems(Column {
                Row(
                    // Modifier padding, margin , bord 등 이렇게 주면 됨
                    // width를 주면 Row로 했기 때문에 세로로 글씨들이 벌어지게 됨
                    Modifier
                        .padding(10.dp)
                        .background(Color(0xffeaffd0)),
                    // 그래비티와 같은 기능
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "나도 한다 compose", Modifier.padding(all = 10.dp))
                    // Spacer 는 공간을 주는 것
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = "나도 한다 compose2")
                }
                Row(
                    // Modifier padding, margin , bord 등 이렇게 주면 됨
                    // width를 주면 Row로 했기 때문에 세로로 글씨들이 벌어지게 됨
                    Modifier
                        .padding(10.dp)
                        .background(Color(0xffeaffd0)),
                    // 그래비티와 같은 기능
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "나도 한다 compose", Modifier.padding(all = 10.dp))
                    // Spacer 는 공간을 주는 것
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = "나도 한다 compose2")
                }

            })
        }
    )
    }

    // 버티칼 리니어 레이아웃
//    Column() {
//        Row(
//            // Modifier padding, margin , bord 등 이렇게 주면 됨
//            // width를 주면 Row로 했기 때문에 세로로 글씨들이 벌어지게 됨
//            Modifier
//                .padding(10.dp)
//                .background(Color(0xffeaffd0)),
//            // 그래비티와 같은 기능
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "나도 한다 compose", Modifier.padding(all = 10.dp))
//            // Spacer 는 공간을 주는 것
//            Spacer(modifier = Modifier.size(10.dp))
//            Text(text = "나도 한다 compose2")
//        }
//        Row(
//            // Modifier padding, margin , bord 등 이렇게 주면 됨
//            // width를 주면 Row로 했기 때문에 세로로 글씨들이 벌어지게 됨
//            Modifier
//                .padding(10.dp)
//                .background(Color(0xffeaffd0)),
//            // 그래비티와 같은 기능
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "나도 한다 compose", Modifier.padding(all = 10.dp))
//            // Spacer 는 공간을 주는 것
//            Spacer(modifier = Modifier.size(10.dp))
//            Text(text = "나도 한다 compose2")
//        }
//
//    }


// 어느 클레스에서든 가져가서 볼 수 있음
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        Greeting("Android")
    }
}