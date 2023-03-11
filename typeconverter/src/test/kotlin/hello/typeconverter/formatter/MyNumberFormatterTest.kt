package hello.typeconverter.formatter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class MyNumberFormatterTest {
    private val formatter = MyNumberFormatter()

    @Test
    fun parse() {
        val result = formatter.parse("1,000", Locale.KOREA)
        assertThat(result).isEqualTo(1000L)
    }

    @Test
    fun print() {
        val result = formatter.print(1000, Locale.KOREA)
        assertThat(result).isEqualTo("1,000")
    }
}