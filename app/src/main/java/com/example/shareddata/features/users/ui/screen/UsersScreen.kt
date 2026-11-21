package com.example.shareddata.features.users.ui.screen

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shareddata.ui.theme.SharedDataTheme

data class UserData(
    val name: String,
    val old: String,
    val gender: String
)

@Composable
fun UsersScreen() {
   val listUser: List<UserData> = listOf(
       UserData(
           name = "Ricardo",
           old = "17",
           gender = "Masculino"
       ),
               UserData(
               name = "Rafael",
       old = "17",
       gender = "Masculino"
   )
   )
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(
            all = 30.dp
        )
    )  {

        item {
            Box(
                modifier = Modifier.fillMaxWidth().padding(
                    vertical = 30.dp
                ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        10.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier.size(13.dp),
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "Adicionar",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Text("Adicionar novo",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    )
                }
            }

        }

        items(listUser){
            Column(
                modifier = Modifier.padding(
                    vertical = 10.dp
                ).fillMaxWidth(),
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ){
                        Column(
                            modifier = Modifier.padding(
                                horizontal = 10.dp,
                                vertical = 5.dp
                            )
                        ) {
                            TitleAndSubTitle(
                                title = "Nome:",
                                subTitle = it.name
                            )

                            TitleAndSubTitle(
                                title = "Genero:",
                                subTitle = it.gender
                            )
                            TitleAndSubTitle(
                                title = "Idade:",
                                subTitle = it.old
                            )
                        }
                }

            }
        }

    }



}


@Composable
private fun TitleAndSubTitle(
    title: String,
    subTitle:String
) {
   Row(
       horizontalArrangement = Arrangement.spacedBy(
           10.dp
       )
   ) {
        Text(title,
            style = TextStyle(
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.tertiary,
            ))
        Text(subTitle, style = TextStyle(
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onSurface,
        ))
    }

}

@Composable
@Preview
fun UserScreenPreview() {
    SharedDataTheme {
        UsersScreen()
    }
}