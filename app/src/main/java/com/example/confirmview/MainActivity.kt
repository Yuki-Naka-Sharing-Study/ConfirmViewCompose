package com.example.confirmview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    NoRecordImageView(
                        modifier = Modifier
                            .size(20.dp)
                            .aspectRatio(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun NoRecordImageView(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.music_note),
        contentDescription = "Description of the image",
        modifier = modifier
            .size(20.dp)
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