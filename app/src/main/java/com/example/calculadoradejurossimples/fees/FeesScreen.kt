package com.example.calculadoradejurossimples.fees

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoradejurossimples.CaixaDeEntrada
import com.example.calculadoradejurossimples.ResultCard

@Composable
fun FeesScreen(feesScreenViewModel: FeesScreenViewModel) {

    val capital by feesScreenViewModel.capital.observeAsState(initial = "")
    val rate by feesScreenViewModel.rate.observeAsState(initial = "")
    val time by feesScreenViewModel.time.observeAsState(initial = "")
    val fees by feesScreenViewModel.fees.observeAsState(initial = 0.0)
    val amount by feesScreenViewModel.amount.observeAsState(initial = 0.0)

    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(
                text = "Cálculo de Juros Simples",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Formulário para entrada de dados
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Dados do Investimento",
                        fontWeight = FontWeight.Bold
                    )
                    CaixaDeEntrada(
                        label = "Valor do investimento",
                        placeholder = "Quanto deseja investir?",
                        value = capital,
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        atualizarValor = {
                            feesScreenViewModel.onCapitalChanged(it)
                        }
                    )
                    CaixaDeEntrada(
                        label = "Taxa de juros mensal",
                        placeholder = "Qual a taxa de juros mensal?",
                        value = rate,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        atualizarValor = {
                            feesScreenViewModel.onRateChanged(it)
                        }
                    )
                    CaixaDeEntrada(
                        label = "Período em meses",
                        placeholder = "Qual o tempo em meses?",
                        value = time,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        atualizarValor = {
                            feesScreenViewModel.onTimeChanged(it)
                        }
                    )
                    Button(
                        onClick = {
                            feesScreenViewModel.calculateFeesViewModel()
                            feesScreenViewModel.calculateAmountViewModel()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                    ) {
                        Text(text = "CALCULAR")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Resultado da aplicação
            ResultCard(juros = fees, montante = amount)
        }
    }
}