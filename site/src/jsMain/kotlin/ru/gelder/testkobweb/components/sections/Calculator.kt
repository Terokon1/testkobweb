package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import ru.gelder.testkobweb.SitePalette
import kotlin.math.pow

val CalculatorSectionStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .backgroundColor(Color("#f8f9fa"))
        .padding(topBottom = 80.px, leftRight = 20.px)
}

val CalculatorContainerStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .maxWidth(1200.px)
        .margin(leftRight = 0.px)
}

val CalculatorTitleStyle = CssStyle.base {
    Modifier
        .fontSize(36.px)
        .fontWeight(700)
        .color(Color("#1a1a1a"))
        .textAlign(TextAlign.Center)
        .margin(bottom = 16.px)
}

val CalculatorSubtitleStyle = CssStyle.base {
    Modifier
        .fontSize(18.px)
        .color(Color("#666"))
        .textAlign(TextAlign.Center)
        .margin(bottom = 40.px)
        .lineHeight(1.6)
}

val CalculatorFormStyle = CssStyle.base {
    Modifier
        .backgroundColor(Color.white)
        .padding(30.px)
        .borderRadius(16.px)
}

val CalculatorResultsStyle = CssStyle.base {
    Modifier
        .backgroundColor(SitePalette.theme.primary)
        .padding(30.px)
        .borderRadius(16.px)
        .color(Color.white)
}

val FormGroupStyle = CssStyle.base {
    Modifier
        .margin(bottom = 20.px)
}

val LabelStyle = CssStyle.base {
    Modifier
        .fontSize(16.px)
        .fontWeight(600)
        .color(Color("#333"))
        .margin(bottom = 8.px)
        .display(DisplayStyle.Block)
}

val InputStyle = CssStyle.base {
    Modifier
        .width(100.percent)
        .padding(12.px, 16.px)
        .border(1.px, LineStyle.Solid, Color("#ddd"))
        .borderRadius(8.px)
        .fontSize(16.px)
        .backgroundColor(Color("#f8f9fa"))
}

val ResultItemStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.SpaceBetween)
        .margin(bottom = 12.px)
        .fontSize(16.px)
}

val ResultValueStyle = CssStyle.base {
    Modifier
        .fontSize(18.px)
        .fontWeight(600)
}

val HighlightBoxStyle = CssStyle.base {
    Modifier
        .backgroundColor(rgba(255, 255, 255, 0.1))
        .padding(20.px)
        .borderRadius(12.px)
        .margin(topBottom = 20.px)
}

@Composable
fun Calculator() {
    var propertyValue by remember { mutableStateOf(5000000.0) }
    var loanPercent by remember { mutableStateOf(60.0) }
    var interestRate by remember { mutableStateOf(12.0) }
    var loanTerm by remember { mutableStateOf(36) }

    val loanAmount = propertyValue * (loanPercent / 100)
    val monthlyRate = interestRate / 100 / 12
    val monthlyPayment = if (monthlyRate > 0) {
        loanAmount * (monthlyRate * (1 + monthlyRate).pow(loanTerm) / ((1 + monthlyRate).pow(loanTerm) - 1))
    } else loanAmount / loanTerm
    val totalAmount = monthlyPayment * loanTerm
    val overpayment = totalAmount - loanAmount

    fun formatNumber(value: Double): String {
        return when {
            value >= 1000000 -> "${(value / 1000000).toInt()}.${((value % 1000000) / 1000).toInt()}K"
            value >= 1000 -> "${(value / 1000).toInt()}K"
            else -> "${value.toInt()}"
        }
    }

    Section(attrs = CalculatorSectionStyle.toAttrs()) {
        Div(attrs = CalculatorContainerStyle.toAttrs()) {
            H2(attrs = CalculatorTitleStyle.toAttrs()) {
                Text("Калькулятор кредита")
            }
            P(attrs = CalculatorSubtitleStyle.toAttrs()) {
                Text("Рассчитайте приблизительные условия кредита под залог вашего имущества. Получите предварительную оценку ежемесячного платежа и суммы кредита.")
            }

            Row(
                modifier = Modifier.fillMaxWidth().gap(30.px),
                horizontalArrangement = Arrangement.spacedBy(30.px)
            ) {
                // Form
                Column(modifier = CalculatorFormStyle.toModifier().weight(1)) {
                    H3(attrs = { style { fontSize(20.px); fontWeight(600); marginBottom(20.px) } }) {
                        Text("📋 Параметры кредита")
                    }
                    P(attrs = { style { fontSize(14.px); color(Color("#666")); marginBottom(20.px) } }) {
                        Text("Укажите параметры для расчёта условий кредитования")
                    }

                    Div(attrs = FormGroupStyle.toAttrs()) {
                        Label(attrs = LabelStyle.toAttrs()) { Text("Тип залогового имущества") }
                        Select(attrs = InputStyle.toAttrs()) {
                            Option(value = "apartment") { Text("Квартира (ставка от 12%)") }
                            Option(value = "house") { Text("Дом (ставка от 13%)") }
                            Option(value = "commercial") { Text("Коммерческая недвижимость (ставка от 14%)") }
                            Option(value = "car") { Text("Автомобиль (ставка от 15%)") }
                            Option(value = "land") { Text("Земельный участок (ставка от 16%)") }
                        }
                    }

                    Div(attrs = FormGroupStyle.toAttrs()) {
                        Label(attrs = LabelStyle.toAttrs()) {
                            Text("Стоимость имущества: ${formatNumber(propertyValue)} ₽")
                        }
                        Input(
                            type = InputType.Number,
                            attrs = InputStyle.toAttrs {
                                value(propertyValue.toString())
                                onInput { event ->
                                    val target = event.target as org.w3c.dom.HTMLInputElement
                                    propertyValue = target.value.toDoubleOrNull() ?: propertyValue
                                }
                            }
                        )
                    }

                    Div(attrs = FormGroupStyle.toAttrs()) {
                        Label(attrs = LabelStyle.toAttrs()) {
                            Text("Процент от стоимости: ${loanPercent.toInt()}% (макс. 70%)")
                        }
                        Input(
                            type = InputType.Range,
                            attrs = {
                                value(loanPercent.toString())
                                attr("min", "10")
                                attr("max", "70")
                                attr("step", "5")
                                onInput { event ->
                                    val target = event.target as org.w3c.dom.HTMLInputElement
                                    loanPercent = target.value.toDoubleOrNull() ?: loanPercent
                                }
                            }
                        )
                        Div(attrs = {
                            style {
                                display(DisplayStyle.Flex); justifyContent(JustifyContent.SpaceBetween); fontSize(
                                12.px
                            ); color(Color("#999"))
                            }
                        }) {
                            Span { Text("10%") }
                            Span { Text("70%") }
                        }
                    }

                    Div(attrs = FormGroupStyle.toAttrs()) {
                        Label(attrs = LabelStyle.toAttrs()) {
                            Text("Процентная ставка: ${interestRate.toInt()}% годовых")
                        }
                        Input(
                            type = InputType.Range,
                            attrs = {
                                value(interestRate.toString())
                                attr("min", "12")
                                attr("max", "25")
                                attr("step", "1")
                                onInput { event ->
                                    val target = event.target as org.w3c.dom.HTMLInputElement
                                    interestRate = target.value.toDoubleOrNull() ?: interestRate
                                }
                            }
                        )
                        Div(attrs = {
                            style {
                                display(DisplayStyle.Flex); justifyContent(JustifyContent.SpaceBetween); fontSize(
                                12.px
                            ); color(Color("#999"))
                            }
                        }) {
                            Span { Text("12%") }
                            Span { Text("25%") }
                        }
                    }

                    Div(attrs = FormGroupStyle.toAttrs()) {
                        Label(attrs = LabelStyle.toAttrs()) {
                            Text("Срок кредита: ${loanTerm} мес. (${loanTerm / 12} лет)")
                        }
                        Input(
                            type = InputType.Range,
                            attrs = {
                                value(loanTerm.toString())
                                attr("min", "6")
                                attr("max", "120")
                                attr("step", "6")
                                onInput { event ->
                                    val target = event.target as org.w3c.dom.HTMLInputElement
                                    loanTerm = target.value.toIntOrNull() ?: loanTerm
                                }
                            }
                        )
                        Div(attrs = {
                            style {
                                display(DisplayStyle.Flex); justifyContent(JustifyContent.SpaceBetween); fontSize(
                                12.px
                            ); color(Color("#999"))
                            }
                        }) {
                            Span { Text("6 мес.") }
                            Span { Text("120 мес.") }
                        }
                    }
                }

                // Results
                Column(modifier = CalculatorResultsStyle.toModifier().weight(1)) {
                    H3(attrs = { style { fontSize(20.px); fontWeight(600); marginBottom(20.px) } }) {
                        Text("📊 Результаты расчета")
                    }

                    Div(attrs = HighlightBoxStyle.toAttrs()) {
                        Div(attrs = ResultItemStyle.toAttrs()) {
                            Text("Сумма кредита")
                            Span(attrs = ResultValueStyle.toAttrs()) { Text("${formatNumber(loanAmount)} ₽") }
                        }
                        Div(attrs = ResultItemStyle.toAttrs()) {
                            Text("Ежемесячный платеж")
                            Span(attrs = ResultValueStyle.toAttrs()) { Text("${formatNumber(monthlyPayment)} ₽") }
                        }
                    }

                    Div(attrs = ResultItemStyle.toAttrs()) {
                        Text("Общая сумма к выплате")
                        Text("${formatNumber(totalAmount)} ₽")
                    }
                    Div(attrs = ResultItemStyle.toAttrs()) {
                        Text("Переплата")
                        Text("${formatNumber(overpayment)} ₽")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth().margin(top = 30.px),
                        horizontalArrangement = Arrangement.spacedBy(20.px)
                    ) {
                        Column(
                            modifier = Modifier.textAlign(TextAlign.Center).padding(20.px)
                                .backgroundColor(rgba(255, 255, 255, 0.1)).borderRadius(12.px),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Div(attrs = { style { fontSize(32.px); marginBottom(8.px) } }) { Text("📅") }
                            Div(attrs = { style { fontSize(24.px); fontWeight(600) } }) { Text("${loanTerm / 12}") }
                            Div(attrs = { style { fontSize(14.px); opacity(0.8) } }) { Text("лет") }
                        }
                        Column(
                            modifier = Modifier.textAlign(TextAlign.Center).padding(20.px)
                                .backgroundColor(rgba(255, 255, 255, 0.1)).borderRadius(12.px),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Div(attrs = { style { fontSize(32.px); marginBottom(8.px) } }) { Text("💸") }
                            Div(attrs = { style { fontSize(24.px); fontWeight(600) } }) { Text("${interestRate.toInt()}%") }
                            Div(attrs = { style { fontSize(14.px); opacity(0.8) } }) { Text("ставка") }
                        }
                    }

                    Div(attrs = {
                        style {
                            marginTop(30.px); padding(20.px); backgroundColor(
                            rgba(
                                255,
                                255,
                                255,
                                0.1
                            )
                        ); borderRadius(12.px)
                        }
                    }) {
                        H4(attrs = { style { fontSize(16.px); fontWeight(600); marginBottom(10.px) } }) {
                            Text("Важная информация")
                        }
                        Ul(attrs = { style { fontSize(14.px); opacity(0.9) } }) {
                            Li { Text("Расчет носит предварительный характер") }
                            Li { Text("Итоговые условия зависят от оценки залога") }
                            Li { Text("Возможны дополнительные комиссии") }
                            Li { Text("Требуется индивидуальное рассмотрение") }
                        }
                    }

                    Button(
                        onClick = { /* Scroll to application */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .margin(top = 20.px)
                            .backgroundColor(Color.white)
                            .color(SitePalette.theme.primary)
                            .padding(16.px)
                            .borderRadius(8.px)
                            .fontSize(16.px)
                            .fontWeight(600)
                    ) {
                        Text("Подать заявку с этими параметрами")
                    }

                    Button(
                        onClick = { /* Get consultation */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .margin(top = 12.px)
                            .backgroundColor(rgba(255, 255, 255, 0.1))
                            .color(Color.white)
                            .padding(16.px)
                            .borderRadius(8.px)
                            .fontSize(16.px)
                            .fontWeight(500)
                            .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.3))
                    ) {
                        Text("Получить консультацию")
                    }
                }
            }
        }
    }
}