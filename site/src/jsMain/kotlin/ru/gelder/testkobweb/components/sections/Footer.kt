package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import ru.gelder.testkobweb.SitePalette

val FooterSectionStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .backgroundColor(Color("#1e2329"))
        .color(Color.white)
        .padding(topBottom = 60.px, leftRight = 20.px)
}

val FooterContainerStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .maxWidth(1200.px)
        .margin(leftRight = 0.px)
}

val FooterColumnStyle = CssStyle.base {
    Modifier
        .margin(bottom = 30.px)
}

val FooterTitleStyle = CssStyle.base {
    Modifier
        .fontSize(20.px)
        .fontWeight(600)
        .margin(bottom = 20.px)
        .color(Color.white)
}

val FooterLinkStyle = CssStyle.base {
    Modifier
        .fontSize(16.px)
        .color(Color("#b3b3b3"))
        .margin(bottom = 12.px)
        .display(DisplayStyle.Block)
}

val FooterDescriptionStyle = CssStyle.base {
    Modifier
        .fontSize(14.px)
        .color(Color("#b3b3b3"))
        .lineHeight(1.6)
        .margin(bottom = 20.px)
}

val LicenseInfoStyle = CssStyle.base {
    Modifier
        .fontSize(14.px)
        .color(Color("#888"))
        .margin(bottom = 8.px)
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
}

val CopyrightStyle = CssStyle.base {
    Modifier
        .fontSize(14.px)
        .color(Color("#666"))
        .padding(top = 30.px)
}

@Composable
fun Footer() {
    Footer(attrs = FooterSectionStyle.toAttrs()) {
        Div(attrs = FooterContainerStyle.toAttrs()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                // Company Info
                Column(modifier = FooterColumnStyle.toModifier().weight(1)) {
                    Div(attrs = { style { display(DisplayStyle.Flex); alignItems(AlignItems.Center); marginBottom(20.px) } }) {
                        Div(attrs = {
                            style {
                                width(40.px); height(40.px); backgroundColor(SitePalette.theme.primary); borderRadius(8.px)
                                display(DisplayStyle.Flex); alignItems(AlignItems.Center); justifyContent(JustifyContent.Center)
                                fontSize(20.px); fontWeight(700); color(Color.white); marginRight(12.px)
                            }
                        }) {
                            Text("ГФ")
                        }
                        Column {
                            H4(attrs = { style { fontSize(20.px); fontWeight(600); color(Color.white); margin(0.px) } }) {
                                Text("ГельдерФинанс")
                            }
                            P(attrs = { style { fontSize(14.px); color(Color("#b3b3b3")); margin(0.px) } }) {
                                Text("Кредиты под залог")
                            }
                        }
                    }

                    P(attrs = FooterDescriptionStyle.toAttrs()) {
                        Text("ООО \"ГельдерФинанс\" — лицензированная финансовая организация, специализирующаяся на кредитовании под залог недвижимости и автомобилей.")
                    }

                    Div(attrs = LicenseInfoStyle.toAttrs()) {
                        Span(attrs = { style { marginRight(8.px); color(SitePalette.theme.primary) } }) { Text("🏛️") }
                        Text("Лицензия ЦБ РФ")
                    }
                }

                // Credit Types
                Column(modifier = FooterColumnStyle.toModifier().weight(1)) {
                    H4(attrs = FooterTitleStyle.toAttrs()) {
                        Text("Виды кредитов")
                    }
                    A(href = "#", attrs = FooterLinkStyle.toAttrs()) { Text("Под залог квартир") }
                    A(href = "#", attrs = FooterLinkStyle.toAttrs()) { Text("Под залог домов и коттеджей") }
                    A(href = "#", attrs = FooterLinkStyle.toAttrs()) { Text("Под залог коммерческой недвижимости") }
                    A(href = "#", attrs = FooterLinkStyle.toAttrs()) { Text("Под залог автомобилей") }
                    A(href = "#", attrs = FooterLinkStyle.toAttrs()) { Text("Под залог земельных участков") }
                    A(href = "#", attrs = FooterLinkStyle.toAttrs()) { Text("Рефинансирование кредитов") }
                }

                // Contacts
                Column(modifier = FooterColumnStyle.toModifier().weight(1)) {
                    H4(attrs = FooterTitleStyle.toAttrs()) {
                        Text("Контакты")
                    }
                    Div(attrs = { style { fontSize(16.px); color(Color("#b3b3b3")); marginBottom(16.px) } }) {
                        Div(attrs = { style { display(DisplayStyle.Flex); alignItems(AlignItems.Center); marginBottom(8.px) } }) {
                            Span(attrs = { style { marginRight(8.px); color(SitePalette.theme.primary) } }) { Text("📞") }
                            Span(attrs = { style { color(Color.white); fontWeight(600) } }) { Text("+7 (495) 777-88-99") }
                        }
                        Div(attrs = { style { fontSize(14.px); opacity(0.8) } }) {
                            Text("Горячая линия 24/7")
                        }
                    }

                    Div(attrs = { style { fontSize(16.px); color(Color("#b3b3b3")); marginBottom(16.px) } }) {
                        Div(attrs = { style { display(DisplayStyle.Flex); alignItems(AlignItems.Center); marginBottom(8.px) } }) {
                            Span(attrs = { style { marginRight(8.px); color(SitePalette.theme.primary) } }) { Text("📧") }
                            Span(attrs = { style { color(Color.white); fontWeight(600) } }) { Text("info@gelderfinance.ru") }
                        }
                        Div(attrs = { style { fontSize(14.px); opacity(0.8) } }) {
                            Text("Электронная почта")
                        }
                    }

                    Div(attrs = { style { fontSize(16.px); color(Color("#b3b3b3")); marginBottom(16.px) } }) {
                        Div(attrs = { style { display(DisplayStyle.Flex); alignItems(AlignItems.Center); marginBottom(8.px) } }) {
                            Span(attrs = { style { marginRight(8.px); color(SitePalette.theme.primary) } }) { Text("📍") }
                            Span(attrs = { style { color(Color.white); fontWeight(600) } }) { Text("Москва, Красная площадь, д. 1") }
                        }
                        Div(attrs = { style { fontSize(14.px); opacity(0.8) } }) {
                            Text("Главный офис")
                        }
                    }
                }

                // Legal Info
                Column(modifier = FooterColumnStyle.toModifier().weight(1)) {
                    H4(attrs = FooterTitleStyle.toAttrs()) {
                        Text("Правовая информация")
                    }
                    Div(attrs = { style { fontSize(14.px); color(Color("#b3b3b3")) } }) {
                        Div { Text("📋 15 лет на рынке") }
                        Div { Text("🏢 Работаем 24/7") }
                        Div { Text("ОГРН: 1234567890123") }
                        Div { Text("ИНН: 1234567890") }
                        Div { Text("Политика конфиденциальности") }
                        Div { Text("Пользовательское соглашение") }
                    }
                }
            }

            // Bottom Links
            Div(attrs = {
                style {
                    paddingTop(30.px)
                    display(DisplayStyle.Flex); justifyContent(JustifyContent.SpaceBetween)
                    alignItems(AlignItems.Center); gap(20.px)
                }
            }) {
                Row(
                    modifier = Modifier.gap(30.px),
                    horizontalArrangement = Arrangement.spacedBy(30.px)
                ) {
                    A(
                        href = "#",
                        attrs = { style { fontSize(14.px); color(Color("#888")) } }
                    ) { Text("Политика конфиденциальности") }
                    A(
                        href = "#",
                        attrs = { style { fontSize(14.px); color(Color("#888")) } }
                    ) { Text("Условия использования") }
                    A(
                        href = "#",
                        attrs = { style { fontSize(14.px); color(Color("#888")) } }
                    ) { Text("Карта сайта") }
                }
            }

            // Copyright
            Div(attrs = { style { textAlign("center"); paddingTop(30.px) } }) {
                P(attrs = { style { margin(0.px) } }) {
                    Text("© 2024 ООО \"ГельдерФинанс\". Все права защищены. Лицензия ЦБ РФ.")
                }
                P(attrs = { style { fontSize(12.px); color(Color("#555")); margin(5.px, 0.px, 0.px, 0.px) } }) {
                    Text("У кредитов имеются ограничения. Ознакомьтесь с условиями при оформлении. Возможно получение отказа по кредиту.")
                }
                P(attrs = { style { fontSize(12.px); color(Color("#555")); margin(5.px, 0.px, 0.px, 0.px) } }) {
                    Text("Кредит предоставляется гражданам РФ от 21 до 75 лет на основании залога недвижимости или автотранспорта. Процентная ставка от 1% в месяц. Возможна досрочная комиссия и платежи.")
                }
            }
        }
    }
}
