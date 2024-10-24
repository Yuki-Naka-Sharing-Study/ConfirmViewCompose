package com.example.confirmview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.confirmview.ui.theme.ConfirmViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfirmViewTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            SearchScreen()

//                            NoRecordImageView()
//                            NoRecordText()
//                            NoRecordDescriptionText()
                        }
                    }
                }
            }
        }
    }
}

// 以下は「記録無し」のコード

@Composable
fun NoRecordImageView(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.music_note),
        contentDescription = "Description of the image",
        modifier = modifier
            .size(200.dp)
            .aspectRatio(1f)
    )
}

@Preview(showBackground = true)
@Composable
fun NoRecordImageViewPreview() {
    ConfirmViewTheme {
        NoRecordImageView(modifier = Modifier)
    }
}



@Composable
fun NoRecordText(modifier: Modifier = Modifier) {
    Text(
        text = "記録無し",
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun NoRecordTextPreview() {
    ConfirmViewTheme {
        NoRecordText()
    }
}



@Composable
fun NoRecordDescriptionText(modifier: Modifier = Modifier) {
    Text(
        text = "まだ何も記録されていません。",
        fontWeight = FontWeight.Light,
        color = Color.LightGray
    )
}

@Preview(showBackground = true)
@Composable
fun NoRecordDescriptionTextPreview() {
    ConfirmViewTheme {
        NoRecordDescriptionText()
    }
}



// 以下は「記録あり」のコード

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    val modifier = Modifier
        .fillMaxWidth()
        .background(Color.Gray.copy(alpha = 0.1f), shape = RoundedCornerShape(12.dp))
        .padding(8.dp)

    Box(modifier = modifier) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = { Text("曲名・アーティスト名で検索") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search Icon")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SearchScreen() {
    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it }
        )
        // 検索結果を表示するためのUIをここに追加。
    }
}