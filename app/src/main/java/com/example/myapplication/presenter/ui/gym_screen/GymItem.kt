package com.example.myapplication.presenter.ui.gym_screen

import android.content.Context

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import com.example.myapplication.domain.model.GymsResponseItem
import com.example.myapplication.utils.Utils


@Composable
fun GymItem(gym: GymsResponseItem, context: Context) {

    Card(

        elevation = 10.dp, shape = RoundedCornerShape(10.dp), modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()

            .padding(PaddingValues(8.dp))
    ) {
        Row() {
            Text(
                text = gym.id.toString(),
                modifier = Modifier
                    .padding(8.dp)
                    .align(alignment = Alignment.CenterVertically),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Right

            )
            Column() {
                Text(
                    text = gym.name,
                    modifier = Modifier.padding(4.dp),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start

                )

                Row {

                    Text(
                        text = gym.adress,
                        modifier = Modifier
                            .padding(4.dp)
                            .weight(1.0f),
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Start

                    )

                    OutlinedButton(onClick = {
                        Utils.shareToFaceBook(context, gym.location)

                    }) {
                        Text("Share")
                    }
                }
            }


        }

    }


}
