package com.openminis.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Indigo/violet accent for the Axisynx brand
private val IndigoPrimary = Color(0xFF4F5BD5)
private val IndigoOnPrimary = Color(0xFFFFFFFF)
private val IndigoPrimaryContainer = Color(0xFFDFE0FF)
private val IndigoOnPrimaryContainer = Color(0xFF000A5C)
private val IndigoSecondary = Color(0xFF5B5D72)
private val IndigoOnSecondary = Color(0xFFFFFFFF)
private val IndigoSecondaryContainer = Color(0xFFE0E1F9)
private val IndigoOnSecondaryContainer = Color(0xFF181A2C)
private val IndigoTertiary = Color(0xFF77536D)
private val IndigoOnTertiary = Color(0xFFFFFFFF)
private val IndigoTertiaryContainer = Color(0xFFFFD7F0)
private val IndigoOnTertiaryContainer = Color(0xFF2D1128)
private val IndigoBackground = Color(0xFFFBF8FF)
private val IndigoOnBackground = Color(0xFF1B1B21)
private val IndigoSurface = Color(0xFFFBF8FF)
private val IndigoOnSurface = Color(0xFF1B1B21)
private val IndigoSurfaceVariant = Color(0xFFE3E1EC)
private val IndigoOnSurfaceVariant = Color(0xFF46464F)
private val IndigoOutline = Color(0xFF777680)

private val IndigoDarkPrimary = Color(0xFFBAC3FF)
private val IndigoDarkOnPrimary = Color(0xFF1D2AA0)
private val IndigoDarkPrimaryContainer = Color(0xFF3643BD)
private val IndigoDarkOnPrimaryContainer = Color(0xFFDFE0FF)
private val IndigoDarkSecondary = Color(0xFFC4C5DD)
private val IndigoDarkOnSecondary = Color(0xFF2D2F42)
private val IndigoDarkSecondaryContainer = Color(0xFF434659)
private val IndigoDarkOnSecondaryContainer = Color(0xFFE0E1F9)
private val IndigoDarkBackground = Color(0xFF131318)
private val IndigoDarkOnBackground = Color(0xFFE4E1E9)
private val IndigoDarkSurface = Color(0xFF131318)
private val IndigoDarkOnSurface = Color(0xFFE4E1E9)
private val IndigoDarkSurfaceVariant = Color(0xFF46464F)
private val IndigoDarkOnSurfaceVariant = Color(0xFFC7C5D0)
private val IndigoDarkOutline = Color(0xFF91909A)

// Neutral grouped-card surfaces (iOS-style system-grouped background).
// Override Material3's tonal `surfaceContainer*` so cards don't pick up the
// teal primary tint.
// Light: page = #F2F2F7 gray, card = white
// Dark:  page = #000, card = #1C1C1E
private val NeutralGroupedBg = Color(0xFFF2F2F7)
private val NeutralGroupedCard = Color(0xFFFFFFFF)
private val NeutralGroupedCardElevated = Color(0xFFF7F7FA)
private val NeutralOutline = Color(0xFFD1D1D6)

private val NeutralDarkGroupedBg = Color(0xFF000000)
private val NeutralDarkGroupedCard = Color(0xFF1C1C1E)
private val NeutralDarkGroupedCardElevated = Color(0xFF2C2C2E)
private val NeutralDarkOutline = Color(0xFF38383A)

private val LightColorScheme = lightColorScheme(
    primary = IndigoPrimary,
    onPrimary = IndigoOnPrimary,
    primaryContainer = IndigoPrimaryContainer,
    onPrimaryContainer = IndigoOnPrimaryContainer,
    secondary = IndigoSecondary,
    onSecondary = IndigoOnSecondary,
    secondaryContainer = IndigoSecondaryContainer,
    onSecondaryContainer = IndigoOnSecondaryContainer,
    tertiary = IndigoTertiary,
    onTertiary = IndigoOnTertiary,
    tertiaryContainer = IndigoTertiaryContainer,
    onTertiaryContainer = IndigoOnTertiaryContainer,
    background = NeutralGroupedBg,
    onBackground = IndigoOnBackground,
    surface = NeutralGroupedBg,
    onSurface = IndigoOnSurface,
    surfaceVariant = NeutralGroupedCard,
    onSurfaceVariant = IndigoOnSurfaceVariant,
    surfaceContainerLowest = NeutralGroupedBg,
    surfaceContainerLow = NeutralGroupedCard,
    surfaceContainer = NeutralGroupedCard,
    surfaceContainerHigh = NeutralGroupedCardElevated,
    surfaceContainerHighest = NeutralGroupedCardElevated,
    outline = NeutralOutline,
    outlineVariant = NeutralOutline,
)

private val DarkColorScheme = darkColorScheme(
    primary = IndigoDarkPrimary,
    onPrimary = IndigoDarkOnPrimary,
    primaryContainer = IndigoDarkPrimaryContainer,
    onPrimaryContainer = IndigoDarkOnPrimaryContainer,
    secondary = IndigoDarkSecondary,
    onSecondary = IndigoDarkOnSecondary,
    secondaryContainer = IndigoDarkSecondaryContainer,
    onSecondaryContainer = IndigoDarkOnSecondaryContainer,
    background = NeutralDarkGroupedBg,
    onBackground = IndigoDarkOnBackground,
    surface = NeutralDarkGroupedBg,
    onSurface = IndigoDarkOnSurface,
    surfaceVariant = NeutralDarkGroupedCard,
    onSurfaceVariant = IndigoDarkOnSurfaceVariant,
    surfaceContainerLowest = NeutralDarkGroupedBg,
    surfaceContainerLow = NeutralDarkGroupedCard,
    surfaceContainer = NeutralDarkGroupedCard,
    surfaceContainerHigh = NeutralDarkGroupedCardElevated,
    surfaceContainerHighest = NeutralDarkGroupedCardElevated,
    outline = NeutralDarkOutline,
    outlineVariant = NeutralDarkOutline,
)

// App-wide FAB accent color (warm beige, matching iOS New Chat button).
// Reads from ChatPalette so it follows the in-app theme override (theme_mode pref),
// not android.isSystemInDarkTheme(), which only tracks the system setting.
@Composable
fun minisFabColor(): Color = LocalChatPalette.current.fabAccent

// App-wide shape system — larger corners for a modern, friendly feel
// DropdownMenu uses extraSmall, Dialog uses extraLarge, BottomSheet uses extraLarge
private val MinisShapes = Shapes(
    extraSmall = RoundedCornerShape(12.dp),   // DropdownMenu, Tooltip, OutlinedTextField default
    small = RoundedCornerShape(12.dp),        // Chip, TextField
    medium = RoundedCornerShape(20.dp),       // Card, Snackbar
    large = RoundedCornerShape(24.dp),        // NavigationDrawer
    extraLarge = RoundedCornerShape(28.dp),   // Dialog, BottomSheet
)

@Composable
fun MinisTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    fontScale: Float = 1f,
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val typography = scaledTypography(fontScale)
    val chatPalette = if (darkTheme) DarkChatPalette else LightChatPalette

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = MinisShapes,
        typography = typography,
    ) {
        CompositionLocalProvider(LocalChatPalette provides chatPalette, content = content)
    }
}

private fun TextStyle.scale(factor: Float): TextStyle =
    if (factor == 1f) this else copy(fontSize = fontSize * factor)

private fun scaledTypography(factor: Float): Typography {
    val base = Typography()
    return Typography(
        displayLarge = base.displayLarge.scale(factor),
        displayMedium = base.displayMedium.scale(factor),
        displaySmall = base.displaySmall.scale(factor),
        headlineLarge = base.headlineLarge.scale(factor),
        headlineMedium = base.headlineMedium.scale(factor),
        headlineSmall = base.headlineSmall.scale(factor),
        titleLarge = base.titleLarge.scale(factor),
        titleMedium = base.titleMedium.scale(factor),
        titleSmall = base.titleSmall.scale(factor),
        bodyLarge = base.bodyLarge.scale(factor),
        bodyMedium = base.bodyMedium.scale(factor),
        bodySmall = base.bodySmall.scale(factor),
        labelLarge = base.labelLarge.scale(factor),
        labelMedium = base.labelMedium.scale(factor),
        labelSmall = base.labelSmall.scale(factor),
    )
}
