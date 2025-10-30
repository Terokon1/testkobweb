package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.Composable
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
import com.varabyte.kobweb.silk.theme.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import ru.gelder.testkobweb.SitePalette

val HeroSectionStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .backgroundImage("linear-gradient(135deg, #f5f7ff 0%, #e5edff 100%)")
        .padding(top = 120.px, bottom = 100.px)
        .padding(leftRight = 20.px)
}

val HeroContainerStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .maxWidth(1180.px)
        .margin(leftRight = auto)
        .gap(60.px)
}

val HeroBadgeStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.InlineFlex)
        .alignItems(AlignItems.Center)
        .gap(10.px)
        .padding(vertical = 10.px, horizontal = 18.px)
        .backgroundColor(Color.white)
        .color(SitePalette.theme.primary)
        .fontSize(14.px)
        .fontWeight(600)
        .borderRadius(999.px)
        .boxShadow(0.px, 12.px, 30.px, Color.rgba(59, 91, 219, 0.15))
}

val HeroTitleStyle = CssStyle.base {
    Modifier
        .fontSize(56.px)
        .fontWeight(700)
        .lineHeight(1.05)
        .color(Color("#1f2937"))
        .margin(top = 16.px, bottom = 24.px)
}

val HeroTitleAccentStyle = CssStyle.base {
    Modifier.color(SitePalette.theme.primary)
}

val HeroDescriptionStyle = CssStyle.base {
    Modifier
        .fontSize(18.px)
        .lineHeight(1.6)
        .color(Color("#475569"))
        .maxWidth(560.px)
        .margin(bottom = 32.px)
}

val HeroHighlightsStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .flexWrap(FlexWrap.Wrap)
        .gap(16.px)
        .margin(bottom = 40.px)
}

val HighlightCardStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .gap(14.px)
        .padding(vertical = 14.px, horizontal = 20.px)
        .backgroundColor(Color.white)
        .borderRadius(16.px)
        .boxShadow(0.px, 18.px, 35.px, Color.rgba(15, 23, 42, 0.08))
        .fontSize(16.px)
        .color(Color("#1f2937"))
        .fontWeight(500)
}

val HighlightIconStyle = CssStyle.base {
    Modifier
        .width(36.px)
        .height(36.px)
        .borderRadius(999.px)
        .backgroundColor(Color.rgba(59, 91, 219, 0.12))
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .justifyContent(JustifyContent.Center)
        .color(SitePalette.theme.primary)
        .fontSize(18.px)
        .fontWeight(700)
}

val HeroButtonsStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .gap(18.px)
        .alignItems(AlignItems.Center)
        .flexWrap(FlexWrap.Wrap)
}

val PrimaryButtonStyle = CssStyle.base {
    Modifier
        .backgroundColor(SitePalette.theme.primary)
        .color(Color.white)
        .padding(vertical = 16.px, horizontal = 32.px)
        .borderRadius(14.px)
        .fontSize(16.px)
        .fontWeight(600)
        .boxShadow(0.px, 18.px, 34.px, Color.rgba(59, 91, 219, 0.28))
}

val SecondaryLinkStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.InlineFlex)
        .alignItems(AlignItems.Center)
        .gap(8.px)
        .color(SitePalette.theme.primary)
        .fontSize(16.px)
        .fontWeight(600)
}

val HeroArtworkWrapperStyle = CssStyle.base {
    Modifier
        .width(520.px)
        .height(420.px)
        .borderRadius(36.px)
        .overflow(Overflow.Hidden)
        .boxShadow(0.px, 35.px, 60.px, Color.rgba(15, 23, 42, 0.12))
        .backgroundImage("linear-gradient(160deg, #3b5bdb 0%, #4361ee 35%, #ffffff 100%)")
        .position(Position.Relative)
}

val HeroArtworkContentStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .flexDirection(FlexDirection.Column)
        .justifyContent(JustifyContent.SpaceBetween)
        .height(100.percent)
        .padding(32.px)
        .color(Color.white)
}

val HeroArtworkIntroStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .flexDirection(FlexDirection.Column)
        .gap(14.px)
}

val HeroArtworkCardsStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .flexDirection(FlexDirection.Column)
        .gap(18.px)
}

val HeroArtworkChipStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.InlineFlex)
        .alignItems(AlignItems.Center)
        .gap(10.px)
        .backgroundColor(Color.rgba(255, 255, 255, 0.16))
        .padding(vertical = 10.px, horizontal = 18.px)
        .borderRadius(999.px)
        .fontSize(14.px)
        .fontWeight(600)
}

val HeroArtworkPrimaryCardStyle = CssStyle.base {
    Modifier
        .backgroundColor(Color.white)
        .color(Color("#1f2937"))
        .borderRadius(22.px)
        .padding(20.px)
        .display(DisplayStyle.Flex)
        .flexDirection(FlexDirection.Column)
        .gap(12.px)
        .boxShadow(0.px, 28.px, 38.px, Color.rgba(15, 23, 42, 0.18))
        .width(100.percent)
        .maxWidth(260.px)
}

val HeroArtworkPrimaryCardHeaderStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.SpaceBetween)
        .alignItems(AlignItems.Center)
}

val HeroArtworkPrimaryCardBadgeStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.InlineFlex)
        .alignItems(AlignItems.Center)
        .gap(6.px)
        .backgroundColor(Color.rgba(59, 91, 219, 0.12))
        .color(SitePalette.theme.primary)
        .padding(vertical = 6.px, horizontal = 12.px)
        .borderRadius(999.px)
        .fontSize(13.px)
        .fontWeight(600)
}

val HeroArtworkPrimaryCardLabelStyle = CssStyle.base {
    Modifier
        .fontSize(28.px)
        .fontWeight(700)
        .color(Color("#111827"))
}

val HeroArtworkPrimaryCardFootnoteStyle = CssStyle.base {
    Modifier
        .fontSize(13.px)
        .color(Color("#6b7280"))
        .lineHeight(1.4)
}

val HeroArtworkSecondaryCardStyle = CssStyle.base {
    Modifier
        .backgroundColor(Color.rgba(255, 255, 255, 0.2))
        .padding(16.px)
        .borderRadius(20.px)
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.SpaceBetween)
        .alignItems(AlignItems.Center)
        .color(Color.white)
        .fontSize(15.px)
        .fontWeight(500)
        .gap(14.px)
}

val HeroArtworkDecorStyle = CssStyle.base {
    Modifier
        .position(Position.Absolute)
        .borderRadius(50.percent)
        .backgroundColor(Color.rgba(255, 255, 255, 0.14))
}

@Composable
fun Hero() {
    val breakpoint = rememberBreakpoint()
    val stackVertically = breakpoint <= Breakpoint.MD

    val highlights = listOf(
        "Ставка от 1% в месяц",
        "Сумма до 100 млн ₽",
        "Решение за 1 день",
        "Без справок и поручителей"
    )

    Section(attrs = HeroSectionStyle.toAttrs {
        id("hero")
    }) {
        Div(attrs = HeroContainerStyle.toAttrs()) {
            if (stackVertically) {
                Column(
                    modifier = Modifier.fillMaxWidth().gap(48.px),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HeroLeftContent(highlights, alignCenter = true)
                    HeroRightImage(compact = true)
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HeroLeftContent(highlights, alignCenter = false, modifier = Modifier.weight(1f))
                    HeroRightImage(compact = false)
                }
            }
        }
    }
}

@Composable
private fun HeroLeftContent(
    highlights: List<String>,
    alignCenter: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.then(Modifier.gap(18.px)),
        horizontalAlignment = if (alignCenter) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Span(attrs = HeroBadgeStyle.toAttrs()) {
            Text("ООО \"ГельдерФинанс\" — надежный партнёр")
        }

        val titleSize = if (alignCenter) 44.px else 56.px
        H1(attrs = HeroTitleStyle.toAttrs {
            style {
                fontSize(titleSize)
                if (alignCenter) {
                    textAlign("center")
                }
            }
        }) {
            Text("Кредиты под залог")
            Br()
            Span(attrs = HeroTitleAccentStyle.toAttrs()) {
                Text("недвижимости и автомобилей")
            }
        }

        P(attrs = HeroDescriptionStyle.toAttrs {
            if (alignCenter) {
                style {
                    textAlign("center")
                }
            }
        }) {
            Text("ООО \"ГельдерФинанс\" — надежный партнёр в получении кредитов под залог. Работаем с физическими и юридическими лицами. Минимальные требования к заёмщику, сумма до 100 млн рублей, ставка от 1% в месяц.")
        }

        Div(attrs = HeroHighlightsStyle.toAttrs {
            if (alignCenter) {
                justifyContent(JustifyContent.Center)
            }
        }) {
            highlights.forEach { item ->
                Div(attrs = HighlightCardStyle.toAttrs()) {
                    Span(attrs = HighlightIconStyle.toAttrs()) { Text("✓") }
                    Text(item)
                }
            }
        }

        Div(attrs = HeroButtonsStyle.toAttrs {
            if (alignCenter) {
                justifyContent(JustifyContent.Center)
            }
        }) {
            Button(
                onClick = { window.location.href = "#calculator" },
                modifier = PrimaryButtonStyle.toModifier()
            ) {
                Text("Рассчитать кредит")
            }

            A(
                href = "#application",
                attrs = SecondaryLinkStyle.toAttrs()
            ) {
                Text("Подать заявку")
                Span { Text("→") }
            }
        }
    }
}

@Composable
private fun HeroRightImage(compact: Boolean) {
    Div(attrs = HeroArtworkWrapperStyle.toAttrs {
        style {
            if (compact) {
                width(100.percent)
                maxWidth(460.px)
                height(360.px)
                margin(leftRight = auto)
            }
        }
    }) {
        Div(attrs = HeroArtworkContentStyle.toAttrs()) {
            Div(attrs = HeroArtworkIntroStyle.toAttrs()) {
                Span(attrs = HeroArtworkChipStyle.toAttrs()) {
                    Text("Одобрение 92% заявок")
                }
                P(attrs = {
                    style {
                        fontSize(30.px)
                        fontWeight(600)
                        margin(0.px)
                        color(Color.white)
                    }
                }) {
                    Text("Залоговое финансирование")
                }
                P(attrs = {
                    style {
                        fontSize(15.px)
                        lineHeight(1.5)
                        color(Color.rgba(255, 255, 255, 0.86))
                        margin(0.px)
                        maxWidth(260.px)
                    }
                }) {
                    Text("Быстрая оценка и прозрачные условия для квартир, домов и авто.")
                }
            }

            Div(attrs = HeroArtworkCardsStyle.toAttrs()) {
                Div(attrs = HeroArtworkPrimaryCardStyle.toAttrs()) {
                    Div(attrs = HeroArtworkPrimaryCardHeaderStyle.toAttrs()) {
                        Span(attrs = HeroArtworkPrimaryCardBadgeStyle.toAttrs()) {
                            Text("Индивидуально")
                        }
                        Span(attrs = {
                            style {
                                fontSize(13.px)
                                color(Color("#9ca3af"))
                            }
                        }) { Text("Одобрение") }
                    }
                    Div(attrs = HeroArtworkPrimaryCardLabelStyle.toAttrs()) {
                        Text("до 100 млн ₽")
                    }
                    P(attrs = HeroArtworkPrimaryCardFootnoteStyle.toAttrs()) {
                        Text("Ставка от 1% в месяц. Оформление без справок и поручителей.")
                    }
                }

                Div(attrs = HeroArtworkSecondaryCardStyle.toAttrs()) {
                    Span { Text("Срок до 15 лет") }
                    Span {
                        Text("Подать заявку →")
                    }
                }
            }
        }

        Div(attrs = HeroArtworkDecorStyle.toAttrs {
            style {
                width(120.px)
                height(120.px)
                left((-40).px)
                top(60.px)
            }
        })

        Div(attrs = HeroArtworkDecorStyle.toAttrs {
            style {
                width(180.px)
                height(180.px)
                right((-80).px)
                bottom(40.px)
            }
        })
    }
}
