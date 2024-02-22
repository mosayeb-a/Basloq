import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ma.basloq.android.components.basloqRippleColor


@Composable
fun BasloqTextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
) {
        TextButton(
            onClick = { onClick() },
            shape = MaterialTheme.shapes.medium,
            modifier = modifier
                .basloqRippleColor(color = MaterialTheme.colorScheme.primary)
                .fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = text,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }


@Composable
fun BasloqButton(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
) {
        Button(
            modifier = modifier
                .basloqRippleColor(color = MaterialTheme.colorScheme.primary)
                .fillMaxWidth(),
            onClick = {
                onClick()
            },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp,
                pressedElevation = 0.dp,
            )
        ) {
            Text(
                text = text,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
}

