package com.HelpConnect.ysxsq

import HomeActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.HelpConnect.ysxsq.ui.theme.一双扶手之缘Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            一双扶手之缘Theme {
                // Call the top-level function
                SplashScreen()
                // 使用LaunchedEffect在页面加载后延迟跳转到HomeActivity
                LaunchedEffect(Unit) {
                    // 延迟3秒
                    delay(3000)
                    // 跳转到HomeActivity
                    startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                    // 关闭当前页面（可选）
                    finish()
                }
            }
        }
    }

    @Composable
    fun SplashScreen() {
        val coroutineScope = rememberCoroutineScope()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image with content description
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "重庆第一双语学校学生墙",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            // Text with the title
            Text(
                text = "重庆第一双语学校学生墙·扶手之缘",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}