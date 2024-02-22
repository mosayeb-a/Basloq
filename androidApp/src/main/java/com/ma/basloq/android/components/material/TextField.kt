import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import com.ma.basloq.android.theme.Gray80

@Composable
fun BasloqOutlineTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    errorMessage: String
) {
    val outlinedTextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
    )

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        singleLine = true,
        onValueChange = { onValueChange(it) },
        isError = isError,
        shape = MaterialTheme.shapes.medium,
        textStyle = MaterialTheme.typography.labelLarge,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Light,
                color = Gray80
            )
        },
        supportingText = {
            if (isError)
                Text(
                    // todo error input message
                    text = errorMessage,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Red
                )
        },
        visualTransformation = visualTransformation,
        colors = outlinedTextFieldColors
    )
}