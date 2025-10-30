package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaTimes
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import ru.gelder.testkobweb.SitePalette

val NavHeaderStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .position(Position.Sticky)
        .top(0.px)
        .zIndex(99)
        .backgroundColor(Color.white)
        .boxShadow(0.px, 12.px, 32.px, Color.rgba(15, 23, 42, 0.08))
}

val HeaderContainerStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .maxWidth(1180.px)
        .margin(leftRight = auto)
        .padding(topBottom = 0.px, leftRight = 24.px)
}

val LogoContainerStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .gap(12.px)
}

val LogoIconStyle = CssStyle.base {
    Modifier
        .width(44.px)
        .height(44.px)
        .backgroundColor(SitePalette.theme.primary)
        .borderRadius(12.px)
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .justifyContent(JustifyContent.Center)
        .fontSize(18.px)
        .fontWeight(700)
        .color(Color.white)
}

val TitleStyle = CssStyle.base {
    Modifier
        .fontSize(20.px)
        .fontWeight(700)
        .color(SitePalette.theme.primary)
        .margin(0.px)
}

val DescriptionStyle = CssStyle.base {
    Modifier
        .fontSize(14.px)
        .color(Color("#666"))
        .margin(0.px)
}

val NavItemsStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .gap(2.cssRem)
        .alignItems(AlignItems.Center)
}

val NavItemStyle = CssStyle.base {
    Modifier
        .fontSize(16.px)
        .color(Color("#1f2937"))
        .fontWeight(500)
}

val NavActionsStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .gap(32.px)
        .alignItems(AlignItems.Center)
}

val ContactClusterStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .gap(18.px)
        .alignItems(AlignItems.Center)
}

val ContactItemStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .gap(10.px)
        .fontSize(15.px)
        .color(Color("#4b5563"))
}

val MobileMenuStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .backgroundColor(Color.white)
        .boxShadow(0.px, 16.px, 36.px, Color.rgba(15, 23, 42, 0.12))
        .borderRadius(bottomLeft = 20.px, bottomRight = 20.px)
        .padding(20.px)
        .gap(20.px)
}

val MobileContactInfoStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .flexDirection(FlexDirection.Column)
        .gap(12.px)
}

@Composable
fun NavHeader() {
    val breakpoint = rememberBreakpoint()
    val isMobile = breakpoint <= Breakpoint.SM

    var isMenuOpen by remember { mutableStateOf(false) }

    LaunchedEffect(breakpoint) {
        if (!isMobile) {
            isMenuOpen = false
        }
    }

    Column(NavHeaderStyle.toModifier(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            HeaderContainerStyle.toModifier(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(18.px)) {
                Div(attrs = LogoContainerStyle.toAttrs()) {
                    Div(attrs = LogoIconStyle.toAttrs()) {
                        Text("ГФ")
                    }
                    Column {
                        H1(attrs = TitleStyle.toAttrs()) { Text("ГельдерФинанс") }
                        P(attrs = DescriptionStyle.toAttrs()) { Text("Кредиты под залог") }
                    }
                }
            }

            if (!isMobile) {
                Row(
                    modifier = NavActionsStyle.toModifier(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Nav(attrs = NavItemsStyle.toAttrs()) {
                        A(href = "#hero", attrs = NavItemStyle.toAttrs()) { Text("О нас") }
                        A(href = "#calculator", attrs = NavItemStyle.toAttrs()) { Text("Калькулятор") }
                        A(href = "#application", attrs = NavItemStyle.toAttrs()) { Text("Заявка") }
                        A(href = "#footer", attrs = NavItemStyle.toAttrs()) { Text("Контакты") }
                    }

                    Row(
                        modifier = ContactClusterStyle.toModifier(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Div(attrs = ContactItemStyle.toAttrs()) {
                            Span(attrs = {
                                style {
                                    fontSize(18.px)
                                    color(SitePalette.theme.primary)
                                }
                            }) { Text("📞") }
                            A(href = "tel:+74957778899", attrs = {
                                style {
                                    color(Color("#1f2937"))
                                    textDecoration("none")
                                }
                            }) { Text("+7 (495) 777-88-99") }
                        }

                        Div(attrs = ContactItemStyle.toAttrs()) {
                            Span(attrs = {
                                style {
                                    fontSize(18.px)
                                    color(SitePalette.theme.primary)
                                }
                            }) { Text("📧") }
                            A(href = "mailto:info@gelderfinance.ru", attrs = {
                                style {
                                    color(Color("#1f2937"))
                                    textDecoration("none")
                                }
                            }) { Text("info@gelderfinance.ru") }
                        }

                        Button(
                            onClick = { window.location.href = "#application" },
                            modifier = Modifier
                                .backgroundColor(SitePalette.theme.primary)
                                .color(Color.white)
                                .padding(14.px, 28.px)
                                .borderRadius(14.px)
                                .fontSize(15.px)
                                .fontWeight(600)
                        ) {
                            Text("Получить кредит")
                        }
                    }
                }
            } else {
                Button(
                    onClick = { isMenuOpen = !isMenuOpen },
                    modifier = Modifier
                        .backgroundColor(Color.transparent)
                        .border(1.px, LineStyle.Solid, Color.transparent)
                        .borderRadius(12.px)
                        .padding(10.px)
                ) {
                    if (isMenuOpen) {
                        FaTimes()
                    } else {
                        FaBars()
                    }
                }
            }
        }

        if (isMobile && isMenuOpen) {
            Column(
                MobileMenuStyle.toModifier(),
                horizontalAlignment = Alignment.Start
            ) {
                Nav {
                    Column(modifier = Modifier.gap(16.px)) {
                        A(href = "#hero", attrs = NavItemStyle.toAttrs { onClick { isMenuOpen = false } }) { Text("О нас") }
                        A(href = "#calculator", attrs = NavItemStyle.toAttrs { onClick { isMenuOpen = false } }) { Text("Калькулятор") }
                        A(href = "#application", attrs = NavItemStyle.toAttrs { onClick { isMenuOpen = false } }) { Text("Заявка") }
                        A(href = "#footer", attrs = NavItemStyle.toAttrs { onClick { isMenuOpen = false } }) { Text("Контакты") }
                    }
                }

                Column(attrs = MobileContactInfoStyle.toAttrs()) {
                    Div(attrs = ContactItemStyle.toAttrs()) {
                        Span(attrs = {
                            style {
                                fontSize(18.px)
                                color(SitePalette.theme.primary)
                            }
                        }) { Text("📞") }
                        A(href = "tel:+74957778899", attrs = {
                            style {
                                color(Color("#1f2937"))
                                textDecoration("none")
                                fontSize(16.px)
                            }
                        }) { Text("+7 (495) 777-88-99") }
                    }
                    Div(attrs = ContactItemStyle.toAttrs()) {
                        Span(attrs = {
                            style {
                                fontSize(18.px)
                                color(SitePalette.theme.primary)
                            }
                        }) { Text("📧") }
                        A(href = "mailto:info@gelderfinance.ru", attrs = {
                            style {
                                color(Color("#1f2937"))
                                textDecoration("none")
                                fontSize(16.px)
                            }
                        }) { Text("info@gelderfinance.ru") }
                    }
                }

                Button(
                    onClick = {
                        isMenuOpen = false
                        window.location.href = "#application"
                    },
                    modifier = Modifier
                        .backgroundColor(SitePalette.theme.primary)
                        .color(Color.white)
                        .padding(16.px)
                        .borderRadius(14.px)
                        .fontSize(16.px)
                        .fontWeight(600)
                        .width(100.percent)
                ) {
                    Text("Получить кредит")
                }
            }
        }
    }
}
