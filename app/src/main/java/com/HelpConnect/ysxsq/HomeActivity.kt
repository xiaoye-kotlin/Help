import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.HelpConnect.ysxsq.R
import androidx.compose.material3.Text
import com.HelpConnect.ysxsq.ui.theme.一双扶手之缘Theme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            一双扶手之缘Theme {
                // Call the top-level function
                HomeScreen()
            }
        }
    }

    // Move the Head() function outside of HomeActivity
    @Composable
    fun HomeScreen() {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Head()
            CreateAssistCodeInput()
            Spacer(modifier = Modifier.height(8.dp))
            CreateAssistKeyInput()
            Spacer(modifier = Modifier.height(8.dp))
            AssistButton(
                buttonText = "立即创建",
                onSuccess = {
                    // 显示创建成功提示
                    //Text(text = "创建成功")
                },
                onFailure = {
                    // 显示创建失败提示
                    //Text(text = "创建失败")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            FillAssistCodeInput()
            Spacer(modifier = Modifier.height(8.dp))
            FillAssistKeyInput()
            Spacer(modifier = Modifier.height(8.dp))
            AssistButton(
                buttonText = "立即救助",
                onSuccess = {
                    // 跳转到另一个界面
                },
                onFailure = {
                    // 显示救助失败提示
                    //Text(text = "救助失败")
                }
            )
        }
    }

    @Composable
    fun Head() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "重庆第一双语学校学生墙",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Text(text = "一双学生墙·扶手之缘：", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.width(8.dp))
            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(text = "请输入救助码or创建救助码", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }


    @Composable
    fun CreateAssistCodeInput() {
        Text(
            text = "创建一个救助码",
            style = MaterialTheme.typography.titleLarge
        )
        BasicTextField(
            value = TextFieldValue(""),
            onValueChange = { /*TODO*/ },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        )
    }

    @Composable
    fun CreateAssistKeyInput() {
        Text(
            text = "创建一个救助秘钥",
            style = MaterialTheme.typography.titleLarge
        )
        BasicTextField(
            value = TextFieldValue(""),
            onValueChange = { /*TODO*/ },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        )
    }

    @Composable
    fun AssistButton(buttonText: String, onSuccess: () -> Unit, onFailure: () -> Unit) {
        Button(
            onClick = {
                // 假设这里提交信息到网站并返回结果
                // 如果提交成功，调用onSuccess()函数，否则调用onFailure()函数
                val isSuccess = true // 假设提交成功
                if (isSuccess) {
                    onSuccess()
                } else {
                    onFailure()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

    @Composable
    fun FillAssistCodeInput() {
        Text(
            text = "填写一个救助码",
            style = MaterialTheme.typography.titleLarge
        )
        BasicTextField(
            value = TextFieldValue(""),
            onValueChange = { /*TODO*/ },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        )
    }

    @Composable
    fun FillAssistKeyInput() {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "填写一个救助码",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "粘贴",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
        BasicTextField(
            value = TextFieldValue(""),
            onValueChange = { /*TODO*/ },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        )
    }
}