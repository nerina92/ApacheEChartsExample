package com.apacheechartsexample

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
public fun kpiVentas(){
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        //Painter para imagen
        val painter = painterResource(id = R.drawable.arrow_circle_up)
        Column (modifier = Modifier.fillMaxWidth().background(Color.White)){
            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total de ventas",
                    color = Color(0xFFF37920),
                    fontSize = 18.sp,
                    style = TextStyle(fontWeight = FontWeight.SemiBold)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painter, contentDescription = "flecha arriba")
                    Text(
                        text = "% 15",
                        color = Color(0xFF34964F),
                        fontSize = 26.sp,
                        style = TextStyle(fontWeight = W700)
                    )
                }

            }
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                .padding(12.dp)
                .background(Color(0xFFF5F5F5))
                .fillMaxWidth()
                ) {
                Text(
                    text = "$157.2536",
                    color = Color(0xFF304891),
                    modifier = Modifier.padding(10.dp),
                    fontSize = 32.sp,
                    style = TextStyle(fontWeight = FontWeight.Medium)
                )
            }
            Row(
                modifier = Modifier.padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cantidad de TKT: ",
                    color = Color(0xFFF37920),
                    fontSize = 14.sp,
                    style = TextStyle(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = "7",
                    color = Color(0xFF7A7A7A),
                    fontSize = 14.sp,
                    style = TextStyle(fontWeight = FontWeight.Medium)
                )
            }
            Row (
                modifier = Modifier.padding( 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Promedio de ventas: ",
                    color = Color(0xFFF37920),
                    fontSize = 14.sp,
                    style = TextStyle(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = "$25.156",
                    color = Color(0xFF7A7A7A),
                    fontSize = 14.sp,
                    style = TextStyle(fontWeight = FontWeight.Medium)

                )
            }

        }
    }
}

@Preview (backgroundColor = 10, showBackground = true)
@Composable
private fun KpiVentasPreview() {
    kpiVentas()
}