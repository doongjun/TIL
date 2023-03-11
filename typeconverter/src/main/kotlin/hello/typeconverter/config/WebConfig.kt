package hello.typeconverter.config

import hello.typeconverter.converter.IntegerToStringConverter
import hello.typeconverter.converter.IpPortToStringConverter
import hello.typeconverter.converter.StringToIntegerConverter
import hello.typeconverter.converter.StringToIpPortConverter
import hello.typeconverter.formatter.MyNumberFormatter
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {
    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(StringToIpPortConverter())
        registry.addConverter(IpPortToStringConverter())

        /**
         * 우선순위
         * converter > formatter
         */
//        registry.addConverter(StringToIntegerConverter())
//        registry.addConverter(IntegerToStringConverter())
        registry.addFormatter(MyNumberFormatter())
    }
}