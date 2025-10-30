package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import ru.gelder.testkobweb.SitePalette

val NAV_HEADER_HEIGHT = 80.px

val NavHeaderStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .position(Position.Sticky)
        .top(0.px)
        .padding(1.cssRem)
        .zIndex(99)
        .height(NAV_HEADER_HEIGHT)
        .backgroundColor(Color.white)
}

val LogoContainerStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .gap(12.px)
}

val LogoIconStyle = CssStyle.base {
    Modifier
        .width(40.px)
        .height(40.px)
        .backgroundColor(SitePalette.theme.primary)
        .borderRadius(8.px)
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
        .color(Color("#333"))
        .fontWeight(500)
}

val ContactItemStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .gap(8.px)
        .fontSize(14.px)
        .color(Color("#666"))
}

@Composable
fun NavHeader() {
    Row(
        NavHeaderStyle.toModifier(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // Logo and Company Name
        Div(attrs = LogoContainerStyle.toAttrs()) {
            Div(attrs = LogoIconStyle.toAttrs()) {
                Text("ГФ")
            }
            Column {
                H1(attrs = TitleStyle.toAttrs()) { Text("ГельдерФинанс") }
                P(attrs = DescriptionStyle.toAttrs()) { Text("Кредиты под залог") }
            }
        }

        // Navigation Items
        Nav(attrs = NavItemsStyle.toAttrs()) {
            A(href = "#hero", attrs = NavItemStyle.toAttrs()) { Text("О нас") }
            A(href = "#calculator", attrs = NavItemStyle.toAttrs()) { Text("Калькулятор") }
            A(href = "#application", attrs = NavItemStyle.toAttrs()) { Text("Заявка") }
            A(href = "#footer", attrs = NavItemStyle.toAttrs()) { Text("Контакты") }
        }

        // Contact Info and Button
        Row(
            modifier = Modifier.gap(20.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Phone
            Div(attrs = ContactItemStyle.toAttrs()) {
                Span(attrs = {
                    style {
                        fontSize(16.px); color(SitePalette.theme.primary)
                    }
                }) { Text("📞") }
                Text("+7 (495) 777-88-99")
            }

            // Email  
            Div(attrs = ContactItemStyle.toAttrs()) {
                Span(attrs = { style { fontSize(16.px); color(SitePalette.theme.primary) } }) { Text("📧") }
                Text("info@gelderfinance.ru")
            }

            // CTA Button
            Button(
                onClick = { /* Scroll to application */ },
                modifier = Modifier
                    .backgroundColor(SitePalette.theme.primary)
                    .color(Color.white)
                    .padding(12.px, 24.px)
                    .borderRadius(8.px)
                    .fontSize(14.px)
                    .fontWeight(600)
            ) {
                Text("Получить кредит")
            }
        }
    }
}
