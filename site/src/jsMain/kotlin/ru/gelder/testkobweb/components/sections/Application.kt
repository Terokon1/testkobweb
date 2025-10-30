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
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import ru.gelder.testkobweb.SitePalette

val ApplicationSectionStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .backgroundColor(Color("#f8f9fa"))
        .padding(topBottom = 80.px, leftRight = 20.px)
}

val ApplicationContainerStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .maxWidth(1200.px)
        .margin(leftRight = 0.px)
}

val ApplicationTitleStyle = CssStyle.base {
    Modifier
        .fontSize(36.px)
        .fontWeight(700)
        .color(Color("#1a1a1a"))
        .textAlign(TextAlign.Center)
        .margin(bottom = 16.px)
}

val ApplicationSubtitleStyle = CssStyle.base {
    Modifier
        .fontSize(18.px)
        .color(Color("#666"))
        .textAlign(TextAlign.Center)
        .margin(bottom = 40.px)
        .lineHeight(1.6)
}

val ApplicationFormStyle = CssStyle.base {
    Modifier
        .backgroundColor(Color.white)
        .padding(40.px)
        .borderRadius(16.px)
        .margin(bottom = 30.px)
}

val StepsStyle = CssStyle.base {
    Modifier
        .backgroundColor(SitePalette.theme.primary)
        .padding(40.px)
        .borderRadius(16.px)
        .color(Color.white)
}

val AppFormGroupStyle = CssStyle.base {
    Modifier
        .margin(bottom = 20.px)
}

val AppLabelStyle = CssStyle.base {
    Modifier
        .fontSize(16.px)
        .fontWeight(600)
        .color(Color("#333"))
        .margin(bottom = 8.px)
        .display(DisplayStyle.Block)
}

val AppInputStyle = CssStyle.base {
    Modifier
        .width(100.percent)
        .padding(12.px, 16.px)
        .border(1.px, LineStyle.Solid, Color("#ddd"))
        .borderRadius(8.px)
        .fontSize(16.px)
        .backgroundColor(Color("#f8f9fa"))
}

@Composable
fun Application() {
    Section(attrs = ApplicationSectionStyle.toAttrs()) {
        Div(attrs = ApplicationContainerStyle.toAttrs()) {
            H2(attrs = ApplicationTitleStyle.toAttrs()) {
                Text("Подать заявку на кредит под залог")
            }
            P(attrs = ApplicationSubtitleStyle.toAttrs()) {
                Text("Заполните форму и получите предварительное решение в течение 30 минут. Все данные конфиденциальны и защищены согласно 152-ФЗ \"О персональных данных\".")
            }

            Row(
                modifier = Modifier.fillMaxWidth().gap(30.px),
                horizontalArrangement = Arrangement.spacedBy(30.px)
            ) {
                // Form
                Column(modifier = ApplicationFormStyle.toModifier().weight(1)) {
                    H3(attrs = { style { fontSize(20.px); fontWeight(600); marginBottom(20.px) } }) {
                        Text("✈️ Заявка на кредит")
                    }
                    P(attrs = { style { fontSize(14.px); color(Color("#666")); marginBottom(20.px) } }) {
                        Text("Заполните все обязательные поля для быстрого рассмотрения заявки")
                    }

                    // Form fields using basic HTML
                    Div(attrs = AppFormGroupStyle.toAttrs()) {
                        Label(attrs = AppLabelStyle.toAttrs()) { Text("Ваше имя *") }
                        Input(
                            type = InputType.Text,
                            attrs = AppInputStyle.toAttrs {
                                placeholder("Иван Иванов")
                            }
                        )
                    }

                    Div(attrs = AppFormGroupStyle.toAttrs()) {
                        Label(attrs = AppLabelStyle.toAttrs()) { Text("Телефон *") }
                        Input(
                            type = InputType.Tel,
                            attrs = AppInputStyle.toAttrs {
                                placeholder("+7 (999) 123-45-67")
                            }
                        )
                    }

                    Div(attrs = AppFormGroupStyle.toAttrs()) {
                        Label(attrs = AppLabelStyle.toAttrs()) { Text("Email") }
                        Input(
                            type = InputType.Email,
                            attrs = AppInputStyle.toAttrs {
                                placeholder("ivan@example.com")
                            }
                        )
                    }

                    Div(attrs = AppFormGroupStyle.toAttrs()) {
                        Label(attrs = AppLabelStyle.toAttrs()) { Text("Тип залогового имущества *") }
                        Select(attrs = AppInputStyle.toAttrs()) {
                            Option(value = "") { Text("Выберите тип имущества") }
                            Option(value = "apartment") { Text("Квартира") }
                            Option(value = "house") { Text("Дом") }
                            Option(value = "commercial") { Text("Коммерческая недвижимость") }
                            Option(value = "car") { Text("Автомобиль") }
                            Option(value = "land") { Text("Земельный участок") }
                        }
                    }

                    Div(attrs = AppFormGroupStyle.toAttrs()) {
                        Label(attrs = AppLabelStyle.toAttrs()) { Text("Стоимость залога") }
                        Input(
                            type = InputType.Text,
                            attrs = AppInputStyle.toAttrs {
                                placeholder("3 000 000 ₽")
                            }
                        )
                    }

                    Div(attrs = AppFormGroupStyle.toAttrs()) {
                        Label(attrs = AppLabelStyle.toAttrs()) { Text("Желаемая сумма кредита") }
                        Input(
                            type = InputType.Text,
                            attrs = AppInputStyle.toAttrs {
                                placeholder("2 000 000 ₽")
                            }
                        )
                    }

                    Div(attrs = AppFormGroupStyle.toAttrs()) {
                        Label(attrs = AppLabelStyle.toAttrs()) { Text("Дополнительная информация") }
                        TextArea(
                            attrs = AppInputStyle.toAttrs {
                                attr("rows", "4")
                                placeholder("Расскажите о цели кредита, особенностях имущества, желаемом сроке кредита и других важных деталях")
                            }
                        )
                    }

                    Div(attrs = { style { margin(20.px, 0.px) } }) {
                        Label(attrs = {
                            style {
                                display(DisplayStyle.Flex); alignItems(AlignItems.Center); fontSize(14.px); color(
                                Color("#666")
                            )
                            }
                        }) {
                            Input(
                                type = InputType.Checkbox,
                                attrs = { style { marginRight(8.px) } }
                            )
                            Text("Я согласен на обработку персональных данных в соответствии с 152-ФЗ и принимаю условия предоставления кредитных услуг *")
                        }
                    }

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .backgroundColor(SitePalette.theme.primary)
                            .color(Color.white)
                            .padding(16.px)
                            .borderRadius(8.px)
                            .fontSize(16.px)
                            .fontWeight(600)
                    ) {
                        Text("Отправить заявку ✓")
                    }

                    P(attrs = { style { fontSize(12.px); color(Color("#999")); textAlign("center"); marginTop(10.px) } }) {
                        Text("* Обязательные поля для заполнения")
                    }
                }

                // Steps and Contact
                Column(modifier = StepsStyle.toModifier().weight(1)) {
                    H3(attrs = { style { fontSize(20.px); fontWeight(600); marginBottom(30.px) } }) {
                        Text("Этапы получения кредита")
                    }

                    Div(attrs = { style { display(DisplayStyle.Flex); alignItems(AlignItems.FlexStart); marginBottom(30.px) } }) {
                        Div(attrs = {
                            style {
                                width(32.px); height(32.px); backgroundColor(
                                rgba(
                                    255,
                                    255,
                                    255,
                                    0.2
                                )
                            ); borderRadius(50.percent)
                                display(DisplayStyle.Flex); alignItems(AlignItems.Center); justifyContent(JustifyContent.Center)
                                fontSize(16.px); fontWeight(600); marginRight(16.px); flexShrink(0)
                            }
                        }) { Text("1") }
                        Column {
                            H4(attrs = { style { fontSize(16.px); fontWeight(600); marginBottom(8.px) } }) {
                                Text("Обработка заявки (30 минут)")
                            }
                            P(attrs = { style { fontSize(14.px); opacity(0.9) } }) {
                                Text("Наш специалист свяжется с вами для уточнения деталей и предварительной оценки")
                            }
                        }
                    }

                    Div(attrs = { style { display(DisplayStyle.Flex); alignItems(AlignItems.FlexStart); marginBottom(30.px) } }) {
                        Div(attrs = {
                            style {
                                width(32.px); height(32.px); backgroundColor(
                                rgba(
                                    255,
                                    255,
                                    255,
                                    0.2
                                )
                            ); borderRadius(50.percent)
                                display(DisplayStyle.Flex); alignItems(AlignItems.Center); justifyContent(JustifyContent.Center)
                                fontSize(16.px); fontWeight(600); marginRight(16.px); flexShrink(0)
                            }
                        }) { Text("2") }
                        Column {
                            H4(attrs = { style { fontSize(16.px); fontWeight(600); marginBottom(8.px) } }) {
                                Text("Оценка имущества (1 день)")
                            }
                            P(attrs = { style { fontSize(14.px); opacity(0.9) } }) {
                                Text("Независимый оценщик проведет оценку залогового имущества за наш счет")
                            }
                        }
                    }

                    Div(attrs = { style { display(DisplayStyle.Flex); alignItems(AlignItems.FlexStart); marginBottom(30.px) } }) {
                        Div(attrs = {
                            style {
                                width(32.px); height(32.px); backgroundColor(
                                rgba(
                                    255,
                                    255,
                                    255,
                                    0.2
                                )
                            ); borderRadius(50.percent)
                                display(DisplayStyle.Flex); alignItems(AlignItems.Center); justifyContent(JustifyContent.Center)
                                fontSize(16.px); fontWeight(600); marginRight(16.px); flexShrink(0)
                            }
                        }) { Text("3") }
                        Column {
                            H4(attrs = { style { fontSize(16.px); fontWeight(600); marginBottom(8.px) } }) {
                                Text("Принятие решения (1 день)")
                            }
                            P(attrs = { style { fontSize(14.px); opacity(0.9) } }) {
                                Text("Окончательное решение и расчет индивидуальных условий кредитования")
                            }
                        }
                    }

                    Div(attrs = { style { display(DisplayStyle.Flex); alignItems(AlignItems.FlexStart); marginBottom(30.px) } }) {
                        Div(attrs = {
                            style {
                                width(32.px); height(32.px); backgroundColor(
                                rgba(
                                    255,
                                    255,
                                    255,
                                    0.2
                                )
                            ); borderRadius(50.percent)
                                display(DisplayStyle.Flex); alignItems(AlignItems.Center); justifyContent(JustifyContent.Center)
                                fontSize(16.px); fontWeight(600); marginRight(16.px); flexShrink(0)
                            }
                        }) { Text("4") }
                        Column {
                            H4(attrs = { style { fontSize(16.px); fontWeight(600); marginBottom(8.px) } }) {
                                Text("Получение денег (в день подписания)")
                            }
                            P(attrs = { style { fontSize(14.px); opacity(0.9) } }) {
                                Text("Подписание договора, регистрация залога и выдача денежных средств")
                            }
                        }
                    }

                    Div(attrs = {
                        style {
                            marginTop(40.px); padding(20.px); backgroundColor(
                            rgba(
                                255,
                                255,
                                255,
                                0.1
                            )
                        ); borderRadius(12.px)
                        }
                    }) {
                        H4(attrs = { style { fontSize(18.px); fontWeight(600); marginBottom(20.px) } }) {
                            Text("Наши контакты")
                        }

                        Div(attrs = {
                            style {
                                display(DisplayStyle.Flex); alignItems(AlignItems.Center); marginBottom(16.px); fontSize(
                                16.px
                            )
                            }
                        }) {
                            Span(attrs = { style { width(24.px); height(24.px); marginRight(12.px) } }) { Text("📞") }
                            Column {
                                Text("+7 (495) 777-88-99")
                                Div(attrs = { style { fontSize(12.px); opacity(0.8) } }) {
                                    Text("Круглосуточно, без выходных")
                                }
                            }
                        }

                        Div(attrs = {
                            style {
                                display(DisplayStyle.Flex); alignItems(AlignItems.Center); marginBottom(16.px); fontSize(
                                16.px
                            )
                            }
                        }) {
                            Span(attrs = { style { width(24.px); height(24.px); marginRight(12.px) } }) { Text("📧") }
                            Column {
                                Text("info@gelderfinance.ru")
                                Div(attrs = { style { fontSize(12.px); opacity(0.8) } }) {
                                    Text("Ответ в течение 1 часа")
                                }
                            }
                        }

                        Div(attrs = {
                            style {
                                display(DisplayStyle.Flex); alignItems(AlignItems.Center); marginBottom(16.px); fontSize(
                                16.px
                            )
                            }
                        }) {
                            Span(attrs = { style { width(24.px); height(24.px); marginRight(12.px) } }) { Text("📍") }
                            Column {
                                Text("Москва, Красная площадь, д. 1")
                                Div(attrs = { style { fontSize(12.px); opacity(0.8) } }) {
                                    Text("Офис открыт с 9:00 до 21:00")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}