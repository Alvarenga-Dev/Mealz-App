package com.alvarengadev.mealzapp.view

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.transform.CircleCropTransformation
import com.alvarengadev.mealzapp.data.resposes.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    var isExpanded by remember { mutableStateOf(false) } // create interaction, is a necessary use remember!!
    val imageSizeDp: Dp by animateDpAsState(
        targetValue = if (isExpanded) 200.dp else 100.dp
    )
    Column(modifier = Modifier.padding(16.dp)) {
        Row {
            SubcomposeAsyncImage(
                model = meal?.imageUrl,
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = null,
                modifier = Modifier
                    .size(imageSizeDp)
            )
            Text(
                text = meal?.name ?: "Default name",
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
        }
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { isExpanded = !isExpanded }
        ) {
            Text(text = "Change state of meal profile picture")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMealDetailsScreen() {
    MealDetailsScreen(meal = null)
}
